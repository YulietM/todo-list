package com.yuliet.todo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TareaDto {

    private Integer id;
    private String name;
    private Boolean completo;

    public Integer getId() {
        return this.id;
    }

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
