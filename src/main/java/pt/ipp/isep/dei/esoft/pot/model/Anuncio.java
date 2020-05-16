package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.model.Listas.lstCandidatura;

import java.util.Date;

/**
 * The type Anuncio.
 */
public class Anuncio {
    private Colaborador c;
    private Tarefa tarefa;
    private Date dtIniP;
    private Date dtFimP;
    private Date dtIniC;
    private Date dtFimC;
    private Date dtIniS;
    private Date dtFimS;
    private Regimento regTR;
    private lstCandidatura list;

    /**
     * Instantiates a new Anuncio.
     *
     * @param c      the c
     * @param tarefa the tarefa
     * @param dtIniP the date ini publicacao
     * @param dtFimP the date fim publicacao
     * @param dtIniC the date ini apresentação de candidaturas
     * @param dtFimC the date fim apresentação de candidaturas
     * @param dtIniS the date ini seriação
     * @param dtFimS the date fim seriação
     * @param regTR  the  regimento
     */
    public Anuncio(Colaborador c, Tarefa tarefa, Date dtIniP, Date dtFimP, Date dtIniC, Date dtFimC, Date dtIniS, Date dtFimS, Regimento regTR) {
        if ( (c == null) || (tarefa == null) || (dtIniP == null) ||(dtFimP == null) ||(dtIniC == null) ||(dtFimC == null) ||(dtIniS == null) ||(dtFimS == null)||(regTR == null)  )
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio");
        this.c = c;
        this.tarefa = tarefa;
        this.dtIniP = dtIniP;
        this.dtFimP = dtFimP;
        this.dtIniC = dtIniC;
        this.dtFimC = dtFimC;
        this.dtIniS = dtIniS;
        this.dtFimS = dtFimS;
        this.regTR = regTR;
        this.list=new lstCandidatura();
    }

    @Override
    public String toString() {
        return "" +
                "Colaborador=" + c.toString() +
                ", Tarefa=" + tarefa.toString() +
                ", data inicial de publicitação=" + dtIniP.toString() +
                ", data final de publicitação=" + dtFimP.toString() +
                ", data inicial de apresentação de candidaturas=" + dtIniC.toString() +
                ", data final de apresentação de candidaturas=" + dtFimC.toString() +
                ", data inicial de seriação=" + dtIniS.toString() +
                ", data final de seriação=" + dtFimS.toString() +
                ", " + regTR.toString() +
                '}';
    }

    /**
     * Get dt fim c date.
     *
     * @return the date
     */
    public Date getDtFimC (){
        return this.dtFimC;
    }

    /**
     * Get tarefa tarefa.
     *
     * @return the tarefa
     */
    public Tarefa getTarefa(){
        return this.tarefa;
    }

    /**
     * E freelancer elegivel boolean.
     *
     * @param free the free
     * @return the boolean
     */
    public boolean eFreelancerElegivel(Freelancer free){
        for (CaraterCT ct:this.getTarefa().getCCtList()){
            if (!VerificarCaracterCT(free,ct)){
                return false;
            }
        }
        return true;
    }

    /**
     * Verificar caracter ct boolean.
     *
     * @param free the free
     * @param ct   the ct
     * @return success or fail (boolean)
     */
    public boolean VerificarCaracterCT(Freelancer free,CaraterCT ct){
        if (ct.isObg()){
            if (free.getListCT().contains(ct.getCt())){
                for (ReconhecimentoCompetenciaTecnica rct : free.getListRCT()){
                    if (rct.getCt().equals(ct.getCt())){
                        return  (rct.getGp().getValor()>=ct.getGp().getValor());

                    }
                }
            }
            return false;
        }
        return true;
    }

    /**
     * Aceita candidatura boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean aceitaCandidatura(){
        Date dataAtual = new Date();
        return dataAtual.before(this.dtFimC);
    }

    /**
     * Gets c.
     *
     * @return the c
     */
    public Colaborador getC() {
        return c;
    }

    /**
     * Valida categoria boolean.
     *
     * @param cand the cand
     * @return success or fail (boolean)
     */
    public boolean validaCategoria(Candidatura cand){
        return !this.list.getCandidaturaList().contains(cand);
    }

    /**
     * Get list lst candidatura.
     *
     * @return the lst candidatura
     */
    public lstCandidatura getList(){
        return this.list;
    }

    /**
     * Add candidatura boolean.
     *
     * @param cand the cand
     * @return the boolean
     */
    public boolean addCandidatura(Candidatura cand){
        return this.list.add(cand);
    }

    /**
     * Regista candidatura boolean.
     *
     * @param cand the cand
     * @return the boolean
     */
    public boolean registaCandidatura(Candidatura cand){
        if (this.validaCategoria(cand)){
            return this.addCandidatura(cand);
        }
        return false;
    }

    public Regimento getRegTR() {
        return regTR;
    }


}
