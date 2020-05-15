package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Grau proficiencia.
 */
public class GrauProficiencia implements Serializable,Comparable<GrauProficiencia> {
    private String designacao;
    private int valor;

    /**
     * Instantiates a new Grau proficiencia.
     *
     * @param valor      the valor
     * @param designacao the designacao
     */
    public GrauProficiencia(int valor,String designacao ) {
        this.designacao = designacao;
        this.valor = valor;
    }

    /**
     * Gets designacao.
     *
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Sets designacao.
     *
     * @param designacao the designacao
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Gets valor.
     *
     * @return the valor
     */
    public int getValor() {
        return this.valor;
    }

    /**
     * Sets valor.
     *
     * @param valor the valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "GrauProficiencia{" +
                "designacao='" + designacao + '\'' +
                ", valor=" + valor +
                '}';
    }

    @Override
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
            GrauProficiencia obj = (GrauProficiencia) o;
            return (Objects.equals(designacao, obj.designacao));

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.designacao);
        return hash;
    }

    @Override
    public int compareTo(GrauProficiencia o) {
        return this.valor - o.getValor();
    }
}
