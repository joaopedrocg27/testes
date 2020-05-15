package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Candidatura.
 */
public class Candidatura implements Serializable {
    private Freelancer free;
    private Date data;
    private double valorPretendido;
    private int nrDeDias;
    private String txtApres;
    private String txtMotiv;

    /**
     * Instantiates a new Candidatura.
     *
     * @param free            the free
     * @param data            the data
     * @param valorPretendido the valor pretendido
     * @param nrDeDias        the nr de dias
     * @param txtApres        the txt apres
     * @param txtMotiv        the txt motiv
     */
    public Candidatura(Freelancer free, Date data, double valorPretendido, int nrDeDias, String txtApres, String txtMotiv) {
        this.free = free;
        this.data = data;
        this.valorPretendido = valorPretendido;
        this.nrDeDias = nrDeDias;
        this.txtApres = txtApres;
        this.txtMotiv = txtMotiv;
    }

    /**
     * Instantiates a new Candidatura.
     *
     * @param free            the free
     * @param data            the data
     * @param valorPretendido the valor pretendido
     * @param nrDeDias        the nr de dias
     */
    public Candidatura(Freelancer free, Date data, double valorPretendido, int nrDeDias) {
        this.free = free;
        this.data = data;
        this.valorPretendido = valorPretendido;
        this.nrDeDias = nrDeDias;
    }

    @Override
    public String toString() {
        return "Candidatura{" +
                "free=" + free +
                ", data=" + data +
                ", valorPretendido=" + valorPretendido +
                ", nrDeDias=" + nrDeDias +
                ", txtApres='" + txtApres + '\'' +
                ", txtMotiv='" + txtMotiv + '\'' +
                '}';
    }
}
