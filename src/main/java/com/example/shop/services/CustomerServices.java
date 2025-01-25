package com.example.shop.services;

import com.example.shop.interfaces.CustomerInterface;
import com.example.shop.model.Adress;
import com.example.shop.model.Customer;
import com.example.shop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices implements CustomerInterface {

   private final CustomerRepository customerRepository;


    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name).get();
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email).get();
    }

    @Override
    public Customer findCustomerByAdress(Adress adress) {
        Customer firstCust = null;
        Optional<List<Customer>> optional = customerRepository.findCustomerByAdress(adress);
        if (optional.isPresent()) {
            List<Customer> result = optional.get();
            if (result.size() > 0) {
               firstCust = result.get(0);
            }
        }

        return firstCust;
    }


    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }


    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }


    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer>findAllCustomers(){
        List<Customer>customerList = customerRepository.findAll();

        return customerList;
    }


}
