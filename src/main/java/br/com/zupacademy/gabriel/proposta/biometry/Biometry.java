package br.com.zupacademy.gabriel.proposta.biometry;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.proposta.card.Card;

@Entity
public class Biometry {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String fingerPoint;
	@NotNull
	private LocalDateTime creationDate = LocalDateTime.now();
	@ManyToOne @NotNull
	private Card card;
	
	@Deprecated
	public Biometry() {
	}
	
	public Biometry(@NotBlank String fingerPoint, @NotNull Card card) {
		super();
		this.fingerPoint = fingerPoint;
		this.card = card;
	}

	public Long getId() {
		return id;
	}

	
	
	
	

}
