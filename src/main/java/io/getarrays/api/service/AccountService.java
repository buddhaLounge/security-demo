package io.getarrays.api.service;

import io.getarrays.api.model.Account;
import io.getarrays.api.model.dto.AccountDTO;

import java.util.List;
import java.util.Optional;

public interface AccountService {

	Account createUser(AccountDTO account);

	Optional<Account> findByUsername(String username);

	List<Account> getUsers();

}
