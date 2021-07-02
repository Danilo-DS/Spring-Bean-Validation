package br.com.springvalidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springvalidation.domain.Employee;
import br.com.springvalidation.repositoy.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class EmployeeService {
	
	private final EmployeeRepository repository;
	
	public List<Employee> list() {
		return repository.findAll();
	}
	
	public Employee save(Employee employee) {
		return repository.save(employee);
	}
}
