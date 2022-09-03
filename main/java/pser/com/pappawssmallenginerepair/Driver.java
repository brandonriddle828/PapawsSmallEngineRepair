package pser.com.pappawssmallenginerepair;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.Icon;
import java.io.File;
import java.sql.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Driver extends Application
{

    @Override
    public void start(Stage primaryStage) throws IOException
    {



        Parent root = FXMLLoader.load(getClass().getResource("LoginMenuStyle.fxml"));
        Scene scene = new Scene(root, Color.BLACK);
        primaryStage.setTitle("Papaws's Small Engine Repair");
        primaryStage.setResizable(false);
        File file = new File("icon.png");
        Image image = new Image(file.toURI().toString());
        primaryStage.getIcons().add(image);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}