package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.HabilitacaoAcademica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Lst hab acad.
 */
public class lstHabAcad implements Serializable {
    private final Set<HabilitacaoAcademica> list_HabAc;

    /**
     * Instantiates a new Lst hab acad.
     */
    public lstHabAcad(){
        this.list_HabAc=new HashSet<>();
    }

    /**
     * Add boolean.
     *
     * @param hab the hab
     * @return the boolean
     */
    public boolean add(HabilitacaoAcademica hab){
        return this.list_HabAc.add(hab);
    }

    /**
     * Get habilitacao academica list array list.
     *
     * @return the array list
     */
    public ArrayList<HabilitacaoAcademica> getHabilitacaoAcademicaList(){
        ArrayList<HabilitacaoAcademica> habList = new ArrayList<>(this.list_HabAc);
        return habList;
    }
}
