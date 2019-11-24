/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entite.Formation;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import service.Formationservice;

/**
 * FXML Controller class
 *
 * @author YES_INFO
 */
public class AjouterController_1 implements Initializable {

    private TextField txtlieuf;
    private TextField txtprixf;
    private TextField txtdatef;
    private TextField txtnbrf;
    @FXML
    private Button btnajoutf;
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private TextField lieu;
    @FXML
    private TextField prix;
    @FXML
    private TextField date;
    @FXML
    private TextField nbr_places;
    @FXML
    private TextField id;
    @FXML
    private ImageView img;
    @FXML
    private TextField img1;
    @FXML
    private ImageView UploadImage;
    @FXML
    private Button uploadImage;
    private String imageUpload;
    private String name;
    
    /**
     * Initializes the controller class.
     */
   /* @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnajoutf.setOnAction((ActionEvent e)->
            {Formation f =new Formation (nomftxt.getText(), descftxt.getText(),lieuftxt.getText(),prixftxt.getText(),nbrftxt.getText());
            
            Formationservice pst=new Formationservice();
            pst .insertPst(f);
           //AlertDialog.display("Bonjour", "Ajout complet");
            Parent root;
            root=FXMLLoader.load(getClass().getResourses("/Source Packages/dhia/modifier.fxml")); // Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
            btnajoutf.getScene().setRoot(root);
//Parent PageParent = FXMLLoader.load(getClass().getResource("/Smartstart06/Source Pachages/dhia/modifier.fxml"));
// Scene PageScene = new Scene(PageParent);
// Stage window = (Stage) ((Node) Formation.getsource()).getScene().getWindow();
//window.setScene(PageScene);
// window.show();
                    });
    
}
}*/

    
    
/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnajoutf.setOnAction(e->{
             if( nom.getText().isEmpty() || lieu.getText().isEmpty()
                 || description.getText().isEmpty() || nbr_places.getText().isEmpty() || date.getText().isEmpty() || prix.getText().isEmpty() )
         {
          
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider vos champs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez remplir les champs ");
            alert1.showAndWait();
         
         
       
         }else if(imageUpload==null){
              Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider vos champs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez choisir une image ");
            alert1.showAndWait();
         
         }else if(!lieu.getText().matches("^[a-zA-Z\\s]*$") )
         {
              Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider les noms des acteurs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez vérifier le nom du lieu ");
            alert1.showAndWait();
         }else if(!description.getText().matches("^[a-zA-Z\\s]*$") )
         {
              Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider le nom du directeur");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez verifier votre description ");
            alert1.showAndWait();
         
        }
       else  if(Integer.parseInt(nbr_places.getText())<0)
          {
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("veuillez saisir un nbre de place positif");
            alert.setContentText("Erreur");
            alert.showAndWait();
        } 
       
       else  if(Integer.parseInt(nbr_places.getText())<0)
          {
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("veuillez saisir un nbre de place positif");
            alert.setContentText("Erreur");
            alert.showAndWait();
        } 
       else if(((Integer.parseInt(nbr_places.getText()))>500)||((Integer.parseInt(nbr_places.getText()))<1))
          {
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("veuillez saisir un nbre de place entre 1 et 500");
            alert.setContentText("Erreur");
            alert.showAndWait();
        } 
                else{
             Formationservice pst=new Formationservice();
             Formation f =new Formation(nom.getText(), lieu.getText(), Integer.parseInt(prix.getText()), date.getText(), description.getText(), img1.getText(), Integer.parseInt(nbr_places.getText()));
            
           
            pst.insertPst(f);
                        Dialog.AlertDialog.display("Formation", "ajout reussite !");

            
            
            Parent root;
        try {
            root=FXMLLoader.load(getClass().getResource("modifier_1.fxml"));
            btnajoutf.getScene().setRoot(root);
        } catch (IOException ex) {
            //Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    }
        });
                }    

    @FXML
    private void uploadImage(ActionEvent event) throws IOException {
        
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)", "*.png");
        fc.getExtensionFilters().addAll(ext1, ext2);
        Stage stage = new Stage();
        File file = fc.showOpenDialog(stage);
        BufferedImage bf;
        if (file != null) {
            bf = ImageIO.read(file);
            img1.setText(file.getAbsolutePath());
            name = file.getName();
            javafx.scene.image.Image image = SwingFXUtils.toFXImage(bf, null);
            UploadImage.setImage(image);
            FileInputStream fin = new FileInputStream(file);
            imageUpload = file.getName();
    }
    
}

    @FXML
    private void aff(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("modifier_1.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}