package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.Organizacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Lista organizacao.
 */
public class ListaOrganizacao implements Serializable {
    private final Set<Organizacao> list;

    /**
     * Instantiates a new Lista organizacao.
     */
    public ListaOrganizacao(){
        this.list = new HashSet<>();
    }

    /**
     * Add boolean.
     *
     * @param org the org
     * @return success or fail (boolean)
     */
    public boolean add (Organizacao org){
        return this.list.add(org);
    }

    /**
     * Get organizacao list list.
     *
     * @return the list
     */
    public List<Organizacao> getOrganizacaoList(){
        ArrayList<Organizacao> orgList = new ArrayList<>(this.list);
        return orgList;
    }
}
