package pt.ipp.isep.dei.esoft.pot.model.Registo;

import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Categoria;


import java.io.Serializable;
import java.util.*;

/**
 * The type Registo categorias.
 */
public class RegistoCategorias implements Serializable {
    private Categoria oCat;
    private final List<Categoria> list;

    /**
     * Instantiates a new Registo categorias.
     */
    public RegistoCategorias() {
        this.list = new ArrayList<Categoria>() {
        };
    }


    /**
     * Nova categoria categoria.
     *
     * @param m_strDescricao   the m str descricao
     * @param m_oAreaAtividade the m o area atividade
     * @return the categoria
     */
    public Categoria novaCategoria(String m_strDescricao, AreaAtividade m_oAreaAtividade)
    {
        return new Categoria(geraCategoriaId(m_strDescricao),m_strDescricao,m_oAreaAtividade);
    }

    /**
     * Regista categoria boolean.
     *
     * @param oCat the o cat
     * @return success or fail (boolean)
     */
    public boolean registaCategoria(Categoria oCat)
    {
        if (this.validaCategoria(oCat))
        {
            return addCategoria(oCat);
        }
        return false;
    }

    /**
     * Get categoria by id categoria.
     *
     * @param catId the cat id
     * @return the categoria
     */
    public Categoria getCategoriaById(String catId){
        for (Categoria cat : list) {
            if (cat.getId().equals(catId)) {
                return cat;
            }
        }
        return null;
        }

    private boolean addCategoria(Categoria oCat)
    {
        return list.add(oCat);
    }

    /**
     * Valida categoria boolean.
     *
     * @param oCat the o cat
     * @return success or fail (boolean)
     */
    public boolean validaCategoria(Categoria oCat) {
        return !(this.list.contains(oCat));
    }

    /**
     * Gera categoria id string.
     *
     * @param m_strDescricao the m str descricao
     * @return the string
     */
    public String geraCategoriaId(String m_strDescricao){
            int hash = 7;
            hash = 23 * hash + Objects.hashCode(m_strDescricao);
            String hash2 = String.valueOf(hash);
            return hash2;

    }

    /**
     * Gets categorias.
     *
     * @return the categorias
     */
    public List<Categoria> getCategorias()
    {
        return this.list;
    }

}

