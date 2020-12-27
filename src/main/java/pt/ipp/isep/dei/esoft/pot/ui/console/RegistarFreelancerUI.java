package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.LocalData.Data;
import pt.ipp.isep.dei.esoft.pot.controller.RegistarFreelancerController;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.model.GrauProficiencia;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * The type Registar freelancer ui.
 */
public class RegistarFreelancerUI {
    private final RegistarFreelancerController m_controller;

    /**
     * Instantiates a new Registar freelancer ui.
     *
     * @throws NoSuchMethodException     the no such method exception
     * @throws IOException               the io exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    public RegistarFreelancerUI() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        m_controller = new RegistarFreelancerController();
    }

    /**
     * Run.
     */
    public void run()
    {
        System.out.println("\nRegiste o Freelancer:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaFreelancer()) {
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
        String nome = Utils.readLineFromConsole("Nome: ");
        String email= Utils.readLineFromConsole("Email: ");
        String nif = Utils.readLineFromConsole("NIF: ");
        String telefone = Utils.readLineFromConsole("Telefone: ");
        String local = Utils.readLineFromConsole("Rua/Av.: ");
        String codigoPostal = Utils.readLineFromConsole("Codigo Postal: ");
        String localidade = Utils.readLineFromConsole("Localidade: ");
        boolean decisao = m_controller.novoFreelancer(nome,nif,email,telefone,localidade,codigoPostal,local);
        do{
            introduzHabilitacaoAcademica();
            this.m_controller.registaHabilitacaoAcademica();
        }while(Utils.confirma("Deseja Introduzir Mais Habilitações? (S/N)"));
        do{
            introduzReconhecimentoCompetenciaTecnica();
            this.m_controller.registaReconhecimentoCompetenciaTecnica();
        }while(Utils.confirma("Deseja Introduzir Mais Reconhecimento Tecninco? (S/N)"));

        return decisao;
    }

    /**
     * Introduz habilitacao academica boolean.
     *
     * @return the boolean
     */
    public boolean introduzHabilitacaoAcademica() {
        String grau = Utils.readLineFromConsole("Grau: ");
        String desing = Utils.readLineFromConsole("Designação: ");
        String inst = Utils.readLineFromConsole("Instituição: ");
        double media = Double.parseDouble(Utils.readLineFromConsole("Media: "));
        return m_controller.novaHabilitacaoAcademica(grau,desing,inst,media);
    }
    private void apresentaDados()
    {
        System.out.println("\nFreelancer:\n" + m_controller.getFreelancerToString());
    }

    /**
     * Introduz reconhecimento competencia tecnica boolean.
     *
     * @return the boolean
     */
    public boolean introduzReconhecimentoCompetenciaTecnica(){
        List lc = this.m_controller.getCTList();
        CompetenciaTecnica ct = (CompetenciaTecnica) Utils.apresentaESeleciona(lc, "Selecione a Competencia Tecnica Mais Apropriada:");
        List lgp = ct.getGrauProficienciaList();
        GrauProficiencia gp= (GrauProficiencia) Utils.apresentaESeleciona(lgp,"Selecione o Grau de Proficiencia Mais Adequado:");
        return this.m_controller.novoReconhecimentoCompetenciaTecnica(ct.getM_strId(),gp.getValor());

    }
}


