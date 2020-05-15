package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarTarefaController;
import pt.ipp.isep.dei.esoft.pot.controller.PublicarTarefaController;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.Listas.ListaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoAnuncio;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoOrganizacoes;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoTiposRegimento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *  Imports file publicar tarefa.
 */
public class InputPublicarTarefa {

    private PublicarTarefaController m_controller;


    /**
     * Instantiates a new Input publicar tarefa.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public InputPublicarTarefa() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

    }

    /**
     * Run / reads the file and creates the objects.
     *
     * @throws IOException               the io exception
     * @throws ParseException            the parse exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public void run() throws IOException, ParseException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        File dadosOrganizacao = new File("Publicar_Tarefas.txt");
        Scanner sc = new Scanner(dadosOrganizacao);
        sc.nextLine();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(";");
            String ref = dados[0].trim();
            String dtIniPS = dados[1].trim();
            String dtFimPS = dados[2].trim();
            String dtIniCS = dados[3].trim();
            String dtFimCS = dados[4].trim();
            String dtIniSS = dados[5].trim();
            String dtFimSS = dados[6].trim();
            Date dtIniP = new SimpleDateFormat("dd-MM-yyyy").parse(dtIniPS);
            Date dtFimP = new SimpleDateFormat("dd-MM-yyyy").parse(dtFimPS);
            Date dtIniC = new SimpleDateFormat("dd-MM-yyyy").parse(dtIniCS);
            Date dtFimC = new SimpleDateFormat("dd-MM-yyyy").parse(dtFimCS);
            Date dtIniS = new SimpleDateFormat("dd-MM-yyyy").parse(dtIniSS);
            Date dtFimS = new SimpleDateFormat("dd-MM-yyyy").parse(dtFimSS);
            String desTR = dados[7].trim();
            String email = dados[8].trim();
            this.m_controller = new PublicarTarefaController(email);
            this.m_controller.novoAnuncio(dtIniP,dtFimP,dtIniC,dtFimC,dtIniS,dtFimS,Integer.parseInt(desTR),ref);
            this.m_controller.registaAnuncio();

            }

        sc.close();
    }
}