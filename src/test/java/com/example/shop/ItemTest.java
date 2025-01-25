package com.example.shop;

import com.example.shop.model.Item;
import com.example.shop.repositories.ItemRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ItemTest {

    @Autowired
    ItemRepository itemRepository;

    @BeforeEach
    public void TestData(){
        generateData();
    }
    public void generateData(){
        List<Item>items = new ArrayList<>();
        Item item = new Item();
       item.setName("Airforce 1");
       item.setPrice(85.99d);
       items.add(item);

        item = new Item();
        item.setName("Air jordan");
        item.setPrice(120d);
        items.add(item);

        item = new Item();
        item.setName("addidas");
        item.setPrice(69.99d);
        items.add(item);

        item = new Item();
        item.setName("puma");
        item.setPrice(50d);
        items.add(item);

        item = new Item();
        item.setName("latchen");
        item.setPrice(50d);
        items.add(item);

        itemRepository.saveAll(items);

    }

    @Test
    @Transactional
    public void deleteByName(){
        itemRepository.deleteItemByName("latchen");

        Assertions.assertEquals(itemRepository.count(),4);
    }
    @Test
    public void findByName(){
       Item item =  itemRepository.findItemByName("latchen");

       Assertions.assertEquals(item.getPrice(),50);

    }
    @Test
    public void findByPrice(){
       List <Item> item = itemRepository.findItemByPrice(50);

       Assertions.assertEquals(item.size(),2);

    }
      @AfterEach
    public void deleteAll(){
        itemRepository.deleteAll();
    }

}
