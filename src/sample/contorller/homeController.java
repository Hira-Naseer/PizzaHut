package sample.contorller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {

    @FXML
    Button saleInvoiceButton;
    @FXML
    Button uncompletedOrdersbutton;
    @FXML
    Button saleRecordButton;
    @FXML
    Button changeProductButton;
    @FXML
    Button logOutButton;
    @FXML
    BorderPane borderPane;
    @FXML
    Button invoiceRecordButton;
    @FXML
    Button viewProductsButton;


    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saleInvoiceButton.setOnAction(event -> {
            try {
                borderPane.setCenter(main.invoiceView());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        invoiceRecordButton.setOnAction(event -> {
            try {
                borderPane.setCenter(main.invoiceRecordView());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        viewProductsButton.setOnAction(event -> {
            try {
                borderPane.setCenter(main.viewProducts());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        uncompletedOrdersbutton.setOnAction(event -> {
            try {
                borderPane.setCenter(main.uncompleteOrdersView());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        saleRecordButton.setOnAction(event -> {
            try {
                borderPane.setCenter(main.saleRecordView());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        changeProductButton.setOnAction(event -> {
            try {
                borderPane.setCenter(main.changePasswordView());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        logOutButton.setOnAction(event -> {
            try {
                main.frontView();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }
}
