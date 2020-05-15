/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.ipp.isep.dei.esoft.pot.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.FileInput.*;
import pt.ipp.isep.dei.esoft.pot.Seriacao.Seriacao;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;
import pt.ipp.isep.dei.esoft.pot.model.ProcessoSeriacao;
import pt.ipp.isep.dei.esoft.pot.ui.console.MenuUI;

import java.io.File;

/**
 * The type Main.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main extends Application {

    public void start(Stage stage) throws Exception {

        File f = new File("login.fxml");
        if(f.exists()) {
            System.out.println("File exists");
            System.out.println(f.getAbsoluteFile());
        }

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));



        Scene scene = new Scene(root);

        stage.setTitle("T4J");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);


        try
        {


           InputAreaAtividade a = new InputAreaAtividade();
           a.run();

            InputCompetenciaTecnica b = new InputCompetenciaTecnica();
            b.run();

            //InputDefinirCategoria c = new InputDefinirCategoria();
            //c.run();

            InputOrganizacao e = new InputOrganizacao();
            e.run();


            InputEspecificarTarefa d = new InputEspecificarTarefa();
            d.run();



            InputPublicarTarefa f = new InputPublicarTarefa();
            f.run();

            InputRegistarFreelancer g = new InputRegistarFreelancer();
             g.run();
             InputEfetuarCandidatura i = new InputEfetuarCandidatura();
             i.run();

           // InputRegistarOrganizacao h = new InputRegistarOrganizacao();
            //h.run();


            MenuUI uiMenu = new MenuUI();

            uiMenu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
