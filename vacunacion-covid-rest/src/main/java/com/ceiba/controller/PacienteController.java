package com.ceiba.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.ceiba.models.entity.Paciente;
import com.ceiba.models.service.PacienteService;


@RestController
@RequestMapping("/api")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("/pacientes")
	public List<Paciente> listAll() {
		return pacienteService.findAll();		
	}
	
	@PostMapping("/pacientes")
	@ResponseStatus(HttpStatus.CREATED) 
	public ResponseEntity<String> create(@RequestBody Paciente paciente) {
		 LocalDate hoy = LocalDate.now();   
		 LocalDate nacimiento = paciente.getFecha_nacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
		 long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
		 System.out.print(edad);
		 System.out.print(pacienteService.findByID(paciente.getCedula()));
		if(pacienteService.findByID(paciente.getCedula()) != null || edad < 18 ) {
			return new ResponseEntity<>("No valido por reglas de negocio", HttpStatus.BAD_REQUEST);
		} else {
			pacienteService.saveNew(paciente);
			return new ResponseEntity<>("Usuario creado", HttpStatus.ACCEPTED);
		}
		
	}
}
