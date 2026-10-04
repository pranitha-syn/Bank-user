package com.bank.main;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;

public class TestUpdateCustomer {

    public static void main(String[] args) {

        Customer customer = new Customer();

        customer.setCustomerId(1);
        customer.setName("Kasturi Patil");
        customer.setEmail("kasturi.updated@gmail.com");
        customer.setPhone("9999999999");
        customer.setAddress("Mumbai");

        CustomerDAO dao = new CustomerDAO();

        dao.updateCustomer(customer);
    }
}