package com.ahmedbelhout.authenticationn.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedbelhout.authenticationn.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	// READ ALL
	List<Book> findAll();

}