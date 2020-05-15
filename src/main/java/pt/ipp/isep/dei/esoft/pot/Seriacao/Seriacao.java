package pt.ipp.isep.dei.esoft.pot.Seriacao;

import pt.ipp.isep.dei.esoft.pot.model.GrauProficiencia;

import java.util.Date;

/**
 * The type Seriacao.
 */
public class Seriacao {
    private int numeroRegimeno;
    private String nome;
    private Object seriacaoObj;

    /**
     * Instantiates a new Seriacao.
     *
     * @param numeroRegimeno the numero regimeno
     * @param nome           the nome
     */
    public Seriacao(int numeroRegimeno,String nome) {
        this.numeroRegimeno = numeroRegimeno;
        this.nome = nome;
    }

    /**
     * Gets numero regimeno.
     *
     * @return the numero regimeno
     */
    public int getNumeroRegimeno() {
        return numeroRegimeno;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    public String toString(){
        return this.nome;
    }

    /**
     * Sets seriacao obj.
     *
     * @param seriacaoObj the seriacao obj
     */
    public void setSeriacaoObj(Object seriacaoObj) {
        this.seriacaoObj = seriacaoObj;
    }

    /**
     * Gets seriacao obj.
     *
     * @return the seriacao obj
     */
    public Object getSeriacaoObj() {
        return seriacaoObj;
    }
}
