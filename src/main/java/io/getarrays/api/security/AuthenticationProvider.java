package io.getarrays.api.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private final PasswordEncoder encoder;
	private final UserDetailsService service;

	@Override
	protected void additionalAuthenticationChecks(
		UserDetails userDetails,
		UsernamePasswordAuthenticationToken authentication
	) throws AuthenticationException {
		if(authentication.getCredentials() == null || userDetails.getPassword() == null)
			throw new BadCredentialsException("Credentials may not be null");

		if(encoder.matches((String) authentication.getCredentials(), userDetails.getPassword()))
			throw new BadCredentialsException("Invalid credentials");
	}

	@Override
	protected UserDetails retrieveUser(
		String username,
		UsernamePasswordAuthenticationToken authentication
	) throws AuthenticationException {
		return service.loadUserByUsername(username);
	}
}
