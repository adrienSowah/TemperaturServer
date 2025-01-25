package com.example.shop;

import com.example.shop.model.Adress;
import com.example.shop.model.Customer;
import com.example.shop.model.Item;
import com.example.shop.model.Order;
import com.example.shop.repositories.AdressRepository;
import com.example.shop.repositories.CustomerRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 @SpringBootTest
public class CustomerTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AdressRepository adressRepository;

    @BeforeEach
    public void TestData(){
        generatTestData();
    }
    public void generatTestData(){

        Adress adress = new Adress();
        adress.setCity("erfurt");
        adress.setStreet("Lappenhügel");
        adress.setPlz(99098);
        adress.setHausNr(7);

        Customer customer = new Customer();
        customer.setName("Kasper");
        customer.setEmail("kasper@gamil1.com");
        customer.setAdress(adress);
        adress.addCustomer(customer);
        //customerRepository.save(customer);
         Adress add = adressRepository.saveAndFlush(adress);

     //   customer.setAdress(adress);


     //   adress.addCustomer(customer);
 /*       customer = new Customer();
        customer.setName("SmoothOP");
        customer.setEmail("SmoothOP@gamil.com");
      //   customer.setAdress(adress);
        adress.addCustomer(customer);
*/
        /*
         Adress myaddress = adressRepository.save(adress);
         customer.setAdress(myaddress);
         customerRepository.save(customer);
*/
         Optional<Adress> result = adressRepository.findAdressByHausNr(7);
         if (result.isPresent()){
             Adress myAdress = result.get();
             System.out.println(myAdress.getPlz());
             System.out.println(myAdress.getCustomers().size());
         }else {
             System.out.println("No address found");
         }


/*

        Order myOrder = new Order();

        Item soldItem = new Item();
        soldItem.setName("Iphone 10");
        soldItem.setPrice(600.65d);
        myOrder.addItem(soldItem);

        soldItem = new Item();
        soldItem.setName("Samsung Galaxy");
        soldItem.setPrice(200.00d);
        myOrder.addItem(soldItem);

        customer.addOrderItem(myOrder);

       //customerRepository.save(customer);
        adressRepository.save(adress);

        adress = new Adress();
        adress.setCity("erfurt");
        adress.setStreet("Lappenhügel");
        adress.setPlz(99098);
        adress.setHausNr(8);

        customer = new Customer();
        customer.setName("Adrien");
        customer.setEmail("Adrien@gamil.com");
        customer.setAdress(adress);



        customerList = new ArrayList<>();
        customerList.add(customer);
        adress.setCustomers(customerList);


         customerRepository.save(customer);



        adress = new Adress();
        adress.setCity("erfurt");
        adress.setStreet("Reise str");
        adress.setPlz(99093);
        adress.setHausNr(1);

        customer = new Customer();
        customer.setName("MK1");
        customer.setEmail("Mk1@gamil.com");
        customer.setAdress(adress);

        customerList = new ArrayList<>();
        customerList.add(customer);
         adress.setCustomers(customerList);

        customerRepository.save(customer);
        adressRepository.save(adress);
        */

    }
    @Test

    public void exampleTest() {
        Assertions.assertTrue(true);
    }
    /*

    @Test
    public void findCustomerByName(){

        Optional<Customer> customer = customerRepository.findCustomerByName("MK1");
        Assertions.assertTrue(customer.isPresent());
        Assertions.assertEquals(customer.get().getName(),"MK1");
    }

    @Test
    public void findCustomerByEmail(){
        Optional<Customer>customer = customerRepository.findCustomerByEmail("Adrien@gamil.com");

        Assertions.assertEquals(customer.get().getName(),"Adrien");

    }

*/

    @AfterEach
    public void deleteAll(){
      //  customerRepository.deleteAll();
      //  adressRepository.deleteAll();
    }


}
