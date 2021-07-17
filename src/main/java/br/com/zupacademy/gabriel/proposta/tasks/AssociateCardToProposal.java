package br.com.zupacademy.gabriel.proposta.tasks;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.zupacademy.gabriel.proposta.card.CardClient;
import br.com.zupacademy.gabriel.proposta.card.CardRequest;
import br.com.zupacademy.gabriel.proposta.card.CardResponse;
import br.com.zupacademy.gabriel.proposta.proposal.Proposal;
import br.com.zupacademy.gabriel.proposta.proposal.ProposalRepository;
import br.com.zupacademy.gabriel.proposta.proposal.ProposalStatus;
import feign.FeignException;

@Service
public class AssociateCardToProposal {
	
	@Autowired
	private ProposalRepository proposalRepository;
	@Autowired
	private CardClient cardClient;

	private final Logger logger = LoggerFactory.getLogger(AssociateCardToProposal	.class);
	
	@Scheduled(fixedDelayString = "${associate.card.fixed.delay}")
	public void associateCardToProposal () {
		Optional<Proposal> approvedProposal = proposalRepository.findTop1ByProposalStatusAndCardIsNull(ProposalStatus.ELIGIBLE);
		if (approvedProposal.isPresent()) {
			try {
				CardResponse response = cardClient.associateCard(new CardRequest(approvedProposal.get()));
				approvedProposal.get().associateCard(response);
				proposalRepository.save(approvedProposal.get());
				
			} catch (FeignException e) {
				logger.error("Serviço externo apresentou falha pois ainda não foi processado, aguardar próxima interação.");
			}
		} else {
			logger.info("Não tem nenhuma proposta aprovada para associar um cartão");
		}
		
	}

}