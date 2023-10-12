package com.ahmedbelhout.burgertracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @NotBlank
    @NotNull
    @Size(min = 5, max = 200)
    private String name;
    @NotBlank
    @NotNull
    @Size(min = 5, max = 200)
    private String restaurantName;

    @NotNull
    @Min(1)
    @Max(6)
    private int rating;
    

    private String notes="";
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date updatedAt;


    //Constructors 
    
    
    
    
    
    
    
    
    
    //Getters and Setters
	public Long getId() {
		return id;
	}
	public Burger() {
		super();
	}

	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
