/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dialog.AlertDialog;
import Service.UserService;
import entite.Admin;
import entite.Freelancer;
import entite.Startup;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterUserController implements Initializable {

    @FXML
    private TextField txtlogin;
    @FXML
    private TextField txtpassword;
    @FXML
    private TextField txtrole;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtadresse;
    @FXML
    private TextField txtimage;
    @FXML
    private Button txtbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtbutton.setOnAction(e -> {
//          if ("admin".equals(txtrole.getText()))
//          {  User p = new Admin(txtlogin.getText(), txtpassword.getText(), txtrole.getText());}
//          else if ("freelencer".equals(txtrole.getText()))
//              {  User p = new Freelancer(txtlogin.getText(), txtpassword.getText(), txtrole.getText());}
//          else if ("startup".equals(txtrole.getText()))
//                  {  User p = new Startup(txtlogin.getText(), txtpassword.getText(), txtrole.getText());}
//          else
//              {  User p = new User(txtlogin.getText(), txtpassword.getText(), txtrole.getText());
//                  System.out.println("vous aver crée un utilisateur quelconque");}
              
          
          User p = new User(txtlogin.getText(), txtpassword.getText(), txtrole.getText(), txtnom.getText(), txtprenom.getText(), txtemail.getText(), txtadresse.getText(), txtimage.getText());
            UserService ps = new UserService();
            ps.insert(p);
            AlertDialog.display("titre", "ajout reussi !");
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("AfficherUser.fxml"));
                txtbutton.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(AjouterUserController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

    }
}
