/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhia;

import entite.Formation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author YES_INFO
 */
public class AccepterformationController implements Initializable {

    /**
     * Initializes the controller class.
     *  @FXML*/
    private TableView<Formation> TXTTABF;
    @FXML
    private TableColumn<Formation, Integer> colid;
    @FXML
    private TableColumn<Formation, String> colnom;
    @FXML
    private TableColumn<Formation, String> collieu;
    @FXML
    private TableColumn<Formation, String>  COLDESC;
    @FXML
    private TableColumn<Formation, String> COLPRIX;
     @FXML
    private TableColumn<Formation, String> COLDATE;
      @FXML
    private TableColumn<Formation, String> COLNBRPL;
      @FXML
    private Button BTNSUPPRIMER ;
     @FXML
    private Button BTNACCEPTER ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
