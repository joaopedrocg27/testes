/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Registo utilizadores.
 *
 * @author paulomaio
 */
public class RegistoUtilizadores implements Serializable
{
    private Set<Utilizador> m_lstUtilizadores = new HashSet<Utilizador>();


    /**
     * Novo utilizador utilizador.
     *
     * @param strNome     the str nome
     * @param strEmail    the str email
     * @param strPassword the str password
     * @return the utilizador
     */
    public Utilizador novoUtilizador(String strNome, String strEmail, String strPassword)
    {
        return new Utilizador(strNome,strEmail,strPassword);
    }

    /**
     * Add utilizador boolean.
     *
     * @param utlz the utlz
     * @return the boolean
     */
    public boolean addUtilizador(Utilizador utlz)
    {
        if (utlz != null)
            return this.m_lstUtilizadores.add(utlz);
        return false;
    }

    /**
     * Remove utilizador boolean.
     *
     * @param utlz the utlz
     * @return the boolean
     */
    public boolean removeUtilizador(Utilizador utlz)
    {
        if (utlz != null)
            return this.m_lstUtilizadores.remove(utlz);
        return false;
    }

    /**
     * Procura utilizador utilizador.
     *
     * @param strId the str id
     * @return the utilizador
     */
    public Utilizador procuraUtilizador(String strId)
    {
        for(Utilizador utlz: this.m_lstUtilizadores)
        {
            if(utlz.hasId(strId))
                return utlz;
        }
        return null;
    }

    /**
     * Has utilizador boolean.
     *
     * @param strId the str id
     * @return the boolean
     */
    public boolean hasUtilizador(String strId)
    {
        Utilizador utlz = procuraUtilizador(strId);
        if (utlz != null)
            return this.m_lstUtilizadores.contains(utlz);
        return false;
    }

    /**
     * Has utilizador boolean.
     *
     * @param utlz the utlz
     * @return the boolean
     */
    public boolean hasUtilizador(Utilizador utlz)
    {
        return this.m_lstUtilizadores.contains(utlz);
    }
}
