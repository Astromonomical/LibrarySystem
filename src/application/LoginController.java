package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Handles the loading and displaying of the user form
 */
public class LoginController extends Application {

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
                                FXMLLoader.load(getClass().getClassLoader().getResource("application/LoginForm.fmxl"));

                        // Load root into the stage
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
