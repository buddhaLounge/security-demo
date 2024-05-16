package io.getarrays.api.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfiguration {

	private final UserDetailsService service;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.getSharedObject(AuthenticationManagerBuilder.class)
			.authenticationProvider(new AuthenticationProvider(encoder(), service));
		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(
				req -> req.requestMatchers(HttpMethod.POST, "/api/users").permitAll()
				.anyRequest().hasAnyRole("USER", "ADMIN")
			)
			.httpBasic(withDefaults())
			.sessionManagement(conf -> conf.sessionCreationPolicy(STATELESS));
		return http.build();
	}

	@Bean
	public PasswordEncoder encoder(){
		return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y);
	}

}
