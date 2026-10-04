package com.bank.main;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.UserDAO;
import com.bank.model.Customer;
import com.bank.model.User;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserDAO userDAO = new UserDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                User user = new User();

                System.out.print("Enter Username: ");
                user.setUsername(sc.nextLine());

                System.out.print("Enter Password: ");
                user.setPassword(sc.nextLine());

                user.setRole("CUSTOMER");

                userDAO.registerUser(user);

                break;

            case 2:

                System.out.print("Enter Username: ");
                String username = sc.nextLine();

                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                String role = userDAO.loginUser(username, password);

                if (role != null) {

                    System.out.println("Login Successful!");

                    if (role.equalsIgnoreCase("ADMIN")) {

                        adminMenu(sc, customerDAO);

                    } else {

                        customerMenu(sc, customerDAO);

                    }

                } else {

                    System.out.println("Invalid Username or Password!");
                }

                break;

            case 3:

                System.out.println("Thank You!");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice!");
            }
        }
    }

    // ADMIN MENU
    public static void adminMenu(Scanner sc, CustomerDAO customerDAO) {

        while (true) {

            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. View All Customers");
            System.out.println("2. View Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                customerDAO.viewAllCustomers();
                break;

            case 2:

                System.out.print("Enter Customer ID: ");
                int viewId = sc.nextInt();

                customerDAO.viewCustomer(viewId);
                break;

            case 3:

                System.out.print("Enter Customer ID: ");
                int deleteId = sc.nextInt();

                customerDAO.deleteCustomer(deleteId);
                break;

            case 4:

                return;

            default:

                System.out.println("Invalid Choice!");
            }
        }
    }

    // CUSTOMER MENU
    public static void customerMenu(Scanner sc, CustomerDAO customerDAO) {

        while (true) {

            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. Add Customer Profile");
            System.out.println("2. View Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                Customer customer = new Customer();

                System.out.print("Enter User ID: ");
                customer.setUserId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Name: ");
                customer.setName(sc.nextLine());

                System.out.print("Enter Email: ");
                customer.setEmail(sc.nextLine());

                System.out.print("Enter Phone: ");
                customer.setPhone(sc.nextLine());

                System.out.print("Enter Address: ");
                customer.setAddress(sc.nextLine());

                customerDAO.addCustomer(customer);

                break;

            case 2:

                System.out.print("Enter Customer ID: ");
                int viewId = sc.nextInt();

                customerDAO.viewCustomer(viewId);

                break;

            case 3:

                Customer updateCustomer = new Customer();

                System.out.print("Enter Customer ID: ");
                updateCustomer.setCustomerId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter New Name: ");
                updateCustomer.setName(sc.nextLine());

                System.out.print("Enter New Email: ");
                updateCustomer.setEmail(sc.nextLine());

                System.out.print("Enter New Phone: ");
                updateCustomer.setPhone(sc.nextLine());

                System.out.print("Enter New Address: ");
                updateCustomer.setAddress(sc.nextLine());

                customerDAO.updateCustomer(updateCustomer);

                break;

            case 4:

                return;

            default:

                System.out.println("Invalid Choice!");
            }
        }
    }
}