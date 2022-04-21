import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarTareaComponent } from './components/editar-tarea/editar-tarea.component';
import { CrearTareaComponent } from './components/crear-tarea/crear-tarea.component';
import { ListarTareasComponent } from './components/listar-tareas/listar-tareas.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'listar-tareas',
    pathMatch: 'full'
  },
  {
    path: 'listar-tareas',
    component: ListarTareasComponent,
  },
  {
    path: 'crear-tareas',
    component: CrearTareaComponent
  },
  {
    path: 'editar-tarea/:idTarea',
    component: EditarTareaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
