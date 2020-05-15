/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarCompetenciaTecnicaController;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 * The type Especificar competencia tecnica ui.
 *
 * @author paulomaio
 */
public class EspecificarCompetenciaTecnicaUI
{
    private EspecificarCompetenciaTecnicaController m_controller;

    /**
     * Instantiates a new Especificar competencia tecnica ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EspecificarCompetenciaTecnicaUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        m_controller = new EspecificarCompetenciaTecnicaController();
    }

    /**
     * Run.
     */
    public void run()
    {
        System.out.println("\nEspecificar Competência Técnica:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaCompetenciaTecnica()) {
                    //Data.EscreverRegistoCT(this.m_controller.getRegistoCompetenciaTecnica());
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
    private boolean introduzGrauProficiencia(){
            int valor = Integer.parseInt(Utils.readLineFromConsole("Valor: "));
            String desin = Utils.readLineFromConsole("Descricao: ");
            return m_controller.novoGrauProficiencia(valor,desin);
    }
    
    private boolean introduzDados() {
        String ctID = Utils.readLineFromConsole("ID da Competencia Tecnica: ");
        String strDescricaoBreve = Utils.readLineFromConsole("Descrição Breve: ");
        String strDescricaoDetalhada = Utils.readLineFromConsole("Descrição Detalhada: ");
        
        List<AreaAtividade> lc = m_controller.getAreasAtividade();
        
        String areaId = "";
        AreaAtividade area = (AreaAtividade)Utils.apresentaESeleciona(lc, "Selecione a Área de Atividaade a que é referente esta Competência Técnica:");
        if (area != null)
            areaId = area.getCodigo();
        boolean decisao= m_controller.novaCompetenciaTecnica(ctID,strDescricaoBreve,strDescricaoDetalhada,areaId);
        do{
        introduzGrauProficiencia();
        m_controller.registaGrauProficiencia();
        }while (Utils.confirma("Deseja Introduzir Mais? (S/N)"));
        return decisao;
    }
    
    private void apresentaDados() 
    {
        System.out.println("\nCompetência Técnica:\n" + m_controller.getCompetenciaTecnicaString());
    }
      
}
