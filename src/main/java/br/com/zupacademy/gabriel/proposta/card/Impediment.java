package br.com.zupacademy.gabriel.proposta.card;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Impediment {
	
	@Id
	private String id;
	@NotNull
	private LocalDateTime blockedIn;
	@NotBlank
	private String responsibleSystem;
	@NotNull
	private Boolean active;
	@ManyToOne
	private Card card;
	
	public Impediment(LocalDateTime blockedIn, String responsibleSystem, Boolean active) {
		super();
		this.blockedIn = blockedIn;
		this.responsibleSystem = responsibleSystem;
		this.active = active;
	}
	
	

}
