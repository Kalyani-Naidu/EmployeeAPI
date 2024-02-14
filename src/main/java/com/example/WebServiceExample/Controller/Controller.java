package com.example.WebServiceExample.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebServiceExample.Entity.Employee;
import com.example.WebServiceExample.Service.EmpService;


@RestController
@RequestMapping("/employees")
public class Controller {

	@Autowired
	private EmpService empService;
	
	@PostMapping(path = "/saveEmployee")
	public ResponseEntity<String> saveEmp(@RequestBody Employee empData){
		String Status = empService.saveEmployee(empData);
		return new ResponseEntity<>(Status, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/saveAllEmployees")
	public ResponseEntity<String> saveAllEmp(@RequestBody List<Employee> empData){
		String status  = empService.saveAllEmployees(empData);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/getEmp/{empId}")
	public ResponseEntity<Employee> getEmp(@PathVariable int empId){
		Employee employee = empService.getEmployee(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmp(){
		List<Employee> employeeList = empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
	
	@PutMapping(path = "/updateEmployee/{id}")
	public ResponseEntity<String> updateEmp(@PathVariable int id,@RequestBody Employee empData){
		String Status = empService.updateRecord(id, empData);
		return new ResponseEntity<>(Status, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delEmp/{empId}")
	public ResponseEntity<String> delEmp(@PathVariable int empId){
		String status = empService.removeEmployee(empId);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
}
