package br.com.zupacademy.gabriel.proposta.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gabriel.proposta.proposal.Proposal;

public class CardRequest {
	
	@JsonProperty("documento")
	private String document;
	@JsonProperty("nome")
	private String name;
	@JsonProperty("idProposta")
	private String proposalId;
	
	@Deprecated
	public CardRequest() {
	}

	public CardRequest(Proposal approvedProposal) {
		this.document = approvedProposal.getDocument();
		this.name = approvedProposal.getName();
		this.proposalId = approvedProposal.getId().toString();
	}

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

	public String getProposalId() {
		return proposalId;
	}






}
