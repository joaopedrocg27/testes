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
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAreasAtividade;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 * The type Especificar area atividade controller.
 *
 * @author paulomaio
 */
public class EspecificarAreaAtividadeController implements Serializable
{
    private final Plataforma m_oPlataforma;
    private AreaAtividade m_oAreaAtividade;
    private final RegistoAreasAtividade rat;

    /**
     * Instantiates a new Especificar area atividade controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EspecificarAreaAtividadeController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if(!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.rat = this.m_oPlataforma.getM_oRegistoAreaAtividade();
    }

    /**
     * Get registo area registo areas atividade.
     *
     * @return the registo areas atividade
     */
    public RegistoAreasAtividade getRegistoArea(){
        return this.rat;
    }

    /**
     * Gets m o plataforma.
     *
     * @return the  plataforma
     */
    public Plataforma getM_oPlataforma() {
        return m_oPlataforma;
    }

    /**
     * Nova area atividade boolean.
     *
     * @param strCodigo             the str codigo
     * @param strDescricaoBreve     the str descricao breve
     * @param strDescricaoDetalhada the str descricao detalhada
     * @return the boolean
     */
    public boolean novaAreaAtividade(String strCodigo, String strDescricaoBreve, String strDescricaoDetalhada)
    {
        try
        {
            this.m_oAreaAtividade = this.rat.novaAreaAtividade(strCodigo, strDescricaoBreve,strDescricaoDetalhada);
            return this.rat.validaAreaAtividade(this.m_oAreaAtividade);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oAreaAtividade = null;
            return false;
        }
    }


    /**
     * Regista area atividade boolean.
     *
     * @return the boolean
     */
    public boolean registaAreaAtividade()
    {
        return this.rat.registaAreaAtividade(this.m_oAreaAtividade);
    }

    /**
     * Gets area atividade string.
     *
     * @return the area atividade string
     */
    public String getAreaAtividadeString()
    {
        return this.m_oAreaAtividade.toString();
    }

    /**
     * The type Definir categoria controller.
     */
    public static class DefinirCategoriaController {
    }
}
