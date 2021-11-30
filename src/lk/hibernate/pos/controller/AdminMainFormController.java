package lk.hibernate.pos.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public class AdminMainFormController {
    public AnchorPane root;
    public ImageView imgItem;
    public ImageView imgBusinessIncome;
    public ImageView imgItemMove;
    public ImageView imgLogOut;
    public ImageView imgViewReport;
    public ImageView imgCustomerIncome;
    public Label lblDescription;
    public Label lblMenu;

    public void navigate(MouseEvent event) throws IOException {
    }

    public void playMouseEnterAnimation(MouseEvent event) {
    }

    public void playMouseExitAnimation(MouseEvent event) {
    }
}
