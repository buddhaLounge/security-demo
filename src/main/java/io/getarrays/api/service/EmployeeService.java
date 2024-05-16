package io.getarrays.api.service;

import io.getarrays.api.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveOrUpdateEmployee(Employee employee);

    //Make sure you paginate the results in a new implementation
    List<Employee> getAllEmployees();

    Employee findEmployeeById(int id);

    boolean deleteEmployeeById(int id);
}
