package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Handles the loading and displaying of the user form
 */
public class LoginController extends Application {

        // Login button
        @FXML
        private JFXButton loginBtn;

        // Username text field
        @FXML
        private JFXTextField usernameTxt;

        // Password text field
        @FXML
        private JFXPasswordField passwordTxt;

        /**
         * Launches the login form
         * @param args
         */
        public static void main(String[] args) {
                launch(args);
        }

        /**
         * Loads and displays the login form
         * @param primaryStage
         */
        @Override
        public void start(Stage primaryStage) {
                try {
                        BorderPane root =
                                FXMLLoader.load(getClass().getClassLoader().getResource("application/LoginForm.fxml"));

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
         * @param event
         */
        @FXML
        private void handleLoginBtn(ActionEvent event) {
                LoginFunctions.verify(usernameTxt.getText(),
                        passwordTxt.getText());
        }
}
