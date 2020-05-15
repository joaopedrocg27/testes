/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAreasAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoCT;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 * The type Especificar competencia tecnica controller.
 *
 * @author paulomaio
 */
public class EspecificarCompetenciaTecnicaController implements Serializable
{
    private Plataforma m_oPlataforma;
    private RegistoCT registoCompetenciaTecnica;
    private CompetenciaTecnica m_oCompetencia;
    private RegistoAreasAtividade rat;
    private GrauProficiencia gp;

    /**
     * Instantiates a new Especificar competencia tecnica controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EspecificarCompetenciaTecnicaController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if (AplicacaoPOT.getInstance().getSessaoAtual()!=null){
        if(!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
            throw new IllegalStateException("Utilizador não Autorizado");}
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.registoCompetenciaTecnica = m_oPlataforma.getM_oRegistoCompetenciaTecnica();
        this.rat = this.m_oPlataforma.getM_oRegistoAreaAtividade();
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
     * Get registo competencia tecnica.
     *
     * @return the registo competencia tecnica
     */
    public RegistoCT getRegistoCompetenciaTecnica(){
        return this.registoCompetenciaTecnica;
    }

    /**
     * Gets areas atividade.
     *
     * @return the areas atividade
     */
    public List<AreaAtividade> getAreasAtividade()
    {
        return this.rat.getAreasAtividade();
    }

    /**
     * Nova competencia tecnica boolean.
     *
     * @param ctId                  the ct id
     * @param strDescricaoBreve     the str descricao breve
     * @param strDescricaoDetalhada the str descricao detalhada
     * @param areaAtividadeId       the area atividade id
     * @return success or fail (boolean)
     */
    public boolean novaCompetenciaTecnica(String ctId,String strDescricaoBreve, String strDescricaoDetalhada, String areaAtividadeId)
    {
        try
        {
            AreaAtividade area = this.rat.getAreaAtividadeById(areaAtividadeId);
            this.m_oCompetencia = this.registoCompetenciaTecnica.novaCompetenciaTecnica(ctId,strDescricaoBreve,strDescricaoDetalhada,area);
            return this.registoCompetenciaTecnica.validaCompetenciaTecnica(this.m_oCompetencia);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCompetencia = null;
            return false;
        }
    }

    /**
     * Novo grau proficiencia boolean.
     *
     * @param valor the valor
     * @param des   the des
     * @return success or fail (boolean)
     */
    public boolean novoGrauProficiencia(int valor,String des){
        try
        {
            this.gp=this.m_oCompetencia.novoGrauProficiencia(valor,des);
            return this.m_oCompetencia.validaGrauProficiencia(this.gp);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCompetencia = null;
            return false;
        }
    }

    /**
     * Regista grau proficiencia boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaGrauProficiencia(){
        return this.m_oCompetencia.registaGrauProficiencia(this.gp);
    }


    /**
     * Regista competencia tecnica boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaCompetenciaTecnica()
    {
        return this.registoCompetenciaTecnica.registaCompetenciaTecnica(this.m_oCompetencia);
    }

    /**
     * Gets competencia tecnica string.
     *
     * @return the competencia tecnica string
     */
    public String getCompetenciaTecnicaString()
    {
        return this.m_oCompetencia.toString();
    }

}
