package com.customer.customer.controller;

import com.customer.customer.model.Customers;
import com.customer.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @CrossOrigin
    @GetMapping("/customer")
    public ResponseEntity<List<Customers>> getCustomer(@RequestParam String customer, @RequestParam String segmento){
        if (!customer.isEmpty()) {
            return ResponseEntity.ok(repository.findByCustomerContainingIgnoreCase(customer));
        } else if (!segmento.isEmpty()) {
            return ResponseEntity.ok(repository.findBySegmentoContainingIgnoreCase(segmento));
        }
        return ResponseEntity.ok(repository.findAll());
    }

    @CrossOrigin
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable("id") long id){
        Optional<Customers> customerData = repository.findById(id);
        if (customerData.isPresent()){
            return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable("id") long id, @RequestBody Customers customer){
        Optional<Customers> customerData = repository.findById(id);
        if (customerData.isPresent()){
            Customers cs = customerData.get();
            cs.setCustomer(customer.getCustomer());
            cs.setSegmento(customer.getSegmento());
            cs.setCac(customer.getCac());
            cs.setLtv(customer.getLtv());
            cs.setRoas(customer.getRoas());
            cs.setRoi(customer.getRoi());

            return new ResponseEntity<>(repository.save(cs), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customers> deleteCustomer(@PathVariable("id") long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/customer")
    public ResponseEntity<Customers> saveCustomer(@RequestBody Customers customers){
        try {
            return new ResponseEntity<>(repository.save(customers), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
