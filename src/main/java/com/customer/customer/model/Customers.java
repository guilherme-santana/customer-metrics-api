package com.customer.customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class Customers {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "customer")
    @NotEmpty(message = "Cannot be empty")
    @NotNull(message = "Cannot be null")
    private String customer;

    @Column(name = "segmento")
    @NotEmpty(message = "Cannot be empty")
    @NotNull(message = "Cannot be null")
    private String segmento;

    @Column(name = "ltv")
    @NotNull(message = "Cannot be null")
    private Integer ltv;

    @Column(name = "cac")
    @NotNull(message = "Cannot be null")
    private Double cac;

    @Column(name = "roi")
    @NotNull(message = "Cannot be null")
    private Double roi;

    @Column(name = "roas")
    @NotNull(message = "Cannot be null")
    private Double roas;

public Customers(){

}

public Customers(String customer, String segmento, Integer ltv, Double cac, Double roi, Double roas){
    this.customer = customer;
    this.segmento = segmento;
    this.ltv = ltv;
    this.cac = cac;
    this.roi = roi;
    this.roas = roas;
}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getLtv() {
        return ltv;
    }

    public void setLtv(Integer ltv) {
        this.ltv = ltv;
    }

    public Double getCac() {
        return cac;
    }

    public void setCac(Double cac) {
        this.cac = cac;
    }

    public Double getRoi() {
        return roi;
    }

    public void setRoi(Double roi) {
        this.roi = roi;
    }

    public Double getRoas() {
        return roas;
    }

    public void setRoas(Double roas) {
        this.roas = roas;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    @Override
    public String toString(){
        return  "Customers [id=" + id + ", customer=" + customer + ", segmento=" + segmento + ", ltv=" + ltv + ", cac=" + cac + "roi=" + roi + "roas=" + roas + "]";
    }
}
