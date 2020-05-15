/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;

/**
 * The type Aplicacao pot.
 *
 * @author paulomaio
 */
public class AplicacaoPOT
{
       
    private final Plataforma m_oPlataforma;
    private final AutorizacaoFacade m_oAutorizacao;
    
    private AplicacaoPOT() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Properties props = getProperties();
        this.m_oPlataforma = new Plataforma(props.getProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO));
        this.m_oAutorizacao = this.m_oPlataforma.getAutorizacaoFacade();
        bootstrap();
    }

    /**
     * Gets plataforma.
     *
     * @return the plataforma object
     */
    public Plataforma getPlataforma()
    {
        return this.m_oPlataforma;
    }


    /**
     * Gets sessao atual.
     *
     * @return the sessao atual
     */
    public SessaoUtilizador getSessaoAtual()
    {
        return this.m_oAutorizacao.getSessaoAtual();
    }

    /**
     * Do login boolean.
     *
     * @param strId  the str id
     * @param strPwd the str pwd
     * @return the boolean
     */
    public boolean doLogin(String strId, String strPwd)
    {
       return this.m_oAutorizacao.doLogin(strId,strPwd) != null;
    }

    /**
     * Do logout.
     */
    public void doLogout()
    {
        this.m_oAutorizacao.doLogout();
    }


    /**
     * returns Properties
     */
    private Properties getProperties()
    {
        Properties props = new Properties();
        
        // Adiciona propriedades e valores por omissão
        props.setProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO, "Task for Joe");

        
        // Lê as propriedades e valores definidas 
        try
        {
            InputStream in = new FileInputStream(Constantes.PARAMS_FICHEIRO);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {
            
        }
        return props;
    }

    
    private void bootstrap()
    {
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_GESTOR_ORGANIZACAO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_COLABORADOR_ORGANIZACAO);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 1", "adm1@esoft.pt", "123456",Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 2", "adm2@esoft.pt", "123456",Constantes.PAPEL_ADMINISTRATIVO);

        this.m_oAutorizacao.registaUtilizadorComPapel("Colaborador 1", "col1@esoft.pt", "123456",Constantes.PAPEL_COLABORADOR_ORGANIZACAO);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 1", "free1@esoft.pt", "123456",Constantes.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 2", "free2@esoft.pt", "123456",Constantes.PAPEL_FREELANCER);
        
        this.m_oAutorizacao.registaUtilizadorComPapeis("Martim", "martim@esoft.pt", "123456",new String[] {Constantes.PAPEL_FREELANCER, Constantes.PAPEL_ADMINISTRATIVO});
    }
    
    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static AplicacaoPOT singleton = null;

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public static AplicacaoPOT getInstance() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if(singleton == null) 
        {
            synchronized(AplicacaoPOT.class) 
            { 
                singleton = new AplicacaoPOT();
            }
        }
        return singleton;
    }

    
}
