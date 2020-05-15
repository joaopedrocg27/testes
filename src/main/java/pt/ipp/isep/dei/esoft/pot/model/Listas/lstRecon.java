package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.ReconhecimentoCompetenciaTecnica;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Lst recon.
 */
public class lstRecon implements Serializable {
    private final Set<ReconhecimentoCompetenciaTecnica> reconList;

    /**
     * Instantiates a new Lst recon.
     */
    public lstRecon(){
        this.reconList = new HashSet<>();
    }

    /**
     * Get reconhecimento competencia tecnica list array list.
     *
     * @return the array list
     */
    public ArrayList<ReconhecimentoCompetenciaTecnica> getReconhecimentoCompetenciaTecnicaList(){
        ArrayList<ReconhecimentoCompetenciaTecnica> recon = new ArrayList<>(reconList);
        return recon;
    }

    /**
     * Add boolean.
     *
     * @param recon the recon
     * @return success or fail (boolean)
     */
    public boolean add(ReconhecimentoCompetenciaTecnica recon){
        return this.reconList.add(recon);
    }
}
