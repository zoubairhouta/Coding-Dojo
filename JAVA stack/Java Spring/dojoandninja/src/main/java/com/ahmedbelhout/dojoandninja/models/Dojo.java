package com.ahmedbelhout.dojoandninja.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotBlank
	@NotNull
	@Size(min = 5, max = 100)
	private String name;
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date updatedAt;
	
	
	//Constructors
	public Dojo() {
	}


	
	
	//Getters And Setters
	

	public List<Ninja> getNinjas() {
		return ninjas;
	}




	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}











	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@PrePersist
	protected void onCreate()
	{
		this.createdAt = new Date();
	}
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	}


