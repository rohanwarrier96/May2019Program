package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;

//Initialize the JUnit Test when Spring Boot Application Environment
//Spring Boot Test: used to test Spring Application Context
//with all the test cases identified

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentAppTests {
		
		//scan in memory all the components and provide the best match object in the component
		@Autowired
		DepartmentService depService;
		
		@Autowired
		Department dep;
		
		@Test
		public void addDepartmentUsingService() {
			dep.setName("New Department");
			dep.setLocation("London");
			dep=depService.registerOrUpdateDepartment(dep);
			assertNotNull(dep);
		}

		@Test
		public void findByDeptnoUsingService() {
			int deptno =23;
			assertNotNull(depService.findByDepno(deptno));
		}
		
		@Test
		public void deleteByEmpnoUsingService() {
			int depno=27;
			depService.deleteByDeptno(depno);
			assertNull(depService.findByDepno(depno));
		}
		
		
		@Test
		public void checkFetchByLocation() {
			List<Department> deps= depService.fetchDepartmentByLocation("London");
			for(Department department:deps) {
				System.out.println(department);
			}
			assertEquals(deps.size(),5);
		}
}
