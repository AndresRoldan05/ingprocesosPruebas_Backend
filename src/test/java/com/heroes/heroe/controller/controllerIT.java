package com.heroes.heroe.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;
import com.heroes.heroe.entity.Heroe;
import com.heroes.heroe.service.HeroeService;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

@RunWith(SpringRunner.class)
//@WebIntegrationTest({"server.port=3600"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class controllerIT {
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Autowired
	private HeroeService heroeService;
	
	@Test
	void addHero() {
		ResponseEntity<Heroe> responseEntity = restTemplate.postForEntity("/addheroe", new Heroe ("2", "loida", "psiquis", true), Heroe.class);
		Heroe hero = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	

	@Test
	void getHeroForId() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		String fooResourceUrl= "http://localhost:8080/heroe/getheroe/?id=1";
		// String id =1;
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
		Assert.assertEquals(response.getStatusCode(), equals(HttpStatus.OK)); //assertThat, equalsTo
	}
	
	@Test
	void deleteHero() {
		Heroe heroe = new Heroe();
        heroe.setId("3");
        heroe.setNombre("Eliza");
        heroe.setPoder("invisibilidad");
        heroe.setVivo (true);
        
        heroeService.addHeroe(heroe);
        
        String entero = heroe.getId();
        
        restTemplate.delete("http://localhost:8888/heroe/"+ entero, Collections.EMPTY_MAP);
        
        Heroe hero = heroeService.findHeroeById(entero);
        assertNull(hero);

        
	}

}
