package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.CaraterCT;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Lst caracter ct.
 */
public class lstCaracterCT implements Serializable {
    private final Set<CaraterCT> list;

    /**
     * Instantiates a new Lst caracter ct.
     */
    public lstCaracterCT(){
        this.list=new HashSet<>();
    }

    /**
     * Add boolean.
     *
     * @param ct the ct
     * @return success or fail (boolean)
     */
    public boolean add(CaraterCT ct){
        return this.list.add(ct);
    }

    /**
     * Get caracter ct list list.
     *
     * @return the list
     */
    public List<CaraterCT> getCaracterCTList(){
        ArrayList <CaraterCT> ct = new ArrayList<>(this.list);
        return ct;
    }
}
