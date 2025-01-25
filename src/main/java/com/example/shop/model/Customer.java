package com.example.shop.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "Customer")
public class Customer implements Serializable {



    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Adress_id")
    /*
    @JoinTable(name = "Customer_Adress",
            joinColumns = {@JoinColumn(name="customer_id", referencedColumnName  ="id", nullable = false, insertable = true, updatable = true)},
            inverseJoinColumns = {@JoinColumn (name = "adress_id", referencedColumnName = "id", nullable = false, insertable = true)})
    */
    private Adress adress;

    @OneToMany(mappedBy = "customer")
    List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email  ;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        adress = adress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> order) {
        this.orders = order;
    }

    public void addOrderItem(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        order.setCustomer(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return id !=null && id.equals(((Customer)o).getId());
    }

    @Override
    public int hashCode() {
       return  getClass().hashCode();

    }
}
