package com.bank.main;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;

public class TestCustomer {

    public static void main(String[] args) {

        Customer customer = new Customer();

        customer.setUserId(3);
        customer.setName("Kasturi");
        customer.setEmail("kasturi@gmail.com");
        customer.setPhone("9876543210");
        customer.setAddress("Pune");

        CustomerDAO dao = new CustomerDAO();

        dao.addCustomer(customer);
    }
}