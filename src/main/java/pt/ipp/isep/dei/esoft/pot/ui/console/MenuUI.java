

package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 * The type Menu ui.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MenuUI
{

    /**
     * Instantiates a new Menu ui.
     */
    public MenuUI()
    {
    }

    /**
     * Run.
     *
     * @throws IOException               the io exception
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     */
    public void run() throws IOException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<String> options = new ArrayList<String>();
        options.add("Login / Autenticação");
        options.add("Registar Organização");
        int opcao = 0;
        do
        {            
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Principal");

            switch(opcao)
            {
                case 0:
                    AutenticacaoUI uiLogin = new AutenticacaoUI();
                    boolean sucesso = uiLogin.run();
                    if (sucesso)
                    {
                        redirecionaParaUI(uiLogin.getPapeisUtilizador());
                    }
                    uiLogin.logout();
                    break;
                case 1:
                    RegistarOrganizacaoUI ui = new RegistarOrganizacaoUI();
                    ui.run();
                    break;
                case 2:
                    PublicarTarefaUI PTUI = new PublicarTarefaUI();
                    PTUI.run();
                    break;
            }
        }
        while (opcao != -1 );
    }

    private void redirecionaParaUI(List<PapelUtilizador> papeis) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
       if (papeis == null)
       {
           System.out.println("O utilizador não tem atribuído nenhum papel/função.");
           return;
       }
       if (papeis.isEmpty())
       {
           System.out.println("O utilizador não tem atribuído nenhum papel/função.");
           return;
       }          
       PapelUtilizador papel = selecionaPapel(papeis);
       
       if (papel.hasId("ADMINISTRATIVO"))
       {
           MenuAdministrativoUI ui = new MenuAdministrativoUI();
           ui.run();
       }
       if (papel.hasId("GESTOR_ORGANIZACAO"))
       {
           MenuGestorOrganizacaoUI ui = new MenuGestorOrganizacaoUI();
           ui.run();
       }
       if (papel.hasId("FREELANCER")){
           MenuFreelancerUI ui = new MenuFreelancerUI();
            ui.run();
       }
       if (papel.hasId("COLABORADOR_ORGANIZACAO")){
           MenuColaboradorUI ui = new MenuColaboradorUI();
           ui.run();
       }
    }

    private PapelUtilizador selecionaPapel(List<PapelUtilizador> papeis)
    {
        if (papeis.size() == 1)
            return papeis.get(0);
        else
           return (PapelUtilizador)Utils.apresentaESeleciona(papeis, "Escolha o papel que pretende assumir:");
    }
}
