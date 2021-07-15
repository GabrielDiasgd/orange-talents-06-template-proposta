package br.com.zupacademy.gabriel.proposta.proposal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ProposalController {
	
	@Autowired
	private ProposalRepository proposalRepository;
	
	@PostMapping("/proposals")
	public ResponseEntity<?> create (@RequestBody @Valid ProposalRequest request, UriComponentsBuilder uriBuilder) {
		Proposal proposal = request.toModel();
		proposalRepository.save(proposal);
		return ResponseEntity.created(uriBuilder.path("/proposal/{id}").buildAndExpand(proposal.getId()).toUri()).build();
	}

}
