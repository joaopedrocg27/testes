/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Area atividade.
 *
 * @author paulomaio
 */
public class AreaAtividade implements Serializable
{
    private final String m_strCodigo;
    private final String m_strDescricaoBreve;
    private final String m_strDescricaoDetalhada;


    /**
     * Instantiates a new Area atividade.
     *
     * @param strCodigo             the str codigo
     * @param strDescricaoBreve     the str descricao breve
     * @param strDescricaoDetalhada the str descricao detalhada
     */
    public AreaAtividade(String strCodigo, String strDescricaoBreve, String strDescricaoDetalhada)
    {
        if ( (strCodigo == null) || (strDescricaoBreve == null) || (strDescricaoDetalhada == null) ||
                (strCodigo.isEmpty())|| (strDescricaoBreve.isEmpty())|| (strDescricaoDetalhada.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strCodigo = strCodigo;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
    }

    /**
     * Has id boolean.
     *
     * @param strId the str id
     * @return the boolean
     */
    public boolean hasId(String strId)
    {
        return this.m_strCodigo.equalsIgnoreCase(strId);
    }

    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    public String getCodigo()
    {
        return this.m_strCodigo;
    }
   
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strCodigo);
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
        AreaAtividade obj = (AreaAtividade) o;
        return (Objects.equals(m_strCodigo, obj.m_strCodigo));
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s - %s ", this.m_strCodigo, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada);
    }

}
