package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.pot.controller.EfetuarCandidaturaController;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarAreaAtividadeController;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarTarefaController;
import pt.ipp.isep.dei.esoft.pot.ui.console.EfetuarCandidaturaUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Imports file efetuar candidatura.
 */
public class InputEfetuarCandidatura {

    private EfetuarCandidaturaController control;

    /**
     * Instantiates a new Input efetuar candidatura.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public  InputEfetuarCandidatura() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

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
    public void run() throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, ParseException {

        File dadosOrganizacao = new File("Candidatura.txt");
        Scanner sc= new Scanner(dadosOrganizacao);
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(";");
            String anuncioID=dados[0].trim();
            String valorEsperadoS=dados[1].trim();
            String numeroDeDiasS=dados[2].trim();
            String txtApres=dados[3].trim();
            String txtMotiv=dados[4].trim();
            String email = dados[5].trim();
            String data = dados[6].trim();
            Date dtIniP = new SimpleDateFormat("dd-MM-yyyy").parse(data);
            this.control = new EfetuarCandidaturaController(email);
            double valorEsperado = Double.parseDouble(valorEsperadoS);
            int numeroDeDias = Integer.parseInt(numeroDeDiasS);

          this.control.novaCandidatura(anuncioID,valorEsperado,numeroDeDias,txtApres,txtMotiv,dtIniP);
          this.control.registaCandidatura();


        }
        sc.close();
    }
}

