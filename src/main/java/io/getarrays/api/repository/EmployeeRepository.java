package io.getarrays.api.repository;

import io.getarrays.api.model.Employee;
import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeRepository extends ListCrudRepository<Employee, Integer> {
}
