package br.com.zupacademy.gabriel.proposta.proposal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long>{

	Optional<Proposal> findByDocument(String document);

	Optional<Proposal> findTop1ByProposalStatusAndCardIsNull(ProposalStatus eligible);

}
