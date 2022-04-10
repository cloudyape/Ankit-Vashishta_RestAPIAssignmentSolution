package com.employee.management.controller;

import com.employee.management.models.user;
import com.employee.management.models.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.employee.management.repo.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private employeesRepo employeesRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/employees")
    public List<employees> getUsers() {
        return employeesRepo.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(consumes = "application/json", value = "/save")
    public String saveEmployees(@RequestBody employees employees) {
        employeesRepo.save(employees);
        return "Saved...";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id , @RequestBody employees employees) {
        System.out.print(id);
        employees updateUser = employeesRepo.findById(id).get();
        updateUser.setFirstname(employees.getFirstname());
        updateUser.setLastname(employees.getLastname());
        updateUser.setEmail(employees.getEmail());
        employeesRepo.save(updateUser);
        return "Updated...";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        employees deleteUser = employeesRepo.findById(id).get();
        employeesRepo.delete(deleteUser);
        return "Delete User with the id: "+id;
    }
}
