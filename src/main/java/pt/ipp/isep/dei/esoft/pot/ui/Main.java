package pt.ipp.isep.dei.esoft.pot.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.FileInput.*;
import pt.ipp.isep.dei.esoft.pot.ui.console.MenuUI;


/**
 * The type Main.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main extends Application {

    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));

        Scene scene = new Scene(root);


        stage.setResizable(false);
        stage.setTitle("T4J");
        stage.setScene(scene);
        stage.getIcons().add(new Image("https://media-exp1.licdn.com/dms/image/C4E0BAQF4QqK3j0aJTg/company-logo_200_200/0?e=2159024400&v=beta&t=dmvO7NnU_rCKi09KLS4AbDHwJVHASswdNalMJ0tLGSM"));
        stage.show();
    }
    public static void main(String[] args){

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

/*
            MenuUI uiMenu = new MenuUI();

            uiMenu.run();*/

            launch(args);

        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
