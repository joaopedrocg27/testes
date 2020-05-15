package pt.ipp.isep.dei.esoft.pot.model.Registo;

import pt.ipp.isep.dei.esoft.pot.Seriacao.Seriacao;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Regimento;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The type Registo tipos regimento.
 */
public class RegistoTiposRegimento implements Serializable {

    private List<Object> ListTiposRegimento;
    private List<Seriacao> ListSeriacao;

    /**
     * Instantiates a new Registo tipos regimento.
     *
     * @throws IOException               the io exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws InvocationTargetException the invocation target exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     */
    public RegistoTiposRegimento() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.ListTiposRegimento = new ArrayList<>();
        this.ListSeriacao = new ArrayList<>();
        File fichConfiguracao = new File("resources/config.properties");
        FileReader reader = new FileReader(fichConfiguracao);
        Properties props = new Properties();
        props.load(reader);
        for (int i=1;i<=Integer.parseInt(props.getProperty("NumeroDeTiposDeRegimento"));i++){
            this.ListTiposRegimento.add(this.getAlgoritmoSeriacao(props,i));
            Class cls = this.ListTiposRegimento.get(i-1).getClass();
            Method met = cls.getDeclaredMethod("toString");
            Seriacao sec = new Seriacao(i, (String) met.invoke(this.ListTiposRegimento.get(i-1)));
            this.ListSeriacao.add(sec);
            sec.setSeriacaoObj(this.ListTiposRegimento.get(i-1));

        }
    }

    /**
     * Gets tipos regimento.
     *
     * @return the tipos regimento
     */
    public List getTiposRegimento() {
        return null;
    }

    /**
     * Novo tipo regimento regimento.
     *
     * @param id   the id
     * @param desc the desc
     * @param nome the nome
     * @return the regimento
     */
    public Regimento novoTipoRegimento(String id, String desc, String nome){
        return new Regimento(id,desc,nome);
    }

    /**
     * Valida regimento boolean.
     *
     * @param reg the reg
     * @return the boolean
     */
    public boolean validaRegimento(Regimento reg){
        return !this.ListTiposRegimento.contains(reg);
    }

    /**
     * Get list seriacao list.
     *
     * @return the list
     */
    public List<Seriacao> getListSeriacao(){
        return this.ListSeriacao;
    }

    /**
     * Gets list tipos regimento.
     *
     * @return the list tipos regimento
     */
    public List<Object> getListTiposRegimento() {
        return ListTiposRegimento;
    }

    /**
     * Add tarefa boolean.
     *
     * @param reg the reg
     * @return the boolean
     */
    public boolean addTarefa(Regimento reg) {
        return ListTiposRegimento.add(reg);
    }

    /**
     * Regista regimento boolean.
     *
     * @param reg the reg
     * @return the boolean
     */
    public boolean registaRegimento (Regimento reg){
        if (this.validaRegimento(reg)){

            return this.addTarefa(reg);
        }else{
            return false;
        }
    }

    /**
     * Gets regimento by desc.
     *
     * @param desTR the des tr
     * @return the regimento by desc
     */
    public Object getRegimentoByDesc(int desTR) {
        for(Seriacao sec: this.ListSeriacao){
            if(sec.getNumeroRegimeno()==desTR){
                return sec.getSeriacaoObj();
            }
        }
        return null;
    }

    /**
     * Gets algoritmo seriacao.
     *
     * @param props  the props
     * @param numero the numero
     * @return the algoritmo seriacao
     * @throws IOException               the io exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InstantiationException    the instantiation exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws InvocationTargetException the invocation target exception
     */
    public Object getAlgoritmoSeriacao(Properties props,int numero) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        String nomeFicheiro = "classe." + numero;

        Class<?> oClass = Class.forName(props.getProperty(nomeFicheiro));

        System.out.println(oClass.toString());



        return oClass.newInstance();

    }
}
