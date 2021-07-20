package br.com.zupacademy.gabriel.proposta.card.duedate;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gabriel.proposta.card.Card;

public class DueDateResponse {

	private String id;
	@NotBlank
	@JsonProperty(value = "dia")
	private String day;
	@NotNull
	@JsonProperty(value = "dataDeCriacao")
	private LocalDateTime creationDate;
	
	@Deprecated
	public DueDateResponse() {
	}
	
	public String getId() {
		return id;
	}
	public String getDay() {
		return day;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	public DueDate toModel (Card card) {
		return new DueDate(this.id, this.day, this.creationDate, card);
	}
	

}
