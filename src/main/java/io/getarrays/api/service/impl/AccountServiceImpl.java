package io.getarrays.api.service.impl;

import io.getarrays.api.model.Account;
import io.getarrays.api.model.Role;
import io.getarrays.api.model.constants.RoleType;
import io.getarrays.api.model.dto.AccountDTO;
import io.getarrays.api.repository.AccountRepository;
import io.getarrays.api.repository.RoleRepository;
import io.getarrays.api.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

	private final AccountRepository userRepo;
	private final RoleRepository roleRepo;
	private final PasswordEncoder encoder;

	@Override
	public Account createUser(AccountDTO account) {
		log.info("AccountServiceImpl.createUser START with parameter: {}", account);
		Account a = new Account();
		a.setUsername(account.getUsername());
		a.setPassword(encoder.encode(account.getPassword()));
		List<Role> roles = account.getRoles()
			.stream()
			.map(p -> roleRepo.findByName(RoleType.getByName(p.getName())).orElseThrow())
			.toList();
		a.setRoles(roles);
		log.info("AccountServiceImpl.createUser END");
		return userRepo.save(a);
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
