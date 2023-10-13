package com.ahmedbelhout.dojoandninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedbelhout.dojoandninja.models.Dojo;
import com.ahmedbelhout.dojoandninja.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository repoDojo;

	public DojoService(DojoRepository repoDojo) {
		this.repoDojo = repoDojo;
	}

	public Dojo createDojo(Dojo dojo) {
		return repoDojo.save(dojo);
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo> optDojo = repoDojo.findById(id);
		if (optDojo.isPresent()) {
			return optDojo.get();
		} else {
			return null;
		}
	}
	
	public List<Dojo> findAll()
	{
		return repoDojo.findAll();
	}

}
