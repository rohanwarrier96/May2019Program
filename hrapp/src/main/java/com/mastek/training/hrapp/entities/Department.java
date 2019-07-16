package com.mastek.training.hrapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //one copy for each test
@Entity // declares as an entity
@Table(name="JPA_DEPARTMENT")// declaring the table name for the class

@NamedQueries({
	@NamedQuery(name="Department.findByLocation",
			query="select d from Department d where d.location = :location")
})//JPA Query
public class Department implements Serializable {
	@Value("-1")
	private int deptno;
	@Value("Default Dept")
	private String name;
	@Value("Location")
	private String location;
	
	public Department() {
		System.out.println("Department Created");
	}

	@Id //declare the property as Primary Key
	@Column(name="department_number")//declare the column name
	@GeneratedValue(strategy=GenerationType.AUTO) //auto-numbering the primary key
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Column(name="department_name", nullable= false, length=45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="department_location", nullable= false, length=45)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [getDeptno()=" + getDeptno() + ", getName()=" + getName() + ", getLocation()="
				+ getLocation() + "]";
	}
	
	
	
}
