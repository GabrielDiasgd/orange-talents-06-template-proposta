package br.com.zupacademy.gabriel.proposta.travel;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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

import br.com.zupacademy.gabriel.proposta.card.Card;
import br.com.zupacademy.gabriel.proposta.card.CardClient;
import br.com.zupacademy.gabriel.proposta.card.CardRepository;
import feign.FeignException.FeignClientException;

@RestController
@RequestMapping("/cards")
public class NotifyTravelController {
	
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private CardClient cardClient;
	
	@Transactional
	@PostMapping("/{cardNumber}/notifications")
	public ResponseEntity<?> notify (@PathVariable String cardNumber, @RequestBody @Valid NotifyTravelRequest request, HttpServletRequest servletRequest) {
		Optional<Card> card = cardRepository.findById(cardNumber);
		if (card.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe nenhum cartão de número " + cardNumber + " cadastrado");
		}
		
		try {
			cardClient.notify(cardNumber, request.toExternalRequest());
			card.get().notifyTravel(request,servletRequest);
			cardRepository.save(card.get());
			return ResponseEntity.ok().build();
		} catch (FeignClientException e) {
			return ResponseEntity.status(e.status()).body("Não foi possível notificar o sistema do banco. Tente novamente mais tarde!");
		}
	}

}
