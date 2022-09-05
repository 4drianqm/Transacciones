/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Adrian
 */
public class DashboardController implements Initializable {

    
    Conection conexion  = new Conection();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void onclicked_hola(ActionEvent event) throws IOException {
            
            Parent root = FXMLLoader.load(getClass().getResource("SerializableWindow.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("This is a new window");
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.NONE);
            primaryStage.show();
            
           conexion.ejecutarSenctenciaSQL("set session transaction isolation level serializable");
    }
    
     @FXML
     private void onclicked_commited(ActionEvent event) throws IOException{
         
         
         
          Parent root = FXMLLoader.load(getClass().getResource("SerializableWindow.fxml"));
          Scene scene = new Scene(root);
          Stage stage = new Stage();
          stage.setTitle("");
          stage.setScene(scene);
          stage.show();
          
          conexion.ejecutarSenctenciaSQL("set session transaction isolation level read committed");
    }
    @FXML
    private void onclicked_uncommited(ActionEvent event) throws IOException {
         System.out.println("this is uncommited");
         Parent root = FXMLLoader.load(getClass().getResource("SerializableWindow.fxml"));
          Scene scene = new Scene(root);
          Stage stage = new Stage();
          stage.setTitle("committed window!");
          stage.setScene(scene);
          stage.show();
          
  
          conexion.ejecutarSenctenciaSQL("set session transaction isolation level read uncommitted");
          
    }
    
    @FXML
    private void onclicked_Repetible(ActionEvent event) throws IOException {
        System.out.println("This is repetible");
        Parent root = FXMLLoader.load(getClass().getResource("SerializableWindow.fxml"));
          Scene scene = new Scene(root);
          Stage stage = new Stage();
          stage.setTitle("committed window!");
          stage.setScene(scene);
          stage.show();
          
          conexion.ejecutarSenctenciaSQL("set session transaction isolation level repeatable read");
    }

 
}
