package pt.ipp.isep.dei.esoft.pot.FileInput;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarCompetenciaTecnicaController;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Imports file competencia tecnica.
 */
public class InputCompetenciaTecnica {

    private EspecificarCompetenciaTecnicaController control;


    /**
     * Instantiates a new Input competencia tecnica.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public InputCompetenciaTecnica() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.control = new EspecificarCompetenciaTecnicaController();

    }

    /**
     * Run / reads the file and creates the objects.
     *
     * @throws FileNotFoundException the file not found exception
     */
    public void run() throws FileNotFoundException {



        File dadosOrganizacao = new File("Competencias_Tecnicas.txt");
        Scanner sc= new Scanner(dadosOrganizacao);
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(";");
            String cod =dados[0].trim();
            String areaAtividadeId=dados[3].trim();
            String strDescricaoBreve=dados[1].trim();
            String strDescricaoDetalhada=dados[2].trim();
            this.control.novaCompetenciaTecnica(cod,strDescricaoBreve,strDescricaoDetalhada,areaAtividadeId);
            String gp = sc.nextLine();
            String[] gpDados = gp.split(";");
            do{
                if (gpDados.length>1){
                    this.control.novoGrauProficiencia(Integer.parseInt(gpDados[0]),gpDados[1]);
                    this.control.registaGrauProficiencia();
                    if (sc.hasNextLine()){
                    gp=sc.nextLine();
                    gpDados=gp.split(";");}else{break;}
                }
            }while (gpDados.length>1);

            this.control.registaCompetenciaTecnica();
        }
        sc.close();
    }

}
