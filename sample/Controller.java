package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML  public VBox vBox;
    @FXML  public JFXButton add_btn;
    @FXML  public JFXButton view_btn;
    @FXML public ScrollPane scroll;
    @FXML public StackPane stackPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        stackPane.setVisible(false);
    }
}
