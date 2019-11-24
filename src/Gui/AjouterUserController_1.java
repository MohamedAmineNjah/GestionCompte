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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterUserController_1 implements Initializable {

    @FXML
    private TextField txtlogin;
    @FXML
    private TextField txtpassword;
//    @FXML
//    private TextField txtrole;
//ComboBox<String> 
    @FXML
    private ComboBox<String> combobox;
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
    @FXML
    private Label lblStatus;
    @FXML
    private Button txtretour;
    ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    private ImageView imageview;
    @FXML
    private Button importerreserv;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list.setAll("admin", "freelancer", "startup");
        combobox.setItems(list);
        combobox.setValue("admin");

        importerreserv.setOnAction((event) -> {
            FileChooser f = new FileChooser();
            f.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Image", "*.*")
            );

            File fi = f.showOpenDialog(null);

            if (fi != null) {
                txtimage.setText(fi.getName());
                Image image = new Image(fi.getAbsoluteFile().toURI().toString());
                imageview.setImage(image);
            }
        });

    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        if (txtlogin.getText().isEmpty() || txtpassword.getText().isEmpty() || txtnom.getText().isEmpty() || txtprenom.getText().isEmpty() || txtemail.getText().isEmpty() || txtadresse.getText().isEmpty() || txtimage.getText().isEmpty()) {
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText("Enter all details");
        } else {
//          if ("admin".equals(txtrole.getText()))
//          {  User p = new Admin(txtlogin.getText(), txtpassword.getText(), txtrole.getText());}
//          else if ("freelencer".equals(txtrole.getText()))
//              {  User p = new Freelancer(txtlogin.getText(), txtpassword.getText(), txtrole.getText());}
//          else if ("startup".equals(txtrole.getText()))
//                  {  User p = new Startup(txtlogin.getText(), txtpassword.getText(), txtrole.getText());}
//          else
//              {  User p = new User(txtlogin.getText(), txtpassword.getText(), txtrole.getText());
//                  System.out.println("vous aver crée un utilisateur quelconque");}

            String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+" + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
            Pattern pattern = Pattern.compile(masque);
            Matcher controler = pattern.matcher(txtemail.getText());
            if (controler.matches()) {
                String login = txtlogin.getText();
                String password = txtpassword.getText();
                User p = new User(txtlogin.getText(), txtpassword.getText(), combobox.getValue(), txtnom.getText(), txtprenom.getText(), txtemail.getText(), txtadresse.getText(), txtimage.getText());
                UserService ps = new UserService();
                ps.insert(p);
                AlertDialog.display("titre", "ajout reussi !");

//                    Node node = (Node) event.getSource();
//                    Stage stage = (Stage) node.getScene().getWindow();
//                   
//                    stage.close();
//                    
//                    
//                    
//                    String sqle = "SELECT role FROM user Where login = ? and password = ?";
//                    try {
//                        preparedStatement = con.prepareStatement(sqle);
//                        preparedStatement.setString(1, login);
//                        preparedStatement.setString(2, password);
//                        resultSet = preparedStatement.executeQuery();
//
//                        System.out.println(resultSet);
//
//                        if (resultSet.next()) {
//                            String role = resultSet.getString(1);
//                            if (role.equals("admin")) {
//                                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Accueil1.fxml")));
//                                stage.setScene(scene);
//                                stage.show();
//                            } else if (role.equals("freelancer")) {
//                                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("modifier.fxml")));
//                                stage.setScene(scene);
//                                stage.show();
//                            } else if (role.equals("startup")) {
//                                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AfficherUser.fxml")));
//                                stage.setScene(scene);
//                                stage.show();
//                            }
                //           }
//                    } catch (SQLException ex) {
//                        System.err.println(ex.getMessage());
//
//                    }
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                 stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Accueil1.fxml")));
                stage.setScene(scene);
                stage.show();

            } else {
                //La c'est pas bon
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Email format is not valid !");
                alert.show();

            }
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}
