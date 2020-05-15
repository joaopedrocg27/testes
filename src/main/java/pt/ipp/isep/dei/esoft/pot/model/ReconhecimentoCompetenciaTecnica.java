package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Reconhecimento competencia tecnica.
 */
public class ReconhecimentoCompetenciaTecnica  implements Serializable  {
    private CompetenciaTecnica ct;
    private Date data;
    private GrauProficiencia gp;

    /**
     * Instantiates a new Reconhecimento competencia tecnica.
     *
     * @param ct the ct
     * @param gp the gp
     */
    public ReconhecimentoCompetenciaTecnica(CompetenciaTecnica ct, GrauProficiencia gp) {
        this.ct = ct;
        this.gp = gp;
        this.data = new Date();
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

}
