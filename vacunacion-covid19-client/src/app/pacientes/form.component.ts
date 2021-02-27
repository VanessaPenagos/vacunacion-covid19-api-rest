import { Component, OnInit } from '@angular/core';
import { Paciente } from './paciente';
import { PacienteService } from './pacientes.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2'


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

  public paciente: Paciente = new Paciente();
  

  constructor(private pacienteService:PacienteService,private router:Router, private activatedRoute:ActivatedRoute) {  }

  ngOnInit(): void {
  
  }

  public create():void{
    this.pacienteService.create(this.paciente).subscribe(
      paciente => {
        this.router.navigate(['/pacientes'])
        swal.fire('Paciente guardado',`paciente ${this.paciente.nombre} creado con exito!`, 'success')
      }      
    )
  }
}
