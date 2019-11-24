/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entite.Formation;
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
import service.Formationservice;

/**
 * FXML Controller class
 *
 * @author YES_INFO
 */
public class ConsulterController implements Initializable {

   @FXML
    private TableColumn<Formation, Integer> colid;
    @FXML
    private TableColumn<Formation, String> colnom;
    @FXML
    private TableColumn<Formation, String> collieu;
    @FXML
    private TableColumn<Formation, String> COLDESCR;
    @FXML
    private TableColumn<Formation, String> COLDATE;
    @FXML
    private TableColumn<Formation, Integer> COLPRIX;
    @FXML
    private TableColumn<Formation, Integer> COLNBRPL;
    @FXML
    private TableColumn<Formation, String> colimg;
    @FXML
    private TableView<Formation> TXTTABF;
    @FXML
    private Button retour1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Formationservice ps = new Formationservice();
        ArrayList<Formation> pers = (ArrayList<Formation>) ps.readAll();
        ObservableList<Formation> obs = FXCollections.observableArrayList(pers);
        TXTTABF.setItems(obs);
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        COLDESCR.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        COLDATE.setCellValueFactory(new PropertyValueFactory<>("date"));
        COLPRIX.setCellValueFactory(new PropertyValueFactory<>("prix"));
        COLNBRPL.setCellValueFactory(new PropertyValueFactory<>("nbr_places"));
        colimg.setCellValueFactory(new PropertyValueFactory<>("image"));
    }    

    @FXML
    private void retour1(ActionEvent event) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("participerr.fxml"));
                Scene newScene=new Scene(root);
                Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
                window.setScene(newScene);
                window.show();
    }
       
        
    }
    

