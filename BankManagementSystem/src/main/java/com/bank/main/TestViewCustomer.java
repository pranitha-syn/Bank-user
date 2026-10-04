package com.bank.main;

import com.bank.dao.CustomerDAO;

public class TestViewCustomer {

    public static void main(String[] args) {

        CustomerDAO dao = new CustomerDAO();

        dao.viewCustomer(1);

    }
}