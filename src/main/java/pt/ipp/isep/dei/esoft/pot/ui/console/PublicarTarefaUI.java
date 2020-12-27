package pt.ipp.isep.dei.esoft.pot.ui.console;


import pt.ipp.isep.dei.esoft.pot.controller.PublicarTarefaController;
import pt.ipp.isep.dei.esoft.pot.model.Regimento;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * The type Publicar tarefa ui.
 */
public class PublicarTarefaUI {
    private final PublicarTarefaController m_controller;
    private Tarefa Tarefa;
    private Regimento regimento;

    /**
     * Instantiates a new Publicar tarefa ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public PublicarTarefaUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        m_controller = new PublicarTarefaController();
    }

    /**
     * Run.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public void run() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        System.out.println("\nPublicar Tarefa:");




        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaAnuncio()) {
                    //Data.EscreverRegistoAnuncio(m_controller.getRan());
                    //Data.EscreverPlataforma(this.m_controller.getPlat());
                    System.out.println("Registo efetuado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        }
        else
        {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }
    private void apresentaDados() {
        System.out.println("\nAnúncio:\n" + m_controller.getAnuncio());
    }

    private boolean introduzDados() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        String desTR = "";
        List<Tarefa> tar = m_controller.getTarefasParaPublicar();

        if (tar.isEmpty()) {
            System.out.println("ERRO: Lista de Tarefas vazia!");
            return false;
        } else {
            String tarRef = "";
            Tarefa = (Tarefa) Utils.apresentaESeleciona(tar, "Selecione a tarefa a publicar:");

            if (Tarefa != null) {
                tarRef = Tarefa.getRef();
                m_controller.selecionaTarefa(tarRef);

                Date dtIniP = Utils.readDateFromConsole("Data de Inicio De Publicação: ");
                Date dtFimP = Utils.readDateFromConsole("Data de Fim De Publicação: ");
                Date dtIniC = Utils.readDateFromConsole("Data de Inicio De Candidatura: ");
                Date dtFimC = Utils.readDateFromConsole("Data de Fim De Candidatura: ");
                Date dtIniS = Utils.readDateFromConsole("Data de Inicio de Seriamento: ");
                Date dtFimS = Utils.readDateFromConsole("Data de Fim de Seriamento: ");

                List<Regimento> ltreg = m_controller.getTiposRegimento();

                if (ltreg.isEmpty()) {
                    System.out.println("ERRO: Lista de Regimento vazia!");
                    return false;
                } else {
                    this.regimento =(Regimento) Utils.apresentaESeleciona(ltreg, "Selecione o regimento da Tarefa:");
                    if (this.regimento != null) {
                        int desc = this.regimento.getId();
                        return m_controller.novoAnuncio(dtIniP, dtFimP, dtIniC, dtFimC, dtIniS, dtFimS, desc,tarRef);

                    }else{
                       return false;
                    }
                }
            }else{
                return false;
            }
        }

    }








}
