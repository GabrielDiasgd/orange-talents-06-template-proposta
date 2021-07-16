package br.com.zupacademy.gabriel.proposta.proposal.solicitation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.proposta.config.validations.Document;

public class SolicitationRequest {

	@Document @NotNull 
	private String documento;
	@NotBlank
	private  String nome;
	private String idProposta;
	
	@Deprecated
	public SolicitationRequest() {
	}

	public SolicitationRequest(@Document @NotNull String documento, @NotBlank String nome, String idProposta) {
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
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
