package pt.ipp.isep.dei.esoft.pot.model.Registo;

import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.model.Listas.ListCT;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The type Registo ct.
 */
public class RegistoCT implements Serializable {
    private final ListCT list;

    /**
     * Instantiates a new Registo ct.
     */
    public RegistoCT(){
        this.list = new ListCT();
    }

    /**
     * Gets competencia tecnica by id.
     *
     * @param strId the str id
     * @return the competencia tecnica by id
     */
    public CompetenciaTecnica getCompetenciaTecnicaById(String strId)
    {
        return this.list.getCompetenciaTecnicaById(strId);
    }

    /**
     * Nova competencia tecnica competencia tecnica.
     *
     * @param ctID                 the ct id
     * @param strDescricaoBreve    the str descricao breve
     * @param strDescricaoCompleta the str descricao completa
     * @param oArea                the o area
     * @return the competencia tecnica
     */
    public CompetenciaTecnica novaCompetenciaTecnica( String ctID,String strDescricaoBreve, String strDescricaoCompleta, AreaAtividade oArea)
    {
        return new CompetenciaTecnica(ctID, strDescricaoBreve,strDescricaoCompleta,oArea);
    }

    /**
     * Get ct list list.
     *
     * @return the list
     */
    public List<CompetenciaTecnica> getCTList(){
        return this.list.getCompetenciaTecnicaList();
    }


    /**
     * Regista competencia tecnica boolean.
     *
     * @param oCompTecnica the o comp tecnica
     * @return the boolean
     */
    public boolean registaCompetenciaTecnica(CompetenciaTecnica oCompTecnica)
    {
        if (this.validaCompetenciaTecnica(oCompTecnica))
        {
            return addCompetenciaTecnica(oCompTecnica);
        }
        return false;
    }

    private boolean addCompetenciaTecnica(CompetenciaTecnica oCompTecnica)
    {
        return this.list.addCompetenciaTecnica(oCompTecnica);
    }

    /**
     * Valida competencia tecnica boolean.
     *
     * @param oCompTecnica the o comp tecnica
     * @return the boolean
     */
    public boolean validaCompetenciaTecnica(CompetenciaTecnica oCompTecnica)
    {

        return !(this.list.getCompetenciaTecnicaList().contains(oCompTecnica));

    }


}
