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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.OffreService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AfficherController implements Initializable {

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
    private TextField id;
    @FXML
    private TextField lieu;
    @FXML
    private TextField remuneration;
    @FXML
    private TextField comptence;
    @FXML
    private TextField ppartime;
    @FXML
    private Button affbtn;
    @FXML
    private Button modibtn;
    @FXML
    private Button suppbtn;
    @FXML
    private TextField cont;
    @FXML
    private ImageView imgview;
    @FXML
    private Button plusbtn;
    @FXML
    private Button retbtn;
    @FXML
    private Button gobtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        
        suppbtn.setOnAction((ActionEvent e) -> {

            Offre p = (Offre) table.getSelectionModel().getSelectedItem();
            int a = p.getId();

            table.getItems().remove(p);
            ps.delete(a);
         JOptionPane.showMessageDialog(null, "Offre deleted! ");
        });
        
        
        modibtn.setOnAction((ActionEvent e) -> {

            Offre a = new Offre(Integer.parseInt(id.getText()), cont.getText(), lieu.getText(), remuneration.getText(), comptence.getText(), ppartime.getText());

            ps.update(a, a.getId());

            obs.clear();
JOptionPane.showMessageDialog(null, "offre updated! ");
            ArrayList<Offre> acts = (ArrayList<Offre>) ps.readAll();
             System.out.println(ps.readAll());
            ObservableList<Offre> nobs = FXCollections.observableArrayList(acts);
            table.setItems(nobs);
           idcoll.setCellValueFactory(new PropertyValueFactory<>("id"));
        contrat.setCellValueFactory(new PropertyValueFactory<>("contrat"));
        lieucoll.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        remunerationcoll.setCellValueFactory(new PropertyValueFactory<>("remuneration"));
        
        competancecoll.setCellValueFactory(new PropertyValueFactory<>("competence"));
        parrtime.setCellValueFactory(new PropertyValueFactory<>("parttime"));

        });
       affbtn.setOnAction(((event) -> {
            Offre p = (Offre) table.getSelectionModel().getSelectedItem();

            id.setText(String.valueOf(p.getId()));
            cont.setText(String.valueOf(p.getContrat()));
            lieu.setText(String.valueOf(p.getLieu()));
           remuneration.setText(String.valueOf(p.getRenumeration()));

            comptence.setText(String.valueOf(p.getCompetence()));
              ppartime.setText(String.valueOf(p.getParttime()));
           

        }));
  
        
    }    

    @FXML
    private void plusbtn(ActionEvent event) throws IOException {
        
        Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/Listeoffre.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void retbtn(ActionEvent event) throws IOException {
           Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/Ajouter.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void gobtn(ActionEvent event) throws IOException {
         Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/candidatures.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }
    
}
