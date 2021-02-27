package com.ceiba.models.service;
import java.util.List;
import com.ceiba.models.entity.Paciente;

public interface PacienteService {
	public List<Paciente> findAll();
	public Paciente saveNew(Paciente paciente);
	public Paciente findByID(Long id);
}
