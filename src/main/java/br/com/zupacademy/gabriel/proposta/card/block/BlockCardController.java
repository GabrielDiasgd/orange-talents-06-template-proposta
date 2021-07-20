package br.com.zupacademy.gabriel.proposta.card.block;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.proposta.card.Card;
import br.com.zupacademy.gabriel.proposta.card.CardClient;
import br.com.zupacademy.gabriel.proposta.card.CardRepository;
import feign.Response;

@RestController
@RequestMapping("/cards")
public class BlockCardController {
	
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private CardClient cardClient;
	
	@Transactional
	@PostMapping("/{cardNumber}/blocks")
	public ResponseEntity<?> blockCard (@PathVariable String cardNumber, HttpServletRequest request) {
		Optional<Card> card = cardRepository.findById(cardNumber);
		if (card.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		if(card.get().isBlocked()) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Cartão de número " + cardNumber + " já está bloqueado.");
		}
		
		Response resp = cardClient.notifyCardBlock(cardNumber, Map.of("sistemaResponsavel:", "Proposal Microservice - Gabriel"));
			if (resp.status() == 200) {
				card.get().BlockCard(request);
				cardRepository.save(card.get());
				return ResponseEntity.ok().build();
		}
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Não foi possível bloquear o cartão no momento. Tente mais tarde!");
	}
}
