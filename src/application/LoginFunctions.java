package application;


import system.DatabaseHandle;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handles the functions and validation of the login form
 */
class LoginFunctions {

        static boolean verify(String username, String password) {
                String query =
                        "SELECT * FROM Account WHERE Account.username='" + username +
                                "' AND Account.password='" + password + "'";
                ResultSet rs = DatabaseHandle.dbQuery(query);

                try {
                        // Loop through results to find if they match
                        while (rs.next()) {
                                if (rs.getString(1).equals(username)) {
                                        if (rs.getString(2).equals(password)) {
                                                return true;
                                        }
                                }
                        }
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                }

                return false;
        }
}
