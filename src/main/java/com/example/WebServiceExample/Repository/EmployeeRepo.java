package com.example.WebServiceExample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebServiceExample.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
