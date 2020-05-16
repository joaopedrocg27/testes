package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.controller.EfetuarCandidaturaController;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The type Efetuar candidatura ui.
 */
public class EfetuarCandidaturaUI {
    private EfetuarCandidaturaController control;

    /**
     * Instantiates a new Efetuar candidatura ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public EfetuarCandidaturaUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.control=new EfetuarCandidaturaController();
    }

    /**
     * Run.
     */
    public void run()
    {
        System.out.println("\nEfetue a Candidatura:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (control.registaCandidatura()) {
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
        List<Anuncio> la = control.getAnunciosEligiveis();
        Anuncio anuncio= (Anuncio)Utils.apresentaESeleciona(la, "Selecione o Anuncio:");
        double valorPretendido =Double.parseDouble(Objects.requireNonNull(Utils.readLineFromConsole("Valor Pretendido: ")));
        int nDeDias =Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Valor Pretendido: ")));
        String txtApresentacao =Utils.readLineFromConsole("Texto de Apresentação: ");
        String txtMotivacao =Utils.readLineFromConsole("Texto de Motivacao: ");

        String anuncioID = "";
        if (anuncio != null)
            anuncioID = anuncio.getTarefa().getRef();

        return control.novaCandidatura(anuncioID,valorPretendido,nDeDias,txtApresentacao,txtMotivacao,new Date());

    }

    private void apresentaDados()
    {
        System.out.println("\nCandidatura:\n" + control.getCandidaturaToString());
    }


}

