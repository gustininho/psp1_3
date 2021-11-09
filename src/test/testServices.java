package test;

import com.company.ConnectionHandler;
import com.company.User;
import org.junit.jupiter.api.Test;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class testServices {
    int currentUserID;
    @Test
    public void roundtripInsertSelect() {
        User user = new User(
                "Gustukas",
                "Dersonas",
                "61234430",
                "gustas.dersonas@gmail.com",
                "kauno g. 2",
                "Gsutukas1@"
        );

        ConnectionHandler.insertUser(user);

        Connection connection = ConnectionHandler.openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "SELECT UserID FROM Vartotojas ORDER BY UserID DESC LIMIT 1";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Display values
                currentUserID = rs.getInt("UserID");
            }


            stmt = connection.createStatement();
            sql = "SELECT FirstName, LastName, PhoneNumber, Email, Adress, Password FROM Vartotojas where userID = " + currentUserID + "";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Display values
                assertEquals("Gustukas", rs.getString("FirstName"));
                assertEquals("Dersonas", rs.getString("LastName"));
                assertEquals("61234430", rs.getString("PhoneNumber"));
                assertEquals("gustas.dersonas@gmail.com", rs.getString("Email"));
                assertEquals("kauno g. 2", rs.getString("Adress"));
                assertEquals("Gsutukas1@", rs.getString("Password"));
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
