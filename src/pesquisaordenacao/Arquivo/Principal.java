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
public class Principal {

    ArquivoJava arqOrd, arqRev, arqRand, auxRev, auxRand;
    int compOrd, compRev, compRand, movOrd, movRev, movRand;
    long tTotalOrd, tTotalRev, tTotalRand, tempoInicio, tempoFim;

    public void geraTabela() {
        arqOrd = new ArquivoJava("arquivos/arquivoOrdenado.dat");
        arqRev = new ArquivoJava("arquivos/arquivoReverso.dat");
        arqRand = new ArquivoJava("arquivos/arquivoRandomico.dat");

        //MÉTODO PARA A GERAÇÃO DA TABELA
        arqOrd.geraArquivoOrdenado();
        arqRev.geraArquivoReverso();
        arqRand.geraArquivoRandomico();

        //INSERÇÃO DIRETA
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.insercaoDireta();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;
        arqOrd.complexidadeInsercaoDireta(1, arqOrd.fileSize());

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoID.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.insercaoDireta();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;
        auxRand.complexidadeInsercaoDireta(2, auxRand.fileSize());

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoID.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.insercaoDireta();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;
        auxRev.complexidadeInsercaoDireta(3, auxRev.fileSize());

        gravaLinhaTabela("Inserção Direta", compOrd, arqOrd.getCompEqua(), movOrd, arqOrd.getMovEqua(), tTotalOrd,
                compRand, auxRand.getCompEqua(), movRand, auxRand.getMovEqua(), tTotalRand,
                compRev, auxRev.getCompEqua(), movRev, auxRev.getMovEqua(), tTotalRev);

        //INSERÇÃO BINÁRIA
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.insercaoBinaria();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;
        arqOrd.complexidadeInsercaoBinaria(1, arqOrd.fileSize());

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoIB.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.insercaoBinaria();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;
        auxRand.complexidadeInsercaoBinaria(2, auxRand.fileSize());

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoIB.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.insercaoBinaria();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;
        auxRev.complexidadeInsercaoBinaria(3, auxRev.fileSize());

        gravaLinhaTabela("Inserção Binária", compOrd, arqOrd.getCompEqua(), movOrd, arqOrd.getMovEqua(), tTotalOrd,
                compRand, auxRand.getCompEqua(), movRand, auxRand.getMovEqua(), tTotalRand,
                compRev, auxRev.getCompEqua(), movRev, auxRev.getMovEqua(), tTotalRev);

        //SELEÇÃO DIRETA
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.selecaoDireta();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;
        arqOrd.complexidadeSelecaoDireta(1, arqOrd.fileSize());

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoSD.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.selecaoDireta();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;
        auxRand.complexidadeSelecaoDireta(2, auxRand.fileSize());

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoSD.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.selecaoDireta();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;
        auxRev.complexidadeSelecaoDireta(3, auxRev.fileSize());

        gravaLinhaTabela("Seleção Direta", compOrd, arqOrd.getCompEqua(), movOrd, arqOrd.getMovEqua(), tTotalOrd,
                compRand, auxRand.getCompEqua(), movRand, auxRand.getMovEqua(), tTotalRand,
                compRev, auxRev.getCompEqua(), movRev, auxRev.getMovEqua(), tTotalRev);

        //BOLHA
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.bolha();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;
        arqOrd.complexidadeBolhaShake(1, arqOrd.fileSize());

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoBolha.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.bolha();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;
        auxRand.complexidadeBolhaShake(2, auxRand.fileSize());

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoBolha.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.bolha();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;
        auxRev.complexidadeBolhaShake(3, auxRev.fileSize());

        gravaLinhaTabela("Bolha", compOrd, arqOrd.getCompEqua(), movOrd, arqOrd.getMovEqua(), tTotalOrd,
                compRand, auxRand.getCompEqua(), movRand, auxRand.getMovEqua(), tTotalRand,
                compRev, auxRev.getCompEqua(), movRev, auxRev.getMovEqua(), tTotalRev);

        //SHAKE
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.shakeSort();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;
        arqOrd.complexidadeBolhaShake(1, arqOrd.fileSize());

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoShake.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.shakeSort();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;
        auxRand.complexidadeBolhaShake(2, auxRand.fileSize());

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoShake.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.shakeSort();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;
        auxRev.complexidadeBolhaShake(3, auxRev.fileSize());

        gravaLinhaTabela("ShakeSort", compOrd, arqOrd.getCompEqua(), movOrd, arqOrd.getMovEqua(), tTotalOrd,
                compRand, auxRand.getCompEqua(), movRand, auxRand.getMovEqua(), tTotalRand,
                compRev, auxRev.getCompEqua(), movRev, auxRev.getMovEqua(), tTotalRev);

        //SHELL
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.shellSort();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoShell.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.shellSort();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoShell.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.shellSort();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;

        gravaLinhaTabela("ShellSort", compOrd, arqOrd.getCompEqua(), movOrd, arqOrd.getMovEqua(), tTotalOrd,
                compRand, auxRand.getCompEqua(), movRand, auxRand.getMovEqua(), tTotalRand,
                compRev, auxRev.getCompEqua(), movRev, auxRev.getMovEqua(), tTotalRev);

        //HEAP
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.heapSort();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoHeap.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.heapSort();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoHeap.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.heapSort();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;

        gravaLinhaTabela("HeapSort", compOrd, arqOrd.getCompEqua(), movOrd, arqOrd.getMovEqua(), tTotalOrd,
                compRand, auxRand.getCompEqua(), movRand, auxRand.getMovEqua(), tTotalRand,
                compRev, auxRev.getCompEqua(), movRev, auxRev.getMovEqua(), tTotalRev);

        //QUICK COM PIVO
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.quickCP();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoQuickComPivo.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.quickCP();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoQuickComPivo.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.quickCP();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;

        gravaLinhaTabela("QuickSort - C/ Pivo", compOrd, 0, movOrd, 0, tTotalOrd,
                compRand, 0, movRand, 0, tTotalRand,
                compRev, 0, movRev, 0, tTotalRev);

        //QUICK SEM PIVO
        //ARQUIVO ORDENADO
        arqOrd.initComp();
        arqOrd.initMov();
        arqOrd.initCompEqua();
        arqOrd.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        arqOrd.quickSP();
        tempoFim = System.currentTimeMillis();
        compOrd = arqOrd.getComp();
        movOrd = arqOrd.getMov();
        tTotalOrd = tempoFim - tempoInicio;

        //ARQUIVO RANDOMICO
        auxRand = new ArquivoJava("arquivos/arquivoAuxiliarRandomicoQuickSemPivo.dat");
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        auxRand.initCompEqua();
        auxRand.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRand.quickSP();
        tempoFim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        tTotalRand = tempoFim - tempoInicio;

        //ARQUIVO REVERSO
        auxRev = new ArquivoJava("arquivos/arquivoAuxiliarReversoQuickSemPivo.dat");
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        auxRev.initCompEqua();
        auxRev.initMovEqua();
        tempoInicio = System.currentTimeMillis();
        auxRev.quickSP();
        tempoFim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        tTotalRev = tempoFim - tempoInicio;

        gravaLinhaTabela("QuickSort - S/ Pivo", compOrd, arqOrd.getCompEqua(), movOrd, arqOrd.getMovEqua(), tTotalOrd,
                compRand, auxRand.getCompEqua(), movRand, auxRand.getMovEqua(), tTotalRand,
                compRev, auxRev.getCompEqua(), movRev, auxRev.getMovEqua(), tTotalRev);

    }

