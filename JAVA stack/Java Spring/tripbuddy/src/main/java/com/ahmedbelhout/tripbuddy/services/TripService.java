package com.ahmedbelhout.tripbuddy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ahmedbelhout.tripbuddy.models.Trip;
import com.ahmedbelhout.tripbuddy.models.User;
import com.ahmedbelhout.tripbuddy.repositories.TripRepository;

@Service
public class TripService {
	private final TripRepository tripRepo;

	public TripService(TripRepository tripRepo) {
		this.tripRepo = tripRepo;
	}

	public List<Trip> allTrips(){
		return tripRepo.findAll();
	}
	public List<User> getPeopleWhoJoinedTheTrip(Trip)

	public Trip updateTrip(Trip trip) {
		return tripRepo.save(trip);
	}
// hedhi query mt3 go find in the database fi tableau el trips el elli contains el users
	public List<Trip> getAssignedTrips(User user){
		return tripRepo.findAllByUsers(user);
	}

	// hedhi query mt3 go find in the database fi tableau el trips el elli not contains el users
	public List<Trip> getUnassignedTrips(User user){
		return tripRepo.findByUsersNotContains(user);
	}
	

	public Trip addTrip(Trip trip) {
		return tripRepo.save(trip);
	}

	public void deleteTrip(Trip trip) {
		tripRepo.delete(trip);
	}

	public Trip findById(Long id) {
		Optional<Trip> optionalTrip = tripRepo.findById(id);
		if(optionalTrip.isPresent()) {
			return optionalTrip.get();
		}else {
			return null;
		}
	}

}