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
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.ResourceBundle;

public class CompleteJob implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    // for Job Completion
    @FXML
    public Label jobLabel;
    @FXML
    protected Label make;
    @FXML
    protected Label model;
    @FXML
    protected Label partsOrdered;
    @FXML
    protected Label partsCost;
    @FXML
    protected Label pickupCost;
    @FXML
    protected Label partsMarkup;
    @FXML
    protected Label laborCostLabel;
    @FXML
    protected Label totalAmountOwed;

    @FXML
    protected TextField jobIDbox;
    @FXML
    protected TextField laborCost;

    @FXML
    protected CheckBox pickupCheckbox;
    @FXML
    protected CheckBox deliveryCheckbox;

    @FXML
    protected CheckBox paymentCheckbox;

    public ObservableList<ActiveJobs> jobData;

    public void loadActiveJobData()
    {

        try
        {
            String sqlCheck = ("SELECT * FROM JobList WHERE Complete = False");
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

    public void selectJob()
    {
                DecimalFormat f = new DecimalFormat("#.00");

                boolean checker;


                int count = 0;
                PreparedStatement stmt = null;
                ResultSet rset = null;
                try
                {
                    String sqlCheck = ("SELECT * FROM PartsList WHERE jobID ="+ jobIDbox.getText() + ";");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    PreparedStatement ps1 = connection.prepareStatement(sqlCheck, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rset = ps1.executeQuery();
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
                } else
                {
                    checker = true;
                }



            if (checker==true)
            {
                try
                {
                    String jobQuery = ("SELECT j.jobID, j.Make, j.Model, sum(p.Quanity), sum(p.Cost), sum(p.cost*.20)\n" +
                        "FROM joblist j\n" +
                        "INNER JOIN partslist p\n" +
                        "ON j.jobID = p.jobID\n" +
                        "WHERE j.JobID = '" + jobIDbox.getText() + "'\n" +
                        "GROUP BY JobID, Make, Model;");


                    Connection connection = DriverManager.getConnection(url, username, password);
                    PreparedStatement ps1 = connection.prepareStatement(jobQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


                    ResultSet rs1 = ps1.executeQuery(jobQuery);


                    rs1 = connection.createStatement().executeQuery(jobQuery);


                    if (rs1.next())
                    {

                    // THIS IS WHERE YOU DETERMINE PICKUP/DELIVERY COST

                        if (pickupCheckbox.isSelected() && deliveryCheckbox.isSelected())
                    {
                        pickupCost.setText("$ " + String.valueOf(Double.parseDouble(String.valueOf(20.00))));
                    } else if (pickupCheckbox.isSelected() || deliveryCheckbox.isSelected())
                    {
                        pickupCost.setText("$ " + String.valueOf(Double.parseDouble(String.valueOf(10.00))));
                    } else
                    {
                        pickupCost.setText("$ " + String.valueOf(Double.parseDouble(String.valueOf(0.00))));
                    }

                    this.jobLabel.setText(String.valueOf(rs1.getInt(1)));
                    this.make.setText(rs1.getString(2));
                    this.model.setText(rs1.getString(3));
                    this.partsOrdered.setText(String.valueOf(rs1.getInt(4)));
                    this.partsCost.setText("$ " + String.valueOf(rs1.getDouble(5)));
                    this.partsMarkup.setText("$ " + String.valueOf(rs1.getDouble(6)));
                    this.laborCostLabel.setText("$ " + String.valueOf(laborCost.getText()));
                    if (laborCost.getText().length() > 0)
                    {
                        this.totalAmountOwed.setText("$ " + String.valueOf(f.format(rs1.getDouble(5) + rs1.getDouble(6) + Double.parseDouble(laborCostLabel.getText().substring(1)) + Double.parseDouble(pickupCost.getText().substring(1)))));
                    } else
                    {
                        this.totalAmountOwed.setText("$ " + String.valueOf(f.format(rs1.getDouble(5) + rs1.getDouble(6) + Double.parseDouble(pickupCost.getText().substring(1)))));
                    }

                }
                    else
                    {
                        Alert finished = new Alert(Alert.AlertType.ERROR);
                        finished.setTitle("Job ID not found");
                        finished.setContentText("Make sure the Job ID you entered is correct");
                        finished.show();

                    }


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
                    String jobQuery1 = ("SELECT jobID, Make, Model\n" +
                            "FROM JobList\n" +
                            "WHERE JobID = " + jobIDbox.getText() + ";");



                    Connection connection = DriverManager.getConnection(url, username, password);
                    PreparedStatement ps1 = connection.prepareStatement(jobQuery1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


                    ResultSet rs2 = ps1.executeQuery();

                    rs2 = connection.createStatement().executeQuery(jobQuery1);


                    if (rs2.next())
                    {

                        // THIS IS WHERE YOU DETERMINE PICKUP/DELIVERY COST

                        if (pickupCheckbox.isSelected() && deliveryCheckbox.isSelected())
                        {
                            pickupCost.setText("$ " + String.valueOf(Double.parseDouble(String.valueOf(20.00))));
                        } else if (pickupCheckbox.isSelected() || deliveryCheckbox.isSelected())
                        {
                            pickupCost.setText("$ " + String.valueOf(Double.parseDouble(String.valueOf(10.00))));
                        } else
                        {
                            pickupCost.setText("$ " + String.valueOf(Double.parseDouble(String.valueOf(0.00))));
                        }

                        this.jobLabel.setText(String.valueOf(rs2.getInt(1)));
                        this.make.setText(rs2.getString(2));
                        this.model.setText(rs2.getString(3));
                        this.partsOrdered.setText("0");
                        this.partsCost.setText("$ 0.00");
                        this.partsMarkup.setText("$ 0.00");
                        this.laborCostLabel.setText("$ " + String.valueOf(laborCost.getText()));
                        if (laborCost.getText().length() > 0)
                        {
                            this.totalAmountOwed.setText("$ " + String.valueOf(f.format( Double.parseDouble(laborCostLabel.getText().substring(1)) + Double.parseDouble(pickupCost.getText().substring(1)))));
                        } else
                        {
                            this.totalAmountOwed.setText("$ " + String.valueOf(f.format( Double.parseDouble(pickupCost.getText().substring(1)))));
                        }

                    }
                    else
                    {
                        Alert finished = new Alert(Alert.AlertType.ERROR);
                        finished.setTitle("Job ID not found");
                        finished.setContentText("Make sure the Job ID you entered is correct");
                        finished.show();

                    }


                }

                catch (Exception e)
                {
                    e.printStackTrace();

                }
            }
            }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        loadActiveJobData();

    }

    public void finishJob()
    {
        Job job = new Job();
        job.jobID= Integer.parseInt(jobLabel.getText());

        boolean checker;


        int count = 0;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try
        {
            String sqlCheck = ("SELECT * FROM joblist WHERE jobID ="+ jobIDbox.getText() + ";");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps1 = connection.prepareStatement(sqlCheck, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rset = ps1.executeQuery();
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
        } else
        {
            checker = true;
        }

        if (checker == true)
        {
            if (!jobLabel.getText().equals("0"))
            {
                try
                {

                    String finishJobQuery = ("INSERT INTO finishedjobs (JobId, ClientID, Start_Date, End_Date, Parts_Ordered, Total_Parts_Cost, Parts_Markup_Amount, Pickup_Delivery_Cost, Labor_Cost, Total_Amount_Owed, Payment_Status)\n" +
                            " SELECT JobId, ClientID, Start_Date,  CURDATE() , '" + partsOrdered.getText() + "', '" + partsCost.getText().substring(1) + "', '" + partsMarkup.getText().substring(1) + "', '" + pickupCost.getText().substring(1) + "', '" + laborCostLabel.getText().substring(1) + "','" + totalAmountOwed.getText().substring(1) + "', FALSE\n" +
                            " FROM joblist\n" +
                            " WHERE JobID = " + jobLabel.getText() + ";");

                    String fk0 = (" SET FOREIGN_KEY_CHECKS=0;\n");

                    /*
                    String delete = (" DELETE \n" +
                            " FROM joblist\n" +
                            " WHERE JobID = " + jobLabel.getText() + ";\n");

                     */

                    String delete = (" UPDATE joblist\n" +
                            " SET complete = true\n" +
                            " WHERE JobID = " + jobLabel.getText() + ";\n");


                    String fk1 = (" SET FOREIGN_KEY_CHECKS=1;");


                    Connection connection = DriverManager.getConnection(url, username, password);
                    PreparedStatement ps2 = connection.prepareStatement(fk0);
                    PreparedStatement ps1 = connection.prepareStatement(finishJobQuery);
                    PreparedStatement ps3 = connection.prepareStatement(delete);
                    PreparedStatement ps4 = connection.prepareStatement(fk1);


                    ps1.execute();
                    ps2.execute();
                    ps3.execute();
                    ps4.execute();


                    loadActiveJobData();
                    Alert finished = new Alert(Alert.AlertType.CONFIRMATION);
                    finished.setTitle("Congratulations");
                    finished.setContentText("You successfully finished a job");
                    finished.show();


                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                Alert finished = new Alert(Alert.AlertType.ERROR);
                finished.setTitle("Job ID not found");
                finished.setContentText("Make sure you Select/Apply Changes.");
                finished.show();
            }

        }
        else
        {
            Alert finished = new Alert(Alert.AlertType.ERROR);
            finished.setTitle("Job ID not found");
            finished.setContentText("Make sure the Job ID you entered is correct!");
            finished.show();
        }
    }
}
