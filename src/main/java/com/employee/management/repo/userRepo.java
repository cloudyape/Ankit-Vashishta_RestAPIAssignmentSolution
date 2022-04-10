package com.employee.management.repo;

import com.employee.management.models.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<user, Long> {
}
