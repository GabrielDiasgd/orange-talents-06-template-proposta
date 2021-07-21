package br.com.zupacademy.gabriel.proposta.wallet;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.proposta.card.Card;

public class WalletRequest {
	
	@NotBlank @Email
	private String email;
	
	@NotNull
	private WalletName walletName;

	public WalletRequest(@NotBlank @Email String email, @NotNull WalletName walletName) {
		super();
		this.email = email;
		this.walletName = walletName;
	}
	
	public WalletName getWalletName() {
		return walletName;
	}

	public Wallet toModel(Card card) {
		return new Wallet(this.email, this.walletName, card);
	}

	public WalletRequestExternal toExternalRequest() {
		return new WalletRequestExternal(this.email, this.walletName.toString());
	}
	
	

}
