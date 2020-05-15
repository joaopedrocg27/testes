package pt.ipp.isep.dei.esoft.pot.model.Registo;

import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Listas.ListaTarefa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Registo anuncio.
 */
public class RegistoAnuncio implements Serializable {
    private Tarefa tar;
    private List<Anuncio> lAnuncio;
    private Date dtIniP;
    private Date dtFimP;
    private Date dtIniC;
    private Date dtFimC;
    private Date dtIniS;
    private Date dtFimS;
    private Regimento regTR;

    /**
     * Instantiates a new Registo anuncio.
     */
    public RegistoAnuncio(){
        this.lAnuncio = new ArrayList<>();
    }


    /**
     * Novo anuncio anuncio.
     *
     * @param c      the c
     * @param tarefa the tarefa
     * @param dtIniP the dt ini p
     * @param dtFimP the dt fim p
     * @param dtIniC the dt ini c
     * @param dtFimC the dt fim c
     * @param dtIniS the dt ini s
     * @param dtFimS the dt fim s
     * @param regT   the reg t
     * @return the anuncio
     */
    public Anuncio novoAnuncio(Colaborador c, Tarefa tarefa, Date dtIniP, Date dtFimP, Date dtIniC, Date dtFimC, Date dtIniS, Date dtFimS, Object regT) {
       return new Anuncio( c,  tarefa,  dtIniP,  dtFimP,  dtIniC,  dtFimC,  dtIniS,  dtFimS,  regT);
    }

    /**
     * Valida anuncio boolean.
     *
     * @param anuncio the anuncio
     * @return the boolean
     */
    public boolean validaAnuncio(Anuncio anuncio){
        return !this.lAnuncio.contains(anuncio);
    }

    /**
     * Regista anuncio boolean.
     *
     * @param anu the anu
     * @return success or fail (boolean)
     */
    public boolean registaAnuncio(Anuncio anu){
        boolean a = validaAnuncio(anu);
        //tar.publicar(anu);
        lAnuncio.add(anu);
    return a;
    }

    /**
     * Get anuncios eligiveis do freelancer array list.
     *
     * @param free the free
     * @return the array list
     */
    public ArrayList<Anuncio> getAnunciosEligiveisDoFreelancer (Freelancer free){
        Date dataAtual = new Date();
        ArrayList<Anuncio> anuncioList = new ArrayList<>();
        for (Anuncio a:this.lAnuncio){
           boolean aceita = a.aceitaCandidatura();
           if (aceita){
               List<CaraterCT> ListCCT= a.getTarefa().getCCtList();
               for (CaraterCT ct :ListCCT){
                   if(a.eFreelancerElegivel(free)){
                       anuncioList.add(a);
                   }
               }
           }
        }
        return anuncioList;
    }

    /**
     * Get anuncio by id anuncio.
     *
     * @param anuncioID the anuncio id
     * @return the anuncio
     */
    public Anuncio getAnuncioByID(String anuncioID){
        for (Anuncio anum:this.lAnuncio){
            if (anum.getTarefa().getRef().equals(anuncioID)){
                return anum;
            }
        }
        return null;
    }

    /**
     * Getl anuncio list.
     *
     * @return the list
     */
    public List<Anuncio> getlAnuncio (){
        return this.lAnuncio;
    }


}
