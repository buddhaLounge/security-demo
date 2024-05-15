package io.getarrays.apiapplication.init;

import io.getarrays.apiapplication.model.Account;
import io.getarrays.apiapplication.model.Role;
import io.getarrays.apiapplication.repository.AccountRepository;
import io.getarrays.apiapplication.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static java.util.List.of;

/*@Component
@RequiredArgsConstructor*/
public class ApplicationStartRunner implements CommandLineRunner {

	/*private final RoleRepository roleRepo;
	private final AccountRepository accountRepo;
	private final PasswordEncoder encoder;*/

	@Override
	public void run(String... args) throws Exception {
		/*Role roleUser = new Role(1, "123", "USER");
		Role roleAdmin = new Role(2, "456", "ADMIN");
		roleRepo.saveAll(of(roleUser, roleAdmin));
		Account mainAccount = new Account();
		mainAccount.setUsername("andrea");
		mainAccount.setPassword(encoder.encode("andrea"));
		mainAccount.setRoles(of(roleUser));
		accountRepo.save(mainAccount);*/
	}
}
