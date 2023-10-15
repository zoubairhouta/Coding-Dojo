package com.ahmedbelhout.authenticationn.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedbelhout.authenticationn.models.Publisher;
import com.ahmedbelhout.authenticationn.repositories.PublisherRepository;


	
	@Service
	public class PublisherService {
		
		@Autowired
		private PublisherRepository publisherRepo;
		
		// C R U D

		// READ ALL
		public List<Publisher> findAll(){
			return publisherRepo.findAll();
		}
		
		// CREATE
		public Publisher createPublisher(Publisher p) {
			return publisherRepo.save(p);
		}
		
		// READ ONE 
		public Publisher findPublisher(Long id) {
			Optional<Publisher> maybePublisher = publisherRepo.findById(id);
			if(maybePublisher.isPresent()) {
				return maybePublisher.get();
			}else { 
				return null;
			}
		}
		
		// UPDATE 
		public Publisher updatePublisher(Publisher p) {
			return publisherRepo.save(p);
		}
		
		// DELETE
		public void deletePublisher(Long id) {
			publisherRepo.deleteById(id);
		}
	}