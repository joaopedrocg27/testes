package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;
import java.util.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * The type Seriar anuncio ui.
 */
public class SeriarAnuncioUI {
    private SeriarAnuncioController controller;

    /**
     * Instantiates a new Seriar anuncio ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public SeriarAnuncioUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.controller = new SeriarAnuncioController();
    }

    /**
     * Run.
     */
    public void run()
    {
        System.out.println("\nSerie  o Anuncio:");

        if(introduzDados())
        {
            //apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (/*controller.registaFreelancer()*/ true ) {
                    System.out.println("Registo efetuado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        }
        else
        {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }

    private boolean introduzDados() {
        List<Anuncio> anun = this.controller.getAnuncioListPorColaborador();
        Anuncio area = (Anuncio) Utils.apresentaESeleciona(anun, "Selecione o Anuncio:");
        List<Candidatura> cand = this.controller.getCandidaturalist(area);
        Candidatura candid = (Candidatura) Utils.apresentaESeleciona(cand,"Selecione a candidatura");
        this.controller.ordenarCandidaturaList(area);

       return true;
    }
}
