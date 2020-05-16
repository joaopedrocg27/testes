package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;

import pt.ipp.isep.dei.esoft.pot.model.*;

import pt.ipp.isep.dei.esoft.pot.model.Listas.lstAnun;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAnuncio;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoOrganizacoes;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoTiposRegimento;

import java.lang.reflect.Method;
import java.util.*;



import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * The type Seriar anuncio controller.
 */
public class SeriarAnuncioController {
    private Anuncio anuncio;
    private Plataforma plat;
    private RegistoAnuncio listAnum;
    private Colaborador c;
    private Tarefa tarefa;
    private RegistoAnuncio ran;
    private Organizacao org;
    private RegistoOrganizacoes rorg;
    private SessaoUtilizador sessao;
    private AplicacaoPOT app;

    /**
     * Instantiates a new Seriar anuncio controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public SeriarAnuncioController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)){
        throw new IllegalStateException("Utilizador não Autorizado");}
        this.plat=AplicacaoPOT.getInstance().getPlataforma();
        this.app = AplicacaoPOT.getInstance();
        this.sessao = app.getSessaoAtual();
        this.ran = this.plat.getRegistoAnuncios();
        this.rorg = plat.getRegistoOrganizacoes();
        this.org = rorg.getOrganizacaoByEmail(sessao.getEmailUtilizador());
        this.c = org.getColaboradorByEmail(sessao.getEmailUtilizador());
        this.listAnum = this.plat.getRegistoAnuncios();

    }

    /**
     * Get anuncio list por colaborador list.
     *
     * @return the list
     */
    public List<Anuncio> getAnuncioListPorColaborador(){
        ArrayList<Anuncio> anuncios = new ArrayList<>();
        for (Anuncio a: this.listAnum.getlAnuncio()){
            if (a.getC().equals(this.c)){
                anuncios.add(a);
            }
        }
        return anuncios;
    }

    /**
     * Get candidaturalist list.
     *
     * @param a the a
     * @return the list
     */
    public List<Candidatura> getCandidaturalist(Anuncio a){
        return a.getList().getCandidaturaList();

    }
    public List<Candidatura> ordenarCandidaturaList(Anuncio a)  {
       Regimento reg = a.getRegTR();
        return  reg.Seriar(a);

    }
}
