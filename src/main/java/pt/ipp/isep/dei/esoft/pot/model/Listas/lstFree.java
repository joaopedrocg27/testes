package pt.ipp.isep.dei.esoft.pot.model.Listas;


import pt.ipp.isep.dei.esoft.pot.model.Freelancer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Lst free.
 */
public class lstFree implements Serializable {
    private final Set<Freelancer> m_Freelancer;

    /**
     * Instantiates a new Lst free.
     */
    public lstFree(){
        this.m_Freelancer = new HashSet<>();
    }

    /**
     * Get freelancer list array list.
     *
     * @return the array list
     */
    public ArrayList<Freelancer> getFreelancerList(){
        ArrayList<Freelancer> freeList = new ArrayList<>(m_Freelancer);
        return freeList;
    }

    /**
     * Add boolean.
     *
     * @param free the free
     * @return the boolean
     */
    public boolean add(Freelancer free){
        return this.m_Freelancer.add(free);
    }
}
