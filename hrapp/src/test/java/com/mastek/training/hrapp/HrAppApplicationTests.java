package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;

//Initialize the JUnit Test when Spring Boot Application Environment
//Spring Boot Test: used to test Spring Application Context
//with all the test cases identified

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrAppApplicationTests {
	
	//scan in memory all the components and provide the best match object in the component
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	Employee emp;
	
	@Test
	public void addEmployeeUsingService() {
		emp.setEmpno(7); 
		emp.setName("New Employee 7");
		emp.setSalary(5555);
		emp=empService.registerOrUpdateEmployee(emp);
		assertNotNull(emp);
		
		
	}
	
	@Test
	public void findByEmpnoUsingService() {
		int empno =1;
		assertNotNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void deleteByEmpnoUsingService() {
		int empno=15;
		empService.deleteByEmpno(empno);
		assertNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void checkFetchBySalary() {
		List<Employee> emps= empService.fetchEmployeesBySalaryRange(0.0, 10000.0);
		for(Employee employee:emps) {
			System.out.println(employee);
		}
		assertEquals(emps.size(),5);
	}
	
	@Test
	public void manageAssociations() {
		Department d1= new Department();
		d1.setName("Admin");
		d1.setLocation("UK");
		
		Employee emp1=new Employee();
		emp1.setName("Admin Emp 1");
		emp1.setSalary(3433);
		
		Employee emp2= new Employee();
		emp2.setName("Admin Emp 2");
		emp2.setSalary(34456);
		
		Project p1=new Project();
		p1.setName("UK Project");
		p1.setCustomerName("UK Customer");
		
		Project p2= new Project();
		p2.setName("US Project");
		p2.setCustomerName("US Customer");
		
		
		//one to Many: one Department has many Employees
		d1.getMembers().add(emp1);
		d1.getMembers().add(emp2);
		
		emp1.setCurrentDepartment(d1);
		emp2.setCurrentDepartment(d1);
		//Many to Many
		emp1.getAssignments().add(p1);
		emp1.getAssignments().add(p2);
		emp2.getAssignments().add(p1);
		
		deptService.registerOrUpdateDepartment(d1);
	}
	
	@Test
	public void simpleTest() {
	System.out.println("System Test Executed");
	}
	
	

}
