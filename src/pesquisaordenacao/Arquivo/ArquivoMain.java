/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisaordenacao.Arquivo;

/**
 *
 * @author Rafael Delanhese
 */
public class ArquivoMain {

    /**
     * @param args the command line arguments
     */
    
    /*
    ALGORITMO JÁ TESTADOS EM ARQUIVO E ESTÃO OK:
    
    INSERÇÃO DIRETA
    INSERÇÃO BINÁRIA
    SELEÇÃO DIRETA
    BOLHA
    SHAKE SORT
    HEAP SORT
    SHEEL SORT
    QUICK SEM PIVO
    QUICK COM PIVO
    */
    public static void main(String[] args) {
        ArquivoJava arquivo = new ArquivoJava("arquivos/arquivoReverso.dat");
        arquivo.geraArquivoReverso();
        arquivo.exibirArq();
        arquivo.insercaoDireta();
        arquivo.exibirArq();
        
    }

}
