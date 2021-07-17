package br.com.zupacademy.gabriel.proposta.proposal.solicitation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "solicitation", url = "${api.solicitations.url}")
public interface ProposalClient {
	
	@PostMapping
	public SolicitationResponse getSolicitationAnalysis (@RequestBody SolicitationRequest request);

}
