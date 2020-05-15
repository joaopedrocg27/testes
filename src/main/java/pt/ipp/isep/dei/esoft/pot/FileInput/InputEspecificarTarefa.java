package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.pot.controller.DefinirCategoriaController;
import pt.ipp.isep.dei.esoft.pot.controller.EfetuarCandidaturaController;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarAreaAtividadeController;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarTarefaController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Imports file especificar tarefa.
 */
public class InputEspecificarTarefa {
    private EspecificarTarefaController m_controller;
    /**
     * The Controller.
     */
    public DefinirCategoriaController controller;

    /**
     * Instantiates a new Input especificar tarefa.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public InputEspecificarTarefa() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        this.controller = new DefinirCategoriaController();
    }

    /**
     * Run / reads the file and creates the objects.
     *
     * @throws IOException               the io exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public void run() throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {


        File dadosOrganizacao = new File("Tarefas.txt");
        Scanner sc = new Scanner(dadosOrganizacao);
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(";");
            String emailColaborador = dados[0].trim();
            this.m_controller = new EspecificarTarefaController(emailColaborador);
            String strRefUnica = dados[1].trim();
            String strDesig = dados[2].trim();
            String strDescInformal = dados[3].trim();
            String strCaracTecnico = dados[4].trim();
            String strDuracaoS = dados[5].trim();
            String strCustoS = dados[6].trim();


            int strDuracao = Integer.parseInt(strDuracaoS);
            int strCusto = Integer.parseInt(strCustoS);

            String linhaCat = sc.nextLine();
            String[] dadosCat = linhaCat.split(";");
            String desc = dadosCat[0].trim();
            String atCod = dadosCat[1].trim();
            this.controller.novaCategoria(desc, atCod);
            String cct = sc.nextLine();
            String[] cctLine = cct.split(";");
            do {
                if (cctLine.length > 1) {
                    this.controller.novoCaracterCT(cctLine[0], Integer.parseInt(cctLine[1]), cctLine[2].equals("s"));
                    this.controller.registaCaracterCt();
                    if (sc.hasNextLine()) {
                        cct = sc.nextLine();
                        cctLine = cct.split(";");
                    } else {
                        break;
                    }
                }
            } while (cctLine.length > 1);
            this.controller.registaCategoria();


            if (m_controller.novaTarefa(strRefUnica, strDesig, strDescInformal,
                    strCaracTecnico, strDuracao, strCusto, this.controller.getCatID())) {
                m_controller.registaTarefa();
            }
        }
        sc.close();
    }
}

