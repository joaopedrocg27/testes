package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.Colaborador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Lst colab.
 */
public class lstColab implements Serializable {
    private final Set<Colaborador> m_lstListaColaboradores;

    /**
     * Instantiates a new Lst colab.
     */
    public lstColab() {
        this.m_lstListaColaboradores = new HashSet<>();
    }

    /**
     * Gets colaborador by email.
     *
     * @param email the email
     * @return the colaborador by email
     */
    public Colaborador getColaboradorByEmail(String email) {
        for(Colaborador colab : this.m_lstListaColaboradores){
            if(colab.getEmail().equals(email)){
                return colab;
            }
        }
        return null;
    }

    /**
     * Add boolean.
     *
     * @param colab the colab
     * @return success or fail (boolean)
     */
    public boolean add(Colaborador colab){
        return this.m_lstListaColaboradores.add(colab);
    }

    /**
     * Get colaboradores list.
     *
     * @return the list
     */
    public List<Colaborador> getColaboradores(){
        ArrayList<Colaborador> co = new ArrayList<>(this.m_lstListaColaboradores);
        return co;
    }


}
