package com.example.shop.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String orderNumber;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_Id", referencedColumnName = "id")
    private Customer customer;


    @OneToMany(cascade  = CascadeType.ALL, mappedBy = "order")
    List<Item> items;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
        item.setOrder(this);
    }
}
