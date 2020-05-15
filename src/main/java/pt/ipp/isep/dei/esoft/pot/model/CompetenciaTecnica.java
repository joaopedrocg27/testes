/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.model.Listas.lgraus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * The type Competencia tecnica.
 *
 * @author paulomaio
 */
public class CompetenciaTecnica implements Serializable
{
    private String m_strId;
    private String m_strDescricaoBreve;
    private String m_strDescricaoDetalhada;
    private AreaAtividade m_oAreaAtividade;
    private lgraus list;

    /**
     * Instantiates a new Competencia tecnica.
     *
     * @param strId                 the str id
     * @param strDescricaoBreve     the str descricao breve
     * @param strDescricaoDetalhada the str descricao detalhada
     * @param oArea                 the o area
     */
    public CompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoDetalhada, AreaAtividade oArea)
    {
        if ( (strId == null) || (strDescricaoBreve == null) || (strDescricaoDetalhada == null) ||
                (oArea == null) || (strId.isEmpty())|| (strDescricaoBreve.isEmpty()) || (strDescricaoDetalhada.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strId = strId;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
        this.m_oAreaAtividade = oArea;
        this.list= new lgraus();
    }

    /**
     * Gets m o area atividade.
     *
     * @return the m o area atividade
     */
    public AreaAtividade getM_oAreaAtividade() {
        return m_oAreaAtividade;
    }

    /**
     * Has id boolean.
     *
     * @param strId the str id
     * @return the boolean
     */
    public boolean hasId(String strId)
    {
        return this.m_strId.equalsIgnoreCase(strId);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strId);
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
        CompetenciaTecnica obj = (CompetenciaTecnica) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s - %s  - Área Atividade: %s", this.m_strId, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada, this.m_oAreaAtividade.toString());
    }

    /**
     * Get m str id string.
     *
     * @return the string
     */
    public String getM_strId(){
        return this.m_strId;
    }

    /**
     * Valida grau proficiencia boolean.
     *
     * @param gp the gp
     * @return the boolean
     */
    public boolean validaGrauProficiencia(GrauProficiencia gp){
        return true;
    }

    /**
     * Novo grau proficiencia grau proficiencia.
     *
     * @param valor  the valor
     * @param design the design
     * @return the grau proficiencia
     */
    public GrauProficiencia novoGrauProficiencia(int valor,String design){
        return new GrauProficiencia(valor,design);
    }

    /**
     * Add grau proficiencia boolean.
     *
     * @param gp the gp
     * @return the boolean
     */
    public boolean addGrauProficiencia(GrauProficiencia gp){
        return this.list.add(gp);
    }

    /**
     * Get grau proficiencia by valor grau proficiencia.
     *
     * @param valor the valor
     * @return the grau proficiencia
     */
    public GrauProficiencia getGrauProficienciaByValor (int valor){
        return this.list.getGrauProficienciaByValor(valor);
    }

    /**
     * Get grau proficiencia list array list.
     *
     * @return the array list
     */
    public ArrayList<GrauProficiencia> getGrauProficienciaList (){
        ArrayList<GrauProficiencia> gp = this.list.getGrauProficienciaList();
        Collections.sort(gp);
        return gp;
    }

    /**
     * Regista grau proficiencia boolean.
     *
     * @param gp the gp
     * @return the boolean
     */
    public boolean registaGrauProficiencia(GrauProficiencia gp){
        if (this.validaGrauProficiencia(gp)){
            return this.addGrauProficiencia(gp);
        }else{
            return false;
        }

    }

}
