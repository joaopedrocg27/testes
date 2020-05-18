package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;

import java.io.Serializable;
import java.util.*;

/**
 * The type Lst candidatura.
 */
public class lstCandidatura implements Serializable {
    private final Set<Candidatura> list;

    /**
     * Instantiates a new Lst candidatura.
     */
    public lstCandidatura(){
        this.list = new HashSet<>();
    }

    /**
     * Add boolean.
     *
     * @param cand the cand
     * @return success or fail (boolean)
     */
    public boolean add(Candidatura cand){
        return this.list.add(cand);
    }

    /**
     * Valida cand boolean.
     *
     * @param cand the cand
     * @return success or fail (boolean)
     */
    public boolean validaCand(Candidatura cand){
        return !this.list.contains(cand);
    }

    /**
     * Get candidatura list list.
     *
     * @return the list
     */
    public List<Candidatura> getCandidaturaList(){
        return new ArrayList<>(this.list);
    }

    /**
     * Nova candidatura candidatura.
     *
     * @param free            the free
     * @param dataAtual       the data atual
     * @param valorPretendido the valor pretendido
     * @param nDias           the n dias
     * @param txtApres        the txt apres
     * @param txtMotiv        the txt motiv
     * @return the candidatura
     */
    public Candidatura novaCandidatura(Freelancer free, Date dataAtual, double valorPretendido, int nDias, String txtApres, String txtMotiv){
        return new Candidatura(free,dataAtual,valorPretendido,nDias,txtApres,txtMotiv);
    }

}
