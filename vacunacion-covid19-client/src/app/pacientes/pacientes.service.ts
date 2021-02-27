import { Injectable } from '@angular/core';
import { Paciente } from './paciente';
import { Observable } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http'

@Injectable()
export class PacienteService {
  private urlEndPoit:string = 'http://localhost:8082/api/pacientes';
  private httpHeader = new HttpHeaders({'Content-type':'application/json'});

  constructor(private http: HttpClient) { }

  getPacientes(): Observable<Paciente[]>{
    return this.http.get<Paciente[]>(this.urlEndPoit);
  }

  create(paciente:Paciente): Observable<Paciente>{
    return this.http.post<Paciente>(this.urlEndPoit,paciente,{headers: this.httpHeader});

  }
}
