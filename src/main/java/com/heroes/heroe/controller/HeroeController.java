package com.heroes.heroe.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

import com.heroes.heroe.entity.Heroe;
import com.heroes.heroe.service.HeroeService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/heroe")
public class HeroeController {
	
	Logger logger;
	
	public HeroeController() {
		logger = Logger.getLogger(HeroeController.class);
		//PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	
	@Autowired
	@Qualifier("heroeServiceImpl")
	private HeroeService heroeService;
		
	
	@GetMapping("/getheroe/{id}")
	public ResponseEntity<Heroe> getHeroe(@PathVariable("id") String id){
		Heroe heroe = heroeService.findHeroeById(id);
		return new ResponseEntity<Heroe>(heroe, HttpStatus.OK);
	}
	
	@GetMapping("/getheroes")
	public ResponseEntity<List<Heroe>> getHeroes(){
		List<Heroe> heroes = heroeService.getHeroes();		
		logger.info("Entro al getheroes");
		return new ResponseEntity<List<Heroe>>(heroes, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeheroe/{id}")
	public void getHeroes(@PathVariable("id") String id){
		heroeService.removeHeroe(id);
		//return new ResponseEntity<String>(resultado, HttpStatus.OK);
	}
	
	
	@PostMapping("/addheroe")
	public Heroe addHeroe(@RequestBody Heroe heroe) {		
		return heroeService.addHeroe(heroe);		
	}
	
	@PutMapping("/editheroe/{id}") // no necesito el id lo dejo para mirar ejemplo 
	public Heroe editHeroe(@RequestBody Heroe heroe, @PathVariable("id") String id ) {	
		//heroeService.removeHeroe(id);  // no se debe eliminar ya que el id es autogenerado y cambia si se elimina el registro
		return heroeService.addHeroe(heroe);		
	}
	

}
