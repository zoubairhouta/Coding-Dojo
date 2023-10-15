package com.ahmedbelhout.authenticationn.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedbelhout.authenticationn.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	// Find by Email
	Optional<User> findByEmail(String email);
}