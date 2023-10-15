package com.ahmedbelhout.authentication.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Username is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String userName;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message = "Password is required!")
    @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
 
    private String password;

    @Transient
    @NotEmpty(message = "Confirm Password is required!")
    @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
    private String confirm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Please enter a valid date of birth.")
    @NotNull(message = "Date of birth is required.")
    private Date dateOfBirth;

    @NotEmpty(message = "Select at least one programming language as an interest.")
    private List<String> programmingLanguages;
    @NotEmpty(message = "Country is required!")
    private String country;

    @NotEmpty(message = "Gender is required!")
    private String gender;
    
    
    //Empty Constructor for java beans 
    public User() {programmingLanguages = new ArrayList<>();
    programmingLanguages.add("Java");
    programmingLanguages.add("JavaScript");
    programmingLanguages.add("Python");
    programmingLanguages.add("C#");
    programmingLanguages.add("Ruby");
    programmingLanguages.add("C++");}

    
    // TODO - Don't forget to generate getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public List<String> getProgrammingLanguages() {
		return programmingLanguages;
	}


	public void setProgrammingLanguages(List<String> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
    
    
    
  
}