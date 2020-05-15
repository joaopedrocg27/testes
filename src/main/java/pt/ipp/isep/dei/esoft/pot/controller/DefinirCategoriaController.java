package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAreasAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoCategorias;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoCT;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Definir categoria controller.
 */
public class DefinirCategoriaController implements Serializable  {

    private Plataforma m_oPlataforma;
    private AreaAtividade m_oAreaAtividade;
    private RegistoCategorias m_oRegistoCategoria;
    private RegistoAreasAtividade rat;
    private RegistoCT rct;
    private CompetenciaTecnica m_oCompetenciaTecnica;
    private GrauProficiencia gp;
    private Categoria m_oCategoria;
    private CaraterCT cCt;

    /**
     * Instantiates a new Definir categoria controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public DefinirCategoriaController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if (AplicacaoPOT.getInstance().getSessaoAtual()!=null){
        if(!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
            throw new IllegalStateException("Utilizador não Autorizado");}
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.m_oRegistoCategoria = m_oPlataforma.getM_oRegistoCategoria();
        this.rat =m_oPlataforma.getM_oRegistoAreaAtividade();
        this.rct = m_oPlataforma.getM_oRegistoCompetenciaTecnica();
    }

    /**
     * Gets m o plataforma.
     *
     * @return the plataforma
     */
    public Plataforma getM_oPlataforma() {
        return m_oPlataforma;
    }

    /**
     * Nova categoria boolean.
     *
     * @param desc  the desc
     * @param atCod the at cod
     * @return success or fail (boolean)
     */
    public boolean novaCategoria(String desc, String atCod){
        try
        {
            this.m_oAreaAtividade = setAT(atCod);
            this.m_oCategoria = this.m_oRegistoCategoria.novaCategoria(desc,this.m_oAreaAtividade);
            return this.m_oRegistoCategoria.validaCategoria(m_oCategoria);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCategoria = null;
            return false;
        }
    }

    /**
     * Novo caracter ct boolean.
     *
     * @param ctCod     the ct cod
     * @param valorGrau the valor grau
     * @param obg       the obg
     * @return success or fail (boolean)
     */
    public boolean novoCaracterCT(String ctCod,int valorGrau,boolean obg){
        try
        {
            this.m_oCompetenciaTecnica = getCT(ctCod);
            this.gp = getGp(valorGrau);
            this.cCt = this.m_oCategoria.novoCaracterCT(m_oCompetenciaTecnica,gp,obg);
            return this.m_oCategoria.validacaracterTC(this.cCt);

        }
        catch (RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.cCt = null;
            return false;
        }
    }

    /**
     * Set  area atividade.
     *
     * @param atCod the at cod
     * @return the area atividade
     */
    public AreaAtividade setAT (String atCod){
return this.rat.getAreaAtividadeById(atCod);
    }

    /**
     * Get AreaAtividade  list.
     *
     * @return the list
     */
    public List<AreaAtividade> getATList(){
        return this.rat.getAreasAtividade();
    }

    /**
     * Get ct competencia tecnica.
     *
     * @param ctCod the ct cod
     * @return the competencia tecnica
     */
    public CompetenciaTecnica getCT(String ctCod){
        return this.rct.getCompetenciaTecnicaById(ctCod);

    }

    /**
     * Get ct list list.
     *
     * @param at the at
     * @return the list
     */
    public List<CompetenciaTecnica> getCTList(AreaAtividade at){
        ArrayList<CompetenciaTecnica> ctList = new ArrayList<>();
        for (CompetenciaTecnica ct :this.rct.getCTList()){
            if (ct.getM_oAreaAtividade().equals(at)){
                ctList.add(ct);
            }
        }
        return ctList;
    }

    /**
     * Regista categoria boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaCategoria(){
        return this.m_oRegistoCategoria.registaCategoria(this.m_oCategoria);
    }

    /**
     * Gets gp.
     *
     * @param valorGrau the valor grau
     * @return the grau proficiencia
     */
    public GrauProficiencia getGp(int valorGrau) {
        return this.m_oCompetenciaTecnica.getGrauProficienciaByValor(valorGrau);
    }

    /**
     * Get categoria string string.
     *
     * @return the string
     */
    public String getCategoriaString(){
        return this.m_oRegistoCategoria.toString();
    }

    /**
     * Regista caracter ct boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaCaracterCt(){
        return this.m_oCategoria.registaCaracterCT(this.cCt);
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
     * Get cat id string.
     *
     * @return the string
     */
    public String getCatID(){
        return this.m_oCategoria.getId();
    }
}
