package br.com.zupacademy.gabriel.proposta.wallet;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.proposta.card.Card;

@Entity
public class Wallet {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email @NotBlank
	private String email;
	
	@NotNull @Enumerated(EnumType.STRING)
	private WalletName walletName;
	
	@ManyToOne @NotNull
	private Card card;
	
	@Deprecated
	public Wallet() {
	}

	public Wallet(@Email @NotBlank String email, @NotNull WalletName walletName, @NotBlank Card card) {
		super();
		this.email = email;
		this.walletName = walletName;
		this.card = card;
	}

	public WalletName getWalletName() {
		return walletName;
	}
	

	public Long getId() {
		return id;
	}

}
