package br.com.zupacademy.gabriel.proposta.proposal;

import org.springframework.security.crypto.encrypt.Encryptors;

public class ProposalResponse {

	private Long id;
	private String document;
	private String name;
	private ProposalStatus status;
	private String cardNumber;

	public ProposalResponse(Proposal proposal, String secret, String salt) {
		this.id = proposal.getId();
		this.document = Encryptors.queryableText(secret, salt).decrypt(proposal.getDocument());
		this.name = proposal.getName();
		this.status = proposal.getProposalStatus();
		this.cardNumber = status.equals(ProposalStatus.ELIGIBLE) ? proposal.getCard().getId()
				: "Proposta não é elegível a receber um cartão, por isso não tem o número";
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

	public ProposalStatus getStatus() {
		return status;
	}

	public String getCardNumber() {
		return cardNumber;
	}

}
