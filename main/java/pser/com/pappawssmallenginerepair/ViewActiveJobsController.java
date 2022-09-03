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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewActiveJobsController implements Initializable
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    protected boolean checker;

    String url = ("jdbc:mysql://localhost:3306/pser");
    String username = ("root");
    String password = ("Roxysdad828!");

    @FXML
    protected TableView<ActiveJobs> activeJobTable;
    @FXML
    protected TableColumn<ActiveJobs, Integer> jobCol;
    @FXML
    protected TableColumn<ActiveJobs, String> makeCol;
    @FXML
    protected TableColumn<ActiveJobs, String> modelCol;
    @FXML
    protected TableColumn<ActiveJobs, Integer> yearCol;
    @FXML
    protected TableColumn<ActiveJobs, String> typeCol;
    @FXML
    protected TableColumn<ActiveJobs, String> startCol;
    @FXML
    protected TableColumn<ActiveJobs, String> issueCol;
    @FXML
    protected TableColumn<ActiveJobs, Integer> clientCol;

    // for adding parts
    @FXML
    protected TextField pname;
    @FXML
    protected TextField pquanity;
    @FXML
    protected TextField pcost;
    @FXML
    protected DatePicker pdate;
    @FXML
    protected TextField jobIDp;

    public ObservableList<ActiveJobs> jobData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        loadActiveJobData();
    }

    public void loadActiveJobData()
    {

        try
        {
            String sqlCheck = ("SELECT * FROM JobList WHERE complete = false;");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(sqlCheck);
            ResultSet rs = ps.executeQuery();

            jobData = FXCollections.observableArrayList();
            rs = connection.createStatement().executeQuery(sqlCheck);

            while (rs.next())
            {
                jobData.add(new ActiveJobs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        jobCol.setCellValueFactory(new PropertyValueFactory<>("jobID"));
        makeCol.setCellValueFactory(new PropertyValueFactory<>("make"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        issueCol.setCellValueFactory(new PropertyValueFactory<>("issue"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientID"));

        activeJobTable.setItems(null);
        activeJobTable.setItems(jobData);
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

    public void switchToViewParts(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ViewPartsList.fxml"));
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

    public void switchToAddParts(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("AddPurchaseWithChart.fxml"));
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

    public void addNewPart(ActionEvent event)
    {
        try
        {
            Parts part = new Parts(0, 0, "", 0, 0, "");
            part.partName = pname.getText().toUpperCase(Locale.ROOT);
            part.cost = Double.parseDouble(pcost.getText().toUpperCase(Locale.ROOT));
            part.quantity = Integer.parseInt(pquanity.getText().toUpperCase(Locale.ROOT));
            part.date = pdate.getValue().toString().toUpperCase(Locale.ROOT);
            part.jobID = Integer.parseInt(jobIDp.getText().toUpperCase(Locale.ROOT));


            int count = 0;
            PreparedStatement stmt = null;
            ResultSet rset = null;

            try
            {
                String sqlCheck = ("SELECT * FROM JobList WHERE jobID ='" + part.jobID + "'");
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


            if (jobIDp.getText().length() > 0 && pname.getText().length() > 0 && pcost.getText().length() > 0 && pquanity.getText().length() > 0 && pdate.getValue().toString().length() > 0)
            {
                if (checker == true)
                {

                    try
                    {

                        Connection connection1 = DriverManager.getConnection(url, username, password);
                        String insertPart = "INSERT INTO partslist (JobID, PartName, Cost, Quanity, DatePurchased) SELECT '" + part.jobID + "', '" + part.partName + "','" + part.cost + "','" + part.quantity + "','" + part.date + "'";

                        PreparedStatement foundStatement = connection1.prepareStatement(insertPart);
                        foundStatement.execute();
                        jobIDp.clear();
                        pname.clear();
                        pquanity.clear();
                        pcost.clear();


                        Alert finished1 = new Alert(Alert.AlertType.CONFIRMATION);
                        finished1.setTitle("Part Added");
                        finished1.setContentText("Success! You've added a part to Job ID " + part.jobID + "!");
                        finished1.show();


                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();

                    }
                } else
                {
                    Alert finished = new Alert(Alert.AlertType.ERROR);
                    finished.setTitle("Job ID not found");
                    finished.setContentText("The Job ID you entered is not found.");
                    finished.show();
                }
            }
        }
        catch (Exception e)
        {

            Alert finished = new Alert(Alert.AlertType.ERROR);
            finished.setTitle("Missing Information");
            finished.setContentText("You must fill out all the information.");
            finished.show();
        }
    }

    public void switchToCompleteJob(ActionEvent event)
    {

        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("FinishJob.fxml"));
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


}