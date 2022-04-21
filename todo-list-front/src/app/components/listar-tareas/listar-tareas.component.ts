import { Component, OnInit } from '@angular/core';
import { Tarea } from '../../interfaces/tarea';
import { RestService } from '../../services/rest.service';

@Component({
  selector: 'app-listar-tareas',
  templateUrl: './listar-tareas.component.html',
  styleUrls: ['./listar-tareas.component.scss']
})
export class ListarTareasComponent implements OnInit {

  tareas: Tarea[] = [];
  constructor(private restService: RestService) {

    this.listarTareas();
  }

  ngOnInit() {
  }

  listarTareas() {
    this.restService.getTareas().subscribe((data: Tarea[]) => {
      this.tareas = data;
    });
  }

  eliminar(idTarea: number) {
    this.restService.eliminarTarea(idTarea).subscribe((data) => { });
    this.listarTareas();
  }

  modificarCompleto(tarea: Tarea) {
    console.log(tarea);

    this.restService.modificarTarea(tarea, tarea.id).subscribe((data: Tarea) => {
    });
  }

}
