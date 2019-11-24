/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entite.Formation;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import static jdk.nashorn.internal.runtime.Debug.id;
import service.Formationservice;

/**
 * FXML Controller class
 *
 * @author YES_INFO
 */
public class ModifierController_1 implements Initializable {

    @FXML
    private ImageView img1;
    @FXML
    private TableView<Formation> TXTTABF;
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
    private Button BTNAFFICHER;
    @FXML
    private Button BTNMODIF;
    @FXML
    private Button BTNSUPPRIMER;
    @FXML
   
    private TextField nom;
    @FXML
    private TextField lieu;
    @FXML
    private TextField description;
    @FXML
    private TextField date;
    @FXML
    private TextField prix;
    @FXML
    private TextField nbr_places;
    @FXML
    private TextField id;
    @FXML
    private TableColumn<Formation, String> colimg;
    @FXML
    private Label labelid;

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
        BTNSUPPRIMER.setOnAction((ActionEvent e) -> {

            Formation p = (Formation) TXTTABF.getSelectionModel().getSelectedItem();
            int a = p.getId();

            TXTTABF.getItems().remove(p);
            ps.delete(p, a);

        });
         BTNMODIF.setOnAction((ActionEvent e) -> {
                Formation p = (Formation) TXTTABF.getSelectionModel().getSelectedItem();
            int a = p.getId();


           // Formation a = new Formation( nom.getText(), lieu.getText(),date.getText(),setPrix(Integer.parseInt(prix.getText())), description.getText(),setNbr_places(Integer.parseInteger(nbr_places.getText()))/*,Integer.parseInt(nbr_places.getText())**/);

       
        p.setNom(nom.getText());
        //a.setAuthor(auth.getText());
        p.setPrix(Integer.parseInt(prix.getText()));
         p.setDate(date.getText());
          p.setLieu(lieu.getText());
           p.setNbr_places(Integer.parseInt(nbr_places.getText()));
           p.setDescription(description.getText());
       
   
            ps.update(p, a);

            obs.clear();
    
                ArrayList<Formation> acts = (ArrayList<Formation>) ps.readAll();

            ObservableList<Formation> nobs = FXCollections.observableArrayList(acts);
        TXTTABF.setItems(nobs);
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
         COLDESCR.setCellValueFactory(new PropertyValueFactory<>("description"));
                 
        
        COLDATE.setCellValueFactory(new PropertyValueFactory<>("date"));
       COLPRIX.setCellValueFactory(new PropertyValueFactory<>("prix"));
        COLNBRPL.setCellValueFactory(new PropertyValueFactory<>("nbr_places"));


    
});
         BTNAFFICHER.setOnAction(((event) -> {
            Formation p = (Formation) TXTTABF.getSelectionModel().getSelectedItem();

            id.setText(String.valueOf(p.getId()));
            nom.setText(String.valueOf(p.getNom()));
            lieu.setText(String.valueOf(p.getLieu()));

            description.setText(String.valueOf(p.getDescription()));
              date.setText(String.valueOf(p.getDate()));
             prix.setText(String.valueOf(p.getPrix()));
            nbr_places.setText(String.valueOf(p.getNbr_places()));
           

        }));
    }}