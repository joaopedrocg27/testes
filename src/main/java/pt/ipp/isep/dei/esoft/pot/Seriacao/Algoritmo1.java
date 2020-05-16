package pt.ipp.isep.dei.esoft.pot.Seriacao;


import pt.ipp.isep.dei.esoft.pot.model.*;

import java.util.List;

/**
 * The type Algoritmo 1.
 */
public class Algoritmo1 extends Regimento {
    /**
     * Instantiates a new Algoritmo 1.
     */
    private int ID;
    private String nome;
    private String descricao;

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }



    public Algoritmo1(int ID, String nome, String descricao) {
        super(ID,nome,descricao);
    }
    public String toString(){
        return "Regimento1";
    }
    @Override
    public List<Candidatura> Seriar(Anuncio anum) {
        List<Candidatura> candList = anum.getList().getCandidaturaList();
        for (int i=1;i<anum.getList().getCandidaturaList().size();i++){
            double media1=calcularMedia(candList.get(i-1),anum);
            double media2=calcularMedia(candList.get(i),anum);
            if (media1<media2){
                candList = inverte(candList,i);
                if (i>1)
                    i--;
            }
            if (media1==media2){
                        if (candList.get(i-1).getValorPretendido()>candList.get(i).getValorPretendido()){
                            candList = inverte(candList,i);
                            if (i>1)
                                i--;
                            if (candList.get(i-1).getValorPretendido()==candList.get(i).getValorPretendido()){
                                if (candList.get(i-1).getData().after(candList.get(i).getData())){
                                    candList = inverte(candList,i);
                                }
                        }
                    }
                }
            }
        return candList;
        }


    private double calcularMedia (Candidatura c,Anuncio anum){
        double media=0;
        int valorNumero=0;
        for (ReconhecimentoCompetenciaTecnica rct:c.getFree().getListRCT()){
            if (anum.getTarefa().getCat().getListaCT().contains(rct.getCt())){
                media = media+ rct.getGp().getValor();
                valorNumero++;
            }
        }
        return media / valorNumero;
    }
    private List<Candidatura> inverte (List<Candidatura> candList,int i){
        Candidatura cTemp = candList.get(i);
        candList.set(i,candList.get(i-1));
        candList.set(i-1,cTemp);
        return candList;
    }


}
