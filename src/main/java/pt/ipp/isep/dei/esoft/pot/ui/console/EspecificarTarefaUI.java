package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarCompetenciaTecnicaController;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarTarefaController;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Categoria;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * The type Especificar tarefa ui.
 */
public class EspecificarTarefaUI {

private EspecificarTarefaController m_controller;

    /**
     * Instantiates a new Especificar tarefa ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EspecificarTarefaUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        m_controller = new EspecificarTarefaController();
    }

    /**
     * Run.
     */
    public void run() {
        System.out.println("\nEspecificarTarefa:");

        if (introduzDados()) {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaTarefa()) {
                    Data.EscreverPlataforma(this.m_controller.getPlat());
                    System.out.println("Especificação efetuada com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        } else {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }



    }
    private boolean introduzDados() {
        String strRefUnica = Utils.readLineFromConsole("Referencia Unica: ");
        String strDesig = Utils.readLineFromConsole("Designação: ");
        String strDescInformal = Utils.readLineFromConsole("Descrição Formal: ");
        String strCaracTecnico = Utils.readLineFromConsole("Descrição Tecnica: ");
        int strDuracao = Utils.readIntegerFromConsole("Duracao: ");
        int strCusto = Utils.readIntegerFromConsole("Custo: ");

        List<Categoria> lc = m_controller.getListaCategorias();

        Categoria cat = (Categoria) Utils.apresentaESeleciona(lc, "Selecione a categoria:");

        String catId="";
        if (cat != null)
            catId = cat.getId();
        boolean decisao= m_controller.novaTarefa(strRefUnica, strDesig,strDescInformal,strCaracTecnico,strDuracao,strCusto,catId);

        return decisao;

    }
    private void apresentaDados()
    {
        System.out.println("\nTarefa:\n" + m_controller.toString());
    }

}