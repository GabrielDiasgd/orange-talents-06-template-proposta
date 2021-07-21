package br.com.zupacademy.gabriel.proposta.card;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zupacademy.gabriel.proposta.travel.ExternalTravelNotificationRequest;
import br.com.zupacademy.gabriel.proposta.wallet.WalletRequestExternal;
import feign.Response;

@FeignClient(name = "card", url = "${api.cards.url}")
public interface CardClient {
	
	@PostMapping
	public CardResponse associateCard (@RequestBody CardRequest request);

	@PostMapping("/{cardNumber}/bloqueios")
	public Response notifyCardBlock(@PathVariable String cardNumber, @RequestBody Map<String, String> request);
	
	@PostMapping("/{cardNumber}/avisos")
	public String notify (@PathVariable String cardNumber, @RequestBody ExternalTravelNotificationRequest request);
	
	@PostMapping("/{cardNumber}/carteiras")
	public String associate (@PathVariable String cardNumber, @RequestBody WalletRequestExternal request);
}
