package  pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Tarefa.
 */
public class Tarefa implements Serializable {
    private String ref;
    private String des;
    private String descInfo;
    private String descTec;
    private int estimCusto;
    private int estDura;
    private Categoria cat;
    private Colaborador colab;

    /**
     * Instantiates a new Tarefa.
     *
     * @param ref        the ref
     * @param des        the des
     * @param descInfo   the desc info
     * @param descTec    the desc tec
     * @param estimCusto the estim custo
     * @param estDura    the est dura
     * @param cat        the cat
     */
    public Tarefa(String ref, String des, String descInfo, String descTec, int estimCusto, int estDura, Categoria cat) {

        if((ref==null || ref.isEmpty() )|| (des.isEmpty()||des==null) || (descInfo.isEmpty()||descInfo==null)|| (descTec.isEmpty()||descTec==null)
                || (estDura==0)|| (estDura==0))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio");

        this.ref = ref;
        this.des = des;
        this.descInfo = descInfo;
        this.descTec = descTec;
        this.estimCusto = estimCusto;
        this.estDura = estDura;
        this.cat = cat;
    }
    public String toString(){
        return "referência única por organização='" + ref + '\'' + ", designação='" + des + '\'' + ", descrição informal='" + descInfo + '\'' + ", descrição tecnica='" + descTec + '\'' + ", estimativa de Custo=" + estimCusto + ", estimativa de duracção=" + estDura + '}';
    }

    /**
     * Set colab.
     *
     * @param colab the colab
     */
    public void setColab(Colaborador colab){
        this.colab=colab;
    }

    /**
     * Get colab colaborador.
     *
     * @return the colaborador
     */
    public Colaborador getColab(){
        return this.colab;
    }

    /**
     * Gets ref.
     *
     * @return the ref
     */
    public String getRef() {
        return ref;
    }

    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Tarefa obj = (Tarefa) o;
        return (Objects.equals(getColab(), obj.getColab()));
    }

    /**
     * Get c ct list list.
     *
     * @return the list
     */
    public List<CaraterCT> getCCtList(){
        return this.cat.getCaracterCTList();
    }

}
