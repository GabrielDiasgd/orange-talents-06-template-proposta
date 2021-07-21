package br.com.zupacademy.gabriel.proposta.travel;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.proposta.card.Card;

@Entity
public class NotifyTravel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String destiny;
	
	@Future @NotNull
	private LocalDate travelEndDate;
	
	@NotBlank
	private String clientIp;
	
	@NotBlank
	private String userAgent;
	
	@NotNull @ManyToOne
	private Card card;
	
	@Deprecated
	public NotifyTravel() {
	}

	public NotifyTravel(@NotBlank String destiny, @Future @NotNull LocalDate travelEndDate, @NotBlank String clientIp,
			@NotBlank String userAgent, @NotNull Card card) {
		super();
		this.destiny = destiny;
		this.travelEndDate = travelEndDate;
		this.clientIp = clientIp;
		this.userAgent = userAgent;
		this.card = card;
	}
	
	

}
