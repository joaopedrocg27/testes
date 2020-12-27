package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.pot.controller.EspecificarTarefaController;
import pt.ipp.isep.dei.esoft.pot.controller.RegistarFreelancerController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Imports file registar freelancer.
 */
public class InputRegistarFreelancer {
    private final RegistarFreelancerController controller;

    /**
     * Instantiates a new Input registar freelancer.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public InputRegistarFreelancer() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.controller=new RegistarFreelancerController();
    }

    /**
     * Run / reads the file and creates the objects.
     *
     * @throws IOException the io exception
     */
    public void run() throws IOException {



        File dadosOrganizacao = new File("Freelancer.txt");
        Scanner sc= new Scanner(dadosOrganizacao);
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(";");
            String nome=dados[0].trim();
            String nif=dados[1].trim();
            String email=dados[2].trim();
            String telefone=dados[3].trim();
            String localidade=dados[4].trim();
            String codigoPostal=dados[5].trim();
            String local=dados[6].trim();

            this.controller.novoFreelancer( nome,  nif,  email,  telefone,  localidade,  codigoPostal,  local);
            String linhaHA = sc.nextLine();
            String[] arrayHA = linhaHA.split(";");

            do{

                    String grau = arrayHA[0];
                    String designacao = arrayHA[1];
                    String insituicao = arrayHA[2];
                    double media = Double.parseDouble(arrayHA[3]);
                    this.controller.novaHabilitacaoAcademica(grau,designacao,insituicao,media);
                    this.controller.registaHabilitacaoAcademica();
                    linhaHA = sc.nextLine();
                    arrayHA = linhaHA.split(";");

            }while (arrayHA.length==4);
            do{
                this.controller.novoReconhecimentoCompetenciaTecnica(arrayHA[0],Integer.parseInt(arrayHA[1]));
                this.controller.registaReconhecimentoCompetenciaTecnica();
                if (sc.hasNextLine()){
                    linhaHA = sc.nextLine();
                    arrayHA = linhaHA.split(";");
                }else{
                    break;
                }
            }while (arrayHA.length>1);


            this.controller.registaFreelancer() ;

        }
        sc.close();
    }
}
