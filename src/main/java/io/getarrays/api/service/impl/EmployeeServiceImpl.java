package io.getarrays.api.service.impl;

import io.getarrays.api.model.Employee;
import io.getarrays.api.model.dto.EmployeeDTO;
import io.getarrays.api.repository.EmployeeRepository;
import io.getarrays.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public Employee saveOrUpdateEmployee(EmployeeDTO employee) {
		Employee e = new Employee();
		e.setFirstName(employee.getFirstName());
		e.setLastName(employee.getLastName());
		e.setEmail(employee.getEmail());
		return employeeRepository.save(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) {
		return employeeRepository.findById(id).orElseThrow();
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return true;
	}
}
