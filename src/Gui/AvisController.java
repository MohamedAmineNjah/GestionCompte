/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MOHAMED RTIMI
 */
public class AvisController implements Initializable {

    @FXML
    private TextField avistxt;
    @FXML
    private Button pubbtn;
    @FXML
    private Button retbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pubbtn(ActionEvent event) {
        
           String f ;
             f=(avistxt.getText());
              String accessToken="EAAEefTYzIwkBANZBNeXs2PHoQJdAJvUZAJOZBsZB3f2v97qZAJomqL6wuT8qqDdkrmaXbM3ZAPQNs9FdWIopDrGJoDDP75O1ZAteXnO81n4B1DleZCeGHBz7cB4l3AojnLVuMFOmy1fnicIJMwOLK3i3kNDgXZAUYU2bvh0DFB6UeC4ZBkzHfV3iI8S67MW10vZAsor8mU4PusgQQZDZD";
        FacebookClient fbClient= new DefaultFacebookClient(accessToken);
    FacebookType response= fbClient.publish("me/feed",FacebookType.class,Parameter.with("message",f));

   System.out.println("fb.com/"+response.getId());
   JOptionPane.showMessageDialog(null, "Avis ajouté . Merci! ");
  
    }

    @FXML
    private void retbtn(ActionEvent event) throws IOException {
         Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/Acceuilfreelancer.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }
    
    
}
