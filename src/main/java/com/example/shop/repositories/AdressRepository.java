package com.example.shop.repositories;

import com.example.shop.model.Adress;
import com.example.shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdressRepository extends JpaRepository<Adress,Long> {


    //@Query("SELECT a FROM  a WHERE a.status = 1")
    Adress findAdressByCustomers(Customer customer);

    //@Query("SELECT a FROM  a WHERE a.hausNr = ?1")
    Optional<Adress> findAdressByHausNr(long housNr);




}
