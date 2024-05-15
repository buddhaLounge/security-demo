package io.getarrays.apiapplication.service;

import io.getarrays.apiapplication.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

	Account createUser(Account account);
	Optional<Account> findByUsername(String username);
	List<Account> getUsers();

}
