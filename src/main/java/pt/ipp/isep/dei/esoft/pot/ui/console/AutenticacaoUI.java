/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;
import pt.ipp.isep.dei.esoft.pot.controller.AutenticacaoController;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 * The type Autenticacao ui.
 *
 * @author paulomaio
 */
public class AutenticacaoUI
{
    private AutenticacaoController m_controller;

    /**
     * Instantiates a new Autenticacao ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public AutenticacaoUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        m_controller = new AutenticacaoController();
    }

    /**
     * Run boolean.
     *
     * @return the boolean
     */
    public boolean run()
    {
        System.out.println("\nEfetuar Login/Autenticação:");
     
        int maxTentativas = 3;
        boolean sucesso = false;
        do
        {
            maxTentativas--;
            String sId = Utils.readLineFromConsole("Introduza Id/Email: ");
            String sPwd = Utils.readLineFromConsole("Introduza Palavra-Passe: ");
            
            sucesso = m_controller.doLogin(sId, sPwd);
            if (!sucesso)
            {
                System.out.println("Utilizador ou Palavra-Passe erradas. \n Possui mais " + maxTentativas + " tentativas");
            }
        
        } while (!sucesso && maxTentativas > 0);
        return sucesso;
    }

    /**
     * Gets papeis utilizador.
     *
     * @return the papeis utilizador
     */
    public List<PapelUtilizador> getPapeisUtilizador()
    {
        return this.m_controller.getPapeisUtilizador();
    }

    /**
     * Logout.
     */
    public void logout()
    {
        m_controller.doLogout();
    }
}
