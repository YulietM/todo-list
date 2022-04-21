import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EditarTareaComponent } from './components/editar-tarea/editar-tarea.component';
import { CrearTareaComponent } from './components/crear-tarea/crear-tarea.component';
import { ListarTareasComponent } from './components/listar-tareas/listar-tareas.component';
import { CardModule } from 'primeng/card';
import { CheckboxModule} from 'primeng/checkbox';
import { RestService } from './services/rest.service';
import { HttpClientModule } from '@angular/common/http';
import { ButtonModule} from 'primeng/button';
import { InputTextModule} from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent, 
    ListarTareasComponent,
    CrearTareaComponent,
    EditarTareaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CardModule,
    CheckboxModule,
    HttpClientModule,
    ButtonModule,
    InputTextModule,
    FormsModule
  ],
  providers: [
    RestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
