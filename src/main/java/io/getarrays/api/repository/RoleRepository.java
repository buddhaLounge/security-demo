package io.getarrays.api.repository;

import io.getarrays.api.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	Optional<Role> findByName(String name);
}
