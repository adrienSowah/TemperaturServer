package com.example.shop.repositories;

import com.example.shop.model.Adress;
import com.example.shop.model.Customer;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends Serializable,JpaRepository<Customer,Long> {
    Optional<Customer> findCustomerByName(String name);

    Optional<Customer> findCustomerByEmail(String email);

   Optional<List<Customer>> findCustomerByAdress(Adress adress);




}
