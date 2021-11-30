package lk.hibernate.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public class LogInPageFormController {
    public AnchorPane root;
    public TextField txtUserName;
    public PasswordField pswPassword;
    public Button btnLogIn;

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {
    }
}
