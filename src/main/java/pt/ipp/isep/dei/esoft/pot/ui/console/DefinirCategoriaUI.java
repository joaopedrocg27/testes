package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.controller.DefinirCategoriaController;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.model.GrauProficiencia;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * The type Definir categoria ui.
 */
public class DefinirCategoriaUI {
    private DefinirCategoriaController m_controller;

    /**
     * Instantiates a new Definir categoria ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public DefinirCategoriaUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.m_controller =new DefinirCategoriaController();
    }

    /**
     * Run.
     */
    public void run()
    {
        System.out.println("\nDefina a Categoria:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaCategoria()) {
                    //Data.EscreverRegistoCategorias(this.m_controller.getM_oRegistoCategoria());
                    Data.EscreverPlataforma(this.m_controller.getM_oPlataforma());
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

    private boolean introduzDados() {
        List<AreaAtividade> lc = m_controller.getATList();
        AreaAtividade area = (AreaAtividade)Utils.apresentaESeleciona(lc, "Selecione a Área de Atividaade a que é referente esta Competência Técnica:");
        String desc = Utils.readLineFromConsole("Descrição: ");




        String areaId = "";
        if (area != null)
            areaId = area.getCodigo();
        boolean devolver =m_controller.novaCategoria(desc,areaId);
        do {
            introduzCompetenciaTecnica(area);
            m_controller.registaCaracterCt();
        }while (Utils.confirma("Deseja Adicionar Mais Competencias Tecnicas? (S/N)"));
        return devolver;

    }
    private boolean introduzCompetenciaTecnica(AreaAtividade at) {

            List<CompetenciaTecnica> lc = m_controller.getCTList(at);
            CompetenciaTecnica ct = (CompetenciaTecnica) Utils.apresentaESeleciona(lc, "Selecione a Competência Técnica:");
            String ctID = "";
            if (ct !=null){
                ctID=ct.getM_strId();
                List<GrauProficiencia> gpl = ct.getGrauProficienciaList();
                GrauProficiencia gp = (GrauProficiencia) Utils.apresentaESeleciona(gpl,"Selecione o Grau de Proficiencia");
                boolean obg = Utils.confirma("Este Grau de Proficiencia tem Caracter Obrigatorio? (S/N)");
                return this.m_controller.novoCaracterCT(ctID,gp.getValor(),obg);

            }
                return false;



    }

    private void apresentaDados()
    {
        System.out.println("\nCandidatura:\n" + m_controller.getCategoriaString());
    }


}
