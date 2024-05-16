package io.getarrays.api.service;

import io.getarrays.api.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

	Account createUser(Account account);
	Optional<Account> findByUsername(String username);
	List<Account> getUsers();

}
