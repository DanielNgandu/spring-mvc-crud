package com.form.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="employees")
public class Employee {
	@Column(name="first_name")
	@NotNull(message="Field cant be empty!")
	@Size(min=5,message = "is required.")
	private String first_name;
	
	
	@Column(name="last_name")
	@NotNull(message="Field cant be empty!")
	@Size(min=5,message = "is required.")
	private String last_name;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Min(value=1,message="Value should be above 0")
    private long id;
	
	@Column(name="email")
	@NotNull(message="Field cant be empty!")
	@Size(min=5,message = "is required.")
    private String email;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id,String first_name,String last_name, String email) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [first_name=" + first_name + ", last_name=" + last_name + ", id=" + id + ", email=" + email
				+ "]";
	}


	

	
}
