package pt.ipp.isep.dei.esoft.pot.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.FileInput.*;
import pt.ipp.isep.dei.esoft.pot.controller.AutenticacaoController;
import pt.ipp.isep.dei.esoft.pot.ui.JavaFX.Exceptions.LoginIncorreto;
import pt.ipp.isep.dei.esoft.pot.ui.console.MenuUI;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private AutenticacaoController m_controller;
    Stage janela = new Stage();

    public LoginController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.m_controller = new AutenticacaoController();
    }

    @FXML
    private TextField txtUsername;

    @FXML
    private Button btnSLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }
    int maxTentativas=3;
    public void login(ActionEvent actionEvent){
            String email = txtUsername.getText();
            String password = txtPassword.getText();
            boolean sucesso = false;

                maxTentativas--;
                sucesso = this.m_controller.doLogin(email, password);
                if (!sucesso){
                    //Alerta---- esta mal tem mais maxTentativas

                    erro(maxTentativas).show();
                    if(maxTentativas==0){
                        maxTentativas=3;
                    }

                }else{
                    janela.show();
                    System.out.println("hvgbshkjxhhhhl");
                }

                email = txtUsername.getText();
            password = txtPassword.getText();
            txtPassword.clear();
            txtUsername.clear();
            email = password = null;


        }

        public Alert erro(int i){
            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setTitle("Erro");
            alerta.setHeaderText("Dados inválidos, "+i+" tentativas restantes");

            return alerta;
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try
        {
            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/seriar.fxml"));

            Scene scene = new Scene(root1);
            janela.setResizable(false);
            janela.setTitle("T4J");
            janela.setScene(scene);

        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

    }
}
