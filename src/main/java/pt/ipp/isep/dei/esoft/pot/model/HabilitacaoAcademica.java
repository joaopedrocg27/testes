package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;

/**
 * The type Habilitacao academica.
 */
public class HabilitacaoAcademica implements Serializable {
    private final String grau;
    private final String design;
    private final String inst;
    private final double media;

    /**
     * Instantiates a new Habilitacao academica.
     *
     * @param grau   the grau
     * @param design the design
     * @param inst   the inst
     * @param media  the media
     */
    public HabilitacaoAcademica(String grau, String design, String inst, double media) {
        this.grau = grau;
        this.design = design;
        this.inst = inst;
        this.media = media;
    }
}
