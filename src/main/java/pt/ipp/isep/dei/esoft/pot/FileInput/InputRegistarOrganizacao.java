package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.pot.controller.EspecificarTarefaController;
import pt.ipp.isep.dei.esoft.pot.controller.RegistarOrganizacaoController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Imports file registar organizacao.
 */
public class InputRegistarOrganizacao {
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

        RegistarOrganizacaoController m_controller = new RegistarOrganizacaoController();

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
            String strTelefone=dados[0].trim();
            String strEmail=dados[1].trim();
            String strLocal=dados[2].trim();
            String strCodPostal=dados[2].trim();

            String strLocalidade=dados[0].trim();
            String strNomeGestor=dados[1].trim();
            String strFuncaoGestor=dados[2].trim();
            String strEmailGestor=dados[0].trim();
            String strTelefoneGestor=dados[1].trim();

            if(m_controller.novaOrganizacao( strNome,  strNIF,  strWebsite,  strTelefone,
                     strEmail,  strLocal,  strCodPostal,  strLocalidade,
                     strNomeGestor,  strFuncaoGestor,  strEmailGestor,   strTelefoneGestor)){
                m_controller.registaOrganizacao();
            }
        }
        sc.close();
    }

}
