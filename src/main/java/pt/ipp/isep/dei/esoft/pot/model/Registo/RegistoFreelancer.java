package pt.ipp.isep.dei.esoft.pot.model.Registo;

import pt.ipp.isep.dei.esoft.autorizacao.AlgoritimoGeradorPwd;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Listas.lstFree;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;

import java.io.Serializable;

/**
 * The type Registo freelancer.
 */
public class RegistoFreelancer implements AlgoritimoGeradorPwd, Serializable {
    private lstFree list;

    private AutorizacaoFacade autorizacao;

    /**
     * Instantiates a new Registo freelancer.
     *
     * @param autorizacao the autorizacao
     */
    public RegistoFreelancer(AutorizacaoFacade autorizacao){
        this.list = new lstFree();

        this.autorizacao=autorizacao;
    }

    /**
     * Novo freelancer freelancer.
     *
     * @param nome         the nome
     * @param nif          the nif
     * @param email        the email
     * @param telefone     the telefone
     * @param localidade   the localidade
     * @param codigoPostal the codigo postal
     * @param local        the local
     * @return the freelancer
     */
    public Freelancer novoFreelancer (String nome, String nif, String email, String telefone, String localidade, String codigoPostal, String local){
        return new Freelancer(nome, nif, email, telefone,localidade,codigoPostal,local);
    }

    /**
     * Get freelancer by email freelancer.
     *
     * @param email the email
     * @return the freelancer
     */
    public Freelancer getFreelancerByEmail(String email){
        for (Freelancer free: this.list.getFreelancerList()){
            if (free.getEmail().equals(email)){
                return free;
            }
        }
        return null;
    }

    /**
     * Valida freelancer boolean.
     *
     * @param free the free
     * @return success or fail (boolean)
     */
    public boolean validaFreelancer(Freelancer free){
        return !(this.list.getFreelancerList().contains(free));
    }

    /**
     * Regista freelancer boolean.
     *
     * @param free the free
     * @return success or fail (boolean)
     */
    public boolean registaFreelancer (Freelancer free){

        if (this.validaFreelancer(free)){
            String nome = free.getNome();
            String email = free.getEmail();
            String pwd = this.gerarPassword(nome,email);
            if (this.autorizacao.registaUtilizadorComPapel(nome,email,pwd, Constantes.PAPEL_FREELANCER)){
            return this.addFreelancer(free);}

        }
        return false;

    }

    private boolean addFreelancer (Freelancer free){
        return this.list.add(free);
    }
    @Override
    public String gerarPassword(String nome,String email){
        return nome + "123";
    }
}
