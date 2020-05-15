/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.io.Serializable;
import java.util.List;

/**
 * The type Sessao utilizador.
 *
 * @author paulomaio
 */
public class SessaoUtilizador implements Serializable
{
    private Utilizador m_oUtilizador = null;
    
    private SessaoUtilizador()
    {
    }

    /**
     * Instantiates a new Sessao utilizador.
     *
     * @param oUtilizador the o utilizador
     */
    public SessaoUtilizador(Utilizador oUtilizador)
    {
        if (oUtilizador == null)
            throw new IllegalArgumentException("Argumento não pode ser nulo.");
        this.m_oUtilizador = oUtilizador;
    }

    /**
     * Do logout.
     */
    public void doLogout()
    {
        this.m_oUtilizador = null;
    }

    /**
     * Is logged in boolean.
     *
     * @return the boolean
     */
    public boolean isLoggedIn()
    {
        return this.m_oUtilizador != null;
    }

    /**
     * Is logged in com papel boolean.
     *
     * @param strPapel the str papel
     * @return the boolean
     */
    public boolean isLoggedInComPapel(String strPapel)
    {
        if (isLoggedIn())
        {
            return this.m_oUtilizador.hasPapel(strPapel);
        }
        return false;
    }

    /**
     * Gets nome utilizador.
     *
     * @return the nome utilizador
     */
    public String getNomeUtilizador()
    {
        if (isLoggedIn())
            this.m_oUtilizador.getNome();
        return null;
    }

    /**
     * Gets id utilizador.
     *
     * @return the id utilizador
     */
    public String getIdUtilizador()
    {
        if (isLoggedIn())
            this.m_oUtilizador.getId();
        return null;
    }

    /**
     * Gets email utilizador.
     *
     * @return the email utilizador
     */
    public String getEmailUtilizador()
    {
        if (isLoggedIn())
            return this.m_oUtilizador.getEmail();
        return null;
    }

    /**
     * Gets papeis utilizador.
     *
     * @return the papeis utilizador
     */
    public List<PapelUtilizador> getPapeisUtilizador()
    {
        return this.m_oUtilizador.getPapeis();
    }
}
