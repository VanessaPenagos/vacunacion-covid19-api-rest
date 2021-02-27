package com.ceiba.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.models.dao.PacienteDao;
import com.ceiba.models.entity.Paciente;

@Service
public class PacienteServiceC implements PacienteService {

	@Autowired
	private PacienteDao pacienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Paciente> findAll() {
		return (List<Paciente>) pacienteDao.findAll();
	}

	@Override
	@Transactional
	public Paciente saveNew(Paciente paciente) {
		return pacienteDao.save(paciente);
	}

	@Override
	@Transactional(readOnly = true)
	public Paciente findByID(Long id) {
		return pacienteDao.findById(id).orElse(null);
	}
}