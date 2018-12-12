package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import system.Account;
import system.ActiveUser;
import system.DatabaseHandle;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class MenuController {

        @FXML
        private Label usernameLbl;

        @FXML
        private Label balanceLbl;

        @FXML
        private ImageView profileImg;

        @FXML
        private JFXButton logoutBtn;

        @FXML
        private Label fnameLbl;

        @FXML
        private Label snameLbl;

        @FXML
        private JFXTextField staffIDTxt;

        @FXML
        private JFXCheckBox isLibCheck;

        @FXML
        private JFXButton saveBtn;

        @FXML
        private JFXTextField fnameTxt;

        @FXML
        private JFXTextField snameTxt;

        @FXML
        private JFXTextField usernameTxt;

        @FXML
        private JFXPasswordField passwordTxt;

        /**
         * Sets labels
         */
        @FXML
        private void initialize() {
                Account activeUser = ActiveUser.getAcc();

                usernameLbl.setText(activeUser.getUsername());
                balanceLbl.setText("Balance: £" + activeUser.getBalance());
                File file = new File(activeUser.getAvatar());
                Image image = new Image(file.toURI().toString());
                profileImg.setImage(image);

                fnameLbl.setText(ActiveUser.getUser().getFName());
                snameLbl.setText(ActiveUser.getUser().getSName());

        }

        /**
         * Logs out
         */
        @FXML
        private void handleLogout() {
                Stage stage = (Stage) profileImg.getScene().getWindow();

                try {
                        BorderPane root =
                                FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(
                                        "application/LoginForm.fxml")));

                        // Load root into the stage
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        stage.centerOnScreen();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        private void handleCheck() {
                boolean ticked = isLibCheck.isSelected();

                if (ticked) {
                        staffIDTxt.setDisable(false);
                } else {
                        staffIDTxt.setDisable(true);
                }
        }

        @FXML
        private void handleSave() {
                String username = usernameTxt.getText();
                String fname = fnameTxt.getText();
                String sname = snameTxt.getText();
                String password = passwordTxt.getText();

                if (username != null && fname  != null && sname != null && password != null) {
                        if (isLibCheck.isSelected()) {
                                String staffID = staffIDTxt.getText();
                                saveLib(username, password, fname, sname,
                                        staffID);
                        } else {
                                saveUser(username, password, fname, sname);
                        }

                } else {
                        FxDialogs.showError("Incompleted Form", "Please " +
                                "ensure all required fields have been " +
                                "completed");
                }
        }

        private void saveLib(String username, String password, String fname,
                             String sname, String staffID) {
                try {
                        // Setup new user value
                        DatabaseHandle.dbInsert("INSERT INTO User (fname, " +
                                "sname) " +
                                "VALUES ('" + fname +
                                "', '" + sname + "')");

                        // Acquire UserID
                        ResultSet rs =
                                DatabaseHandle.dbQuery("SELECT User.userID FROM User" +
                                        " WHERE fname='" + fname + "' AND sname='" + sname + "'");
                        String userID = String.valueOf(rs.getInt(1));

                        // Save new Account
                        DatabaseHandle.dbInsert("INSERT INTO Account VALUES " +
                                "('" + username + "', '" + password + "', " +
                                Integer.parseInt(userID) + ", " + 0.00 +
                                ", 'Database/avatars/default.png', " + 1 + ")");

                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                }
        }

        private void saveUser(String username, String password, String fname,
                              String sname) {

        }
}
