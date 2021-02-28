import { Injectable } from '@angular/core';
import { Paciente } from './paciente';
import { Observable, throwError} from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import swal from 'sweetalert2';
import { catchError } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable()
export class PacienteService {
  private urlEndPoit:string = 'http://localhost:8082/api/pacientes';
  private httpHeader = new HttpHeaders({'Content-type':'application/json'});

  constructor(private http: HttpClient,private router:Router, private activatedRoute:ActivatedRoute) { }

  getPacientes(): Observable<Paciente[]>{
    return this.http.get<Paciente[]>(this.urlEndPoit);
  }

  create(paciente:Paciente): Observable<Paciente>{
    return this.http.post<Paciente>(this.urlEndPoit,paciente,{headers: this.httpHeader}).pipe(
      catchError(e => {
        this.router.navigate(['/pacientes']);
        swal.fire('Error al inscribir el paciente', 'Datos no concuerda con la logica del negocio', 'error');
        return throwError(e);
      })
    );
  }
}
