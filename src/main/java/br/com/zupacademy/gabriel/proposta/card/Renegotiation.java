package br.com.zupacademy.gabriel.proposta.card;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Renegotiation {
	
	@Id
	private String id;
	@Positive
	private Integer quantity;
	@Positive
	private BigDecimal value;
	@NotNull
	private LocalDateTime creationDate;

	
	public Renegotiation(String id, @Positive Integer quantity, @Positive BigDecimal value,
			@NotNull LocalDateTime creationDate) {
				this.id = id;
				this.quantity = quantity;
				this.value = value;
				this.creationDate = creationDate;
	}


	public String getId() {
		return id;
	}
	public Integer getQuantity() {
		return quantity;
	}

	public BigDecimal getValue() {
		return value;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	

}
