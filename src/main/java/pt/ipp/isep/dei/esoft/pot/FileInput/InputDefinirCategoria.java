package pt.ipp.isep.dei.esoft.pot.FileInput;

import pt.ipp.isep.dei.esoft.pot.controller.DefinirCategoriaController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Imports file definir categoria.
 */
public class InputDefinirCategoria {
    private final DefinirCategoriaController control;

    /**
     * Instantiates a new Input definir categoria.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public InputDefinirCategoria() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        control = new DefinirCategoriaController();
    }

    /**
     * Run / reads the file and creates the objects.
     *
     * @throws FileNotFoundException the file not found exception
     */
    public void run() throws FileNotFoundException {


            File dadosOrganizacao = new File("Categorias.txt");
            Scanner sc= new Scanner(dadosOrganizacao);
            sc.nextLine();

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                String desc=dados[0].trim();
                String atCod=dados[1].trim();
                this.control.novaCategoria(desc,atCod);
                String cct = sc.nextLine();
                String [] cctLine = cct.split(";");
                do{
                    if (cctLine.length>1){
                        this.control.novoCaracterCT(cctLine[0],Integer.parseInt(cctLine[1]),cctLine[2].equals("s"));
                        this.control.registaCaracterCt();
                        if (sc.hasNextLine()){
                            cct=sc.nextLine();
                            cctLine=cct.split(";");}else{break;}
                    }
                }while (cctLine.length>1);
                this.control.registaCategoria();
            }
            sc.close();
        }

}
