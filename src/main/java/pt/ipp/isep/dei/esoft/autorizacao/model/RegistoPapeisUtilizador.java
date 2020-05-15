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
 * The type Registo papeis utilizador.
 *
 * @author paulomaio
 */
public class RegistoPapeisUtilizador implements Serializable
{
    private Set<PapelUtilizador> m_lstPapeis = new HashSet<PapelUtilizador>();

    /**
     * Novo papel utilizador papel utilizador.
     *
     * @param strPapel the str papel
     * @return the papel utilizador
     */
    public PapelUtilizador novoPapelUtilizador(String strPapel)
    {
        return new PapelUtilizador(strPapel);
    }

    /**
     * Novo papel utilizador papel utilizador.
     *
     * @param strPapel     the str papel
     * @param strDescricao the str descricao
     * @return the papel utilizador
     */
    public PapelUtilizador novoPapelUtilizador(String strPapel, String strDescricao)
    {
        return new PapelUtilizador(strPapel,strDescricao);
    }

    /**
     * Add papel boolean.
     *
     * @param papel the papel
     * @return the boolean
     */
    public boolean addPapel(PapelUtilizador papel)
    {
        if (papel != null)
            return this.m_lstPapeis.add(papel);
        return false;
    }

    /**
     * Remove papel boolean.
     *
     * @param papel the papel
     * @return the boolean
     */
    public boolean removePapel(PapelUtilizador papel)
    {
        if (papel != null)
            return this.m_lstPapeis.remove(papel);
        return false;
    }

    /**
     * Procura papel papel utilizador.
     *
     * @param strPapel the str papel
     * @return the papel utilizador
     */
    public PapelUtilizador procuraPapel(String strPapel)
    {
        for(PapelUtilizador p: this.m_lstPapeis)
        {
            if(p.hasId(strPapel))
                return p;
        }
        return null;
    }

    /**
     * Has papel boolean.
     *
     * @param strPapel the str papel
     * @return the boolean
     */
    public boolean hasPapel(String strPapel)
    {
        PapelUtilizador papel = procuraPapel(strPapel);
        if (papel != null)
            return this.m_lstPapeis.contains(papel);
        return false;
    }

    /**
     * Has papel boolean.
     *
     * @param papel the papel
     * @return the boolean
     */
    public boolean hasPapel(PapelUtilizador papel)
    {
        return this.m_lstPapeis.contains(papel);
    }
}
