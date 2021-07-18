package br.com.zupacademy.gabriel.proposta.card;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.gabriel.proposta.proposal.Proposal;

@Entity
public class Card {
	
	@Id
	private String id;
	@NotNull
	private LocalDateTime issuedOn;
	@NotBlank
	private String owner;
	@Positive @Column(name = "card_limit")
	private BigDecimal limit;
	@OneToOne(cascade = CascadeType.MERGE)
	private DueDate dueDate;
	@OneToOne
	private Proposal proposal;

	@Deprecated	
	public Card() {
	}

	public String getId() {
		return id;
	}

	public Card(String id, @NotNull LocalDateTime issuedOn, @NotBlank String owner, @Positive BigDecimal limit,
		 DueDateResponse vencimento, Proposal proposal) {
		super();
		this.id = id;
		this.issuedOn = issuedOn;
		this.owner = owner;
		this.limit = limit;
		this.dueDate = vencimento.toModel(this);
		this.proposal = proposal;
	}


	

	
}
