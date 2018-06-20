package com.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class Employee {

	private int employeeId;
	private String employeeName;
	private String designation;
	private int experience;
	private long contactNum;
	private double salary;
	
	public Employee(int employeeId, String employeeName, String designation, int experience, long contactNum,
			double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.experience = experience;
		this.contactNum = contactNum;
		this.salary = salary;
	}
	public Employee() {
		
	}
	
	@XmlElement
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@XmlElement
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@XmlElement
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@XmlElement
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@XmlElement
	public long getContactNum() {
		return contactNum;
	}
	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}
	@XmlElement
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + employeeId + ", name=" + employeeName + ", designation="
				+ designation + ", experience=" + experience + ", contactNum=" + contactNum
				+ ", salary=" + salary + "]";
	}
	

}
