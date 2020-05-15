/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 * The type Menu administrativo ui.
 *
 * @author paulomaio
 */
public class MenuAdministrativoUI
{

    /**
     * Instantiates a new Menu administrativo ui.
     */
    public MenuAdministrativoUI()
    {
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
        options.add("Especificar Área de Atividade ");
        options.add("Especificar Competência Técnica");
        options.add("Especificar Categoria de Tarefa");
        options.add("Registar Freelancer");
        
        int opcao = 0;
        do
        {            
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Administrativo");

            switch(opcao)
            {
                case 0:
                    EspecificarAreaAtividadeUI uiCat = new EspecificarAreaAtividadeUI();
                    uiCat.run();
                    break;
                case 1:
                    EspecificarCompetenciaTecnicaUI uiServ = new EspecificarCompetenciaTecnicaUI();
                    uiServ.run();
                    break;
                
                case 2:
                    DefinirCategoriaUI uiCate = new DefinirCategoriaUI();
                    uiCate.run();
                    break;
                case 3:
                    RegistarFreelancerUI uiFree = new RegistarFreelancerUI();
                    uiFree.run();
                    break;
            }

            // Incluir as restantes opções aqui
            
        }
        while (opcao != -1 );
    }
}
