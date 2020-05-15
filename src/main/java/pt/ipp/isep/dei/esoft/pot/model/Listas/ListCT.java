package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type List ct.
 */
public class ListCT implements Serializable {
    private final Set<CompetenciaTecnica> m_lstCompetencias;

    /**
     * Instantiates a new List ct.
     */
    public ListCT(){
        this.m_lstCompetencias= new HashSet<>();
    }

    /**
     * Gets competencia tecnica by id.
     *
     * @param strId the str id
     * @return the competencia tecnica by id
     */
    public CompetenciaTecnica getCompetenciaTecnicaById(String strId)
    {
        for(CompetenciaTecnica oCompTecnica : this.m_lstCompetencias)
        {
            if (oCompTecnica.hasId(strId))
            {
                return oCompTecnica;
            }
        }

        return null;
    }


    /**
     * Add competencia tecnica boolean.
     *
     * @param oCompTecnica the o comp tecnica
     * @return success or fail (boolean)
     */
    public boolean addCompetenciaTecnica(CompetenciaTecnica oCompTecnica)
    {
        return m_lstCompetencias.add(oCompTecnica);
    }

    /**
     * Get competencia tecnica list list.
     *
     * @return the list
     */
    public List<CompetenciaTecnica> getCompetenciaTecnicaList(){
        ArrayList<CompetenciaTecnica> ct = new ArrayList<>(this.m_lstCompetencias);
        
        return ct;
    }
}

