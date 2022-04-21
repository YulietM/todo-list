import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tarea } from '../../interfaces/tarea';
import { RestService } from '../../services/rest.service';

@Component({
  selector: 'app-crear-tarea',
  templateUrl: './crear-tarea.component.html',
  styleUrls: ['./crear-tarea.component.scss']
})
export class CrearTareaComponent implements OnInit {

  tarea: Tarea = <Tarea>{
    name: '',
    completo: false
  };

  constructor(private route: ActivatedRoute, private router: Router, private restService: RestService) {

  }

  ngOnInit() {
  }

  guardar() {
    this.restService.guardarTarea(this.tarea).subscribe((data: Tarea) => {
      this.router.navigate(['/listar-tareas']);
    });

  }
}