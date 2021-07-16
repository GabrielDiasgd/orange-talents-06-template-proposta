package br.com.zupacademy.gabriel.proposta.proposal.solicitation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "solicitation", url = "http://localhost:9999")
public interface ProposalClient {
	
	@RequestMapping (method = RequestMethod.POST, value = "/api/solicitacao")
	public SolicitationResponse getSolicitationAnalysis (@RequestBody SolicitationRequest request);

}
