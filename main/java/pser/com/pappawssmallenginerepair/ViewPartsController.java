package pser.com.pappawssmallenginerepair;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ViewPartsController implements Initializable
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    protected  boolean checker;

    String url = ("jdbc:mysql://localhost:3306/pser");
    String username = ("root");
    String password = ("");

    @FXML
    protected TableView<Parts> partsTable;
    @FXML
    protected TableColumn<Parts, Integer > jidCol;
    @FXML
    protected TableColumn <Parts, Integer > pidCol;
    @FXML
    protected TableColumn <Parts, String > pnameCol;
    @FXML
    protected TableColumn <Parts, Double > pcostCol;
    @FXML
    protected TableColumn <Parts, Integer > pquanityCol;
    @FXML
    protected TableColumn <Parts, String > datePurchasedCol;

    @FXML
    protected TextField jobPartSearch;


    public ObservableList<Parts> partData;

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
    public void  switchToViewParts(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ViewPartsList.fxml"));
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

    public void switchToViewActiveJobs(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ActiveJobs.fxml"));
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

    public void loadPartData()
    {
        try
        {
            String sqlCheck = ("SELECT * FROM partsList");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(sqlCheck);
            ResultSet rs = ps.executeQuery();

            partData = FXCollections.observableArrayList();
            rs=connection.createStatement().executeQuery(sqlCheck);

            while (rs.next())
            {
                partData.add(new Parts(rs.getInt(2),rs.getInt(1),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        jidCol.setCellValueFactory(new PropertyValueFactory<>("jobID"));
        pidCol.setCellValueFactory(new PropertyValueFactory<>("partID"));
        pnameCol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        pcostCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
        pquanityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        datePurchasedCol.setCellValueFactory(new PropertyValueFactory<>("date"));


        partsTable.setItems(null);
        partsTable.setItems(partData);
}

    public void searchPartByJob()
    {

        try
        {
            String sqlCheck = ("SELECT *  FROM partslist WHERE jobID = '"+ jobPartSearch.getText().toString() +"' ;");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(sqlCheck);
            ResultSet rs = ps.executeQuery();

            partData = FXCollections.observableArrayList();
            rs=connection.createStatement().executeQuery(sqlCheck);

            while (rs.next())
            {
                partData.add(new Parts(rs.getInt(2),rs.getInt(1),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        jidCol.setCellValueFactory(new PropertyValueFactory<>("jobID"));
        pidCol.setCellValueFactory(new PropertyValueFactory<>("partID"));
        pnameCol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        pcostCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
        pquanityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        datePurchasedCol.setCellValueFactory(new PropertyValueFactory<>("date"));


        partsTable.setItems(null);
        partsTable.setItems(partData);

    }



}
