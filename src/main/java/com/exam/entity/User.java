package com.exam.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;//d
	private String password;//d
	private String firstName;//d
	private String middleName;//d
	private String lastName;//d
	private String email;//d
	private String city;
	private String state;
	private String qualification;
	private String year_of_completion;
	private String dob;
	private String phone;//d
	private boolean enabled = true;
	private String profile;//d

	public User() {

	}

	

	public User(int id, String username, String password, String firstName, String middleName, String lastName,
			String email, String city, String state, String qualification, String year_of_completion, String dob,
			String phone, boolean enabled, String profile, Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.qualification = qualification;
		this.year_of_completion = year_of_completion;
		this.dob = dob;
		this.phone = phone;
		this.enabled = enabled;
		this.profile = profile;
		this.userRoles = userRoles;
	}
	
	public User(int id, String username, String password, String firstName, String lastName, String email, String phone,
			String state, String city, boolean enabled, String profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.state = state;
		this.city = city;
		this.enabled = enabled;
		this.profile = profile;
	}



	// mapped by user to avoid extra table
	// fetch type eager such that when
	// data is entered in user it
	// should also be fetched in role
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore // to ignore the Json
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "user")//when lazy it means we have to call the getter then only the data gets loaded
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//when we fetch quiz we dont get the data of questions
	private Set<Report> reports=new HashSet<Report>();
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getMiddleName() {
		return middleName;
	}



	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getQualification() {
		return qualification;
	}



	public void setQualification(String qualification) {
		this.qualification = qualification;
	}



	public String getYear_of_completion() {
		return year_of_completion;
	}



	public void setYear_of_completion(String year_of_completion) {
		this.year_of_completion = year_of_completion;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}



	public Set<UserRole> getUserRoles() {
		return userRoles;
	}



	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}



}
