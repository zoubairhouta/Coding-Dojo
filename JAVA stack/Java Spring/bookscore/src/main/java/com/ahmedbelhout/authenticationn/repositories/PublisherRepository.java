package com.ahmedbelhout.authenticationn.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedbelhout.authenticationn.models.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
	
	// READ ALL
	List<Publisher> findAll();
	
}