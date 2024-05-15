package io.getarrays.apiapplication.repository;

import io.getarrays.apiapplication.model.Employee;
import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeRepository extends ListCrudRepository<Employee, Integer> {
}
