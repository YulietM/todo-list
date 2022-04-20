package com.yuliet.todo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "completo")
    private Boolean completo;

    public Integer getId() {
        return this.id;
    }

    @JsonIgnore
    @JsonProperty(value = "id")
    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getCompleto() {
        return this.completo;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setCompleto(final Boolean completo) {
        this.completo = completo;
    }
}