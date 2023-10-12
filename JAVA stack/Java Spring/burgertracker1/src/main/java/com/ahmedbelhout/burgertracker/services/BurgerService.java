package com.ahmedbelhout.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ahmedbelhout.burgertracker.models.Burger;
import com.ahmedbelhout.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	private final BurgerRepository repo;
	
	public BurgerService(BurgerRepository repo) {
		this.repo = repo;
	}
	
	public List<Burger> allBurgers() {
		return repo.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return repo.save(burger);
	}
	
	public Burger findBurger(Long id) {
		
		Optional<Burger> burger = repo.findById(id);
		if (burger.isPresent()) {
			return burger.get();
		}
		else {
			return null;
		}
	}
	
	public Burger updateBook(Burger burger) {
		
		return repo.save(burger);
	}
	
	public void deleteBurger(Long id) {
		repo.deleteById(id);
	}
}