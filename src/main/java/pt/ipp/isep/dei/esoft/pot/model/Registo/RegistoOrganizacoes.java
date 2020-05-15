package pt.ipp.isep.dei.esoft.pot.model.Registo;

import pt.ipp.isep.dei.esoft.autorizacao.AlgoritimoGeradorPwd;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Listas.ListaOrganizacao;
import pt.ipp.isep.dei.esoft.pot.model.Listas.lstAreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Listas.lstColab;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Registo organizacoes.
 */
public class RegistoOrganizacoes implements AlgoritimoGeradorPwd, Serializable {
    private AutorizacaoFacade m_oAutorizacao;
    private ListaOrganizacao listaOrganizacao;


    /**
     * Instantiates a new Registo organizacoes.
     *
     * @param auth the auth
     */
    public RegistoOrganizacoes(AutorizacaoFacade auth) {
        this.m_oAutorizacao = auth;
        this.listaOrganizacao = new ListaOrganizacao();
    }
    private boolean addOrganizacao(Organizacao oOrganizacao)
    {
        return this.listaOrganizacao.add(oOrganizacao);
    }

    /**
     * Regista organizacao boolean.
     *
     * @param oOrganizacao the o organizacao
     * @return the boolean
     */
    public boolean registaOrganizacao(Organizacao oOrganizacao)
    {
        if (this.validaOrganizacao(oOrganizacao))
        {
            Colaborador oGestor = oOrganizacao.getGestor();
            String strNomeGestor = oGestor.getNome();
            String strEmailGestor = oGestor.getEmail();
            String strPwd = this.gerarPassword(strNomeGestor,strEmailGestor);
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(strNomeGestor,strEmailGestor, strPwd,
                    new String[] {Constantes.PAPEL_GESTOR_ORGANIZACAO,Constantes.PAPEL_COLABORADOR_ORGANIZACAO}))
                return addOrganizacao(oOrganizacao);
        }
        return false;
    }

    /**
     * Valida organizacao boolean.
     *
     * @param oOrganizacao the o organizacao
     * @return the boolean
     */
    public boolean validaOrganizacao(Organizacao oOrganizacao)
    {
        boolean bRet = true;
        if (this.m_oAutorizacao.existeUtilizador(oOrganizacao.getGestor().getEmail()))
            bRet = false;



        return bRet;
    }

    /**
     * Nova organizacao organizacao.
     *
     * @param strNome     the str nome
     * @param strNIF      the str nif
     * @param strWebsite  the str website
     * @param strTelefone the str telefone
     * @param strEmail    the str email
     * @param oMorada     the o morada
     * @param oColab      the o colab
     * @return the organizacao
     */
    public Organizacao novaOrganizacao (String strNome, String strNIF, String strWebsite,String strTelefone, String strEmail,EnderecoPostal oMorada, Colaborador oColab){
        return new Organizacao(strNome, strNIF, strWebsite,strTelefone, strEmail, oMorada, oColab);
    }

    /**
     * Get organizacao by email organizacao.
     *
     * @param email the email
     * @return the organizacao
     */
    public Organizacao getOrganizacaoByEmail(String email){

        for(Organizacao org : this.listaOrganizacao.getOrganizacaoList()){
            if(org.getListaColaboradores().contains(org.getColaboradorByEmail(email))){
                return org;
            }
        }
        return null;
    }

    @Override
    public String gerarPassword(String nome, String email) {
        return nome +"123";
    }
}
