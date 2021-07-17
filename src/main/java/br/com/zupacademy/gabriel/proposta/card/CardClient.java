package br.com.zupacademy.gabriel.proposta.card;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "card", url = "${api.cards.url}")
public interface CardClient {
	
	@PostMapping
	public CardResponse associateCard (@RequestBody CardRequest request);

}
