package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Menu colaborador ui.
 */
public class MenuColaboradorUI {
    /**
     * Instantiates a new Menu colaborador ui.
     */
    public MenuColaboradorUI(){

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
        options.add("Especificar Tarefa");
        options.add("Publicar Tarefa");
        options.add("Seriar Anuncio");
        // Adicionar Aqui Outras Opções

        int opcao = 0;
        do
        {
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Colaborador");

            switch(opcao)
            {
                case 0:
                    EspecificarTarefaUI ui = new EspecificarTarefaUI();
                    ui.run();

                    break;
                case 1:
                    PublicarTarefaUI PTUI = new PublicarTarefaUI();
                    PTUI.run();

                    break;
                case 2:
                    SeriarAnuncioUI seui = new SeriarAnuncioUI();
                    seui.run();

            }

            // Incluir as restantes opções aqui

        }
        while (opcao != -1 );
    }
    }

