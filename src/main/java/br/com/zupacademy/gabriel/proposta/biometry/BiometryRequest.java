package br.com.zupacademy.gabriel.proposta.biometry;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabriel.proposta.card.Card;
import br.com.zupacademy.gabriel.proposta.config.validations.Base64;

public class BiometryRequest {
	
	@NotBlank @Base64(fieldName = "fingerPoint")
	private String fingerPoint;

	public String getFingerPoint() {
		return fingerPoint;
	}
	
	public Biometry toModel(Card card) {
		return new Biometry(this.fingerPoint, card);
	}

}
