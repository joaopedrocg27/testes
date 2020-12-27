package pt.ipp.isep.dei.esoft.pot.model.Registo;



import pt.ipp.isep.dei.esoft.pot.Seriacao.Algoritmo1;
import pt.ipp.isep.dei.esoft.pot.Seriacao.Algoritmo2;
import pt.ipp.isep.dei.esoft.pot.model.Regimento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Registo tipos regimento.
 */
public class RegistoTiposRegimento implements Serializable {

    private final List<Regimento> ListTiposRegimento;


    /**
     * Instantiates a new Registo tipos regimento.
     *
     */
    public RegistoTiposRegimento()  {
        this.ListTiposRegimento = new ArrayList<>();

    }
    public void novoRegimento(int ID,String desc,String nome) {
        switch (ID){
            case 1:
                this.getListTiposRegimento().add(new Algoritmo1(ID,desc,nome));
                break;
            case 2:
                this.getListTiposRegimento().add(new Algoritmo2(ID,desc,nome));
                break;
        }

    }
    public List<Regimento> getListTiposRegimento(){
        return this.ListTiposRegimento;
    }
    public Regimento getRegimentoByID(int ID){
        return this.ListTiposRegimento.get(ID-1);
    }



}
