package pacote;

import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.Comparator;
import nuvem_tags.Palavra;
import processing.core.*;

public class Main {

    public No raiz = null;
    public List<Palavra> heapPalavras = new ArrayList<Palavra>();
    
    

    
    public static void main(String[] args) throws IOException {
       new Main().exec();
        
    }
    
 
    
    
    
    // imprime a arvore
    public List<Palavra> imprime( No a , List<Palavra> x ){
        
        if( a != null ){
        Palavra tempWord = new Palavra();    
            imprime( a.getEsquerda(), x );
            String temp="";
            int total;
            
            // ciclo que prepara a impressao das linhas onde ocorrem as palavras
            // prepara uma string com as linhas onde a palavra ocorre. (temp)
            
            for (int i = 0; i < a.getOcurr().length; i++) {
                 temp += "|" + a.getOcurr()[i] + "| ";
                 
            }
            System.out.printf("%-15s %-10d %s %n",a.getPalavra(),a.getOcurr().length,temp);
           
            // parse da palavra e num. de ocurrencias
            tempWord.setConteudo(a.getPalavra());
            tempWord.setNoccurencias(a.getOcurr().length);
            // adiciono o no a lista, para usar no heap
            x.add(tempWord);
            
            temp = "";
            tempWord = null;
            imprime( a.getDireita(), x );
        }
        // retorno da lista de palavras e respectivas ocurrencias,
        // a lista ser‡ em seguida ordenada por num. de occurencias.
        
        
        return x;
    }
    
    
    // metodo para inserir novos nos na arvore
    public No insere( No node, String palavra, int linha ){
        if( node == null ){
            node = new No();
            node.setPalavra( palavra );
            node.setEsquerda( null );
            node.setDireita( null );
            node.NovaOcurr(linha);
        }
        else{
            if(  palavra.compareTo(node.getPalavra())<0 ){
                node.setEsquerda( insere( node.getEsquerda(), palavra, linha ));
            } else if (palavra.compareTo(node.getPalavra())>0 ){
                node.setDireita( insere( node.getDireita(), palavra, linha));
            }
            else{
                // caso a palavra exista, insere a linha em que ela aparece
                node.NovaOcurr(linha);
                return node;
            }
        }
        return node;
    }
    
    
    
    public No pesquisa( No temp, String palavra, int linha ){
        if( temp == null ){
            return null;
        }
        else {
            if( palavra.equals(temp.getPalavra()) ){
               
                return temp;
            }
            else {
                if( palavra.compareTo(temp.getPalavra()) >0 ){
                   return pesquisa( temp.getEsquerda(), palavra, linha );
                }
                else {
                    return pesquisa( temp.getDireita(), palavra, linha );
                }
            }
        }
    }
   
    
    public void exec() throws IOException{
        
        No n;
        String linha;
        String textoMem[];
        Ficheiro a = new Ficheiro();
        a.abreLeitura("texto.txt");
        
         int contalinha=0;
      
         /*  ciclo que faz leitura linha-a-linha do ficheiro 
            para controlar a linha em que as palavras ocorrem,
            evita fazer verificacoes if(a.linha==null) senao na ultima
            linha a ler daria erro porque depois do if a leitura seguinte 
            ja seria da proxima linha (null)
         */
         
         
         while (1!=0) 
        {            
            linha=a.leLinha();
           
            if (linha == null)
                break;
            else
            {
                contalinha++;
                
                textoMem = linha.split(" ");
                
                
            /*  ordena o vector */
                Arrays.sort(textoMem);
        
            }
            
            /*
             ciclo que percorre as palavras de uma linha, pesquisa-as na arvore 
             * e caso nao existam, insere-as. o controlo para palavras que j‡ existem
             * Ž feito no metodo insere()
             */
            for (int i = 0; i < textoMem.length; i++) {
                
                
                n = pesquisa( raiz, textoMem[i] , contalinha);
                
                 if( n != null ){
                
                 insere(n, textoMem[i], contalinha);
               
            }
            else{
                raiz = insere(raiz, textoMem[i], contalinha);
               
            }
            }
            
        }
         
        // cabealho de impressao
        System.out.printf("%-10s %-10s %10s %n","PALAVRA","OCORRENCIAS","LINHAS");
        
        imprime(raiz, getHeapPalavras());
        sortLista();
    }

    

    public Comparator<Palavra> COMPARATOR = new Comparator<Palavra>()
    {
        public int compare(Palavra o1, Palavra o2)
        {
            return o1.getNoccurencias() - o2.getNoccurencias();

        }

   
   };
    
    
    public void sortLista(){
   Collections.sort(getHeapPalavras(), COMPARATOR);
   
   for(Palavra temp : getHeapPalavras()){
   
       System.out.println(":: " + temp.getConteudo() + " " + temp.getNoccurencias());
   
   }
   
   }

    /**
     * @return the heapPalavras
     */
    public List<Palavra> getHeapPalavras() {
        return heapPalavras;
    }

   
   
 
    
    
}