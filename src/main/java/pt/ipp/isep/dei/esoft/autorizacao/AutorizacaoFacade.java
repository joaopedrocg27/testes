/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao;

import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;
import pt.ipp.isep.dei.esoft.autorizacao.model.RegistoPapeisUtilizador;
import pt.ipp.isep.dei.esoft.autorizacao.model.RegistoUtilizadores;
import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.autorizacao.model.Utilizador;

import java.io.Serializable;

/**
 * The type Autorizacao facade.
 *
 * @author paulomaio
 */
public class AutorizacaoFacade implements Serializable
{
    private SessaoUtilizador m_oSessao = null;
    
    private final RegistoPapeisUtilizador m_oPapeis = new RegistoPapeisUtilizador();
    private final RegistoUtilizadores m_oUtilizadores = new RegistoUtilizadores();

    /**
     * Regista papel utilizador boolean.
     *
     * @param strPapel the str papel
     * @return the boolean
     */
    public boolean registaPapelUtilizador(String strPapel)
    {
        PapelUtilizador papel = this.m_oPapeis.novoPapelUtilizador(strPapel);
        return this.m_oPapeis.addPapel(papel);
    }

    /**
     * Regista papel utilizador boolean.
     *
     * @param strPapel     the  papel
     * @param strDescricao the  descricao
     * @return success or fail (boolean)
     */
    public boolean registaPapelUtilizador(String strPapel, String strDescricao)
    {
        PapelUtilizador papel = this.m_oPapeis.novoPapelUtilizador(strPapel,strDescricao);
        return this.m_oPapeis.addPapel(papel);
    }

    /**
     * Regista utilizador boolean.
     *
     * @param strNome     the str nome
     * @param strEmail    the str email
     * @param strPassword the str password
     * @return success or fail (boolean)
     */
    public boolean registaUtilizador(String strNome, String strEmail, String strPassword)
    {
        Utilizador utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        return this.m_oUtilizadores.addUtilizador(utlz);
    }

    /**
     * Regista utilizador com papel boolean.
     *
     * @param strNome     the str nome
     * @param strEmail    the str email
     * @param strPassword the str password
     * @param strPapel    the str papel
     * @return success or fail (boolean)
     */
    public boolean registaUtilizadorComPapel(String strNome, String strEmail, String strPassword, String strPapel)
    {
        PapelUtilizador papel = this.m_oPapeis.procuraPapel(strPapel);
        Utilizador utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        utlz.addPapel(papel);
        boolean teste = this.m_oUtilizadores.addUtilizador(utlz);
        return teste;
    }

    /**
     * Regista utilizador com papeis boolean.
     *
     * @param strNome     the str nome
     * @param strEmail    the str email
     * @param strPassword the str password
     * @param papeis      the papeis
     * @return success or fail (boolean)
     */
    public boolean registaUtilizadorComPapeis(String strNome, String strEmail, String strPassword, String[] papeis)
    {
        Utilizador utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        for (String strPapel: papeis)
        {
            PapelUtilizador papel = this.m_oPapeis.procuraPapel(strPapel);
            utlz.addPapel(papel);
        }
        
        return this.m_oUtilizadores.addUtilizador(utlz);
    }

    /**
     * Existe utilizador boolean.
     *
     * @param strId the str id
     * @return success or fail (boolean)
     */
    public boolean existeUtilizador(String strId)
    {
        return this.m_oUtilizadores.hasUtilizador(strId);
    }


    /**
     * Do login sessao utilizador.
     *
     * @param strId  the str id
     * @param strPwd the str pwd
     * @return the sessao utilizador
     */
    public SessaoUtilizador doLogin(String strId, String strPwd)
    {
        Utilizador utlz = this.m_oUtilizadores.procuraUtilizador(strId);
        if (utlz != null)
        {
            if (utlz.hasPassword(strPwd)){
                this.m_oSessao = new SessaoUtilizador(utlz);
            }
        }
        return getSessaoAtual();
    }

    /**
     * Gets sessao atual.
     *
     * @return the sessao atual
     */
    public SessaoUtilizador getSessaoAtual()
    {
        return this.m_oSessao;
    }

    /**
     * Do logout.
     */
    public void doLogout()
    {
        if (this.m_oSessao != null)
            this.m_oSessao.doLogout();
        this.m_oSessao = null;
    }
}
