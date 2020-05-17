package pt.ipp.isep.dei.esoft.pot.ui.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAnuncio;

public class SeriarController {
    private Plataforma plat;
    private RegistoAnuncio rAnu;
    public ListView<Anuncio> lista;
    private SeriarAnuncioController serCon;


    @FXML
    private Button btnVerCan;

    @FXML
    private Button btnSeriar;

    @FXML
    private Button btnVerAnuncios;

    @FXML
    private Label dados;

    @FXML
    private ListView<Anuncio> lstView;


    public void Seriar(){
        if (lista.getSelectionModel().getSelectedItem() == null) {
            criarAlerta("Erro...", "Por favor, selecione o anúncio que pretende seriar!");
        } else {
            Anuncio AnuncioSelecionado = lista.getSelectionModel().getSelectedItem();
            lista.getItems().setAll((Anuncio) serCon.ordenarCandidaturaList(AnuncioSelecionado));
        }
        btnSeriar.setDisable(true);
        btnVerAnuncios.setDisable(false);
        btnVerCan.setDisable(true);

    }

    public void verAnunciosAction() {
        lista.getItems().setAll(rAnu.getlAnuncio());
        dados.setText("Anúncios:");
        btnVerAnuncios.setDisable(true);
    }

    public void verCandidaturasAction() {
        if (lista.getSelectionModel().getSelectedItem() == null) {
            criarAlerta("Erro", "Por favor, selecione o anúncio");
        } else {
            Anuncio AnuncioSelecionado = lista.getSelectionModel().getSelectedItem();
            lista.getItems().setAll((Anuncio) serCon.getCandidaturalist(AnuncioSelecionado));
        }
        dados.setText("Candidaturas:");
        btnSeriar.setDisable(true);
        btnVerAnuncios.setDisable(false);
        btnVerCan.setDisable(true);
    }

    private Alert criarAlerta(String cabecalho, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("T4J");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);

        return alerta;
    }










}
