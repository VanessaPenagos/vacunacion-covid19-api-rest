import { Component, OnInit } from '@angular/core';
import {Paciente } from './paciente';
import {PacienteService} from './pacientes.service'

@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.component.html'
})
export class PacientesComponent implements OnInit {

  paciente: Paciente[];

  constructor(private pacienteService:PacienteService) { 
  }

  ngOnInit(): void {
    this.pacienteService.getPacientes().subscribe(
      paciente => this.paciente = paciente
    );
  }
}
