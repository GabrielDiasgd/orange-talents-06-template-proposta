package br.com.zupacademy.gabriel.proposta.card.block;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.proposta.card.Card;
import br.com.zupacademy.gabriel.proposta.card.CardRepository;

@RestController
@RequestMapping("/cards")
public class BlockCardController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@PostMapping("/{cardNumber}/blocks")
	public ResponseEntity<?> blockCard (@PathVariable String cardNumber, HttpServletRequest request) {
		Optional<Card> card = cardRepository.findById(cardNumber);
		if (card.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		if(card.get().isBlocked()) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Cartão de número " + cardNumber + " já está bloqueado.");
		}
		card.get().BlockCard(request);
		cardRepository.save(card.get());
		return ResponseEntity.ok().build();
	}
}
