/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisaordenacao.LDE;

/**
 *
 * @author Rafael Delanhese
 */
public class LDEMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lde = new Lista();
        System.out.println("--MÉTODOS DE ORDENAÇÃO EM LISTA DUPLAMENTE ENCADEADA--");
        System.out.println("\n");
        
        lde.inicializa();
        lde.insereDadosLista();
        System.out.println("--INSERÇÃO DIRETA--");
        lde.exibir();
        lde.insercaoDireta();
        System.out.println(" ");
        lde.exibir();
        System.out.println(" ");

        lde.inicializa();
        lde.insereDadosLista();
        System.out.println("--SELEÇÃO DIRETA--");
        lde.exibir();
        lde.selecaoDireta();
        System.out.println(" ");
        lde.exibir();
        System.out.println(" ");

        lde.inicializa();
        lde.insereDadosLista();
        System.out.println("--BOLHA--");
        lde.exibir();
        lde.bolha();
        System.out.println(" ");
        lde.exibir();
        System.out.println(" ");

        lde.inicializa();
        lde.insereDadosLista();
        System.out.println("--SHAKE--");
        lde.exibir();
        lde.shake();
        System.out.println(" ");
        lde.exibir();
    }

}
