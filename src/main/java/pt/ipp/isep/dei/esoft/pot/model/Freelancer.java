package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.model.Listas.lstHabAcad;
import pt.ipp.isep.dei.esoft.pot.model.Listas.lstRecon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Freelancer.
 */
public class Freelancer implements Serializable {
    private final String nome;
    private final String nif;
    private final String email;
    private final String telefone;
    private final EnderecoPostal end;
    private final lstHabAcad list;
    private final lstRecon reconList;

    /**
     * Instantiates a new Freelancer.
     *
     * @param nome         the nome
     * @param nif          the nif
     * @param email        the email
     * @param telefone     the telefone
     * @param localidade   the localidade
     * @param codigoPostal the codigo postal
     * @param local        the local
     */
    public Freelancer(String nome, String nif, String email, String telefone,String localidade,String codigoPostal,String local) {
        this.nome = nome;
        this.nif = nif;
        this.email = email;
        this.telefone = telefone;
        this.end = new EnderecoPostal(local,codigoPostal,localidade);
        this.list = new lstHabAcad();
        this.reconList = new lstRecon();
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
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Add habilitacao academica boolean.
     *
     * @param hab the hab
     * @return the boolean
     */
    public boolean addHabilitacaoAcademica (HabilitacaoAcademica hab){
        return this.list.add(hab);
    }

    /**
     * Nova habilitacao academica habilitacao academica.
     *
     * @param grau   the grau
     * @param design the design
     * @param inst   the inst
     * @param media  the media
     * @return the habilitacao academica
     */
    public HabilitacaoAcademica novaHabilitacaoAcademica(String grau,String design , String inst,double media){
        return new HabilitacaoAcademica(grau,design,inst,media);
    }

    /**
     * Valida habilitacao academica boolean.
     *
     * @param hab the hab
     * @return the boolean
     */
    public boolean validaHabilitacaoAcademica (HabilitacaoAcademica hab){
        return !(this.list.getHabilitacaoAcademicaList().contains(hab));
    }

    /**
     * Regista habilitacao academica boolean.
     *
     * @param hab the hab
     * @return the boolean
     */
    public boolean registaHabilitacaoAcademica(HabilitacaoAcademica hab){
        if (this.validaHabilitacaoAcademica(hab)){
            return this.addHabilitacaoAcademica(hab);
        }else{
            return false;
        }
    }

    /**
     * Get list rct list.
     *
     * @return the list
     */
    public List<ReconhecimentoCompetenciaTecnica> getListRCT(){
        return this.reconList.getReconhecimentoCompetenciaTecnicaList();
    }

    /**
     * Get list ct list.
     *
     * @return the list
     */
    public List<CompetenciaTecnica> getListCT(){
        ArrayList<CompetenciaTecnica> ctList = new ArrayList<>();
        for (ReconhecimentoCompetenciaTecnica rct: this.reconList.getReconhecimentoCompetenciaTecnicaList()){
            ctList.add(rct.getCt());
        }
        return ctList;
    }

    /**
     * Add reconhecimento competencia tecnica boolean.
     *
     * @param recon the recon
     * @return the boolean
     */
    public boolean addReconhecimentoCompetenciaTecnica(ReconhecimentoCompetenciaTecnica recon){
        return this.reconList.add(recon);
    }

    /**
     * Novo reconhecimento competencia tecnica reconhecimento competencia tecnica.
     *
     * @param ct the ct
     * @param gp the gp
     * @return the reconhecimento competencia tecnica
     */
    public ReconhecimentoCompetenciaTecnica novoReconhecimentoCompetenciaTecnica(CompetenciaTecnica ct,GrauProficiencia gp){
        return new ReconhecimentoCompetenciaTecnica (ct,gp);
    }

    /**
     * Regista reconhecimento competencia tecnica boolean.
     *
     * @param recon the recon
     * @return the boolean
     */
    public boolean registaReconhecimentoCompetenciaTecnica(ReconhecimentoCompetenciaTecnica recon){
        if (this.validaReconhecimentoCompetenciaTecnica(recon)){
            return this.addReconhecimentoCompetenciaTecnica(recon);
        }else {
            return false;
        }
    }

    /**
     * Valida reconhecimento competencia tecnica boolean.
     *
     * @param recon the recon
     * @return the boolean
     */
    public boolean validaReconhecimentoCompetenciaTecnica(ReconhecimentoCompetenciaTecnica recon){
        return (!this.reconList.getReconhecimentoCompetenciaTecnicaList().contains(recon));
    }
    public String toString(){
        return this.nome;
    }
}
