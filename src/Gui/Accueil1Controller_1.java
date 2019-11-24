/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dialog.AlertDialog;
import entite.User;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Accueil1Controller_1 implements Initializable {
@FXML
    private Label txtfermer;

    @FXML
    private Button txtretour;
    
    @FXML
    private Label lblExpired;
    @FXML
    private Label lbl7;
    @FXML
    private Label lbl30;
    @FXML
    private Label lbl90;
    
    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    void fermer(MouseEvent event) {
Stage stage = (Stage) txtfermer.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtretour.setOnAction(e -> {
             Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                txtretour.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(AjouterUserController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
       
        }

    @FXML
    private void utilisateurs(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherUser.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void reclamation(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void offrefreelancer(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("Acceuilfreelancer.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void formation(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("participerr.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }
    
    }    
    

