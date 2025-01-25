package com.example.shop;

import com.example.shop.model.Adress;
import com.example.shop.model.Customer;
import com.example.shop.repositories.AdressRepository;
import com.example.shop.repositories.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.XMLFormatter;

@SpringBootTest
public class AdressTest {

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void TestData(){
        generateData();
    }
     public void generateData(){
        List<Adress>adressList = new ArrayList<>();
         Adress adress = new Adress();
         adress.setCity("erfurt");
         adress.setStreet("Lappenhügel");
         adress.setPlz(99098);
         adress.setHausNr(7);
         adressList.add(adress);

         Customer customer = new Customer();
         List<Customer> customerList = new ArrayList<>();
         customer.setName("Kasper");
         customer.setEmail("kasper@gamil.com");
        customer.setAdress(adress);
         customerList.add(customer);

         adress = new Adress();
         adress.setCity("erfurt");
         adress.setStreet("Reise str");
         adress.setPlz(99093);
         adress.setHausNr(1);
         adressList.add(adress);

         customer = new Customer();
         customer.setName("MK1");
         customer.setEmail("Mk1@gamil.com");
         customer.setAdress(adress);
         customerList.add(customer);

         adress = new Adress();
         adress.setCity("erfurt");
         adress.setStreet("frankestraße");
         adress.setPlz(99093);
         adress.setHausNr(13);
         adressList.add(adress);

         customer = new Customer();
         customer.setName("x");
         customer.setEmail("x@gamil.com");
         customer.setAdress(adress);
         customerList.add(customer);

         adressRepository.saveAll(adressList);
         customerRepository.saveAll(customerList);
     }

     @Test
    public void findAdressByCustomer(){
       Optional<Customer> customer =  customerRepository.findCustomerByName("x");
        Adress adress = adressRepository.findAdressByCustomers(customer.get());

         Assertions.assertTrue(adress.getCustomers().contains(customer.get()));
     }

   //  @AfterEach
    public void deleteAll(){
        adressRepository.deleteAll();
        customerRepository.deleteAll();
     }
}
