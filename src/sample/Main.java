package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.contorller.*;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        frontView();
    }
    public void frontView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/frontView.fxml"));
        SplitPane pane = loader.load();
        FrontViewController frontControllerobj = loader.getController();
        frontControllerobj.setMain(this);

        Scene scene = new Scene(pane, 800, 465);
        primaryStage.setTitle("Pizza Hut");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public BorderPane invoiceView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/invoiceView.fxml"));
        BorderPane borderPane = null;
        try {
            borderPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return borderPane;
    }
    public void homeView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/home.fxml"));
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane,800,465);
        this.primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        this.primaryStage.show();

        homeController homectrlObj = loader.getController();
        homectrlObj.setMain(this);
    }
    public FlowPane uncompleteOrdersView() throws  Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/uncompleteOrdersView.fxml"));
        FlowPane pane = loader.load();
        unCompletedOrdersController uncomOrderCtrObj = loader.getController();
        return pane;
    }
    public Pane invoiceRecordView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/invoiceRecordView.fxml"));
        Pane pane = loader.load();
        invoiceRecordViewController invoiceRecordViewController = loader.getController();
        return pane;
    }
    public Pane saleRecordView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/saleRecordView.fxml"));
        Pane pane = loader.load();
        saleRecordController saleRecordController = loader.getController();
        return pane;
    }
    public Pane changePasswordView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/changePassword.fxml"));
        changePasswordController changePasswordController = loader.getController();

        Pane pane = loader.load();
        return pane;
    }
    public Pane viewProducts() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/ViewProducts.fxml"));
        Pane pane = loader.load();
        viewProductsController viewProductsController = loader.getController();
        return pane;
    }
    public Pane addProducts()throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/addProducts.fxml"));
        Pane pane = loader.load();
        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

