package pt.ipp.isep.dei.esoft.autorizacao;

/**
 * The interface Algoritimo gerador pwd.
 */
public interface AlgoritimoGeradorPwd {
    /**
     * Gerar password string.
     *
     * @param nome  the nome
     * @param email the email
     * @return the string
     */
    String gerarPassword(String nome,String email);
}
