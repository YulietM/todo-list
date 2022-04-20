package com.yuliet.todo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.yuliet.todo.dtos.TareaDto;
import com.yuliet.todo.entities.Tarea;
import com.yuliet.todo.repositories.TareaRepository;
import com.yuliet.todo.services.ITareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/tarea", produces = "application/json")
public class TareaController {

    @Autowired
    private ITareaService tareaService;

    /**
     * Get de todos los nombres
     * 
     * @return
     */

    @GetMapping()
    public ResponseEntity<List<Tarea>> getAll() {
        try {
            List<Tarea> items = new ArrayList<Tarea>();
            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get de nombre por ID
     * 
     * @param id
     * @return
     */

    @GetMapping("{id}")
    public ResponseEntity<TareaDto> getById(@PathVariable("id") Integer id) {

        final TareaDto tareaDto = tareaService.buscarPorId(id);

        if (tareaDto != null) {
            return new ResponseEntity<>(tareaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TareaDto> create(@RequestBody TareaDto item) {
        try {
            final TareaDto savedItem = tareaService.guardar(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Modificar nombre por ID
     * 
     * @param id
     * @param item
     * @return
     */
    @PutMapping(path = "{id}", consumes = "application/json")
    public ResponseEntity<TareaDto> update(@PathVariable("id") Integer id, @RequestBody TareaDto item) {

        final TareaDto tareaDto = tareaService.modificar(item, id);

        if (tareaDto != null) {
            return new ResponseEntity<>(tareaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            tareaService.borrarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}