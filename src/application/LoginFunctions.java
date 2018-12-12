package application;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import system.Account;
import system.DatabaseHandle;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

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

        public static Account compileAccount(String username, String password,
                                      String userID,
                                      double balance, String avatar) {
                return new Account(username, password, userID, balance, avatar);
        }
}