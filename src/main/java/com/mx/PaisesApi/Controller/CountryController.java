package com.mx.PaisesApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.PaisesApi.Entity.Country;
import com.mx.PaisesApi.Service.CountryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path="Pais")
@CrossOrigin
public class CountryController {

	@Autowired
	CountryService countrySrvs;
	
	@GetMapping("Lista")
	public List<Country> countryList() {
		return countrySrvs.countryList();
	}

	@PostMapping("Guardar")
	public ResponseEntity<?> Save(@RequestBody Country country) {
		//TODO: process POST request
		String message=countrySrvs.save(country);
		if(message.equals("ok"))
			return new ResponseEntity<Country>(country, HttpStatus.CREATED);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("Buscar")
	public ResponseEntity<?> srch(@RequestBody Country country) {
		country=countrySrvs.srchCountry(country);
		if (country==null) {
			return new ResponseEntity<String>("No se encontro ningun registro", HttpStatus.OK);
		}
		return new ResponseEntity<Country>(country,HttpStatus.OK);
	}
	
	@PutMapping("Editar")
	public ResponseEntity<?> editCountry(@RequestBody Country country) {
		//TODO: process PUT request
		System.out.println(country);
		String message=countrySrvs.edit(country);
		if (!message.equals("ok")) 
			return new ResponseEntity<String>(message,HttpStatus.OK);
		else 
			return new ResponseEntity<Country>(country, HttpStatus.CREATED);
		
	}
	
	@PostMapping("Borrar")
	public String deleteCountry(@RequestBody Country country) {
		//TODO: process POST request
		if(countrySrvs.delete(country)) {
			return "Se ha eleiminado el registro";
		}
		
		return "El registro no se ha eliminado";
	}
	
}
