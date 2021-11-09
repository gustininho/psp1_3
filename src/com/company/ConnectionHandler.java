package com.company;

import java.sql.*;

public class ConnectionHandler {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/vartotojai";

    //  Database credentials
    static final String USER = "";
    static final String PASS = "";

    public static void main(String[] args) {
        selectUser(3);
        editEmail(3,"koncius@gmail.com");
        selectUser(3);
    }

    public static Connection openConnection() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        return conn;
    }

    public static void insertUser(User user) {
        Connection connection = openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Vartotojas (firstname, lastname, phonenumber, email, adress, password)  " + "VALUES ('" + user.firstName + "', '" + user.lastName + "', '" + user.number + "', '" + user.email + "', '" + user.adress + "', '" + user.password + "' )";

            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        closeConnection(connection, stmt);
    }

    public static void closeConnection(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    public static void deleteUser(int userId) {
        Connection connection = openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "DELETE FROM Vartotojas where userID = " + userId + "";

            stmt.executeUpdate(sql);

            System.out.println("User by ID: " + userId + " records were deleted...");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        closeConnection(connection, stmt);
    }

    public static void selectUser(int userId) {
        Connection connection = openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "SELECT FirstName, LastName, PhoneNumber, Email FROM Vartotojas where userID = " + userId + "";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Display values
                System.out.print("Name: " + rs.getString("FirstName"));
                System.out.print(", Surname: " + rs.getString("LastName"));
                System.out.print(", Phone number: " + rs.getString("PhoneNumber"));
                System.out.println(", Email: " + rs.getString("Email"));
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public static void editEmail(int userId, String newEmail) {
        Connection connection = openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "UPDATE Vartotojas " + "SET Email = '" + newEmail + "' WHERE userID =" + userId + "";

            stmt.executeUpdate(sql);

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}