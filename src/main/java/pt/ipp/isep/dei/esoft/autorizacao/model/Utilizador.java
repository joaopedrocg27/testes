/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The type Utilizador.
 *
 * @author paulomaio
 */
public class Utilizador implements Serializable
{
    private final String m_strNome;
    private final String m_strEmail;
    private final String m_strPassword; // Não deveria guardar a password em "plain text"
    private final Set<PapelUtilizador> m_lstPapeis = new HashSet<PapelUtilizador>();

    /**
     * Instantiates a new Utilizador.
     *
     * @param strNome     the str nome
     * @param strEmail    the str email
     * @param strPassword the str password
     */
    public Utilizador(String strNome, String strEmail, String strPassword)
    {
    
        if ( (strNome == null) || (strEmail == null) || (strPassword == null) || (strNome.isEmpty()) || (strEmail.isEmpty()) || (strPassword.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos não pode ser nulo ou vazio.");
        
        this.m_strNome = strNome;
        this.m_strEmail = strEmail;
        this.m_strPassword = strPassword;
        
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId()
    {
        return this.m_strEmail;
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

    /**
     * Has id boolean.
     *
     * @param strId the str id
     * @return the boolean
     */
    public boolean hasId(String strId)
    {
        return this.m_strEmail.equals(strId);
    }

    /**
     * Has password boolean.
     *
     * @param strPwd the str pwd
     * @return the boolean
     */
    public boolean hasPassword(String strPwd)
    {
        return this.m_strPassword.equals(strPwd);
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
     * Has papel boolean.
     *
     * @param papel the papel
     * @return the boolean
     */
    public boolean hasPapel(PapelUtilizador papel)
    {
        return this.m_lstPapeis.contains(papel);
    }

    /**
     * Has papel boolean.
     *
     * @param strPapel the str papel
     * @return the boolean
     */
    public boolean hasPapel(String strPapel)
    {
        for(PapelUtilizador papel: this.m_lstPapeis)
        {
            if (papel.hasId(strPapel))
                return true;
        }
        return false;
    }

    /**
     * Gets papeis.
     *
     * @return the papeis
     */
    public List<PapelUtilizador> getPapeis()
    {
        List<PapelUtilizador> list = new ArrayList<>();
        for(PapelUtilizador papel: this.m_lstPapeis)
            list.add(papel);
        return list;
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
        Utilizador obj = (Utilizador) o;
        return Objects.equals(m_strEmail, obj.m_strEmail);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.m_strNome, this.m_strEmail);
    }
}
