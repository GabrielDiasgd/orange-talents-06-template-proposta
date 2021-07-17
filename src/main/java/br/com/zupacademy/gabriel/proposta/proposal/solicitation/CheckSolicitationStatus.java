package br.com.zupacademy.gabriel.proposta.proposal.solicitation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zupacademy.gabriel.proposta.proposal.Proposal;
import br.com.zupacademy.gabriel.proposta.proposal.ProposalStatus;
import feign.FeignException;

@Service
public class CheckSolicitationStatus {
	
	@Autowired
	private ProposalClient proposalClient;
	
	public ProposalStatus converteResultadoSolicitacaoForProposalStatus(Proposal proposal) {
		try {
			proposalClient.getSolicitationAnalysis(new SolicitationRequest(proposal));
			return ProposalStatus.ELIGIBLE;
		} catch (FeignException e) {
			return ProposalStatus.NOT_ELIGIBLE;
		}
		
	}

}
