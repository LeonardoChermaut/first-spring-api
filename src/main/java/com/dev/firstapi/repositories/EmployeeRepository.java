package com.dev.firstapi.repositories;

import com.dev.firstapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
