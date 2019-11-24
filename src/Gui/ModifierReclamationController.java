/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dialog.AlertDialog;
import Service.ReclamationService;
import Service.UserService;
import entite.Reclamation;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ModifierReclamationController implements Initializable {

    @FXML
    private TextField txtsujet;
    @FXML
    private Button txtbutton;
    @FXML
    private TextField txtphone;
    @FXML
    private Button txtretour;
    @FXML
    private TextArea txttext;
     ReclamationService re = new ReclamationService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Reclamation> pers = (ArrayList<Reclamation>) re.readAllamine();
        ObservableList<Reclamation> obs = FXCollections.observableArrayList(pers);
        //     table.setItems(obs);

        
        obs.clear();
    }    

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         Reclamation r = new Reclamation(txtsujet.getText(), txttext.getText(), txtphone.getText());
          //  UserService ps = new UserService();

            re.updateamine(r,AfficherReclamationController.cc);
            AlertDialog.display("Brovo", "modification reussite !");

             Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }
    
}
