package com.mastek.training.hrapp.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //one copy for each test
public class Employee {
		@Value("-1")
		private int empno;
		@Value("Default Employee")
		private String name;
		@Value("100.0")
		private double salary;
		
		
		public Employee() {
			System.out.println("Employee Created");
		}
		
		
		public int getEmpno() {
			return empno;
		}
		
		public void setEmpno(int empno) {
			this.empno = empno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [Empno=" + getEmpno() + ", Name=" + getName() + ", Salary=" + getSalary()
					+ "]";
		}
		
		
		
		
}
