package sample.models;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import sample.dataBase.DBConect;

public class PizzaModel {
    private String userName;
    private String password;

    private DBConect dbConect;

    public PizzaModel(){

    }
    public PizzaModel(String userName,String password){
        setUserName(userName);
        setPassword(password);

        try {
            dbConect = new DBConect();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public boolean validate(){
        return dbConect.validate(this.userName,this.password);
    }
    public void alertBox(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("invalid user name or password");
        alert.show();
    }
}
