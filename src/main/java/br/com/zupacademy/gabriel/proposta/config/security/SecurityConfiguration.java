package br.com.zupacademy.gabriel.proposta.config.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests -> authorizeRequests
				.antMatchers(HttpMethod.GET, "/proposal/**").hasAuthority("SCOPE_proposal:read")
				.antMatchers(HttpMethod.POST, "/proposal/**").hasAuthority("SCOPE_proposal:write")
				.antMatchers(HttpMethod.POST, "/cards/**").hasAuthority("SCOPE_card:write")
				.antMatchers(HttpMethod.GET, "/cards/**").hasAuthority("SCOPE_card:read")
				.anyRequest().authenticated())
			.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
}
