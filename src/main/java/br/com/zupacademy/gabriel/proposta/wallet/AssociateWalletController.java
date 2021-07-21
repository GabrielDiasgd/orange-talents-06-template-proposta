package br.com.zupacademy.gabriel.proposta.wallet;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.gabriel.proposta.card.Card;
import br.com.zupacademy.gabriel.proposta.card.CardClient;
import br.com.zupacademy.gabriel.proposta.card.CardRepository;
import feign.FeignException;

@RestController
@RequestMapping("/cards/associate-paypal")
public class AssociateWalletController {
	
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private CardClient cardClient;
	@Autowired
	private WalletRepository walletRepository;
	
	@Transactional
	@PostMapping("/{cardNumber}/wallets")
	public ResponseEntity<?> associate (@PathVariable String cardNumber, @RequestBody @Valid WalletRequest request, UriComponentsBuilder uri){
		Optional<Card> card = cardRepository.findById(cardNumber);
		if (card.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não exixte nenhum cartão de número " + cardNumber + " cadastrado");
		}
		
		if (card.get().cardAlreadyHasTheSameTypeOfWallet(request.getWalletName())) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Já existe uma carteira do tipo " + request.getWalletName() + " associada ao cartão");
		}
		
		try {
			cardClient.associate(cardNumber, request.toExternalRequest());
			Wallet wallet = request.toModel(card.get());
			walletRepository.save(wallet);
			return ResponseEntity.created(uri.path("/cards/{cardNumber}/wallets/{id}").buildAndExpand(cardNumber, wallet.getId()).toUri()).build();
		} catch (FeignException e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Não foi possível associar a carteira no momento");
		}

	}

}
