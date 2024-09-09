package com.mx.PaisesApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.PaisesApi.Entity.State;
import com.mx.PaisesApi.Service.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path="Estado")
@CrossOrigin
public class StateController {

	@Autowired
	StateService stateService;
	
	@GetMapping("Lista")
	public List<State> stateLst() {
		return stateService.list();
	}
	
	@PostMapping("Guardar")
	public ResponseEntity<?> saveState(@RequestBody State state) {
		String message=stateService.save(state);
		if(!message.equals("ok")) {
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		
		return new ResponseEntity<State>(state,HttpStatus.CREATED);
	}
	
	@GetMapping("Buscar")
	public ResponseEntity<?> srchState(@RequestBody State state) {
		state=stateService.srchState(state);
		if (state==null) {
			return new ResponseEntity<String>("El registro no existe",HttpStatus.OK);
		}
		return new ResponseEntity<State>(state,HttpStatus.OK);
	}
	
	@PutMapping("Editar")
	public ResponseEntity<?> edotState(@RequestBody State state) {
		//TODO: process PUT request
		String message = stateService.edit(state);
		if (!message.equals("ok")) {
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		
		return new ResponseEntity<State>(state,HttpStatus.CREATED);
	}
	
	@PostMapping("Borrar")
	public String deleteState(@RequestBody State state) {
		//TODO: process POST request
		if (stateService.delete(state)) {
			return "Se elimino exitosamente";
		}
		return "No existe el estado";
	}
	
	
	
}
