package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Listas.ListaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoCategorias;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoOrganizacoes;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Especificar tarefa controller.
 */
public class EspecificarTarefaController {
    private final RegistoCategorias rcat;
    private final List<Categoria> lcat;
    private Categoria cat;
    private ListaTarefa oTarefa;
    private Tarefa tar;
    private final AplicacaoPOT app;
    private final Plataforma plat;
    private final RegistoOrganizacoes rorgs;
    private final Organizacao org;
    private final Colaborador colab;
    private SessaoUtilizador sessao;


    /**
     * Instantiates a new Especificar tarefa controller.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EspecificarTarefaController() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.plat = AplicacaoPOT.getInstance().getPlataforma();
        this.rcat = plat.getM_oRegistoCategoria();
        this.lcat=rcat.getCategorias();
        this.rorgs = this.plat.getRegistoOrganizacoes();
        this.app=AplicacaoPOT.getInstance();
        this.sessao=this.app.getSessaoAtual();

        String email = this.sessao.getEmailUtilizador();
        this.org = this.rorgs.getOrganizacaoByEmail(email);
        this.colab = this.org.getColaboradorByEmail(email);
        this.oTarefa = this.org.getListaTarefa();
    }

    /**
     * Instantiates a new Especificar tarefa controller.
     *
     * @param email the email
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EspecificarTarefaController(String email) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.plat = AplicacaoPOT.getInstance().getPlataforma();
        this.rcat = plat.getM_oRegistoCategoria();
        this.lcat=rcat.getCategorias();
        this.rorgs = this.plat.getRegistoOrganizacoes();
        this.app=AplicacaoPOT.getInstance();
        this.org = this.rorgs.getOrganizacaoByEmail(email);
        this.colab = this.org.getColaboradorByEmail(email);
        this.oTarefa = this.org.getListaTarefa();
    }


    /**
     * Gets plat.
     *
     * @return the plataforma object
     */
    public Plataforma getPlat() {
        return plat;
    }

    /**
     * Regista tarefa boolean.
     *
     * @return success or fail (boolean)
     */
    public boolean registaTarefa(){
        return this.oTarefa.registaTarefa(this.tar);
    }

    @Override
    public String toString() {
        return this.tar.toString();
    }

    /**
     * Gets lista categorias.
     *
     * @return the lista categorias
     */
    public List<Categoria> getListaCategorias() {
        return lcat;
    }

    /**
     * Nova tarefa boolean.
     *
     * @param strRefUnica     the str ref unica
     * @param strDesig        the str desig
     * @param strDescInformal the str desc informal
     * @param strCaracTecnico the str carac tecnico
     * @param strDuracao      the str duracao
     * @param strCusto        the str custo
     * @param catId           the cat id
     * @return success or fail (boolean)
     */
    public boolean novaTarefa(String strRefUnica, String strDesig, String strDescInformal,
                              String strCaracTecnico, int strDuracao, int strCusto, String catId)
    {
        try
        {

            Categoria catTarefa = rcat.getCategoriaById(catId);


            this.tar = this.oTarefa.novaTarefa(strRefUnica, strDesig,strDescInformal,strCaracTecnico,strDuracao,strCusto,catTarefa);
            this.tar.setColab(colab);
            return this.oTarefa.validaTarefa(this.tar);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.oTarefa = null;
            return false;
        }
    }
}
