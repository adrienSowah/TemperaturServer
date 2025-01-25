package com.example.shop.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Adress")
@Table(name = "adress")
public class Adress implements Serializable {
            @Id
            @GeneratedValue
             private Long id;

          //@OneToMany( mappedBy = "adress",orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "adress" , cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    //@JoinColumn(name="Adress_id", updatable = false, insertable = false)
    Set<Customer> customers = new HashSet<>() ;

            private String street;
            private long hausNr;

            private String city;

            private long plz;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getHausNr() {
        return hausNr;
    }

    public void setHausNr(long hausNr) {
        this.hausNr = hausNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPlz() {
        return plz;
    }

    public void setPlz(long plz) {
        this.plz = plz;
    }

    public void addCustomer(Customer customer) {
        if (customers == null) {
            customers =  new HashSet<Customer>();
        }
    //    customer.setAdress(this);
        customers.add(customer);
        for(Customer cust: customers) {
            cust.setAdress(this);
        }

    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.setAdress(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress adress)) return false;
        return id !=null && id.equals(((Adress)o).getId());
    }

    @Override
    public int hashCode() {
        return  getClass().hashCode();

    }
}
