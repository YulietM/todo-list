package com.yuliet.todo.services;

import java.util.List;

import com.yuliet.todo.dtos.TareaDto;

public interface ITareaService {

    List<TareaDto> listarTareas();

    TareaDto buscarPorId(final Integer id);

    TareaDto guardar(final TareaDto tareaDto);

    TareaDto modificar(final TareaDto tareaDto, final Integer id);

    void borrarPorId(final Integer id);

}
