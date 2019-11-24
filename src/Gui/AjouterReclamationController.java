/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dialog.AlertDialog;
import Service.ReclamationService;
import Service.UserService;
import com.teknikindustries.bulksms.SMS;
import entite.Reclamation;
import entite.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterReclamationController implements Initializable {

    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtsujet;
    @FXML
    private TextField txtphone;
    @FXML
    private Button txtbutton;
    @FXML
    private TextArea txttext;
    @FXML
    private Button txtretour;
    ObservableList<String> list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        if (txtsujet.getText().isEmpty() || txttext.getText().isEmpty() || txtphone.getText().isEmpty()) {
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText("Enter all details");
        } else {
            Reclamation r = new Reclamation(txtsujet.getText(), txttext.getText(), txtphone.getText());
            ReclamationService re = new ReclamationService();
            re.insertamine(r);
            AlertDialog.display("titre", "ajout reussi !");

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();

        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public String sendSms(String number, String msg) {

        try {
            // Construct data
            String apiKey = "ZofHYSNUam0-vphHNfXmwMndf8Ec8UwgGijJ3mEPzo";
            String Secret = "V6wOkUxbImKctMUw";
            String message = "&message=" + msg;
            String sender = "&sender=" + "amitcho";
            String numbers = "&numbers="+number;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
                JOptionPane.showMessageDialog(null, "message" + line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            JOptionPane.showMessageDialog(null, e);

            return "Error " + e;
        }

    }

    @FXML
    private void sms(ActionEvent event) {

//        String ch = sendSms(txtphone.getText(), "alo");
//        System.out.println(ch);
SMS smsTut = new SMS();
smsTut.SendSMS("aminenjah", "amine1612abcA",txttext.getText(),txtphone.getText(), "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
                                         //  "+21652476914"                                  
    }

}
