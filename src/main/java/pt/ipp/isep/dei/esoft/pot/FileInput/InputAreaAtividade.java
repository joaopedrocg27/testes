package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarAreaAtividadeController;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Listas.lstAreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAreasAtividade;

import java.awt.geom.Area;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Imports file area atividade.
 */
public class InputAreaAtividade {
    private Plataforma m_oPlataforma;
    private RegistoAreasAtividade m_oRegistoAreasAtividade;
    private RegistoAreasAtividade rat;
    private AreaAtividade m_oAreaAtividade;

    /**
     * Instantiates a new Input area atividade.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public InputAreaAtividade() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.m_oRegistoAreasAtividade = this.m_oPlataforma.getM_oRegistoAreaAtividade();
        this.rat = this.m_oRegistoAreasAtividade;
    }

    /**
     * Run / reads the file and creates the objects.
     *
     * @throws FileNotFoundException the file not found exception
     */
    public void run() throws FileNotFoundException {



        RegistoAreasAtividade rArea = new RegistoAreasAtividade();

        File dadosOrganizacao = new File("AreasAtividade.txt");
        Scanner sc = new Scanner(dadosOrganizacao);
        sc.nextLine();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(";");
            String strCodigo = dados[0].trim();
            String strDescricaoBreve = dados[1].trim();
            String strDescricaoDetalhada = dados[2].trim();


            this.m_oAreaAtividade = this.rat.novaAreaAtividade(strCodigo, strDescricaoBreve,strDescricaoDetalhada);
            if (this.rat.validaAreaAtividade(this.m_oAreaAtividade)){
                this.rat.registaAreaAtividade(this.m_oAreaAtividade);
            }else {
                this.m_oAreaAtividade = null;
            }
        }
        sc.close();
    }
}
