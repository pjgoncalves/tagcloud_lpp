package pacote;

import java.util.LinkedList;

public class No {
    
    private String palavra;
    private LinkedList ocurr;
    private No esquerda;
    private No direita;
    
    No(){
        
    ocurr = new LinkedList<Integer>();
         
    }
  
    
    public Object[] getOcurr(){
        return this.ocurr.toArray();
                
    }
    
    
    public void NovaOcurr(int linha){
    
    this.ocurr.add(linha);
   }
    

    
    
    public String getPalavra() {
        return palavra; 
   }


    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
    
    public No getEsquerda(){
        return esquerda;
    }
    
    public No getDireita(){
        return direita;
    }
     
    public void setEsquerda( No e ){
        esquerda = e;
    }
    
     public void setDireita( No d ){
        direita = d;
    }
     

   
}