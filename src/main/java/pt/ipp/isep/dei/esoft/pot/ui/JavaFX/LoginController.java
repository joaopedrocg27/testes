package pt.ipp.isep.dei.esoft.pot.ui.JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.controller.AutenticacaoController;
import pt.ipp.isep.dei.esoft.pot.ui.JavaFX.Exceptions.LoginIncorreto;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private AutenticacaoController m_controller;

    @FXML
    private TextField txtUsername;

    @FXML
    private Button btnSLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }
    int maxTentativas=0;
    public void login(ActionEvent actionEvent){
        try{
            String email = txtUsername.getText();
            String password = txtPassword.getText();
            maxTentativas = 3;
            boolean sucesso = false;
            while (!sucesso && maxTentativas > 0) {
                maxTentativas--;
                sucesso = m_controller.doLogin(email, password);
                if (!sucesso){
                    //Alerta---- esta mal tem mais maxTentativas

                    throw new LoginIncorreto(String.valueOf(maxTentativas));

                }else{
                    //launch app
                }
            }txtPassword.clear();
            txtUsername.clear();
            email = password = null;

        } catch (LoginIncorreto loginIncorreto) {
            erro(loginIncorreto);

        }
        }

        public Alert erro(LoginIncorreto loginIncorreto){
            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setTitle("Erro");
            alerta.setHeaderText("Dados inválidos, "+loginIncorreto.getMessage()+" tentativas restantes");
            return alerta;
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
