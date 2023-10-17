package com.ahmedbelhout.tripbuddy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedbelhout.tripbuddy.models.Trip;
import com.ahmedbelhout.tripbuddy.models.User;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
	List<Trip> findAll();
	Trip findByIdIs(Long id);
	List<Trip> findAllByUsers(User user);
	List<Trip> findByUsersNotContains(User user);
}