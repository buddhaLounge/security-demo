package io.getarrays.apiapplication.repository;

import io.getarrays.apiapplication.model.Account;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface AccountRepository extends ListCrudRepository<Account, Integer> {
	Optional<Account> findByUsername(@NonNull String username);
}
