package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Regimento.
 */
public class Regimento implements Serializable {
    private String Id;
    private String desc;
    private String nome;
    private List <Regimento> m_lstTiposRegimento ;

    /**
     * Instantiates a new Regimento.
     *
     * @param id   the id
     * @param desc the desc
     * @param nome the nome
     */
    public Regimento(String id, String desc, String nome) {
        if ( (Id == null) || (desc == null) || (nome == null) || (Id.isEmpty())|| (desc.isEmpty()) || (nome.isEmpty()))
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
    public String getId() {
        return Id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
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


}
