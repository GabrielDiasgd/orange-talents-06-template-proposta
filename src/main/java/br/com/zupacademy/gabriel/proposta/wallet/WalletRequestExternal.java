package br.com.zupacademy.gabriel.proposta.wallet;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WalletRequestExternal {
	
	@NotBlank @Email @JsonProperty(value = "email")
	private String email;
	
	@NotNull @JsonProperty(value = "carteira")
	private String walletName;

	public WalletRequestExternal(@NotBlank @Email String email, @NotNull String walletName) {
		this.email = email;
		this.walletName = walletName;
	}

}
