package br.com.zupacademy.gabriel.proposta.card;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

@Entity
public class Installment {
	
	@Id
	private String id;
	@Positive
	private Integer quantity;
	@Positive
	private BigDecimal value;
	@ManyToOne
	private Card card;
	

}
