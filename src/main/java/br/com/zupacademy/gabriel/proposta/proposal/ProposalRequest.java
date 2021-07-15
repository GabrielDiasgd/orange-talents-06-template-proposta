package br.com.zupacademy.gabriel.proposta.proposal;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.gabriel.proposta.config.validations.Document;

public class ProposalRequest {
	
	@Document @NotNull
	private String document;
	@Email @NotBlank
	private String email;
	@NotBlank
	private String name;
	@NotBlank
	private String address;
	@Positive @NotNull
	private BigDecimal salary;
	
	
	public ProposalRequest(@Document @NotNull String document, @Email @NotBlank String email, @NotBlank String name,
			@NotBlank String address, @Positive @NotNull BigDecimal salary) {
		super();
		this.document = document;
		this.email = email;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	
	
	public Proposal toModel() {
		return new Proposal(this.document, this.email, this.name, this.address, this.salary);
	}
}
