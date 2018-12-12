package application;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import system.Account;
import system.ActiveUser;

import java.io.File;

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
        private void initialize() {
                Account activeUser = ActiveUser.getAcc();

                usernameLbl.setText(activeUser.getUsername());
                balanceLbl.setText("Balance: £" + activeUser.getBalance());
                File file = new File(activeUser.getAvatar());
                Image image = new Image(file.toURI().toString());
                profileImg.setImage(image);

        }

        @FXML
        private void handleLogout() {

        }
}
