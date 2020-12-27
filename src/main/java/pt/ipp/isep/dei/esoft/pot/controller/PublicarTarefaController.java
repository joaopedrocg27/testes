package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Listas.ListaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAnuncio;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoOrganizacoes;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoTiposRegimento;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Publicar tarefa controller.
 */
public class PublicarTarefaController {
    private Anuncio anuncio;
    private final ListaTarefa lTarefas;
    private final Plataforma plat;
    private final RegistoTiposRegimento rreg;
    private final Colaborador c;
    private Tarefa tarefa;
    private final RegistoAnuncio ran;
    private final Organizacao org;
    private final RegistoOrganizacoes rorg;
    private final SessaoUtilizador sessao;
    private final AplicacaoPOT app;

    /**
     * Instantiates a new Publicar tarefa controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public PublicarTarefaController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if(!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.plat=AplicacaoPOT.getInstance().getPlataforma();
        this.rreg=this.plat.getRegistoTiposRegimento();
        this.app = AplicacaoPOT.getInstance();
        this.sessao = app.getSessaoAtual();
        this.ran = this.plat.getRegistoAnuncios();
        String email = sessao.getEmailUtilizador();
        this.rorg = plat.getRegistoOrganizacoes();
        this.org = rorg.getOrganizacaoByEmail(email);
        this.c = org.getColaboradorByEmail(email);
        this.lTarefas=org.getListaTarefa();

    }

    /**
     * Instantiates a new Publicar tarefa controller.
     *
     * @param email the email
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public PublicarTarefaController(String email) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.plat=AplicacaoPOT.getInstance().getPlataforma();
        this.rreg=this.plat.getRegistoTiposRegimento();
        this.app = AplicacaoPOT.getInstance();
        this.sessao = app.getSessaoAtual();
        this.ran = this.plat.getRegistoAnuncios();
        this.rorg = plat.getRegistoOrganizacoes();
        this.org = rorg.getOrganizacaoByEmail(email);
        this.c = org.getColaboradorByEmail(email);
        this.lTarefas=org.getListaTarefa();
    }

    /**
     * Gets plataforma.
     *
     * @return the plataforma
     */
    public Plataforma getPlat() {
        return plat;
    }

    /**
     * Gets ran.
     *
     * @return the ran
     */
    public RegistoAnuncio getRan() {
        return ran;
    }

    /**
     * Gets tarefas para publicar.
     *
     * @return the tarefas para publicar
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public List<Tarefa> getTarefasParaPublicar() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        return this.lTarefas.getTarefasParaPublicar(c);
    }

    /**
     * Seleciona tarefa .
     *
     * @param ref the ref
     * @return the tarefa
     */
    public Tarefa selecionaTarefa(String ref){
        return this.tarefa = lTarefas.getTarefasParaPublicarByRef(ref,this.c);
    }

    /**
     * Gets tipos regimento.
     *
     * @return the tipos regimento
     */
    public List<Regimento> getTiposRegimento() {
        return this.plat.getRegistoTiposRegimento().getListTiposRegimento();

    }


    /**
     * Novo anuncio boolean.
     *
     * @param dtIniP the dt ini p
     * @param dtFimP the dt fim p
     * @param dtIniC the dt ini c
     * @param dtFimC the dt fim c
     * @param dtIniS the dt ini s
     * @param dtFimS the dt fim s
     * @param desTR  the des tr
     * @param ref    the ref
     * @return the boolean
     */
    public boolean novoAnuncio(Date dtIniP, Date dtFimP, Date dtIniC, Date dtFimC, Date dtIniS, Date dtFimS, int desTR,String ref){
        try {
            Regimento regT = this.rreg.getRegimentoByID(desTR);
            RegistoAnuncio regA = this.plat.getRegistoAnuncios();
            this.tarefa=this.lTarefas.getTarefasParaPublicarByRef(ref,this.c);
            this.anuncio = regA.novoAnuncio(this.c, this.tarefa, dtIniP, dtFimP, dtIniC, dtFimC, dtIniS, dtFimS, regT);
            return regA.validaAnuncio(this.anuncio);
        }catch(RuntimeException ex){
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.anuncio = null;
            return false;
        }
    }

    /**
     * Regista anuncio boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaAnuncio(){
        return this.ran.registaAnuncio(anuncio);

    }

    /**
     * Get anuncio string.
     *
     * @return the string
     */
    public String getAnuncio(){
        return anuncio.toString();
    }






}
