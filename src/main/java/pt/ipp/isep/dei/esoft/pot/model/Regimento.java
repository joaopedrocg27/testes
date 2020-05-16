package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.Seriacao.Algoritmo1;
import pt.ipp.isep.dei.esoft.pot.Seriacao.Algoritmo2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Regimento.
 */
public abstract class Regimento implements Serializable {
    private int Id;
    private String desc;
    private String nome;
    private Algoritmo1 algoritmo1 ;
    private Algoritmo2 algoritmo2;
    private List<Object> algs;

    /**
     * Instantiates a new Regimento.
     *
     * @param id   the id
     * @param desc the desc
     * @param nome the nome
     */
    public Regimento(int id, String desc, String nome) {
        if ( (desc == null) || (nome == null) || (desc.isEmpty()) || (nome.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio");
        this.Id = id;
        this.desc = desc;
        this.nome = nome;
    }



    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return Id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int  id) {
        Id = id;
    }

    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets desc.
     *
     * @param desc the desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Regimento:" +
                "Id='" + Id + '\'' +
                ", descrição='" + desc + '\'' +
                ", título='" + nome + '\'' +
                '}';
    }
   public abstract List<Candidatura> Seriar (Anuncio a);

}
