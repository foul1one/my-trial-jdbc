package com.jdbc;

import java.sql.*;


public class Main {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";

    public static void main(String[] args) throws SQLException {

        DBprocessor db = new DBprocessor ();
        Connection con = db.getConnection(URL, USERNAME, PASSWORD);

        String query = "select * from business.products";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {

            int id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            double price = rs.getDouble("price");
            int shopID = rs.getInt("shop_id");

            Product product = new Product(id, name, price, shopID);
            System.out.println(product.toString());
        }

        rs.close();
        stmt.close();
        con.close();

    }
}
