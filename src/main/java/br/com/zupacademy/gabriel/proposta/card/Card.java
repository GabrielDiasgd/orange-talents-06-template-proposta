package br.com.zupacademy.gabriel.proposta.card;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.gabriel.proposta.biometry.Biometry;
import br.com.zupacademy.gabriel.proposta.card.block.Block;
import br.com.zupacademy.gabriel.proposta.card.duedate.DueDate;
import br.com.zupacademy.gabriel.proposta.card.duedate.DueDateResponse;
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
	
	@Enumerated(EnumType.STRING)
	private CardStatus cardStatus = CardStatus.UNBLOCKED;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private DueDate dueDate;
	
	@OneToOne
	private Proposal proposal;
	
	@OneToMany(mappedBy = "card")
	private Set<Biometry> biometrics = new HashSet<>();
	
	@OneToMany(mappedBy = "card", cascade = CascadeType.MERGE)
	private List<Block> blocks = new ArrayList<>();

	@Deprecated	
	public Card() {
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
	
	public String getId() {
		return id;
	}

	public boolean isBlocked() {
		return this.cardStatus.equals(CardStatus.BLOCKED);
	}

	public void BlockCard(HttpServletRequest request) {
		this.cardStatus = CardStatus.BLOCKED;
		this.blocks.add(new Block(request.getRemoteAddr(), request.getHeader("User-Agent"), this));
	}

}
