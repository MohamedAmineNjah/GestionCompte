/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Offre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.OffreService;

/**
 * FXML Controller class
 *
 * @author MOHAMED RTIMI
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField txtcontrat;
    @FXML
    private TextField txtlieu;
    @FXML
    private TextField txtparttime;
    @FXML
    private Button btnajouter;
    @FXML
    private TextField txtremuneration;
    @FXML
    private TextField txtcompetence;
   // @FXML
   // private TextField txtid;
    @FXML
    private AnchorPane imageview;
    @FXML
    private Button morebtn;
    @FXML
    private Button retbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         btnajouter.setOnAction(e->
            {Offre p=new Offre(txtcontrat.getText(), txtlieu.getText(), txtremuneration.getText(), txtcompetence.getText(), txtparttime.getText());
            OffreService ps=new OffreService();
            ps.insert(p); 
            JOptionPane.showMessageDialog(null, "Offre ajoutée");
            });
      
    }    
    

    @FXML
    private void morebtn(ActionEvent event) throws IOException {
        
          Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/Afficher.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void retbtn(ActionEvent event) throws IOException {
           Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/Aceuiladmin.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
        
    }
   

}
