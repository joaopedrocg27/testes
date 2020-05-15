package pt.ipp.isep.dei.esoft.pot.LocalData;

import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarCompetenciaTecnicaController;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * The type Data.
 */
public class Data {

    /**
     * Escrever plataforma.
     *
     * @param ra the ra
     */
    public static void EscreverPlataforma(Plataforma ra) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Plataforma.txt");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(ra);
            outStream.close();
            fileOut.close();
        } catch (
                IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Ler  plataforma.
     *
     * @param pros the pros
     * @return the plataforma
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public static Plataforma lerPlat(Properties pros) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        Plataforma rt;
        try {
            FileInputStream fileIn = new FileInputStream("Plataforma.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            rt = (Plataforma) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {

            return new Plataforma(pros.getProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO));
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();

            return null;
        }
        return rt;
    }
}
