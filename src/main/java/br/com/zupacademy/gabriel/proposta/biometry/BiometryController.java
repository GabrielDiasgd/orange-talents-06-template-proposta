package br.com.zupacademy.gabriel.proposta.biometry;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.gabriel.proposta.card.Card;
import br.com.zupacademy.gabriel.proposta.card.CardRepository;

@RestController
@RequestMapping("/cards/{cardNumber}")
public class BiometryController {
	
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private BiometryRepository biometryRepository;
	
	@PostMapping("/biometrics")
	public ResponseEntity<?> create (@RequestBody @Valid BiometryRequest biometryRequest, @PathVariable String cardNumber, UriComponentsBuilder uri) {
		Optional<Card> card = cardRepository.findById(cardNumber);
		if (card.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Biometry biometry = biometryRequest.toModel(card.get());
		biometryRepository.save(biometry);
		
		return ResponseEntity.created(uri.path("/cards/{cardNumber}/biometrics/{biometricId}").buildAndExpand(cardNumber, biometry.getId()).toUri()).build();
	}

}
