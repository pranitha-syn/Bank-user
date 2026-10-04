package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Customer;
import com.bank.util.DBConnection;

public class CustomerDAO {

    // Add Customer
    public boolean addCustomer(Customer customer) {

        String sql = "INSERT INTO customers(user_id, name, email, phone, address) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customer.getUserId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getAddress());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Added Successfully!");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // View Customer
    public void viewCustomer(int customerId) {

        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nCustomer Details");
                System.out.println("-------------------------");
                System.out.println("Customer ID : " + rs.getInt("customer_id"));
                System.out.println("User ID     : " + rs.getInt("user_id"));
                System.out.println("Name        : " + rs.getString("name"));
                System.out.println("Email       : " + rs.getString("email"));
                System.out.println("Phone       : " + rs.getString("phone"));
                System.out.println("Address     : " + rs.getString("address"));

            } else {

                System.out.println("Customer Not Found!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 // Update Customer
    public boolean updateCustomer(Customer customer) {

        String sql = "UPDATE customers SET name = ?, email = ?, phone = ?, address = ? WHERE customer_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getAddress());
            ps.setInt(5, customer.getCustomerId());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Customer Updated Successfully!");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
 // Delete Customer
    public boolean deleteCustomer(int customerId) {

        String sql = "DELETE FROM customers WHERE customer_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Customer Deleted Successfully!");
                return true;

            } else {

                System.out.println("Customer Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
 // View All Customers
    public void viewAllCustomers() {

        String sql = "SELECT * FROM customers";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== ALL CUSTOMERS =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("customer_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("phone") + " | " +
                        rs.getString("address"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}