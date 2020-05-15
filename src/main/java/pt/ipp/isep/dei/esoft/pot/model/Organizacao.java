 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.model.Listas.ListaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.Listas.lstColab;

import java.io.Serializable;
import java.util.*;

 /**
  * The type Organizacao.
  *
  * @author paulomaio
  */
 public class Organizacao implements Serializable
{
    private String m_strNome;
    private String m_strNIF;
    private EnderecoPostal m_oEnderecoPostal;
    private String m_strWebsite;
    private String m_strTelefone;
    private String m_strEmail;
    private Colaborador m_oGestor;
    private ListaTarefa ltar;
    private lstColab lCol;

    /**
     * Instantiates a new Organizacao.
     *
     * @param strNome      the str nome
     * @param strNIF       the str nif
     * @param strWebsite   the str website
     * @param strTelefone  the str telefone
     * @param strEmail     the str email
     * @param oMorada      the o morada
     * @param oColaborador the o colaborador
     */
    public Organizacao(String strNome, String strNIF, String strWebsite, String strTelefone,
            String strEmail, EnderecoPostal oMorada, Colaborador oColaborador)
    {
        if ( (strNome == null) || (strNIF == null) || (strTelefone == null) ||
                (strEmail == null) || (oMorada == null) || (oColaborador == null) ||
                (strNome.isEmpty())|| (strNIF.isEmpty()) || (strTelefone.isEmpty()) || 
                (strEmail.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strNome = strNome;
        this.m_strNIF = strNIF;
        this.m_oEnderecoPostal = oMorada;
        this.m_strWebsite = strWebsite;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
        this.m_oGestor = oColaborador;
        this.lCol = new lstColab();
        this.ltar = new ListaTarefa();
       
    }

    /**
     * Gets gestor.
     *
     * @return the gestor
     */
    public Colaborador getGestor()
    {
        return this.m_oGestor;
    }
   
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strNIF);
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
        Organizacao obj = (Organizacao) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }
    
    @Override
    public String toString()
    {
        String str = String.format("%s - %s - %s - %s - %s - %s - %s", this.m_strNome, this.m_strNIF, this.m_strWebsite, this.m_strTelefone, this.m_strEmail, this.m_oEnderecoPostal.toString(),this.m_oGestor.toString());
        return str;
    }

    /**
     * Novo colaborador colaborador.
     *
     * @param strNome     the str nome
     * @param strFuncao   the str funcao
     * @param strTelefone the str telefone
     * @param strEmail    the str email
     * @return the colaborador
     */
    public static Colaborador novoColaborador(String strNome, String strFuncao, String strTelefone, String strEmail)
    {
        return new Colaborador(strNome,strFuncao,strTelefone,strEmail);
    }

    /**
     * Novo endereco postal endereco postal.
     *
     * @param strLocal      the str local
     * @param strCodPostal  the str cod postal
     * @param strLocalidade the str localidade
     * @return the endereco postal
     */
    public static EnderecoPostal novoEnderecoPostal(String strLocal, String strCodPostal, String strLocalidade)
    {
        return new EnderecoPostal(strLocal,strCodPostal,strLocalidade);
    }

    /**
     * Get colaborador by email colaborador.
     *
     * @param email the email
     * @return the colaborador
     */
    public Colaborador getColaboradorByEmail(String email){
        return this.lCol.getColaboradorByEmail(email);
    }

    /**
     * Add colaborador boolean.
     *
     * @param colab the colab
     * @return the boolean
     */
    public boolean addColaborador(Colaborador colab){
        return this.lCol.add(colab);
    }

    /**
     * Valida colaborador boolean.
     *
     * @param colab the colab
     * @return the boolean
     */
    public boolean validaColaborador(Colaborador colab){
        return !this.lCol.getColaboradores().contains(colab);
    }

    /**
     * Regista colaborador boolean.
     *
     * @return the boolean
     */
    public boolean registaColaborador (){
        if (this.validaColaborador(this.m_oGestor)){
            return this.addColaborador(this.m_oGestor);
        }else{
            return false;
        }
    }

    /**
     * Gets lista colaboradores.
     *
     * @return the lista colaboradores
     */
    public List getListaColaboradores() {
        return this.lCol.getColaboradores();
    }

    /**
     * Get lista tarefa lista tarefa.
     *
     * @return the lista tarefa
     */
    public ListaTarefa getListaTarefa(){
        return this.ltar;
    }




}
