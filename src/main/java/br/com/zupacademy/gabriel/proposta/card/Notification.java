package br.com.zupacademy.gabriel.proposta.card;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private LocalDate validUntil;
	@NotBlank
	private String  destiny;
	@ManyToOne
	private Card card;
	
	public Notification(@NotNull LocalDate validUntil, @NotBlank String destiny) {
		super();
		this.validUntil = validUntil;
		this.destiny = destiny;
	}
	
	
}
