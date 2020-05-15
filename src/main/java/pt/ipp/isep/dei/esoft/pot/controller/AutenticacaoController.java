/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;

/**
 * The type Autenticacao controller.
 *
 * @author paulomaio
 */
public class AutenticacaoController
{
    private AplicacaoPOT m_oApp;

    /**
     * Instantiates a new Autenticacao controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public AutenticacaoController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.m_oApp = AplicacaoPOT.getInstance();
    }

    /**
     * Do login boolean.
     *
     * @param strId  the str id
     * @param strPwd the str pwd
     * @return the boolean
     */
    public boolean doLogin(String strId, String strPwd)
    {
        return this.m_oApp.doLogin(strId, strPwd);
    }

    /**
     * Gets papeis utilizador.
     *
     * @return the papeis utilizador
     */
    public List<PapelUtilizador> getPapeisUtilizador()
    {
        if (this.m_oApp.getSessaoAtual().isLoggedIn())
        {
            return this.m_oApp.getSessaoAtual().getPapeisUtilizador();
        }
        return null;
    }

    /**
     * Do logout.
     */
    public void doLogout()
    {
        this.m_oApp.doLogout();
    }
}
