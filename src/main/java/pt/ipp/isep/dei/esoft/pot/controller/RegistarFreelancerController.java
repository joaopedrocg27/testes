package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoCT;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoFreelancer;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Registar freelancer controller.
 */
public class RegistarFreelancerController implements Serializable {
    private final Plataforma m_oPlataforma;
    private final RegistoFreelancer registFree;
    private Freelancer free;
    private HabilitacaoAcademica hab;
    private final RegistoCT reg_CT;
    private CompetenciaTecnica ct;
    private GrauProficiencia gp;
    private final AutorizacaoFacade af;
    private ReconhecimentoCompetenciaTecnica recon;

    /**
     * Instantiates a new Registar freelancer controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public RegistarFreelancerController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.af=m_oPlataforma.getAutorizacaoFacade();
        this.registFree = m_oPlataforma.getM_oRegistoFreelancer();
        this.reg_CT = m_oPlataforma.getM_oRegistoCompetenciaTecnica();
    }

    /**
     * Gets af.
     *
     * @return the af
     */
    public AutorizacaoFacade getAf() {
        return af;
    }

    /**
     * Novo freelancer boolean.
     *
     * @param nome         the nome
     * @param nif          the nif
     * @param email        the email
     * @param telefone     the telefone
     * @param localidade   the localidade
     * @param codigoPostal the codigo postal
     * @param local        the local
     * @return the boolean
     */
    public boolean novoFreelancer(String nome, String nif, String email, String telefone, String localidade, String codigoPostal, String local){
        try{
            this.free = this.registFree.novoFreelancer(nome, nif, email, telefone, localidade, codigoPostal, local);
            return this.registFree.validaFreelancer(this.free);
        }catch (RuntimeException ex){
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.free = null;
            return false;
        }
    }

    /**
     * Gets plataforma.
     *
     * @return the  plataforma
     */
    public Plataforma getM_oPlataforma() {
        return m_oPlataforma;
    }

    /**
     * Gets regist free.
     *
     * @return the regist freelancer
     */
    public RegistoFreelancer getRegistFree() {
        return registFree;
    }

    /**
     * Regista freelancer boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaFreelancer(){
        return this.registFree.registaFreelancer(free);
    }

    /**
     * Nova habilitacao academica boolean.
     *
     * @param grau   the grau
     * @param design the design
     * @param inst   the inst
     * @param media  the media
     * @return success or fail (boolean)
     */
    public boolean novaHabilitacaoAcademica(String grau,String design,String inst,double media){
        try{
            this.hab = this.free.novaHabilitacaoAcademica(grau,design,inst,media);
            return this.free.validaHabilitacaoAcademica(this.hab);
        }catch (RuntimeException ex){
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.hab = null;
            return false;
        }
    }

    /**
     * Regista habilitacao academica boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaHabilitacaoAcademica(){
        return this.free.registaHabilitacaoAcademica(this.hab);
    }

    /**
     * Get ct list list.
     *
     * @return the list
     */
    public List<CompetenciaTecnica> getCTList(){
        return this.reg_CT.getCTList();
    }

    /**
     * Get freelancer to string string.
     *the boolean
     * @return the string
     */
    public String getFreelancerToString(){
        return this.free.toString();
    }

    /**
     * Novo reconhecimento competencia tecnica boolean.
     *
     * @param strID the str id
     * @param valor the valor
     * @return success or fail (boolean)
     */
    public boolean novoReconhecimentoCompetenciaTecnica(String strID, int valor){
        try{
            this.ct=this.reg_CT.getCompetenciaTecnicaById(strID);
            this.gp = this.ct.getGrauProficienciaByValor(valor);
            this.recon = this.free.novoReconhecimentoCompetenciaTecnica(this.ct,this.gp);
            return this.free.validaReconhecimentoCompetenciaTecnica(this.recon);
        }catch (RuntimeException ex){
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.recon= null;
            return false;
        }
    }

    /**
     * Regista reconhecimento competencia tecnica boolean.
     *
     * @return the boolean
     */
    public boolean registaReconhecimentoCompetenciaTecnica(){
        return this.free.registaReconhecimentoCompetenciaTecnica(this.recon);
    }


}
