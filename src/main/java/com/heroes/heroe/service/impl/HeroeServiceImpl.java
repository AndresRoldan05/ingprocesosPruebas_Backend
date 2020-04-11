package com.heroes.heroe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.heroes.heroe.entity.Heroe;
import com.heroes.heroe.service.HeroeService;
import com.heroes.heroe.repository.HeroeRepository;

@Service("heroeServiceImpl")
public class HeroeServiceImpl implements HeroeService {

	@Autowired
	@Qualifier("heroeRepository")
	private HeroeRepository heroeRepository; 
	
	@Override
	public Heroe findHeroeById(String id) {
		return heroeRepository.findHeroeById(id);
	}

	@Override
	public List<Heroe> getHeroes() {		
		return heroeRepository.findAll();
	}

	@Override
	public void removeHeroe(String id) {
		Heroe heroe= heroeRepository.findHeroeById(id);
		if(heroe != null) {
		heroeRepository.delete(heroe);
		//return "Se elimino correctamente";
		}
		
		//return "No se envcontro el heroe";
		
	}

	@Override
	public Heroe addHeroe(Heroe heroe) {		
		return heroeRepository.save(heroe);
	}

	@Override
	public Heroe editHeroe(Heroe heroe) {
		return heroeRepository.save(heroe);
	}

}
