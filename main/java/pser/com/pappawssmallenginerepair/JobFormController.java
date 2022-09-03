package pser.com.pappawssmallenginerepair;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class JobFormController extends Job implements Initializable
{

    String url = ("jdbc:mysql://localhost:3306/pser");
    String username = ("root");
    String password = ("Roxysdad828!");

    protected boolean checker;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML
    protected TextField vmake;
    @FXML
    protected TextField vmodel;
    @FXML
    protected TextField vyear;
    @FXML
    protected TextField vissue;
    @FXML
    protected ComboBox vtype;
    @FXML
    protected DatePicker startdate;
    @FXML
    protected TextField fnames;
    @FXML
    protected TextField lnames;
    @FXML
    protected TextField phoness;
    @FXML
    protected TextField emailss;
    @FXML
    protected TextField addressss;


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToClient(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ClientStyle.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void logout(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("LoginMenuStyle.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void switchToJobs(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("JobsStyle.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

    public void clientList(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("AddClientStyle.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void newJobInsert()
    {
        try
        {
            Client client = new Client(0, "", "", "", "", "");


            client.firstName = fnames.getText().toUpperCase(Locale.ROOT).replaceAll("\\s","");
            client.lastName = lnames.getText().toUpperCase(Locale.ROOT).replaceAll("\\s","");
            client.address = addressss.getText().toUpperCase(Locale.ROOT);
            client.email = emailss.getText().toUpperCase(Locale.ROOT);
            client.phone = phoness.getText().toUpperCase(Locale.ROOT);

            this.make = vmake.getText().toUpperCase(Locale.ROOT);
            this.model = vmodel.getText().toUpperCase(Locale.ROOT);
            this.year = vyear.getText().toUpperCase(Locale.ROOT);
            this.type = vtype.getValue().toString().toUpperCase(Locale.ROOT);
            this.issue = vissue.getText().toUpperCase(Locale.ROOT);
            this.type = vtype.getValue().toString().toUpperCase(Locale.ROOT);
            this.startDate = startdate.getValue().toString().toUpperCase(Locale.ROOT);


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
            } finally
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
            } else
            {
                checker = true;
            }


            if (fnames.getText().length() > 0 && lnames.getText().length() > 0 && vmake.getText().length() > 0 && vmodel.getText().length() > 0 && vtype != null && vyear.getText().length()>0)
            {
                if (checker == true)
                {
                    try
                    {
                        Connection connection1 = DriverManager.getConnection(url, username, password);
                        String insertFound = "INSERT INTO JobList (Complete, Make, Model, Year, Type, Issue, Start_Date, ClientID) SELECT False, '" + make + "', '" + model + "','" + year + "','" + type + "','" + issue + "','" + startDate + "', c.ClientId FROM  ClientList c " + " WHERE First_Name = '" + client.firstName + "' AND c.Last_Name = '" + client.lastName + "' ;";

                        PreparedStatement foundStatement = connection1.prepareStatement(insertFound);
                        foundStatement.execute();

                        fnames.clear();
                        lnames.clear();
                        addressss.clear();
                        phoness.clear();
                        emailss.clear();
                        vmake.clear();
                        vmodel.clear();
                        vyear.clear();
                        vissue.clear();

                        Alert finished1 = new Alert(Alert.AlertType.CONFIRMATION);
                        finished1.setTitle("Job Added");
                        finished1.setContentText("Success! You've Created a new job for a previous client!");
                        finished1.show();


                    }
                    catch (Exception e)
                    {

                        e.printStackTrace();
                    }
                }
                else
                {
                    try
                    {
                        Connection connection = DriverManager.getConnection(url, username, password);
                        String insertFound = "INSERT INTO JobList (Complete,Make, Model, Year, Type, Issue, Start_Date, ClientID) SELECT False, '" + make + "', '" + model + "','" + year + "','" + type + "','" + issue + "','" + startDate + "', ClientId FROM  ClientList" + " WHERE First_Name = '" + client.firstName + "' AND Last_Name = '" + client.lastName + "';";
                        String insertNotFound = ("INSERT INTO ClientList (First_Name, Last_Name, Phone, Address, Email) VALUES('" + client.firstName + "', '" + client.lastName + "','" + client.phone + "','" + client.address + "','" + client.email + "') ");
                        PreparedStatement notFoundStatement = connection.prepareStatement(insertNotFound);
                        PreparedStatement foundStatement = connection.prepareStatement(insertFound);
                        notFoundStatement.execute();
                        foundStatement.execute();

                        fnames.clear();
                        lnames.clear();
                        addressss.clear();
                        phoness.clear();
                        emailss.clear();
                        vmake.clear();
                        vmodel.clear();
                        vyear.clear();
                        vissue.clear();

                        Alert finished = new Alert(Alert.AlertType.CONFIRMATION);
                        finished.setTitle("Job and Client Added");
                        finished.setContentText("Success! You've Created a new Job and a new Client");
                        finished.show();


                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            } else
            {
                Alert finished = new Alert(Alert.AlertType.ERROR);
                finished.setTitle("Missing Information");
                finished.setContentText("Make Sure you fill out all the information!\nSpecifically Name, Make, Model, Type, Year and Date.");
                finished.show();
            }

        }
        catch (Exception e)
        {
            Alert finished = new Alert(Alert.AlertType.ERROR);
            finished.setTitle("Missing Information");
            finished.setContentText("Make Sure you fill out all the information!\nSpecifically Name, Make, Model, Type, Year and Date.");
            finished.show();
        }
    }

    public void clear()
    {
        fnames.clear();
        lnames.clear();
        addressss.clear();
        phoness.clear();
        emailss.clear();
        vmake.clear();
        vmodel.clear();
        vyear.clear();
        vissue.clear();
    }

}


