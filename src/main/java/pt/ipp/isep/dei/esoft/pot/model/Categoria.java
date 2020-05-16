package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.model.Listas.lstCaracterCT;
import pt.ipp.isep.dei.esoft.pot.model.Registo.RegistoCategorias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Categoria.
 */
public class Categoria implements Serializable {
    private String m_strDescricao;
    private AreaAtividade m_Area;
    private lstCaracterCT listCaracterCT;

    private String m_strId;


    /**
     * Instantiates a new Categoria.
     *
     * @param id           the id
     * @param strDescricao the str descricao
     * @param m_Area       the m area
     */
    public Categoria(String id,String strDescricao,AreaAtividade m_Area) {
        if (strDescricao == null)
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        this.m_strDescricao = strDescricao;
        this.m_strId = id;
        this.m_Area= m_Area;
        this.listCaracterCT = new lstCaracterCT();
    }

    /**
     * Has id boolean.
     *
     * @param strId the str id
     * @return the boolean
     */
    public boolean hasId(String strId) {
        return this.m_strId.equalsIgnoreCase(strId);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return this.m_strId;
    }



    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Categoria obj = (Categoria) o;
        return (Objects.equals(m_strDescricao, obj.m_strDescricao));
    }

    @Override
    public String toString() {
        String competencias = " ";

        return String.format("%s - Area de atividade %s - Competencia(s) Tecnica(s) %s", this.m_strDescricao, this.m_Area.toString(), competencias);
    }

    /**
     * Regista caracter ct boolean.
     *
     * @param cCt the c ct
     * @return the boolean
     */
    public boolean registaCaracterCT(CaraterCT cCt){
        if (this.validacaracterTC(cCt)){
            this.addCaracterCT(cCt);
            return true;
        }else{
            return false;
        }
   }

    /**
     * Novo caracter ct carater ct.
     *
     * @param m_oCompetenciaTecnica the m o competencia tecnica
     * @param gp                    the gp
     * @param obg                   the obg
     * @return the carater ct
     */
    public CaraterCT novoCaracterCT (CompetenciaTecnica m_oCompetenciaTecnica,GrauProficiencia gp,boolean obg){
        return new CaraterCT(m_oCompetenciaTecnica,gp,obg);
   }


    /**
     * Add caracter ct boolean.
     *
     * @param cCt the c ct
     * @return the boolean
     */
    public boolean addCaracterCT(CaraterCT cCt ) {
       return this.listCaracterCT.add(cCt);

    }


    /**
     * Validacaracter tc boolean.
     *
     * @param cCt the c ct
     * @return the boolean
     */
    public boolean validacaracterTC(CaraterCT cCt) {
        return true;

    }

    /**
     * Get caracter ct list list.
     *
     * @return the list
     */
    public List<CaraterCT> getCaracterCTList(){
        return this.listCaracterCT.getCaracterCTList();
    }
    public List<CompetenciaTecnica> getListaCT(){
        List<CompetenciaTecnica> lct = new ArrayList<>();
        for (CaraterCT ctt:this.getCaracterCTList()){
            lct.add(ctt.getCt());
        }
        return lct;
    }


}
