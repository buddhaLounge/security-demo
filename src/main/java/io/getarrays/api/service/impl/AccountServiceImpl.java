package io.getarrays.api.service.impl;

import io.getarrays.api.model.Account;
import io.getarrays.api.model.Role;
import io.getarrays.api.repository.AccountRepository;
import io.getarrays.api.repository.RoleRepository;
import io.getarrays.api.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountRepository userRepo;
	private final RoleRepository roleRepo;
	private final PasswordEncoder encoder;

	@Override
	public Account createUser(Account account) {
		account.setPassword(encoder.encode(account.getPassword()));
		Role role = roleRepo.findByName("USER").orElseThrow();
		account.setRoles(List.of(role));
		return userRepo.save(account);
	}

	@Override
	public Optional<Account> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public List<Account> getUsers() {
		return userRepo.findAll();
	}

}
