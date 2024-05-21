package io.getarrays.api.resource;

import io.getarrays.api.model.Employee;
import io.getarrays.api.model.dto.EmployeeDTO;
import io.getarrays.api.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid EmployeeDTO employee){
		Employee e = employeeService.saveOrUpdateEmployee(employee);
		return ResponseEntity.created(getLocation(e.getId())).body(e);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(name = "id", required = true) int id){
		return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid EmployeeDTO employee){
		return ResponseEntity.ok(employeeService.saveOrUpdateEmployee(employee));
	}

}
