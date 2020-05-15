/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.EnderecoPostal;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoOrganizacoes;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 * The type Registar organizacao controller.
 *
 * @author paulomaio
 */
public class RegistarOrganizacaoController implements Serializable
{
    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;
    private Organizacao m_oOrganizacao;
    private RegistoOrganizacoes registo;
    private Colaborador oColab;
    private AutorizacaoFacade af;

    /**
     * Instantiates a new Registar organizacao controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public RegistarOrganizacaoController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.m_oApp = AplicacaoPOT.getInstance();
        this.m_oPlataforma = m_oApp.getPlataforma();
        this.registo = this.m_oPlataforma.getRegistoOrganizacoes();
        this.af=this.m_oPlataforma.getAutorizacaoFacade();
    }

    /**
     * Gets af.
     *
     * @return the af
     */
    public AutorizacaoFacade getAf() {
        return af;
    }

    /**
     * Regista organizacao boolean.
     *
     * @return the boolean
     */
    public boolean registaOrganizacao()
    {
        return this.registo.registaOrganizacao(this.m_oOrganizacao);
    }

    /**
     * Gets  plataforma.
     *
     * @return the  plataforma
     */
    public Plataforma getM_oPlataforma() {
        return m_oPlataforma;
    }

    /**
     * Gets organizacao string.
     *
     * @return the organizacao toString
     */
    public String getOrganizacaoString()
    {
        return this.m_oOrganizacao.toString();
    }

    /**
     * Nova organizacao boolean.
     *
     * @param strNome           the str nome
     * @param strNIF            the str nif
     * @param strWebsite        the str website
     * @param strTelefone       the str telefone
     * @param strEmail          the str email
     * @param strLocal          the str local
     * @param strCodPostal      the str cod postal
     * @param strLocalidade     the str localidade
     * @param strNomeGestor     the str nome gestor
     * @param strFuncaoGestor   the str funcao gestor
     * @param strEmailGestor    the str email gestor
     * @param strTelefoneGestor the str telefone gestor
     * @return the boolean
     */
    public boolean novaOrganizacao(String strNome, String strNIF, String strWebsite, String strTelefone,
                                   String strEmail, String strLocal, String strCodPostal, String strLocalidade,
                                   String strNomeGestor, String strFuncaoGestor, String strEmailGestor,  String strTelefoneGestor)
    {
        try
        {
            EnderecoPostal oMorada = Organizacao.novoEnderecoPostal(strLocal, strCodPostal, strLocalidade);
            this.oColab = Organizacao.novoColaborador(strNomeGestor, strFuncaoGestor, strTelefoneGestor, strEmailGestor);
            this.m_oOrganizacao = this.registo.novaOrganizacao(strNome, strNIF, strWebsite,strTelefone, strEmail, oMorada, oColab);
            return this.registo.validaOrganizacao(this.m_oOrganizacao);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oOrganizacao = null;
            return false;
        }
    }

    /**
     * Regista colaborador boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaColaborador(){
       return  this.m_oOrganizacao.registaColaborador();
    }

    /**
     * Gets registo.
     *
     * @return the registo
     */
    public RegistoOrganizacoes getRegisto() {
        return registo;
    }
}
