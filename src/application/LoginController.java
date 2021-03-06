package application;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Handles the loading and displaying of the user form
 */
public class LoginController extends Application {


        // Username text field
        @FXML
        private JFXTextField usernameTxt;

        // Password text field
        @FXML
        private JFXPasswordField passwordTxt;

        /**
         * Launches the login form
         * @param args Command line arguements
         */
        public static void main(String[] args) {
                launch(args);
        }

        /**
         * Loads and displays the login form
         * @param primaryStage The primary stage of the form
         */
        @Override
        public void start(Stage primaryStage) {
                try {
                        BorderPane root =
                                FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(
                                        "application/LoginForm.fxml")));

                        // Load root into the stage
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        /**
         * Handles logging in
         */
        @FXML
        private void handleLoginBtn() {
                boolean verified = LoginFunctions.verify(usernameTxt.getText(),
                        passwordTxt.getText());

                if (verified) {
                        //Login
                } else {
                        // Don't login
                        FxDialogs.showError("Unsuccesful Login", "Username or" +
                                " password incorrect, please try again");
                }
        }
}
