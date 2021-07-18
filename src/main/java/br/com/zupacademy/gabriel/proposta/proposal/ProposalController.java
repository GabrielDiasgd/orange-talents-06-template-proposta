package br.com.zupacademy.gabriel.proposta.proposal;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.gabriel.proposta.proposal.solicitation.CheckSolicitationStatus;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

	@Autowired
	private ProposalRepository proposalRepository;
	
	@Autowired
	private CheckSolicitationStatus checkStatus;

	@PostMapping
	@Transactional
	public ResponseEntity<?> create(@RequestBody @Valid ProposalRequest request, UriComponentsBuilder uriBuilder) {
		Proposal proposal = request.toModel();
		if (proposal.existsProposalforTheSameRequester(proposalRepository)) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body("Já existe uma proposta para esse solicitante");
		}
		proposalRepository.save(proposal);
		proposal.setProposalStatus(checkStatus.converteResultadoSolicitacaoForProposalStatus(proposal));

		return ResponseEntity.created(uriBuilder.path("/proposal/{id}").buildAndExpand(proposal.getId()).toUri())
				.build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultProposal (@PathVariable Long id){
		Optional<Proposal> proposal = proposalRepository.findById(id);
		if (proposal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe nenhuma proposta com id " + id + " cadastrada");
		}
		
		return ResponseEntity.ok(new ProposalResponse(proposal.get()));
	}

}
