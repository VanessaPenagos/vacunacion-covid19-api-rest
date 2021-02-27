package com.ceiba.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.ceiba.models.entity.Paciente;

public interface PacienteDao  extends CrudRepository<Paciente,Long>{

}
