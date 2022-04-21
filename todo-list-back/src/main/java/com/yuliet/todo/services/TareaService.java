package com.yuliet.todo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.yuliet.todo.dtos.TareaDto;
import com.yuliet.todo.entities.Tarea;
import com.yuliet.todo.repositories.TareaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService implements ITareaService {
    
    @Autowired
    private TareaRepository TareaRepository;

    @Override
    public List<TareaDto> listarTareas() {
        final List<TareaDto> tareas = new ArrayList<TareaDto>();

        this.TareaRepository.findAll()
                .stream()
                .map((Tarea tarea) -> {
                    final TareaDto tareaDto = new TareaDto();
                    tareaDto.setId(tarea.getId());
                    tareaDto.setName(tarea.getName());
                    tareaDto.setCompleto(tarea.getCompleto());
                    return tareaDto;
                })
                .forEach(tareaDto -> {
                    tareas.add(tareaDto);
                });

        return tareas;
    
    }

    @Override
    public TareaDto buscarPorId(Integer id) {
        Optional<Tarea> existingItemOptional = TareaRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            final Tarea tarea = existingItemOptional.get(); //
            final TareaDto tareaDto = new TareaDto();
            tareaDto.setId(tarea.getId());
            tareaDto.setName(tarea.getName());
            tareaDto.setCompleto(tarea.getCompleto());
            return tareaDto;
        }
        return null;
    }

    @Override
    public TareaDto guardar(final TareaDto tareaDto) {

        // Conveirte los datos
        final Tarea tarea = new Tarea();
        tarea.setName(tareaDto.getName());
        tarea.setCompleto(tareaDto.getCompleto());
        // guarda los datos
        this.TareaRepository.save(tarea);

        // Obtiene el ID generado
        tareaDto.setId(tarea.getId());
        return tareaDto;

    }

    @Override
    public TareaDto modificar(final TareaDto tareaDto, final Integer id) {

        final Optional<Tarea> tareaOptional = TareaRepository.findById(id);
        if (tareaOptional.isPresent()) {
            final Tarea tareaExistente = tareaOptional.get();

            tareaExistente.setName(tareaDto.getName());
            tareaExistente.setCompleto(tareaDto.getCompleto());
            TareaRepository.save(tareaExistente);

            final TareaDto tareaDtoModificado = new TareaDto();
            tareaDtoModificado.setId(tareaExistente.getId());
            tareaDtoModificado.setName(tareaExistente.getName());
            tareaDtoModificado.setCompleto(tareaExistente.getCompleto());
            return tareaDtoModificado;

        } else {
            return null;
        }
    }

    @Override
    public void borrarPorId(final Integer id) {

        this.TareaRepository.deleteById(id);
    }

}
