import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Tarea } from '../interfaces/tarea';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RestService {


  constructor(private http: HttpClient) {
  }


  getTareas(): Observable<any> {
    return this.http.get(environment.backendDns + `/tarea`);
  }

  getTareaPorId(idTarea: number): Observable<any> {
    return this.http.get(environment.backendDns + `/tarea/${idTarea}`);
  }

  guardarTarea(nuevaTarea: Tarea): Observable<any> {
    return this.http.post(environment.backendDns + `/tarea`, nuevaTarea);
  }

  modificarTarea(tareaModificada: Tarea, idTarea: number): Observable<any> {
    return this.http.put(environment.backendDns + `/tarea/${idTarea}`, tareaModificada);
  }


  eliminarTarea(idTarea: number): Observable<any> {
    return this.http.delete(environment.backendDns + `/tarea/${idTarea}`);
  }


}
