package br.com.zupacademy.gabriel.proposta.card.block;

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
public class Block {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private LocalDateTime blockedIn = LocalDateTime.now();
	@NotBlank
	private String clientIp;
	@NotBlank
	private String userAgent;
	@ManyToOne
	private Card card;
	
	@Deprecated
	public Block() {
	}
	
	public Block(@NotBlank String clientIp, @NotBlank String userAgent,
			Card card) {
		super();
		this.clientIp = clientIp;
		this.userAgent = userAgent;
		this.card = card;
	}
	
	
	
}
