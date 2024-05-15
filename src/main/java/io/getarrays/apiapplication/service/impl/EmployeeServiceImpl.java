package io.getarrays.apiapplication.service.impl;

import io.getarrays.apiapplication.model.Employee;
import io.getarrays.apiapplication.repository.EmployeeRepository;
import io.getarrays.apiapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public Employee saveOrUpdateEmployee(Employee employee) {
		return employeeRepository.save(employee);
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
