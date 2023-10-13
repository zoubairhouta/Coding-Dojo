package com.ahmedbelhout.dojoandninja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedbelhout.dojoandninja.models.Ninja;
import com.ahmedbelhout.dojoandninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository repoNinja ;
	
	
	public Ninja createNinja(Ninja ninja)
	{
		return repoNinja.save(ninja);
	}	
	
}
