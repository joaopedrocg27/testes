package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Regimento;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoTiposRegimento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Imports file regimento.
 */
public class InputRegimento {
    private final Plataforma m_oPlataforma;
    private final RegistoTiposRegimento rreg;
    private Regimento m_oRegimento;

    /**
     * Instantiates a new Input regimento.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public InputRegimento() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.rreg = this.m_oPlataforma.getRegistoTiposRegimento();
    }


    /**
     * Run / reads the file and creates the objects.
     *
     * @throws FileNotFoundException the file not found exception
     */
    public void run() throws FileNotFoundException {

        File dadosCategorias = new File("Regimentos.txt");
        Scanner sc = new Scanner(dadosCategorias);
        sc.nextLine();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(";");
            int strId= Integer.parseInt(dados[0].trim());
            String strTitulo=dados[1].trim();
            String strDesignacao=dados[2].trim();
            this.rreg.novoRegimento(strId,strTitulo,strDesignacao);
            //if (this.rreg.validaTipoRegimento(this.m_oRegimento)) {
            //    this.rreg.registaRegimento(this.m_oRegimento);
            //}
        }
        sc.close();
    }
}