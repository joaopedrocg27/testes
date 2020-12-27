package pt.ipp.isep.dei.esoft.pot.model.Registo;

import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Listas.lstAreaAtividade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Registo areas atividade.
 */
public class RegistoAreasAtividade implements Serializable {
    private final lstAreaAtividade list;

    /**
     * Instantiates a new Registo areas atividade.
     */
    public RegistoAreasAtividade(){
        this.list=new lstAreaAtividade();
    }

    /**
     * Gets area atividade by id.
     *
     * @param strId the str id
     * @return the area atividade by id
     */
    public AreaAtividade getAreaAtividadeById(String strId)
    {
        return this.list.getAreaAtividadeById(strId);
    }

    /**
     * Nova area atividade area atividade.
     *
     * @param strCodigo             the str codigo
     * @param strDescricaoBreve     the str descricao breve
     * @param strDescricaoDetalhada the str descricao detalhada
     * @return the area atividade
     */
    public AreaAtividade novaAreaAtividade(String strCodigo, String strDescricaoBreve, String strDescricaoDetalhada)
    {
        return new AreaAtividade(strCodigo, strDescricaoBreve,strDescricaoDetalhada);
    }

    /**
     * Regista area atividade boolean.
     *
     * @param oArea the o area
     * @return success or fail (boolean)
     */
    public boolean registaAreaAtividade(AreaAtividade oArea)
    {
        if (this.validaAreaAtividade(oArea))
        {
            return addAreaAtividade(oArea);
        }
        return false;
    }

    private boolean addAreaAtividade(AreaAtividade oArea)
    {
        return this.list.add(oArea);
    }

    /**
     * Valida area atividade boolean.
     *
     * @param oArea the o area
     * @return success or fail (boolean)
     */
    public boolean validaAreaAtividade(AreaAtividade oArea)
    {
       return !(this.list.getAreaAtividadeList().contains(oArea));
    }


    /**
     * Gets areas atividade.
     *
     * @return the areas atividade
     */
    public List<AreaAtividade> getAreasAtividade()
    {
        return this.list.getAreaAtividadeList();
    }
}
