package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.pot.controller.RegistarOrganizacaoController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * TImports file organizacao.
 */
public class InputOrganizacao {
    private final RegistarOrganizacaoController m_controller;

    /**
     * Instantiates a new Input organizacao.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public InputOrganizacao() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.m_controller = new RegistarOrganizacaoController();

    }

    /**
     * Run / reads the file and creates the objects.
     *
     * @throws FileNotFoundException the file not found exception
     */
    public void run() throws FileNotFoundException {



            File dadosOrganizacao = new File("Organizacoes.txt");
            Scanner sc= new Scanner(dadosOrganizacao);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                String strNome=dados[0].trim();
                String strNIF=dados[1].trim();
                String strWebsite=dados[2].trim();
                String strTelefone=dados[3].trim();
                String strEmail=dados[4].trim();
                String strLocal=dados[5].trim();
                String strCodPostal=dados[6].trim();
                String strLocalidade=dados[7].trim();
                String strNomeGestor=dados[8].trim();
                String strFuncao=dados[9].trim();
                String strEmailGestor=dados[10].trim();
                String strTelefoneGestor=dados[11].trim();

                if(this.m_controller.novaOrganizacao(strNome, strNIF, strWebsite, strTelefone, strEmail, strLocal, strCodPostal, strLocalidade, strNomeGestor, strFuncao, strEmailGestor, strTelefoneGestor)){
                   this.m_controller.registaOrganizacao();
                   this.m_controller.registaColaborador();
                }
            }
            sc.close();
        }
    }
