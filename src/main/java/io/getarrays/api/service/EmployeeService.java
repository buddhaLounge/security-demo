package io.getarrays.api.service;

import io.getarrays.api.model.Employee;
import io.getarrays.api.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    Employee saveOrUpdateEmployee(EmployeeDTO employee);

    //Make sure you paginate the results in a new implementation
    List<Employee> getAllEmployees();

    Employee findEmployeeById(int id);

    boolean deleteEmployeeById(int id);
}
