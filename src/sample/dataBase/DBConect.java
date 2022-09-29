package sample.dataBase;

import java.sql.*;

public class DBConect {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private String url = "jdbc:mysql://localhost/pizzahut?useTimezone=true&serverTimezone=UTC";
    private String userName = "root";
    private String password = "";

    public Connection getConnection() {
        return connection;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public DBConect() throws Exception{
        connection = DriverManager.getConnection(this.url,userName,password);
    }
    public Boolean isConnect(){
        try {
            return !connection.isClosed();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean validate(String userName,String password){
        try {
            String query = "select * from user where userName = ? and password = MD5(?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            return resultSet.next();

        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }
        public boolean insertData(String productName, double productQuantity, double unitPrice,int productCode) {
            String query = "Insert Into product(productName, productQuntity, unitPrice, productCode) value (?,?,?,?)";
            String query1 = "INSERT INTO catagory(catagoryName) values(catagoryName)";
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, productName);
                preparedStatement.setDouble(2, productQuantity);
                preparedStatement.setDouble(3, unitPrice);
                preparedStatement.setInt(4, productCode);

                int row = preparedStatement.executeUpdate();
                if (row > 0) {
                    return true;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return false;
            }

        }