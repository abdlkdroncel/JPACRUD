package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String surName;
	private int salary;
	
	public Employee() {
		super();
	}
	public Employee(int id, String name, String surName, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surName=" + surName + ", salary=" + salary + "]";
	}
	
}
