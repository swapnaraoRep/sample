package com.login.rest.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_TBL1")
public class Employee implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

@Column
private String name;

@Column
private float salary;

@Column
private String designation;

@Column
private String password;


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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
public float getSalary() {  
    return salary;  
}  
public void setSalary(float salary) {  
    this.salary = salary;  
}  
public String getDesignation() {  
    return designation;  
}  
public void setDesignation(String designation) {  
    this.designation = designation;  
}  
  
}  
