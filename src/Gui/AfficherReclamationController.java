/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dialog.AlertDialog;
import static Gui.AfficherUserController.b;
import Service.ReclamationService;
import entite.Reclamation;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AfficherReclamationController implements Initializable {

    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, Integer> colid;
    @FXML
    private TableColumn<Reclamation, Integer> collogin;
    @FXML
    private TableColumn<Reclamation, Integer> colpassword;
    @FXML
    private TableColumn<Reclamation, Integer> colrole;
    @FXML
    private Button txtbuttonmod;
    @FXML
    private Button txtbuttonsup;
   public static int cc = 0;
    ReclamationService re = new ReclamationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ArrayList<Reclamation> pers = (ArrayList<Reclamation>) re.readAllamine();
        ObservableList<Reclamation> obs = FXCollections.observableArrayList(pers);
        table.setItems(obs);

        colid.setCellValueFactory(new PropertyValueFactory<>("id11"));
        collogin.setCellValueFactory(new PropertyValueFactory<>("sujet11"));
        colpassword.setCellValueFactory(new PropertyValueFactory<>("text11"));
        colrole.setCellValueFactory(new PropertyValueFactory<>("phone11"));
        
        txtbuttonmod.setOnAction(e -> {
            Reclamation r = (Reclamation) table.getSelectionModel().getSelectedItem();
           cc = r.getId11();
            table.getItems().clear();
            obs.clear();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("ModifierReclamation.fxml"));
                txtbuttonmod.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(AfficherReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Accueil1.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void supprime(ActionEvent event) throws IOException {
         Reclamation r = (Reclamation) table.getSelectionModel().getSelectedItem();
            int a = r.getId11();
            table.getItems().remove(r);
            re.deleteamine(a);
            AlertDialog.display("titre", "suppression reussite !");
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }
    
}
