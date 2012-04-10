/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nuvem_tags;

/**
 *
 * @author pedrogoncalves
 */
public class Palavra {
   
    
    private int noccurencias;
    private String conteudo;

    public Palavra() {
    
        this.conteudo = null;
        this.noccurencias = 0;
        
    }
    public Palavra Palavra(String x, int occur) {
        Palavra a = new Palavra();
        a.setConteudo(x);
        a.setNoccurencias(occur);
        return a;
    }
    
    
    
    
    
    /**
     * @return the noccurencias
     */
    public int getNoccurencias() {
        return noccurencias;
    }

    /**
     * @param noccurencias the noccurencias to set
     */
    public void setNoccurencias(int noccurencias) {
        this.noccurencias = noccurencias;
    }

    /**
     * @return the conteudo
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo the conteudo to set
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
