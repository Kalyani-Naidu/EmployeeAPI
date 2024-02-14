package com.example.WebServiceExample.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebServiceExample.Entity.Employee;
import com.example.WebServiceExample.Repository.EmployeeRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmployeeRepo repo;
	
	public String saveEmployee(Employee emp) {
		repo.save(emp);
		return "Data saved!";
	}
	
	public String saveAllEmployees(List<Employee> allEmp){
		repo.saveAll(allEmp);
		return "Data saved succesfully";
	}
	
	public Employee getEmployee(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	public String removeEmployee(int id) {
		repo.deleteById(id);
		return "Employee removed successfully";
	}
	
	public String updateRecord(int id, Employee empData) {
		if(repo.findById(id) != null) {
			Optional<Employee> data = repo.findById(id);
			Employee employee = data.get();
			employee.setName(empData.getName());
			employee.setAge(empData.getAge());
			employee.setDateOfJoining(empData.getDateOfJoining());
			employee.setDepartment(empData.getDepartment());
			employee.setDesignation(empData.getDesignation());
			employee.setGender(empData.getGender());
			employee.setSalary(empData.getSalary());
			repo.save(employee);
			return "Data updated successfully";
		}
		else {
			return "Empid not found";	
		}
	}

}
