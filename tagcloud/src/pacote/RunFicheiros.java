
package pacote;

import com.sun.codemodel.internal.JOp;
import java.io.*;
import javax.swing.JOptionPane;

class Ficheiro {
    private BufferedReader fr;
    private BufferedWriter fw;
    
    public void abreLeitura( String nomeFicheiro ) throws IOException {
        fr = new BufferedReader( new FileReader( nomeFicheiro ) );
    }
    
    public void abreEscrita( String nomeFicheiro ) throws IOException {
        fw = new BufferedWriter( new FileWriter( nomeFicheiro ) );
    }
    
    public void fechaEscrita() throws IOException {
        fw.close();
    }
    
    public String leLinha() throws IOException{
        return fr.readLine();
    }
    
     public void escreveLinha( String linha ) throws IOException{
        System.out.println( "Vou escrever: " + linha);
        fw.write( linha, 0, linha.length());
        fw.newLine();
    }
}

public class RunFicheiros {
    
    public static void main(String[] args) throws IOException{
        Ficheiro f1 = new Ficheiro();
        Ficheiro f2 = new Ficheiro();
        String linha;
        
        f1.abreEscrita("fxw.txt");     // ficheiro de leitura
        f2.abreLeitura( "fxr.txt" );   // ficheiro de escrita
        
        
        System.out.println( "Teste com ficheiros:");
        do{
            linha = JOptionPane.showInputDialog("Introduza uma linha para o ficheiro:");
            
            f1.escreveLinha(linha);
        } while( !linha.equals("fim"));
        
        f1.fechaEscrita();  
        
        do{
            linha = f2.leLinha();
            System.out.println( "Linha lida do ficheiro: "+linha);
        }while( linha != null );
    }
}
