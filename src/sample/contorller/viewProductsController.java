package sample.contorller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;


public class viewProductsController implements Initializable {
    @FXML
    Button addButton;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        addButton.setOnAction(event -> {
            try {
                main.addProducts();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
