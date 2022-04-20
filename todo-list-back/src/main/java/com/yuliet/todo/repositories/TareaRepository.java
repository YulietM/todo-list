package com.yuliet.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yuliet.todo.entities.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    

}