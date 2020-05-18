package pt.ipp.isep.dei.esoft.pot.ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;



public class SeriarController implements Initializable {
    private Plataforma plat;
    public ListView<Object> lista;
    private SeriarAnuncioController serCon;

    public SeriarController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.plat= AplicacaoPOT.getInstance().getPlataforma();

    }


    @FXML
    private Button btnVerCan;

    @FXML
    private Button btnSeriar;

    @FXML
    private Button btnVerAnuncios;

    @FXML
    private Label dados;

    @FXML
    private ListView<Object> lstView;

    private Anuncio AnuncioSelecionado;


    @FXML
    public void Seriar() {
        if (lstView.getSelectionModel().getSelectedItem() == null) {
            criarAlerta("Erro...", "Por favor, selecione o anúncio que pretende seriar!");
        } else {
            lstView.getItems().setAll( serCon.ordenarCandidaturaList(AnuncioSelecionado));
        }
        btnSeriar.setDisable(false);
        btnVerAnuncios.setDisable(false);
        btnVerCan.setDisable(false);

    }

    @FXML
    public void verAnunciosAction() {
        lstView.getItems().addAll(plat.getRegistoAnuncios().getlAnuncio());
        dados.setText("Anúncios:");
        btnVerAnuncios.setDisable(true);

    }

    @FXML
    public void verCandidaturasAction() {
        if (lstView.getSelectionModel().getSelectedItem() == null) {
            criarAlerta("Erro", "Por favor, selecione o anúncio");
        } else {
            AnuncioSelecionado = (Anuncio) lstView.getSelectionModel().getSelectedItem();
            lstView.getItems().setAll(AnuncioSelecionado.getList().getCandidaturaList());

        }
        dados.setText("Candidaturas:");
        btnSeriar.setDisable(false);
        btnVerAnuncios.setDisable(true);
        btnVerCan.setDisable(false);
    }

    @FXML
    private Alert criarAlerta(String cabecalho, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("T4J");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);

        return alerta;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}