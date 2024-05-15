package io.getarrays.apiapplication.resource;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.*;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.getarrays.apiapplication.model.Employee;
import io.getarrays.apiapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/employees")
@RequiredArgsConstructor
public class EmployeeResource implements BaseResource{

	private final EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(required = true, name = "id") int id){
		return ResponseEntity.ok(employeeService.findEmployeeById(id));
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee e = employeeService.saveOrUpdateEmployee(employee);
		return ResponseEntity.created(getLocation(e.getId())).body(e);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(name = "id", required = true) int id){
		return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.saveOrUpdateEmployee(employee));
	}

}
