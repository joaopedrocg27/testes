/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.model.Listas.ListaTarefa;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The type Colaborador.
 *
 * @author paulomaio
 */
public class Colaborador implements Serializable
{
    private final String m_strNome;
    private final String m_strFuncao;
    private final String m_strTelefone;
    private final String m_strEmail;


    /**
     * Instantiates a new Colaborador.
     *
     * @param strNome     the str nome
     * @param strFuncao   the str funcao
     * @param strTelefone the str telefone
     * @param strEmail    the str email
     */
    public Colaborador(String strNome, String strFuncao, String strTelefone, String strEmail)
    {
        if ( (strNome == null) || (strFuncao == null) || (strTelefone == null) || (strEmail == null) ||
                (strNome.isEmpty())|| (strFuncao.isEmpty())|| (strTelefone.isEmpty())|| (strEmail.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strNome = strNome;
        this.m_strFuncao = strFuncao;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;

    }

    /**
     * Has id boolean.
     *
     * @param strId the str id
     * @return the boolean
     */
    public boolean hasId(String strId)
    {
        return this.m_strEmail.equalsIgnoreCase(strId);
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome()
    {
        return this.m_strNome;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail()
    {
        return this.m_strEmail;
    }
   
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strEmail);
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
        Colaborador obj = (Colaborador) o;
        return (Objects.equals(m_strEmail, obj.m_strEmail));
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s - %s - %s", this.m_strNome, this.m_strFuncao, this.m_strTelefone, this.m_strEmail);
    }

}
