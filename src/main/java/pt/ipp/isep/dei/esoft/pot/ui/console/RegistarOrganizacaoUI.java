/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.controller.RegistarOrganizacaoController;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * The type Registar organizacao ui.
 *
 * @author paulomaio
 */
public class RegistarOrganizacaoUI
{
    private final RegistarOrganizacaoController m_controller;

    /**
     * Instantiates a new Registar organizacao ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public RegistarOrganizacaoUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        m_controller = new RegistarOrganizacaoController();
    }

    /**
     * Run.
     */
    public void run()
    {
        System.out.println("\nRegistar Organizacao:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaOrganizacao()&&m_controller.registaColaborador()) {
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
        String strNome = Utils.readLineFromConsole("Nome da Organização: ");
        String strNIF = Utils.readLineFromConsole("NIF: ");
        String strWebsite = Utils.readLineFromConsole("Website: ");
        String strTelefone = Utils.readLineFromConsole("Telefone: ");
        String strEmail = Utils.readLineFromConsole("EMail: ");
        System.out.println("\nEndereço Postal:");
        String strLocal = Utils.readLineFromConsole("Rua/Av.: ");
        String strCodPostal = Utils.readLineFromConsole("Cod. Postal: ");
        String strLocalidade = Utils.readLineFromConsole("Localidade: ");
        System.out.println("\nInformação do Gestor (i.e. de quem procede ao registo):");  
        String strNomeGestor = Utils.readLineFromConsole("Nome da Gestor: ");
        String strFuncao = Utils.readLineFromConsole("Função Desempenhada: ");
        String strTelefoneGestor = Utils.readLineFromConsole("Telefone: ");
        String strEmailGestor = Utils.readLineFromConsole("EMail: ");

        
        return m_controller.novaOrganizacao(strNome, strNIF, strWebsite, strTelefone, strEmail,
                strLocal, strCodPostal, strLocalidade, strNomeGestor, strFuncao, 
                strEmailGestor, strTelefoneGestor);
    }
    
    private void apresentaDados() 
    {
        System.out.println("\n Informação a Registar:\n" + m_controller.getOrganizacaoString());
    }
}
