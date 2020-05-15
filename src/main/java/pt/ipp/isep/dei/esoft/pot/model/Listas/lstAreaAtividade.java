package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Lst area atividade.
 */
public class lstAreaAtividade implements Serializable {
    private final Set<AreaAtividade> m_AreaAtividade;

    /**
     * Instantiates a new Lst area atividade.
     */
    public lstAreaAtividade(){
        m_AreaAtividade = new HashSet<>();
    }

    /**
     * Get area atividade list list.
     *
     * @return the list
     */
    public List<AreaAtividade> getAreaAtividadeList(){
        ArrayList<AreaAtividade> at= new ArrayList<>(m_AreaAtividade);
        return at;
    }

    /**
     * Add boolean.
     *
     * @param oArea the o area
     * @return success or fail (boolean)
     */
    public boolean add(AreaAtividade oArea){
        return m_AreaAtividade.add(oArea);
    }

    /**
     * Gets area atividade by id.
     *
     * @param strId the str id
     * @return the area atividade by id
     */
    public AreaAtividade getAreaAtividadeById(String strId)
    {
        for(AreaAtividade area : this.m_AreaAtividade)
        {
            if (area.hasId(strId))
            {
                return area;
            }
        }

        return null;
    }

}
