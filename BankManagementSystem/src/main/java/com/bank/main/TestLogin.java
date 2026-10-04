package com.bank.main;

import com.bank.dao.UserDAO;

public class TestLogin {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        String role = dao.loginUser("admin", "admin123");

        if (role != null) {

            System.out.println("Login Successful");
            System.out.println("Role : " + role);

        } else {

            System.out.println("Invalid Username or Password");
        }
    }
}
