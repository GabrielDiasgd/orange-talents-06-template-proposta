package br.com.zupacademy.gabriel.proposta.card;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class DueDate {
	
	@Id
	private String id;
	@NotBlank
	private String day;
	@NotNull
	private LocalDateTime creationDate;
	@OneToOne
	@NotNull
	private Card card;
	
	@Deprecated
	public DueDate() {
	}
	
	public DueDate(String id, @NotBlank String day, @NotNull LocalDateTime creationDate, Card card) {
		this.id = id;
		this.day = day;
		this.creationDate = creationDate;
		this.card = card;
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

	public Card getCard() {
		return card;
	}
	

	@Override
	public String toString() {
		return "DueDate [id=" + id + ", day=" + day + ", creationDate=" + creationDate + ", card=" + card + "]";
	}

	
	
}
