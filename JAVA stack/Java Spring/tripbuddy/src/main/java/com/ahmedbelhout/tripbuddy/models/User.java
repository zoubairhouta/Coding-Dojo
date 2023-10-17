package com.ahmedbelhout.tripbuddy.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
// Hedheya el model mt3 El user ma3neha réellement bech nesta3mlou el class Login User bech nekhdmpu beha wel validation mte3ha lli fi User.java wel b9eya optional mahomch required 
//Dima famma el Getters W setters wel empty constructor 

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "First Name is required!")
	@Size(min = 3, max = 30, message = "First Name must be between 3 and 30 characters")
	private String firstName;

	@NotEmpty(message = "Last Name is required!")
	@Size(min = 3, max = 30, message = "Last Name must be between 3 and 30 characters")
	private String lastName;

	@NotEmpty(message = "Email is required!")
	@Email(message = "Please enter a valid email!")
	private String email;

	@NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
	private String password;

	@Transient
	@NotEmpty(message = "Confirm Password is required!")
	@Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
	private String confirm;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// Hehdheya el relation many many mabin el trip wel users lezem tetekteb hakka w
	// fetableau lekher tete9leb w el tableau jointure automatiquement généré

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_trips", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "trip_id"))
	private List<Trip> Trips;

	// Hedhea el relation mt3 one to many men chiret el user puisque one trip can
	// have only 1 creator elli sammitha tripsLed elli ylemha
	@Column(updatable = false)
	@OneToMany(mappedBy = "tripCreator", fetch = FetchType.LAZY)
	private List<Trip> tripsLed;

	// Empty Constructor

	public User() {
	}

	// All getters And Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Trip> getTrips() {
		return Trips;
	}

	public void setTrips(List<Trip> trips) {
		Trips = trips;
	}

	public List<Trip> getTripsLed() {
		return tripsLed;
	}

	public void setTripsLed(List<Trip> tripsLed) {
		this.tripsLed = tripsLed;
	}

}