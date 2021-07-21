package br.com.zupacademy.gabriel.proposta.card;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalTravelNotificationRequest {
	
	@NotBlank
	@JsonProperty(value = "destino")
	private String destiny;
	
	@NotNull
	@Future
	@JsonProperty(value = "validoAte")
	private LocalDate travelEndDate;
	
	public ExternalTravelNotificationRequest(@NotBlank String destiny, @Future @NotNull LocalDate travelEndDate) {
		this.destiny = destiny;
		this.travelEndDate = travelEndDate;
	}
	
}
