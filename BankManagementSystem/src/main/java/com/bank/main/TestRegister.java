package com.bank.main;

import com.bank.dao.UserDAO;
import com.bank.model.User;

public class TestRegister {

    public static void main(String[] args) {

        User user = new User();

        user.setUsername("tashvi2");
        user.setPassword("1234");
        user.setRole("CUSTOMER");

        UserDAO dao = new UserDAO();

        dao.registerUser(user);
    }
}