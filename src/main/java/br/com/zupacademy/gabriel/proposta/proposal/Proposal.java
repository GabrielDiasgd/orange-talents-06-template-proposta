package br.com.zupacademy.gabriel.proposta.proposal;

import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import br.com.zupacademy.gabriel.proposta.card.Card;
import br.com.zupacademy.gabriel.proposta.card.CardResponse;
import br.com.zupacademy.gabriel.proposta.config.validations.Document;

@Entity
public class Proposal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Document @NotNull
	private String document;
	@Email @NotBlank
	private String email;
	@NotBlank 
	private String name;
	@NotBlank
	private String address;
	@Positive @NotNull
	private BigDecimal salary;
	@Enumerated(EnumType.STRING)
	private ProposalStatus proposalStatus;
	@OneToOne(cascade = CascadeType.MERGE)
	private Card card;
	
	@Deprecated
	public Proposal() {
	}
	public Proposal(@Document @NotNull String document, @Email @NotBlank String email, @NotBlank String name, @NotBlank String address,
			@Positive @NotNull BigDecimal salary) {
				this.document = document;
				this.email = email;
				this.name = name;
				this.address = address;
				this.salary = salary;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDocument() {
		return document;
	}
	public String getName() {
		return name;
	}
	public Card getCard() {
		return card;
	}
	public ProposalStatus getProposalStatus() {
		return proposalStatus;
	}

	public void setProposalStatus(ProposalStatus proposalStatus) {
		this.proposalStatus = proposalStatus;
	}

	@Override
	public String toString() {
		return "Proposal [id=" + id + ", document=" + document + ", email=" + email + ", name=" + name + ", address="
				+ address + ", salary=" + salary + ", proposalStatus=" + proposalStatus + "]";
	}

	public boolean existsProposalforTheSameRequester(ProposalRepository proposalRepository) {
		Optional<Proposal> proposal = proposalRepository.findByDocument(document);
		if (proposal.isPresent()) {
			return true;
		}
		return false;
	}
	public void associateCard(CardResponse response) {
		Assert.notNull(response.toModel(this), "Cartão não pode ser nulo");
		this.card = response.toModel(this);
		
		
	}
	
}
