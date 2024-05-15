package io.getarrays.apiapplication.resource;

import io.getarrays.apiapplication.model.Account;
import io.getarrays.apiapplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AccountResource implements BaseResource {

	private final AccountService service;

	@PostMapping
	public ResponseEntity<Account> create(@RequestBody Account account) {
		Account newAccount = service.createUser(account);
		return ResponseEntity.created(getLocation(newAccount.getId())).body(newAccount);
	}

	@GetMapping
	public ResponseEntity<List<Account>> getUsers(){
		return ResponseEntity.ok(service.getUsers());
	}

}
