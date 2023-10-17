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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
 

//Hehdeya el model mt3 trips feha tableu fel sql esmou trips

//fih el id wel title start date end date lead elli howa el creator(one to many)  wel participants (many to many)
@Entity
@Table(name="trips")
public class Trip {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Title is required!")
    private String title;

    @NotEmpty(message="Plan is required!")
    @Size(min=3, message="Plan must be at least 3 characters long")
    private String plan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message=" startDate  is required!")
    private Date startDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message=" endDate is required!")
    private Date endDate;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private User tripCreator;

    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_trips",
			joinColumns = @JoinColumn(name = "trip_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
    private List<User> users;

    
    
    
    
    //Empty Constructor
    public Trip() {}

    
    //Getters and setters 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public User getTripCreator() {
		return tripCreator;
	}
	public void setTripCreator(User tripCreator) {
		this.tripCreator = tripCreator;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	//Hedheya Validation  el start date lezemha tekhdem 9bal el end date 
	  // Custom validation method to ensure startDate is before endDate
    @AssertTrue(message = "Start date must be before end date")
    public boolean isStartDateBeforeEndDate() {
        return startDate.before(endDate);
    }

}