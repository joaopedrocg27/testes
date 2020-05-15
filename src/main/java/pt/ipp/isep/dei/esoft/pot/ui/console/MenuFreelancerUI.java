package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Menu freelancer ui.
 */
public class MenuFreelancerUI {
    /**
     * Instantiates a new Menu freelancer ui.
     */
    public MenuFreelancerUI(){

    }

    /**
     * Run.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public void run() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        List<String> options = new ArrayList<String>();
        options.add("Registar Candidatura ");


        int opcao = 0;
        do
        {
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Freelancer");

            switch(opcao)
            {
                case 0:
                    EfetuarCandidaturaUI uiCat = new EfetuarCandidaturaUI();
                    uiCat.run();
                    break;

            }

            // Incluir as restantes opções aqui

        }
        while (opcao != -1 );
    }

    }

