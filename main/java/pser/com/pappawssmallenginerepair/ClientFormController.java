package pser.com.pappawssmallenginerepair;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;


public class ClientFormController  implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    String url = ("jdbc:mysql://localhost:3306/pser");
    String username = ("root");
    String password = ("");

    @FXML
    protected TextField fname;
    @FXML
    protected TextField lname;
    @FXML
    protected TextField phones;
    @FXML
    protected TextField emails;
    @FXML
    protected TextField addresss;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void  switchToClient(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ClientStyle.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void  switchToJobs(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("JobsStyle.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void  switchToEarnings(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("EarningsStage1.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void  logout(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("LoginMenuStyle.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void  switchToMenu(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenuStyle.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void  addNewClient(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("AddClient.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void  clientList(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("AddClientStyle.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void newClientInsert()
    {
        Client client = new Client(0,"","","","","");
        boolean checker;
        client.firstName = fname.getText().toUpperCase(Locale.ROOT).replaceAll("\\s","");
        client.lastName = lname.getText().toUpperCase(Locale.ROOT).replaceAll("\\s","");
        client.address = addresss.getText().toUpperCase(Locale.ROOT).replaceAll("\\s","");
        client.email = emails.getText().toUpperCase(Locale.ROOT).replaceAll("\\s","");
        client.phone = phones.getText().toUpperCase(Locale.ROOT).replaceAll("\\s","");


        int count = 0;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try
        {
            String sqlCheck = ("SELECT * FROM ClientList WHERE First_Name ='" + client.firstName + "' AND Last_Name ='" + client.lastName + "'");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(sqlCheck);
            rset = ps.executeQuery();
            if (rset.next())
                count = rset.getInt(1);

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally
        {
            if (rset != null)
            {
                try
                {
                    rset.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        if (count == 0)
        {
            checker = false;
        }
        else
        {
            checker = true;
        }


        if (fname.getText().length() > 0 && lname.getText().length() > 0 && phones.getText().length() >= 10)
        {
            if (checker == true)
            {
                Alert finished1 = new Alert(Alert.AlertType.WARNING);
                finished1.setTitle("Existing Client");
                finished1.setContentText("A Client with this name already exist in the database.");
                finished1.show();
            }
            else

                try
                {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "INSERT INTO ClientList (First_Name, Last_Name, Phone, Address, Email) VALUES ('" + client.firstName + "', '" + client.lastName + "','" + client.phone + "','" + client.address + "','" + client.email + "')";
                    PreparedStatement prepstate = connection.prepareStatement(query);
                    prepstate.execute();

                    fname.clear();
                    lname.clear();
                    addresss.clear();
                    phones.clear();
                    emails.clear();

                    Alert finished = new Alert(Alert.AlertType.CONFIRMATION);
                    finished.setTitle("Client Added");
                    finished.setContentText("Success! You've Created a new Client");
                    finished.show();


                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
           else{
            Alert finished = new Alert(Alert.AlertType.ERROR);
            finished.setTitle("Something Went Wrong");
            finished.setContentText("You must have a First Name, Last Name, and \n at least 10 digits in the phone number");
            finished.show();
        }
        }



}
