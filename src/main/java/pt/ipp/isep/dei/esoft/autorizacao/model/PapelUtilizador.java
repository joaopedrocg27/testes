/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Papel utilizador.
 *
 * @author paulomaio
 */
public class PapelUtilizador implements Serializable
{
    private final String m_strPapel;
    private final String m_strDescricao;

    /**
     * Instantiates a new Papel utilizador.
     *
     * @param strPapel the str papel
     */
    public PapelUtilizador(String strPapel)
    {
        if ( (strPapel == null) || (strPapel.isEmpty()))
            throw new IllegalArgumentException("O argumento não pode ser nulo ou vazio.");
        
        this.m_strPapel = strPapel;
        this.m_strDescricao = strPapel;
    }

    /**
     * Instantiates a new Papel utilizador.
     *
     * @param strPapel     the str papel
     * @param strDescricao the str descricao
     */
    public PapelUtilizador(String strPapel, String strDescricao)
    {
        if ( (strPapel == null) || (strDescricao == null) || (strPapel.isEmpty())|| (strDescricao.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos não pode ser nulo ou vazio.");
        
        this.m_strPapel = strPapel;
        this.m_strDescricao = strDescricao;
    }

    /**
     * Gets papel.
     *
     * @return the papel
     */
    public String getPapel()
    {
        return this.m_strPapel;
    }

    /**
     * Gets descricao.
     *
     * @return the descricao
     */
    public String getDescricao()
    {
        return this.m_strDescricao;
    }

    /**
     * Has id boolean.
     *
     * @param strId the str id
     * @return the boolean
     */
    public boolean hasId(String strId)
    {
        return this.m_strPapel.equals(strId);
    }
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strPapel);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        PapelUtilizador obj = (PapelUtilizador) o;
        return Objects.equals(m_strPapel, obj.m_strPapel);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.m_strPapel, this.m_strDescricao);
    }
}
