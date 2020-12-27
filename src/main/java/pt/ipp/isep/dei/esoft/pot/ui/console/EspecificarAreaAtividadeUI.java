/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarAreaAtividadeController;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * The type Especificar area atividade ui.
 *
 * @author paulomaio
 */
public class EspecificarAreaAtividadeUI
{
    private final EspecificarAreaAtividadeController m_controller;

    /**
     * Instantiates a new Especificar area atividade ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EspecificarAreaAtividadeUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        m_controller = new EspecificarAreaAtividadeController();
    }

    /**
     * Run.
     */
    public void run()
    {
        System.out.println("\nEspecificar Área de Atividade:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaAreaAtividade()) {
                    //Data.EscreverRegistoAreasAtividade(this.m_controller.getRegistoArea());
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
        String strCodigo = Utils.readLineFromConsole("Código: ");
        String strDescricaoBreve = Utils.readLineFromConsole("Descrição Breve: ");
        String strDescricaoDetalhada = Utils.readLineFromConsole("Descrição Detalhada: ");
        
        return m_controller.novaAreaAtividade(strCodigo, strDescricaoBreve,strDescricaoDetalhada);
    }
    
    private void apresentaDados() 
    {
        System.out.println("\nÁrea de Atividade:\n" + m_controller.getAreaAtividadeString());
    }
}
