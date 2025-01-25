package com.example.shop.controller;

import com.example.shop.model.Customer;
import com.example.shop.services.CustomerServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.stereotype.Controller
public class ShopController {

CustomerServices customerServices;

public ShopController(CustomerServices customerServices){
this.customerServices = customerServices;
}
@GetMapping(path = "/getAllCustomers")
 public ResponseEntity<List<Customer>>getAllCustomers(){
    List<Customer>customerList  = customerServices.findAllCustomers();
    return new ResponseEntity<>(customerList, HttpStatus.OK);
}

@DeleteMapping(path = "DeleteCustomer/{id}")
    public void DeleteCustomerById(@PathVariable("id")Long id){
    customerServices.deleteCustomerById(id);
}


}
  