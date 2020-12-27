/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.ipp.isep.dei.esoft.pot.model;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarTarefaController;
import pt.ipp.isep.dei.esoft.pot.model.Listas.ListaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.Registo.*;

/**
 * The type Plataforma.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Plataforma implements Serializable
{
    private final RegistoTiposRegimento m_oRegistoTiposRegimentos;
    private final String m_strDesignacao;
    private final AutorizacaoFacade m_oAutorizacao;
    private final RegistoCategorias m_oRegistoCategoria;
    private final RegistoAreasAtividade m_oRegistoAreaAtividade;
    private final RegistoCT m_oRegistoCompetenciaTecnica;
    private final RegistoFreelancer m_oRegistoFreelancer;
    private final RegistoOrganizacoes m_oRegistoOrganizacoes;
    private final RegistoAnuncio m_oRegistoAnuncio;


    /**
     * Instantiates a new Plataforma.
     *
     * @param strDesignacao the str designacao
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public Plataforma(String strDesignacao) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if ( (strDesignacao == null) ||
                (strDesignacao.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strDesignacao = strDesignacao;



        this.m_oAutorizacao = new AutorizacaoFacade();
        this.m_oRegistoCategoria = new RegistoCategorias();
        this.m_oRegistoAreaAtividade = new RegistoAreasAtividade();
        this.m_oRegistoCompetenciaTecnica = new RegistoCT();
        this.m_oRegistoFreelancer = new RegistoFreelancer(this.m_oAutorizacao);
        this.m_oRegistoOrganizacoes = new RegistoOrganizacoes(this.m_oAutorizacao);
        this.m_oRegistoTiposRegimentos = new RegistoTiposRegimento();
        this.m_oRegistoAnuncio = new RegistoAnuncio();

    }

    /**
     * Gets m o registo categoria.
     *
     * @return the m o registo categoria
     */
    public RegistoCategorias getM_oRegistoCategoria() {
        return m_oRegistoCategoria;
    }

    /**
     * Gets autorizacao facade.
     *
     * @return the autorizacao facade
     */
    public AutorizacaoFacade getAutorizacaoFacade()
    {
        return this.m_oAutorizacao;
    }

    /**
     * Get m o registo freelancer registo freelancer.
     *
     * @return the registo freelancer
     */
    public RegistoFreelancer getM_oRegistoFreelancer(){return this.m_oRegistoFreelancer;}

    /**
     * Gets m o registo competencia tecnica.
     *
     * @return the m o registo competencia tecnica
     */
    public RegistoCT getM_oRegistoCompetenciaTecnica() {
        return m_oRegistoCompetenciaTecnica;
    }

    /**
     * Gets m o registo area atividade.
     *
     * @return the m o registo area atividade
     */
    public RegistoAreasAtividade getM_oRegistoAreaAtividade() {
        return m_oRegistoAreaAtividade;
    }

    /**
     * Gets registo organizacoes.
     *
     * @return the registo organizacoes
     */
    public RegistoOrganizacoes getRegistoOrganizacoes() {
        return this.m_oRegistoOrganizacoes;
    }

    /**
     * Gets registo tipos regimento.
     *
     * @return the registo tipos regimento
     */
    public RegistoTiposRegimento getRegistoTiposRegimento() {
        return this.m_oRegistoTiposRegimentos;
    }

    /**
     * Gets registo anuncios.
     *
     * @return the registo anuncios
     */
    public RegistoAnuncio getRegistoAnuncios() {
        return this.m_oRegistoAnuncio;
    }



}
    
    
