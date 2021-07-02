package br.com.springvalidation.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springvalidation.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
