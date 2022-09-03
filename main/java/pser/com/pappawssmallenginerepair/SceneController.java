package pser.com.pappawssmallenginerepair;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Locale;

public class SceneController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void  switchToActiveJobs(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ActiveJobs.fxml"));
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

    public void  switchToFinishedJobs(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ViewFinishedJobs.fxml"));
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

    public void  addNewClient(ActionEvent event)
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

    public void  clientList(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("clientStyle.fxml"));
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

    public void switchToNewJob(ActionEvent event)
    {
        try
        {
            root = FXMLLoader.load(getClass().getResource("AddJobStyle.fxml"));
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

    public void switchToViewClientList(ActionEvent event)
    {
        try
        {
            root = FXMLLoader.load(getClass().getResource("ViewClientStyle.fxml"));
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

}

