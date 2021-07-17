package br.com.zupacademy.gabriel.proposta.card;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RenegotiationResponse {
	
	private String id;
	private Integer quantity;
	private BigDecimal value;
	private LocalDateTime creationDate;
	
	@Deprecated
	public RenegotiationResponse() {
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
	
	public Renegotiation toModel () {
		return new Renegotiation(this.id, this.quantity, this.value, this.creationDate);
	}
	
	
	

}