    public void gravaLinhaTabela(String nomeMet, int compOrd, double compEquaOrd, int movOrd, double movEquaOrd, long tTotalOrd,
            int compRand, double compEquaRand, int movRand, double movEquaRand, long tTotalRand,
            int compRev, double compEquaRev, int movRev, double movEquaRev, long tTotalRev) {

        /*System.out.println(nomeMet + "\t\t" + String.valueOf(compOrd) + "\t" + String.valueOf(compEquaOrd) + "\t" + String.valueOf(movOrd) + "\t" + String.valueOf(movEquaOrd) + "\t" + String.valueOf(tTotalOrd) + "\t"
                + String.valueOf(compRand) + " " + String.valueOf(compEquaRand) + " " + String.valueOf(movRand) + " " + String.valueOf(movEquaRand) + " " + String.valueOf(tTotalRand) + "\t\t"
                + String.valueOf(compRev) + " " + String.valueOf(compEquaRev) + " " + String.valueOf(movRev) + " " + String.valueOf(movEquaRev) + " " + String.valueOf(tTotalRev));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");*/
        System.out.print(nomeMet);
        insereEspacoEmBraco(25,nomeMet);
        System.out.print(compOrd);
        insereEspacoEmBraco(14,String.valueOf(compOrd));
        System.out.print(compEquaOrd);
        insereEspacoEmBraco(13,String.valueOf(compEquaOrd));
        System.out.print(movOrd);
        insereEspacoEmBraco(13,String.valueOf(movOrd));
        System.out.print(movEquaOrd);
        insereEspacoEmBraco(13,String.valueOf(movEquaOrd));
        System.out.print(tTotalOrd);
        
        insereEspacoEmBraco(6,String.valueOf(tTotalOrd));
        System.out.print(compRev);
        insereEspacoEmBraco(13,String.valueOf(compRev));
        System.out.print(compEquaRev);
        insereEspacoEmBraco(13,String.valueOf(compEquaRev));
        System.out.print(movRev);
        insereEspacoEmBraco(12,String.valueOf(movRev));
        System.out.print(movEquaRev);
        insereEspacoEmBraco(9,String.valueOf(movEquaRev));
        System.out.print(tTotalRev);
        
        insereEspacoEmBraco(6,String.valueOf(tTotalRev));
        System.out.print(compRand);
        insereEspacoEmBraco(13,String.valueOf(compRand));
        System.out.print(compEquaRand);
        insereEspacoEmBraco(13,String.valueOf(compEquaRand));
        System.out.print(movRand);
        insereEspacoEmBraco(12,String.valueOf(movRand));
        System.out.print(movEquaRand);
        insereEspacoEmBraco(13,String.valueOf(movEquaRand));
        System.out.print(tTotalRand);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void insereEspacoEmBraco(int tamCampoTab, String nomeVariavel) {
        int diferenca = tamCampoTab - nomeVariavel.codePointCount(0, nomeVariavel.length());
        for (int i = 0; i < diferenca; i++) {
            System.out.print(" ");
        }
    }

    public void cabecalhoTabela() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Métodos Ordenação\t|Arquivo Ordenado\t\t\t\t\t|Arquivo em Ordem Reversa\t\t\t\t|Arquivo Randômico");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t|Comp. Prog *|Comp. Equa #|Mov. Prog. +|Mov Equa -|Tempo|Comp. Prog *|Comp. Equa #|Mov. Prog. +|Mov Equa -|Tempo|Comp. Prog *|Comp. Equa #|Mov. Prog. +|Mov Equa -|Tempo|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String args[]) {
        Principal p = new Principal();
        p.cabecalhoTabela();
        p.geraTabela();
        
    }
}
