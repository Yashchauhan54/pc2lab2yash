package org.example.classactivity2yash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public TableView<actor> actorTable;
    public TableColumn<actor,Integer> id;
    public TableColumn<actor, String> actor;
    public TableColumn<actor, String> email;
    public TableColumn<actor, String> phone;
    public Label welcomeText;
    public TextField gid;
    public TextField gname;
    public TextField gemail;
    public TextField gphone;



    ObservableList<actor> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<actor, Integer>("id"));
        actor.setCellValueFactory(new
                PropertyValueFactory<actor, String>("actor"));
        email.setCellValueFactory(new
                PropertyValueFactory<actor, String>("email"));
        phone.setCellValueFactory(new
                PropertyValueFactory<actor, String>("phone"));
        actorTable.setItems(list);
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
        fetchdata();
    }

    private void fetchdata() {
        list.clear();
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_actor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String actor = resultSet.getString("actor");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                actorTable.getItems().add(new actor(id, actor, email, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(ActionEvent actionEvent) {
        String actor = gname.getText();
        String email = gemail.getText();
        String phone = gphone.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `tbl_actor`( `actor`, `email`, `phone`) VALUES ('"+actor+"','"+email+"','"+phone+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();



    }


}

    public void update(ActionEvent actionEvent) {
        String id = gid.getText();
        String actor = gname.getText();
        String email = gemail.getText();
        String phone = gphone.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `tbl_actor` SET `actor`='"+actor+"',`email`='"+email+"',`phone`='"+phone+"' WHERE id='"+id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete(ActionEvent actionEvent) {
        String id = gid.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `tbl_actor` WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loaddata(ActionEvent actionEvent) {
        String id = gid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_actor WHERE id='" + id + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String actor = resultSet.getString("actor");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                gname.setText(actor);
                gemail.setText(email);
                gphone.setText(phone);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void truncate(ActionEvent actionEvent) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "Truncate tbl_actor";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();



        }

    }
}


