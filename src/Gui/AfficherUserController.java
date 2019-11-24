/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dialog.AlertDialog;
import Service.UserService;
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
public class AfficherUserController implements Initializable {

    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, Integer> colid;
    @FXML
    private TableColumn<User, String> collogin;
    @FXML
    private TableColumn<User, String> colpassword;
    @FXML
    private TableColumn<User, String> colrole;
    @FXML
    private TableColumn<User, String> colnom;
    @FXML
    private TableColumn<User, String> colprenom;
    @FXML
    private TableColumn<User, String> colemail;
    @FXML
    private TableColumn<User, String> coladresse;
    @FXML
    private TableColumn<User, String> colimage;
    @FXML
    private Button txtbuttonsup;
    @FXML
    private Button txtbuttonmod;
// @FXML
//    private Button txtretour;

    public static int b = 0;
UserService ps = new UserService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // UserService ps = new UserService();
        ArrayList<User> pers = (ArrayList<User>) ps.readAll();
        ObservableList<User> obs = FXCollections.observableArrayList(pers);
        table.setItems(obs);

        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        collogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colrole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colimage.setCellValueFactory(new PropertyValueFactory<>("image"));

       

        txtbuttonmod.setOnAction(e -> {
            User p = (User) table.getSelectionModel().getSelectedItem();
            b = p.getId();
            table.getItems().clear();
            obs.clear();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
                txtbuttonmod.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(AjouterUserController.class.getName()).log(Level.SEVERE, null, ex);
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
        User p = (User) table.getSelectionModel().getSelectedItem();
            int a = p.getId();
            table.getItems().remove(p);
            ps.delete(a);
            AlertDialog.display("titre", "suppression reussite !");
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherUser.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterUser.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }
}
