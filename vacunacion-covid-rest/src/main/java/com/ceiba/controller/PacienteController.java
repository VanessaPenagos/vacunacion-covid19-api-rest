package com.ceiba.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.ceiba.models.entity.Paciente;
import com.ceiba.models.service.PacienteService;

@CrossOrigin(origins= {"http://localhost:4200"})
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
	public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {
		 LocalDate hoy = LocalDate.now();   
		 LocalDate nacimiento = paciente.getFecha_nacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
		 long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
			if(pacienteService.findByID(paciente.getCedula()) != null || edad < 18 ) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			pacienteService.saveNew(paciente);
			return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
		}
		
	}
}

