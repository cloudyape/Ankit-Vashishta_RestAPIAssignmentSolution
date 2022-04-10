package com.employee.management.repo;

import com.employee.management.models.employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeesRepo extends JpaRepository<employees, Long> {
}