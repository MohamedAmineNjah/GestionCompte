/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import entite.Mailer;
import entite.candidat;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.candidatService;

/**
 * FXML Controller class
 *
 * @author MOHAMED RTIMI
 */
public class FormulaireController implements Initializable {

    @FXML
    private Button envbtn;
    @FXML
    private TextField nomtxt;
    @FXML
    private TextField prenomtxt;
    @FXML
    private TextField mailtxt;
    @FXML
    private TextField teltxt;
    @FXML
    private TextField sexetxt;
    @FXML
    private TextField diplometxt;
    @FXML
    private DatePicker tfDate;
    @FXML
    private Button morebtn;
    @FXML
    private Button retbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envbtn(ActionEvent event) throws SQLException {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
        LocalDate locald = tfDate.getValue();
        Date date = Date.valueOf(locald);
        String datee = df.format(date);
        java.util.Date parsed = null;
            try {
                parsed = df.parse(datee);
            Date dateFinal = new java.sql.Date(parsed.getTime());
            } catch (ParseException ex) {    
                Logger.getLogger(FormulaireController.class.getName()).log(Level.SEVERE, null, ex);
            }
        java.util.Date dateFinal = null;
           candidatService ps=new candidatService();
       if((nomtxt.getText().isEmpty()) || (prenomtxt.getText().isEmpty()) || (mailtxt.getText().isEmpty()) || (teltxt.getText().isEmpty()) || (sexetxt.getText().isEmpty()) || (diplometxt.getText().isEmpty())){
        JOptionPane.showMessageDialog(null, "sorry!! you can't ");}
       
        
        if(!ps.isInt(teltxt.getText())){
            JOptionPane.showMessageDialog(null, "sorry!! verify your phone number");
        }
        else if ((ps.isInt(nomtxt.getText())) || (ps.isInt(prenomtxt.getText())) || (ps.isInt(mailtxt.getText())) || (ps.isInt(sexetxt.getText())) || (ps.isInt(diplometxt.getText()))){
            JOptionPane.showMessageDialog(null, "sorry!! verify nom prenom mail sexe or diplome");
        }
        else {
         JOptionPane.showMessageDialog(null, "a mail of confirmation will be sent in a few minutes.");
         // Mailer.send("mohamed.rtimi@esprit.tn", "183JMT1979", "raed.bahri@esprit.tn", "hello javatpoint", "How r u?");  
       candidat e=new candidat(nomtxt.getText(), prenomtxt.getText(), mailtxt.getText(), Integer.parseInt(teltxt.getText()),sexetxt.getText(),dateFinal,mailtxt.getText(),diplometxt.getText());

        ps.insertPst(e);

        }
    }

    @FXML
    private void morebtn(ActionEvent event) throws IOException {
        Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/avis.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void retbtn(ActionEvent event) throws IOException {
         Parent PageParent = FXMLLoader.load(getClass().getResource("/gui/listeoffre.fxml"));
        Scene PageScene = new Scene(PageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }
}
    
    

