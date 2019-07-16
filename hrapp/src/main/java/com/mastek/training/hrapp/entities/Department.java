package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
	// One department has many Employees
	private Set<Employee> members = new HashSet<>();
	
	//@OneToMany: used on the get method of set to configure association
	//fetch=Lazy: delay the initialisation until method getMembers() is called
	//using additional select query.
	//EAGER: Initialise the collection on entity find Post load event
	//cascade= All the Entity operation done on Department would be performed on each associated employee object
	//ALL:[Persist,Merge,Delete,Refresh]
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="currentDepartment")
	public Set<Employee> getMembers() {
		return members;
	}

	public void setMembers(Set<Employee> members) {
		this.members = members;
	}
	
	
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
