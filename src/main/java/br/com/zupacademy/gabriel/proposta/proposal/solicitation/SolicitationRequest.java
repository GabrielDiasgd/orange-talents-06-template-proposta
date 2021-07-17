package br.com.zupacademy.gabriel.proposta.proposal.solicitation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.proposta.config.validations.Document;
import br.com.zupacademy.gabriel.proposta.proposal.Proposal;

public class SolicitationRequest {

	@Document @NotNull 
	private String documento;
	@NotBlank
	private  String nome;
	private String idProposta;
	
	@Deprecated
	public SolicitationRequest() {
	}
	public SolicitationRequest(Proposal proposal) {
		this.documento = proposal.getDocument();
		this.nome = proposal.getName();
		this.idProposta = proposal.getId().toString();
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}


	public String getIdProposta() {
		return idProposta;
	}

	

}
