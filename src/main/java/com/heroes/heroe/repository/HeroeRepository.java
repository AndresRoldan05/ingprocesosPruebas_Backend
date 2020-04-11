package com.heroes.heroe.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroes.heroe.entity.Heroe;

@Repository("heroeRepository")
public interface HeroeRepository extends JpaRepository<Heroe, Serializable> {

	public abstract Heroe findHeroeById(String id);

	
}
