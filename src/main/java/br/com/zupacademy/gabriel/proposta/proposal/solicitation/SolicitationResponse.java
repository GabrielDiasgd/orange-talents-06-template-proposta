package br.com.zupacademy.gabriel.proposta.proposal.solicitation;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SolicitationResponse {
	
	private String documento;
	private String nome;
	private String idProposta;
	@Enumerated(EnumType.STRING)
	private ResultadoSolicitacao resultadoSolicitacao;
	
	@Deprecated
	public SolicitationResponse() {
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
	
	public ResultadoSolicitacao getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}


	@Override
	public String toString() {
		return "ProposalClientResponse [documento=" + documento + ", nome=" + nome + ", idProposta=" + idProposta
				+ ", resultadoSolicitacao=" + resultadoSolicitacao + "]";
	}


	
	

}
