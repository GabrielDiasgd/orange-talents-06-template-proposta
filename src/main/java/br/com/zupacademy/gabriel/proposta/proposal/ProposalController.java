package br.com.zupacademy.gabriel.proposta.proposal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/proposals")
public class ProposalController {
	
	@Autowired
	private ProposalRepository proposalRepository;

	@PostMapping
	public ResponseEntity<?> create (@RequestBody @Valid ProposalRequest request, UriComponentsBuilder uriBuilder) {
		Proposal proposal = request.toModel();
		if (proposal.existsProposalforTheSameRequester(proposalRepository)) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Já existe uma proposta para esse solicitante");
		}
		proposalRepository.save(proposal);
		return ResponseEntity.created(uriBuilder.path("/proposal/{id}").buildAndExpand(proposal.getId()).toUri()).build();
	}

}
