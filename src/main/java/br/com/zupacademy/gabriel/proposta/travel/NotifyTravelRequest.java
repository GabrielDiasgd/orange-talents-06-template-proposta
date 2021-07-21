package br.com.zupacademy.gabriel.proposta.travel;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.gabriel.proposta.card.ExternalTravelNotificationRequest;

public class NotifyTravelRequest {
	
	@NotBlank
	private String destiny;
	
	@Future @NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate travelEndDate;
	
	public NotifyTravelRequest(@NotBlank String destiny,@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING) LocalDate travelEndDate) {
		super();
		this.destiny = destiny;
		this.travelEndDate = travelEndDate;
	}
	

	public String getDestiny() {
		return destiny;
	}

	public LocalDate getTravelEndDate() {
		return travelEndDate;
	}
	
	
	public ExternalTravelNotificationRequest toExternalRequest () {
		return new ExternalTravelNotificationRequest(this.destiny, this.travelEndDate);
	}
}
