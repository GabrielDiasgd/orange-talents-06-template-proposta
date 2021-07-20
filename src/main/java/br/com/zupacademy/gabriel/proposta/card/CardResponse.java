package br.com.zupacademy.gabriel.proposta.card;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gabriel.proposta.card.duedate.DueDateResponse;
import br.com.zupacademy.gabriel.proposta.proposal.Proposal;

public class CardResponse {

	private String id;
	@JsonProperty("emitidoEm")
	private LocalDateTime issuedOn;
	@JsonProperty("titular")
	private String owner;
	@JsonProperty("limite")
	private BigDecimal limit;
	@JsonProperty("vencimento")
	private DueDateResponse dueDate;
	@JsonProperty("idProposta")
	private String proposalId;
	
	@Deprecated
	public CardResponse() {
}

	public Card toModel(Proposal proposal) {
		return new Card(this.id, this.issuedOn, this.owner, this.limit, this.dueDate, proposal);
	}
	public String getId() {
		return id;
	}

	public LocalDateTime getIssuedOn() {
		return issuedOn;
	}

	public String getOwner() {
		return owner;
	}

	public BigDecimal getLimit() {
		return limit;
	}

	public DueDateResponse getDueDate() {
		return dueDate;
	}

	public String getProposalId() {
		return proposalId;
	}

	@Override
	public String toString() {
		return "CardResponse [id=" + id + ", emitidoEm=" + issuedOn + ", titular=" + owner + ", limite=" + limit
				+ ", idProposta=" + proposalId + "]";
	}

	
	
	
	

	
	
}
