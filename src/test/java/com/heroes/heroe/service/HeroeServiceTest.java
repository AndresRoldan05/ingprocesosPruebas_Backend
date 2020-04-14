package com.heroes.heroe.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.heroes.heroe.entity.Heroe;
import com.heroes.heroe.service.HeroeService;
import com.heroes.heroe.service.impl.HeroeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class HeroeServiceTest {
	
	private static final String id = "1";
	private static final String nombre = "andres";
	private static final String poder = "regeneration";
	private static final boolean vivo = true;
	
	
	@Mock
	private HeroeService heroeService;
	@InjectMocks
	private Heroe heroe = new Heroe();
	
	//@InjectMocks
	//private HeroeController heroeController;
	
	//@Mocks
	//private HeroeService heroeService;
	
	@Mock  //
	private HeroeServiceImpl simple;
	
	@BeforeEach
	public void setUp() {
		heroeService = Mockito.mock(HeroeService.class);
		//###############################33
		MockitoAnnotations.initMocks(this);
		
        heroe.setId(id);
        heroe.setNombre(nombre);
        heroe.setPoder(poder);
        heroe.setVivo (vivo);
        List<Heroe> todos = new ArrayList<Heroe>();
        todos.add(heroe);
		
	}
	
	@Test
	public void getHeroe() {
		//ResponseEntity<Heroe> entit =heroeController.getHeroe(id);
		Mockito.when(heroeService.findHeroeById(this.id)).thenReturn(heroe);
		//Assert.assertEquals(entit.getStatusCode(), HttpStatus.OK);
	}
	
	/*
	@Test
	public void getHeroe() throws Exception{
		Heroe heroe = new Heroe();
		        heroe.setId(id);
		        heroe.setNombre(nombre);
		        heroe.setPoder(poder);
		        heroe.setVivo (vivo);
		  Mockito.when(heroeService.findHeroeById(id)).thenReturn(heroe);
	}
	*/
	
	@Test
	public void getHeroes() throws NullPointerException {
		List<Heroe> todos = heroeService.getHeroes();
		//todos = heroeService.getHeroes();
		 Assert.assertNotNull(todos);
		// Assert.assertTrue(todos.size() > 0);
	}

	@Test
	public void addHeroe() throws Exception {
		
		//heroeService.addHeroe(this.heroe);
		Mockito.when(heroeService.addHeroe(this.heroe)).thenReturn(heroe);
	}

}
