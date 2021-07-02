package br.com.springvalidation.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springvalidation.domain.Employee;
import br.com.springvalidation.service.EmployeeService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/employee")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class EmployeeResource {
		
	private final EmployeeService service;
	
	@GetMapping
	public ResponseEntity<?> employeeList(){
		return ResponseEntity.ok(service.list());
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee employeeSave(@Valid @RequestBody Employee employee) {
		return service.save(employee);
	}
}
