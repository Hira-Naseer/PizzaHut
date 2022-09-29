package sample.contorller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import sample.Main;
import sample.models.PizzaModel;

import java.net.URL;
import java.util.ResourceBundle;

public class FrontViewController implements Initializable {
    @FXML
    SplitPane splitPane;
    @FXML
    TextField userNameTextFeild;
    @FXML
    PasswordField passwordFeild;
    @FXML
    Button loginButton;
    @FXML
    Button resetButton;

    private PizzaModel pizzaModel;
    private  Main main;

    public void setPizzaModel(PizzaModel pizzaModel){this.pizzaModel = pizzaModel;}
    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginButton.setOnAction(event1 -> {
            String userName = userNameTextFeild.getText();
            String password = passwordFeild.getText();
            PizzaModel pizzaModel = new PizzaModel(userName,password);
               boolean check = pizzaModel.validate();
               if(check == true){
                   try {
                       main.homeView();
                   } catch (Exception exception) {
                       exception.printStackTrace();
                   }
               }
               else {
                   pizzaModel.alertBox();
               }
        });
        resetButton.setOnAction(event -> {
            userNameTextFeild.setText("");
            passwordFeild.setText("");
        });

    }
}
