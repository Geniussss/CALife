package com.jay.ca.easylife.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int Id;
	@Column(name = "EMAIL")
	@Email(message = "*Please provide a valid Email!")
	@NotEmpty(message = "*Please provide an email!")
	private String email;
	@Column(name = "PASSWORD")
	@Length(min = 5, message = "*Your password must have at least 5 characters!")
	@NotEmpty(message = "*Please provide your password!")
	@Transient
	private String password;
	@Column(name = "FIRST_NAME")
	@NotEmpty(message = "*Please provide your name!")
	private String firstname;
	@Column(name = "LAST_NAME")
	@NotEmpty(message = "*Please provide your lastname!")
	private String lastname;
	@Column(name = "ADDRESS")
	@NotEmpty(message = "*Please provide an address!")
	private String address;
	@Column(name = "PHONENUMBER")
	@NotNull(message = "*Please provide your phone numbers!")
	@Min(10)
	private int phonenumber;
	@Column(name = "ACTIVE")
	private int active;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "USER_ROLE",
				joinColumns = @JoinColumn(name = "USER_ID"),
				inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles = new HashSet<Role>();
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
