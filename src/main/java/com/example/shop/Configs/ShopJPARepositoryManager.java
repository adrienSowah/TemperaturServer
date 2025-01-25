package com.example.shop.Configs;

import com.example.shop.interfaces.CustomerInterface;
import com.example.shop.repositories.AdressRepository;
import com.example.shop.repositories.CustomerRepository;
import com.example.shop.repositories.ItemRepository;
import com.example.shop.services.CustomerServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopJPARepositoryManager {

    /**
     * Customer interface for initializing customer specific objects
     */
    CustomerInterface customerInterface;


    public ShopJPARepositoryManager(CustomerServices customerServices){
        customerInterface = customerServices;

    }

    @Bean(name = "Customer")
    CustomerInterface getCustomer(){
        return customerInterface;
    }
}
