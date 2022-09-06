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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class PaidJobsController implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    String url = ("jdbc:mysql://localhost:3306/pser");
    String username = ("root");
    String password = ("");

    @FXML
    protected TableView<FinishedJobs> finishedJobTable;
    @FXML
    protected TableColumn<FinishedJobs, Integer> jobCol;
    @FXML
    protected TableColumn<FinishedJobs, Integer> clientCol;
    @FXML
    protected TableColumn<FinishedJobs, String> sdateCol;
    @FXML
    protected TableColumn<FinishedJobs, String> edateCol;
    @FXML
    protected TableColumn<FinishedJobs, Integer> partQuanCol;
    @FXML
    protected TableColumn<FinishedJobs, Double> partCostCol;
    @FXML
    protected TableColumn<FinishedJobs, Double> pmarkupCol;
    @FXML
    protected TableColumn<FinishedJobs, Double> pickupCol;
    @FXML
    protected TableColumn<FinishedJobs, Double> laborCol;
    @FXML
    protected TableColumn<FinishedJobs, Double> totalCol;

    public ObservableList <FinishedJobs> finishedJobData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    loadPaidJobsData();
    }


    public void loadPaidJobsData()
    {

        try
        {
            String sqlCheck = ("SELECT * FROM FinishedJobs WHERE payment_status = TRUE;");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(sqlCheck);
            ResultSet rs = ps.executeQuery();

            finishedJobData = FXCollections.observableArrayList();
            rs = connection.createStatement().executeQuery(sqlCheck);

            while (rs.next())
            {
                finishedJobData.add(new FinishedJobs(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        jobCol.setCellValueFactory(new PropertyValueFactory<>("jobID"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientID"));
        sdateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        edateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        partQuanCol.setCellValueFactory(new PropertyValueFactory<>("partsOrdered"));
        partCostCol.setCellValueFactory(new PropertyValueFactory<>("partsCost"));
        pmarkupCol.setCellValueFactory(new PropertyValueFactory<>("markupCost"));
        pickupCol.setCellValueFactory(new PropertyValueFactory<>("pickupCost"));
        laborCol.setCellValueFactory(new PropertyValueFactory<>("laborCost"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalAmountOwed"));

        finishedJobTable.setItems(null);
        finishedJobTable.setItems(finishedJobData);
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
    }
