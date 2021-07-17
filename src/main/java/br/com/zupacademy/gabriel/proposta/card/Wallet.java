package br.com.zupacademy.gabriel.proposta.card;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Wallet {
	
	@Id
	private String id;
	@NotBlank @Email
	private String email;
	@NotNull
	private LocalDateTime AssociateIn;
	@NotBlank
	private String issuer;
	@ManyToOne
	private Card card;

}
