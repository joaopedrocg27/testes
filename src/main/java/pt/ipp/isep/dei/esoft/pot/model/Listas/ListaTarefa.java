package pt.ipp.isep.dei.esoft.pot.model.Listas;

import pt.ipp.isep.dei.esoft.pot.model.Categoria;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Lista tarefa.
 */
public class ListaTarefa implements Serializable {
    private final Set<Tarefa> oLsTarefa;

    /**
     * Instantiates a new Lista tarefa.
     */
    public ListaTarefa(){
        this.oLsTarefa = new HashSet<>();
    }


    /**
     * Nova tarefa tarefa.
     *
     * @param strRefUnica     the str ref unica
     * @param strDesig        the str desig
     * @param strDescInformal the str desc informal
     * @param strCaracTecnico the str carac tecnico
     * @param strDuracao      the str duracao
     * @param strCusto        the str custo
     * @param catTarefa       the cat tarefa
     * @return the tarefa
     */
    public Tarefa novaTarefa(String strRefUnica, String strDesig, String strDescInformal, String strCaracTecnico, int strDuracao, int strCusto, Categoria catTarefa){
        return new Tarefa(strRefUnica, strDesig,strDescInformal,strCaracTecnico,strDuracao,strCusto,catTarefa);
    }

    /**
     * Valida tarefa boolean.
     *
     * @param tar the tar
     * @return success or fail (boolean)
     */
    public boolean validaTarefa(Tarefa tar){
        return !this.oLsTarefa.contains(tar);
    }

    /**
     * Gets lista tarefa.
     *
     * @return the lista tarefa
     */
    public List<Tarefa> getListaTarefa() {
        ArrayList<Tarefa> at = new ArrayList<>(this.oLsTarefa);

        return at;
    }

    /**
     * Get tarefa by ref tarefa.
     *
     * @param ref the ref
     * @return the tarefa
     */
    public Tarefa getTarefaByRef(String ref){
        for (Tarefa t:this.oLsTarefa){
            if (t.getRef().equals(ref)){
                return t;
            }
        }
        return null;
    }

    /**
     * Add tarefa boolean.
     *
     * @param tar the tar
     * @return success or fail (boolean)
     */
    public boolean addTarefa(Tarefa tar) {
        return oLsTarefa.add(tar);
    }

    /**
     * Regista tarefa boolean.
     *
     * @param tar the tar
     * @return success or fail (boolean)
     */
    public boolean registaTarefa (Tarefa tar){
        if (this.validaTarefa(tar)){

            return this.addTarefa(tar);
        }else{
            return false;
        }
    }


    /**
     * Gets tarefas para publicar.
     *
     * @param c the c
     * @return the tarefas para publicar
     */
    public List<Tarefa> getTarefasParaPublicar(Colaborador c) {
        List<Tarefa> lista = new ArrayList<>();
        for (Tarefa t : this.oLsTarefa){
            if (t.getColab().equals(c)){
                lista.add(t);
            }
        }
        return lista;
    }

    /**
     * Gets tarefas para publicar by ref.
     *
     * @param ref the ref
     * @param c   the c
     * @return the tarefas para publicar by ref
     */
    public Tarefa getTarefasParaPublicarByRef(String ref, Colaborador c) {
        for (Tarefa t : this.oLsTarefa){
            if (t.getRef().equals(ref)){
                return  t;
            }
        }
    return null;
    }
}
