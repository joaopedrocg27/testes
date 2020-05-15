package pt.ipp.isep.dei.esoft.pot.model.Listas;


import pt.ipp.isep.dei.esoft.pot.model.GrauProficiencia;

import java.io.Serializable;
import java.util.*;

/**
 * The type Lgraus.
 */
public class lgraus implements Serializable {
    private final Set<GrauProficiencia> list_Gp;

    /**
     * Instantiates a new Lgraus.
     */
    public lgraus(){
        this.list_Gp=new HashSet<>();
    }

    /**
     * Add boolean.
     *
     * @param grauProf the grau prof
     * @return success or fail (boolean)
     */
    public boolean add(GrauProficiencia grauProf){
        return this.list_Gp.add(grauProf);
    }

    /**
     * Gets grau proficiencia by valor.
     *
     * @param valor the valor
     * @return the grau proficiencia by valor
     */
    public GrauProficiencia getGrauProficienciaByValor(int valor)
    {
        ArrayList<GrauProficiencia> gp = new ArrayList<>(this.list_Gp);
        Collections.sort(gp);
       if (valor >= gp.size()){
           return null;
       }else{
           return gp.get(valor);
       }
    }

    /**
     * Get grau proficiencia list array list.
     *
     * @return the array list
     */
    public ArrayList<GrauProficiencia> getGrauProficienciaList(){
        ArrayList<GrauProficiencia> gp = new ArrayList<>(this.list_Gp);
        Collections.sort(gp);
        return gp;
    }


}
