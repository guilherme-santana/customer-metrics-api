package com.customer.customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "segmento")
public class Segmento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "segmento")
    @NotEmpty(message = "Cannot be empty")
    @NotNull(message = "Cannot be null")
    private String segmento;

    public Segmento(){

    }

    public Segmento(String segmento){
        this.segmento = segmento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    @Override
    public String toString(){
        return "Segmento [id=" + id + ", segmento=" + segmento + "]";
    }
}
