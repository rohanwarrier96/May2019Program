package com.mastek.training.hrapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectAppTests {
	
		
		//scan in memory all the components and provide the best match object in the component
		@Autowired
		ProjectService projService;
		
		@Autowired
		Project proj;
		
		@Test
		public void addEmployeeUsingService() {
			emp.setEmpno(7); 
			emp.setName("New Employee 7");
			emp.setSalary(5555);
			emp=empService.registerOrUpdateEmployee(emp);
			assertNotNull(emp);
			
			
		}
		

}
