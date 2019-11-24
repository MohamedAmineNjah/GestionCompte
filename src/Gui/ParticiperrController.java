/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entite.Formation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Formationservice;
import utile.DataSourcee;

/**
 * FXML Controller class
 *
 * @author YES_INFO
 */
public class ParticiperrController implements Initializable {

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
    private Button actualiser;
    @FXML
    private Button participer;
    @FXML
    private Button ac;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
        
        
        
        
        
    }    

    @FXML
    private void actualiser(ActionEvent event) {
        
        
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
    private void participer(ActionEvent event) {
        Connection cnx = DataSourcee.getInstance().getConnexion();
        Statement ste;
        PreparedStatement pst;
        //ResultSet rs;

        Formation p = (Formation) TXTTABF.getSelectionModel().getSelectedItem();
        
        int a = p.getId();

        String req = "UPDATE formation SET nbr_places= nbr_places -1 WHERE id=" + a;

        try {
            PreparedStatement e = cnx.prepareStatement(req);
            e.executeUpdate(req);
            // int likes=rs.getInt();
            Formationservice ps = new Formationservice();

            ArrayList<Formation> pub1 = (ArrayList<Formation>) ps.readAll();
            ObservableList<Formation> obsn = FXCollections.observableArrayList(pub1);
 
          colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        COLDESCR.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        COLDATE.setCellValueFactory(new PropertyValueFactory<>("date"));
        COLPRIX.setCellValueFactory(new PropertyValueFactory<>("prix"));
        COLNBRPL.setCellValueFactory(new PropertyValueFactory<>("nbr_places"));
        colimg.setCellValueFactory(new PropertyValueFactory<>("image"));
        

        } catch (SQLException ex) {
            Logger.getLogger(ParticiperrController.class.getName()).log(Level.SEVERE, null, ex);

        }
        
    }

    @FXML
    private void ac(ActionEvent event) {
        
        Parent root;
        try {
            root=FXMLLoader.load(getClass().getResource("../Gui/consulter.fxml"));
            ac.getScene().setRoot(root);
        } catch (IOException ex) {
            //Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
          
    }
    
}
