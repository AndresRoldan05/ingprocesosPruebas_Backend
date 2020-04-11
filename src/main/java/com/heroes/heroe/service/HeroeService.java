package com.heroes.heroe.service;

import java.util.List;

import com.heroes.heroe.entity.Heroe;

public interface HeroeService {

	public abstract Heroe findHeroeById(String id);
	
	public abstract List<Heroe> getHeroes();
	
	public abstract void removeHeroe(String id);
	
	public abstract Heroe addHeroe(Heroe heroe);
	
	public abstract Heroe editHeroe(Heroe heroe);
}
