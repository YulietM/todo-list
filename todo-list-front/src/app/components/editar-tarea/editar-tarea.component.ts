import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tarea } from '../../interfaces/tarea';
import { RestService } from '../../services/rest.service';

@Component({
  selector: 'app-editar-tarea',
  templateUrl: './editar-tarea.component.html',
  styleUrls: ['./editar-tarea.component.scss']
})
export class EditarTareaComponent implements OnInit {

  tarea: Tarea = <Tarea>{};

  constructor(private route: ActivatedRoute, private router: Router, private restService: RestService) {

  }



  ngOnInit() {
    let idTarea = this.route.snapshot.params['idTarea'];
    this.consutarTareaPorId(idTarea);
  }

  consutarTareaPorId(idTarea: number): void {
    this.restService.getTareaPorId(idTarea).subscribe((data: Tarea) => {
      this.tarea = data;
    });
  }

  guardar() {
    this.restService.modificarTarea(this.tarea, this.tarea.id).subscribe((data: Tarea) => {
      this.router.navigate(['/listar-tareas']);
    });

  }
}