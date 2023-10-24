package com.customer.customer.controller;

import com.customer.customer.model.Segmento;
import com.customer.customer.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SegmentoController {

    @Autowired
    SegmentoRepository repository;

    @CrossOrigin
    @GetMapping("/segmento")
    public ResponseEntity<List<Segmento>> getSegmento(){
        return ResponseEntity.ok(repository.findAll());
    }
}
