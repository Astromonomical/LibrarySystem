package application;


import system.DatabaseHandle;

import java.sql.ResultSet;

/**
 * Handles the functions and validation of the login form
 */
public class LoginFunctions {

        public static boolean verify(String username, String password) {
                String query =
                        "SELECT * FROM Account WHERE Account.username='" + username +
                                "' AND Account.password='" + password + "'";
                ResultSet rs = DatabaseHandle.dbQuery(query);

                if (rs != null) {
                        System.out.println("Login Successful!");
                } else {
                        System.out.println("Login unsuccesful!");
                }

                return false;
        }
}
