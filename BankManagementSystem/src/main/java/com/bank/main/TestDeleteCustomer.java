package com.bank.main;

import com.bank.dao.CustomerDAO;

public class TestDeleteCustomer {

    public static void main(String[] args) {

        CustomerDAO dao = new CustomerDAO();

        dao.deleteCustomer(1);

    }
}