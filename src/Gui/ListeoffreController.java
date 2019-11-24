/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Offre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import service.OffreService;

/**
 * FXML Controller class
 *
 * @author MOHAMED RTIMI
 */
public class ListeoffreController implements Initializable {

    @FXML
    private ImageView imageview;
    @FXML
    private TableView<Offre> table;
    @FXML
    private TableColumn<Offre, Integer> idcoll;
    @FXML
    private TableColumn<Offre, String> contratcoll;
    @FXML
    private TableColumn<Offre, String> lieucoll;
    @FXML
    private TableColumn<Offre, String> remunerationcoll;
    @FXML
    private TableColumn<Offre, String> competence;
    @FXML
    private TableColumn<Offre, String> parttimecoll;
    @FXML
    private TextField searchtxt;
    @FXML
    private Button consbtn;
    @FXML
    private Button postbtn;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private Button retbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list_choix = FXCollections.observableArrayList("competence","lieu","contrat");
        combobox.setValue("competence");
        combobox.setItems(list_choix);
     
     OffreService ps = new OffreService();
        ArrayList<Offre> pers = (ArrayList<Offre>) ps.readAll();
        ObservableList<Offre> obs = FXCollections.observableArrayList(pers);
        table.setItems(obs);
        idcoll.setCellValueFactory(new PropertyValueFactory<>("id"));
        contratcoll.setCellValueFactory(new PropertyValueFactory<>("contrat"));
        lieucoll.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        remunerationcoll.setCellValueFactory(new PropertyValueFactory<>("remuneration"));
        
        competence.setCellValueFactory(new PropertyValueFactory<>("competence"));
        parttimecoll.setCellValueFactory(new PropertyValueFactory<>("parttime"));
    }    

    @FXML
    private void postbtn(ActionEvent event) throws IOException {
        
       Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/Formulaire.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    
    }

    @FXML
    private void searchtxt(KeyEvent event) throws SQLException {
        
        String fil=combobox.getValue().toString();
       /*String a=event.getCharacter();
         ab=ab.concat(a);*/
         String msg = searchtxt.getText().concat("%");

        OffreService p= new OffreService(); 
        ArrayList<Offre> pers=(ArrayList<Offre>) p.rechercherpartbycomp(fil, msg);
            ObservableList<Offre> obs=FXCollections.observableArrayList(pers);
            table.getItems().clear();
            table.setItems(obs);
            idcoll.setCellValueFactory(new PropertyValueFactory<>("id"));
        contratcoll.setCellValueFactory(new PropertyValueFactory<>("contrat"));
        lieucoll.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        remunerationcoll.setCellValueFactory(new PropertyValueFactory<>("remuneration"));
        
        competence.setCellValueFactory(new PropertyValueFactory<>("competence"));
        parttimecoll.setCellValueFactory(new PropertyValueFactory<>("parttime"));
            
    }

//    @FXML
//    private void retbtn(ActionEvent event) throws IOException {
//         Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/Afficher.fxml"));
//        Scene PageScene = new Scene(PageParent);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(PageScene);
//        window.show();
//    }

    @FXML
    private void consbtn(ActionEvent event) throws IOException {
           
         Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/listeoffres.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
       window.show();
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
    
    

