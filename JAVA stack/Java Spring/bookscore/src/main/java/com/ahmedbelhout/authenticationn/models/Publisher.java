package com.ahmedbelhout.authenticationn.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="publishers")
public class Publisher {
	
	 public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@NotBlank
	@Size(min = 3, max = 50)
	private String  name;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String location;
	
	// 1:M
	
	@OneToMany(mappedBy="publisher", fetch = FetchType.LAZY)
	private List<Book> booksList;
	
	
	
	// CONSTRUCTOR
	public Publisher() {};
	
	//Don't forget the GETTERS & SETTERS
	public Long getId() {
		return id;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}