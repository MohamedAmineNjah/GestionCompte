/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Offre;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.OffreService;

/**
 * FXML Controller class
 *
 * @author MOHAMED RTIMI
 */
public class ListeoffresController implements Initializable {

    @FXML
    private TableView<Offre> table;
    @FXML
    private TableColumn<Offre, Integer> idcoll;
    @FXML
    private TableColumn<Offre, String> contrat;
    @FXML
    private TableColumn<Offre, String> lieucoll;
    @FXML
    private TableColumn<Offre, String> remunerationcoll;
    @FXML
    private TableColumn<Offre, String> competancecoll;
    @FXML
    private TableColumn<Offre, String> parrtime;
    @FXML
    private Button retbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         OffreService ps = new OffreService();
        ArrayList<Offre> pers = (ArrayList<Offre>) ps.readAll();
        System.out.println(ps.readAll());
        ObservableList<Offre> obs = FXCollections.observableArrayList(pers);
        table.setItems(obs);
        idcoll.setCellValueFactory(new PropertyValueFactory<>("id"));
        contrat.setCellValueFactory(new PropertyValueFactory<>("contrat"));
        lieucoll.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        remunerationcoll.setCellValueFactory(new PropertyValueFactory<>("remuneration"));
        
        competancecoll.setCellValueFactory(new PropertyValueFactory<>("competence"));
        parrtime.setCellValueFactory(new PropertyValueFactory<>("parttime"));
    }
        // TODO
       

    @FXML
    private void retbtn(ActionEvent event) throws IOException {
          Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/listeoffre.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }
    }


