package com.example.shop.interfaces;

import com.example.shop.model.Adress;
import com.example.shop.model.Customer;

public interface CustomerInterface {

    Customer findCustomerByName(String name);

    Customer findCustomerByEmail(String email);

    Customer findCustomerByAdress(Adress adress);


}
