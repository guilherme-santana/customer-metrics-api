package com.customer.customer.repository;

import com.customer.customer.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository <Customers, Long> {

   List<Customers> findByCustomerContainingIgnoreCase(String customer);

   List<Customers> findBySegmentoContainingIgnoreCase(String segmento);
}
