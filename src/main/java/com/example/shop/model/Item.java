package com.example.shop.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Item")
public class Item implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "Items_Sold",
            joinColumns = {@JoinColumn(name="item_id", referencedColumnName  ="id")},
            inverseJoinColumns = {@JoinColumn (name = "order_id", referencedColumnName = "id")})
    Order order;

    private String name;

    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
