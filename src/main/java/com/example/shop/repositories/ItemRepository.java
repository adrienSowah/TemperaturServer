package com.example.shop.repositories;

import com.example.shop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findItemByPrice(double price);

    Item findItemByName(String name);

    void deleteItemByName(String name);

}
