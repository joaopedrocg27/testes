package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;

/**
 * The type Carater ct.
 */
public class CaraterCT implements Serializable {
    private final CompetenciaTecnica ct;
    private final GrauProficiencia gp;
    private final boolean obg;

    /**
     * Instantiates a new Carater ct.
     *
     * @param ct  the ct
     * @param gp  the gp
     * @param obg the obg
     */
    public CaraterCT(CompetenciaTecnica ct, GrauProficiencia gp, boolean obg) {
        this.ct = ct;
        this.gp = gp;
        this.obg = obg;
    }

    /**
     * Gets ct.
     *
     * @return the ct
     */
    public CompetenciaTecnica getCt() {
        return ct;
    }

    /**
     * Gets gp.
     *
     * @return the gp
     */
    public GrauProficiencia getGp() {
        return gp;
    }

    /**
     * Is obg boolean.
     *
     * @return the boolean
     */
    public boolean isObg() {
        return obg;
    }
}
