package pser.com.pappawssmallenginerepair;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;

public class EarningsReport
{


    @FXML
    protected ComboBox monthDropbox;
    @FXML
    protected ComboBox yearDropbox;
    @FXML
    protected TextField jobID;

    @FXML
    protected Label totalPartsCost;
    @FXML
    protected Label pickupDelCost;
    @FXML
    protected Label partsOrdered;
    @FXML
    protected Label laborProfit;
    @FXML
    protected Label partProfit;
    @FXML
    protected Label pickupProfit;
    @FXML
    protected Label totalProfit;


    private Stage stage;
    private Scene scene;
    private Parent root;

    String url = ("jdbc:mysql://localhost:3306/pser");
    String username = ("root");
    String password = ("");


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

    public void switchToEarnings(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("EarningsStage1.fxml"));
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


    public void switchtoMonthlyEarnings(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("MonthlyEarningsReport.fxml"));
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

    public void switchtoYearlyEarnings(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("YearlyEarningsReport.fxml"));
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

    public void switchtoJobEarnings(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("IndividualJobReport.fxml"));
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

    public void loadMontlyReport()
    {
        if (monthDropbox.getValue()!=null && yearDropbox.getValue()!=null)
        {
            DecimalFormat f = new DecimalFormat("#.00");

            String month = "0";

            if (monthDropbox.getValue().equals("January"))
            {
                month = "01";
            } else if (monthDropbox.getValue().equals("February"))
            {
                month = "02";
            } else if (monthDropbox.getValue().equals("March"))
            {
                month = "03";
            } else if (monthDropbox.getValue().equals("April"))
            {
                month = "04";
            } else if (monthDropbox.getValue().equals("May"))
            {
                month = "05";
            } else if (monthDropbox.getValue().equals("June"))
            {
                month = "06";
            } else if (monthDropbox.getValue().equals("July"))
            {
                month = "07";
            } else if (monthDropbox.getValue().equals("August"))
            {
                month = "08";
            } else if (monthDropbox.getValue().equals("September"))
            {
                month = "09";
            } else if (monthDropbox.getValue().equals("October"))
            {
                month = "10";
            } else if (monthDropbox.getValue().equals("November"))
            {
                month = "11";
            } else if (monthDropbox.getValue().equals("December"))
            {
                month = "12";
            }


            try
            {
                String query = ("SELECT * \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND MONTH(End_Date) = " + month + " AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");


                String profitQuery = ("SELECT round(sum(total_amount_owed) - sum(Total_parts_Cost),2)-(sum(Pickup_Delivery_Cost)/2) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND MONTH(End_Date) = " + month + " AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String partCostQuery = ("SELECT sum(Total_parts_Cost) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND MONTH(End_Date) = " + month + " AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String partsOrderedQuery = ("SELECT sum(Parts_Ordered) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND MONTH(End_Date) = " + month + " AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String pickupCostQuery = ("SELECT sum(Pickup_Delivery_Cost)/2 \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND MONTH(End_Date) = " + month + " AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String partprofitQuery = ("SELECT sum(Parts_Markup_Amount) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND MONTH(End_Date) = " + month + " AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String pickupProfitQuery = ("SELECT sum(Pickup_Delivery_Cost)/2 \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND MONTH(End_Date) = " + month + " AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String laborProfitQuery = ("SELECT sum(Labor_Cost) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND MONTH(End_Date) = " + month + " AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");


                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement ps1 = connection.prepareStatement(query);
                PreparedStatement ps2 = connection.prepareStatement(profitQuery);
                PreparedStatement ps3 = connection.prepareStatement(partCostQuery);
                PreparedStatement ps4 = connection.prepareStatement(pickupCostQuery);
                PreparedStatement ps5 = connection.prepareStatement(partsOrderedQuery);
                PreparedStatement ps6 = connection.prepareStatement(partprofitQuery);
                PreparedStatement ps7 = connection.prepareStatement(pickupProfitQuery);
                PreparedStatement ps8 = connection.prepareStatement(laborProfitQuery);


                ResultSet rs1 = ps1.executeQuery();
                rs1 = connection.createStatement().executeQuery(query);

                ResultSet rs2 = ps2.executeQuery();
                rs2 = connection.createStatement().executeQuery(profitQuery);

                ResultSet rs3 = ps3.executeQuery();
                rs3 = connection.createStatement().executeQuery(partCostQuery);

                ResultSet rs4 = ps4.executeQuery();
                rs4 = connection.createStatement().executeQuery(pickupCostQuery);

                ResultSet rs5 = ps5.executeQuery();
                rs5 = connection.createStatement().executeQuery(partsOrderedQuery);

                ResultSet rs6 = ps6.executeQuery();
                rs6 = connection.createStatement().executeQuery(partprofitQuery);

                ResultSet rs7 = ps7.executeQuery();
                rs7 = connection.createStatement().executeQuery(pickupProfitQuery);

                ResultSet rs8 = ps8.executeQuery();
                rs8 = connection.createStatement().executeQuery(laborProfitQuery);


                if (rs1.next())
                {
                    if (rs3.next())
                        totalPartsCost.setText("$ " +f.format(rs3.getDouble(1)));
                    if (rs4.next())
                        pickupDelCost.setText("$ " +f.format(rs4.getDouble(1)));
                    if (rs7.next())
                        pickupProfit.setText("$ " +f.format(rs7.getDouble(1)));
                    if (rs5.next())
                        partsOrdered.setText(String.valueOf(rs5.getInt(1)));
                    if (rs8.next())
                        laborProfit.setText("$ " +f.format(rs8.getDouble(1)));
                    if (rs6.next())
                        partProfit.setText("$ " +f.format(rs6.getDouble(1)));
                    if (rs2.next())
                        totalProfit.setText("$ " +f.format(rs2.getDouble(1)));

                } else
                {
                    Alert finished = new Alert(Alert.AlertType.ERROR);
                    finished.setTitle("No Jobs Found");
                    finished.setContentText("No Jobs were found for this month and year");
                    finished.show();
                }
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        else
        {
            Alert finished = new Alert(Alert.AlertType.ERROR);
            finished.setTitle("Enter Values");
            finished.setContentText("You must enter the values for MONTH and YEAR");
            finished.show();
        }
    }

    public void loadYearlyReport()
    {
        if ( yearDropbox.getValue()!=null)
        {
            DecimalFormat f = new DecimalFormat("#.00");




            try
            {
                String query = ("SELECT * \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");


                String profitQuery = ("SELECT round(sum(total_amount_owed) - sum(Total_parts_Cost),2)-(sum(Pickup_Delivery_Cost)/2) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String partCostQuery = ("SELECT sum(Total_parts_Cost) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String partsOrderedQuery = ("SELECT sum(Parts_Ordered) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String pickupCostQuery = ("SELECT sum(Pickup_Delivery_Cost)/2 \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String partprofitQuery = ("SELECT sum(Parts_Markup_Amount) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String pickupProfitQuery = ("SELECT sum(Pickup_Delivery_Cost)/2 \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");

                String laborProfitQuery = ("SELECT sum(Labor_Cost) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND YEAR(Start_Date) = " + yearDropbox.getValue() + ";");


                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement ps1 = connection.prepareStatement(query);
                PreparedStatement ps2 = connection.prepareStatement(profitQuery);
                PreparedStatement ps3 = connection.prepareStatement(partCostQuery);
                PreparedStatement ps4 = connection.prepareStatement(pickupCostQuery);
                PreparedStatement ps5 = connection.prepareStatement(partsOrderedQuery);
                PreparedStatement ps6 = connection.prepareStatement(partprofitQuery);
                PreparedStatement ps7 = connection.prepareStatement(pickupProfitQuery);
                PreparedStatement ps8 = connection.prepareStatement(laborProfitQuery);


                ResultSet rs1 = ps1.executeQuery();
                rs1 = connection.createStatement().executeQuery(query);

                ResultSet rs2 = ps2.executeQuery();
                rs2 = connection.createStatement().executeQuery(profitQuery);

                ResultSet rs3 = ps3.executeQuery();
                rs3 = connection.createStatement().executeQuery(partCostQuery);

                ResultSet rs4 = ps4.executeQuery();
                rs4 = connection.createStatement().executeQuery(pickupCostQuery);

                ResultSet rs5 = ps5.executeQuery();
                rs5 = connection.createStatement().executeQuery(partsOrderedQuery);

                ResultSet rs6 = ps6.executeQuery();
                rs6 = connection.createStatement().executeQuery(partprofitQuery);

                ResultSet rs7 = ps7.executeQuery();
                rs7 = connection.createStatement().executeQuery(pickupProfitQuery);

                ResultSet rs8 = ps8.executeQuery();
                rs8 = connection.createStatement().executeQuery(laborProfitQuery);


                if (rs1.next())
                {
                    if (rs3.next())
                        totalPartsCost.setText("$ " +f.format(rs3.getDouble(1)));
                    if (rs4.next())
                        pickupDelCost.setText("$ " +f.format(rs4.getDouble(1)));
                    if (rs7.next())
                        pickupProfit.setText("$ " +f.format(rs7.getDouble(1)));
                    if (rs5.next())
                        partsOrdered.setText(String.valueOf(rs5.getInt(1)));
                    if (rs8.next())
                        laborProfit.setText("$ " +f.format(rs8.getDouble(1)));
                    if (rs6.next())
                        partProfit.setText("$ " +f.format(rs6.getDouble(1)));
                    if (rs2.next())
                        totalProfit.setText("$ " +f.format(rs2.getDouble(1)));

                } else
                {
                    Alert finished = new Alert(Alert.AlertType.ERROR);
                    finished.setTitle("No Jobs Found");
                    finished.setContentText("No Jobs were found for this  year");
                    finished.show();
                }
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        else
        {
            Alert finished = new Alert(Alert.AlertType.ERROR);
            finished.setTitle("Enter Values");
            finished.setContentText("You must enter the values for YEAR");
            finished.show();
        }
    }

    public void loadJobReport()
    {
        if ( jobID.getText().length()>0)
        {
            DecimalFormat f = new DecimalFormat("#.00");




            try
            {
                String query = ("SELECT * \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND jobID = " + jobID.getText() + ";");


                String profitQuery = ("SELECT round(sum(total_amount_owed) - sum(Total_parts_Cost),2)-(sum(Pickup_Delivery_Cost)/2) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND jobID = " + jobID.getText() + ";");

                String partCostQuery = ("SELECT sum(Total_parts_Cost) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND  jobID = " + jobID.getText() + ";");

                String partsOrderedQuery = ("SELECT sum(Parts_Ordered) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND jobID = " + jobID.getText() + ";");

                String pickupCostQuery = ("SELECT sum(Pickup_Delivery_Cost)/2 \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND jobID = " + jobID.getText() + ";");

                String partprofitQuery = ("SELECT sum(Parts_Markup_Amount) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND jobID = " + jobID.getText() + ";");

                String pickupProfitQuery = ("SELECT sum(Pickup_Delivery_Cost)/2 \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND jobID = " + jobID.getText()  + ";");

                String laborProfitQuery = ("SELECT sum(Labor_Cost) \n" +
                        "FROM finishedjobs\n" +
                        "WHERE payment_Status = TRUE AND  jobID = " + jobID.getText() + ";");


                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement ps1 = connection.prepareStatement(query);
                PreparedStatement ps2 = connection.prepareStatement(profitQuery);
                PreparedStatement ps3 = connection.prepareStatement(partCostQuery);
                PreparedStatement ps4 = connection.prepareStatement(pickupCostQuery);
                PreparedStatement ps5 = connection.prepareStatement(partsOrderedQuery);
                PreparedStatement ps6 = connection.prepareStatement(partprofitQuery);
                PreparedStatement ps7 = connection.prepareStatement(pickupProfitQuery);
                PreparedStatement ps8 = connection.prepareStatement(laborProfitQuery);


                ResultSet rs1 = ps1.executeQuery();
                rs1 = connection.createStatement().executeQuery(query);

                ResultSet rs2 = ps2.executeQuery();
                rs2 = connection.createStatement().executeQuery(profitQuery);

                ResultSet rs3 = ps3.executeQuery();
                rs3 = connection.createStatement().executeQuery(partCostQuery);

                ResultSet rs4 = ps4.executeQuery();
                rs4 = connection.createStatement().executeQuery(pickupCostQuery);

                ResultSet rs5 = ps5.executeQuery();
                rs5 = connection.createStatement().executeQuery(partsOrderedQuery);

                ResultSet rs6 = ps6.executeQuery();
                rs6 = connection.createStatement().executeQuery(partprofitQuery);

                ResultSet rs7 = ps7.executeQuery();
                rs7 = connection.createStatement().executeQuery(pickupProfitQuery);

                ResultSet rs8 = ps8.executeQuery();
                rs8 = connection.createStatement().executeQuery(laborProfitQuery);


                if (rs1.next())
                {
                    if (rs3.next())
                        totalPartsCost.setText("$ " +f.format(rs3.getDouble(1)));
                    if (rs4.next())
                        pickupDelCost.setText("$ " +f.format(rs4.getDouble(1)));
                    if (rs7.next())
                        pickupProfit.setText("$ " +f.format(rs7.getDouble(1)));
                    if (rs5.next())
                        partsOrdered.setText(String.valueOf(rs5.getInt(1)));
                    if (rs8.next())
                        laborProfit.setText("$ " +f.format(rs8.getDouble(1)));
                    if (rs6.next())
                        partProfit.setText("$ " +f.format(rs6.getDouble(1)));
                    if (rs2.next())
                        totalProfit.setText("$ " +f.format(rs2.getDouble(1)));

                } else
                {
                    Alert finished = new Alert(Alert.AlertType.ERROR);
                    finished.setTitle("No Jobs Found");
                    finished.setContentText("No finished and paid Jobs were found with this Job ID");
                    finished.show();
                }
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        else
        {
            Alert finished = new Alert(Alert.AlertType.ERROR);
            finished.setTitle("Enter Job ID");
            finished.setContentText("You must enter the Job ID");
            finished.show();
        }
    }
}
