package com.heroes.heroe.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.heroes.heroe.entity.Heroe;
import com.heroes.heroe.service.HeroeService;

class pruebas {
	private static final String id = "1";
	private static final String nombre = "andres";
	private static final String poder = "regeneration";
	private static final boolean vivo = true;
	
	@InjectMocks
	private HeroeController heroeController;
	
	@Mock
	private HeroeService heroeService;
	

	@Test
	void test() {
		Assert.assertEquals(nombre, "andres");
	}
	
	@Test
	public void test2(){
		Heroe heroe = new Heroe();
        heroe.setId(id);
        heroe.setNombre(nombre);
        heroe.setPoder(poder);
        heroe.setVivo (vivo);
        Assert.assertEquals(heroe.getNombre(), "andres");
  //Mockito.when(heroeService.findHeroeById(id)).thenReturn(heroe);
	}
	
	@Test
	public void test3() {
		Heroe heroe = new Heroe();
        heroe.setId(id);
        heroe.setNombre(nombre);
        heroe.setPoder(poder);
        heroe.setVivo (vivo);
        when(heroeController.addHeroe(heroe)).thenReturn(heroeService.addHeroe(heroe));
	}

}
