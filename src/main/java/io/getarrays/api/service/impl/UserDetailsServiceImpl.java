package io.getarrays.api.service.impl;

import io.getarrays.api.model.Account;
import io.getarrays.api.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AccountRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> optUser = repo.findByUsername(username);
		if(optUser.isEmpty()){
			String msg = String.format("User %s not found", username);
			throw new UsernameNotFoundException(msg);
		}

		Account account = optUser.get();
		if(account.getRoles() == null || account.getRoles().isEmpty()){
			String msg = String.format("User %s has no roles", username);
			throw new IllegalStateException(msg);
		}

		List<GrantedAuthority> authorities = account.getRoles().stream()
			.map(role -> new SimpleGrantedAuthority(String.format("ROLE_%s", role.getName())))
			.collect(Collectors.toList());

		return new User(account.getUsername(), account.getPassword(), account.isEnabled(), !account.isExpired(),
			!account.isCredentialsExpired(), !account.isLocked(),	authorities);
	}

}
