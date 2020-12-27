package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAnuncio;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoFreelancer;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Efetuar candidatura controller.
 */
public class EfetuarCandidaturaController implements Serializable {
    private final Plataforma plataforma;
    private final RegistoFreelancer reg_Free;
    private final AplicacaoPOT app;
    private final SessaoUtilizador sessao;
    private final Freelancer free;
    private Candidatura cand;
    private final RegistoAnuncio reg_Anun;
    private final ArrayList<Anuncio> anuncioEligiveis;
    private Anuncio anum;

    /**
     * Instantiates a new Efetuar candidatura controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EfetuarCandidaturaController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.plataforma = AplicacaoPOT.getInstance().getPlataforma();



        this.reg_Free = this.plataforma.getM_oRegistoFreelancer();
        this.app=AplicacaoPOT.getInstance();
        this.sessao=this.app.getSessaoAtual();
        String email = this.sessao.getEmailUtilizador();
        this.free = this.reg_Free.getFreelancerByEmail(email);
        this.reg_Anun = this.plataforma.getRegistoAnuncios();
        this.anuncioEligiveis = this.reg_Anun.getAnunciosEligiveisDoFreelancer(free);

    }

    /**
     * Instantiates a new Efetuar candidatura controller.
     *
     * @param email the email
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EfetuarCandidaturaController (String email) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.plataforma = AplicacaoPOT.getInstance().getPlataforma();



        this.reg_Free = this.plataforma.getM_oRegistoFreelancer();
        this.app=AplicacaoPOT.getInstance();
        this.sessao=this.app.getSessaoAtual();
        this.free = this.reg_Free.getFreelancerByEmail(email);
        this.reg_Anun = this.plataforma.getRegistoAnuncios();
        this.anuncioEligiveis = this.reg_Anun.getAnunciosEligiveisDoFreelancer(free);
    }

    /**
     * Gets plataforma.
     *
     * @return the plataforma
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     * Gets reg anun.
     *
     * @return the reg anun
     */
    public RegistoAnuncio getReg_Anun() {
        return reg_Anun;
    }

    /**
     * Nova candidatura boolean.
     *
     * @param anuncioID     the anuncio id
     * @param valorEsperado the valor esperado
     * @param numeroDeDias  the numero de dias
     * @param txtApres      the txt apres
     * @param txtMotiv      the txt motiv
     * @return the boolean
     */
    public boolean novaCandidatura (String anuncioID, double valorEsperado, int numeroDeDias, String txtApres, String txtMotiv,Date data){
        try {
            this.anum=this.reg_Anun.getAnuncioByID(anuncioID);
            if (this.anum.eFreelancerElegivel(this.free)&&this.anum.aceitaCandidatura()){
                this.cand = this.anum.getList().novaCandidatura(this.free,data,valorEsperado,numeroDeDias,txtApres,txtMotiv);
                return this.anum.getList().validaCand(cand);
            }else{
                return false;
            }
        }catch (RuntimeException ex){
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.cand=null;
            return false;
        }
    }

    /**
     * Regista candidatura boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaCandidatura(){
        if (this.anum.eFreelancerElegivel(this.free)&&this.anum.aceitaCandidatura()){
            return this.anum.registaCandidatura(this.cand);
        }
        return false;
    }

    /**
     * Get anuncios eligiveis list.
     *
     * @return the list
     */
    public List<Anuncio> getAnunciosEligiveis(){
        return this.anuncioEligiveis;
    }

    /**
     * Get candidatura to string string.
     *
     * @return the string
     */
    public String getCandidaturaToString(){
        return this.cand.toString();
    }
}
