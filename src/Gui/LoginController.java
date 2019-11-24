package Gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Dialog.AlertDialog;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utile.DataSourcee;
//import utils.ConnectionUtil;

/**
 *
 * @author oXCToo
 */
public class LoginController implements Initializable {

    @FXML
    private Label lblErrors;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignin;
    @FXML
    private Button btnSignup;

    /// -- 
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private Label btnForgot;
    @FXML
    private Button btnFB;

    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == btnSignin) {
            //login here
            if (logIn().equals("Success")) {
                try {

                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    // stage.setMaximized(true);
                    stage.close();

                    String login = txtUsername.getText();
                    String password = txtPassword.getText();
                    String sql = "SELECT role FROM user Where login = ? and password = ?";
                    try {
                        preparedStatement = con.prepareStatement(sql);
                        preparedStatement.setString(1, login);
                        preparedStatement.setString(2, password);
                        resultSet = preparedStatement.executeQuery();

                        System.out.println(resultSet);

                        if (resultSet.next()) {
                            String role = resultSet.getString(1);
                            if (role.equals("admin")) {
                                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Accueil1.fxml")));
                                stage.setScene(scene);
                                stage.show();
                            } else if (role.equals("freelancer")) {
                                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Accueil1_1.fxml")));
                                stage.setScene(scene);
                                stage.show();
                            } else if (role.equals("startup")) {
                                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Accueil1_2.fxml")));
                                stage.setScene(scene);
                                stage.show();
                            }
                        }
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());

                    }

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //  AlertDialog.display("titre", " reussite !");
        // TODO
        con = DataSourcee.getInstance().getConnexion();
        if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
       
    }

    private String logIn() {

        String status = "Success";
        String login = txtUsername.getText();
        String password = txtPassword.getText();
        if (login.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error";
        } else {
            //query
            String sql = "SELECT * FROM user Where login = ? and password = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                //    User e =resultSet.getInt(1);
                System.out.println(resultSet);

                if (!resultSet.next()) {//n'existe pas
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    System.out.println("wrong login or password");
                    status = "Error";
                } else {
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                    System.out.println("Successful authentification,let's go!");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }

        return status;
    }

    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }

    @FXML
    private void signup(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterUser_1.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }
}
