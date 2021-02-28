import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { PacienteService } from './pacientes/pacientes.service';
import { AppComponent } from './app.component';
import { PacientesComponent } from './pacientes/pacientes.component';
import { RouterModule, Routes} from '@angular/router';
import { FormComponent } from './pacientes/form.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';


const routes: Routes = [
  {path:'', redirectTo:'/pacientes', pathMatch:'full'},
  {path: 'pacientes', component:PacientesComponent},
  {path: 'pacientes/form', component:FormComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    PacientesComponent,
    FormComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
    
  ],
  providers: [PacienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
