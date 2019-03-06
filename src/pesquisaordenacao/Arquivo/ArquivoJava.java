/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisaordenacao.Arquivo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Delanhese
 */
public class ArquivoJava {

    private String nomearquivo;
    private RandomAccessFile arquivo;
    private int comp;
    private int mov;
    private double compEqua;
    private double movEqua;
    private int tamArquivo = 20;
    //--GETTERS E SETTERS

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public int getComp() {
        return comp;
    }

    public int getMov() {
        return mov;
    }

    public void initMov() {
        this.mov = 0;
    }

    public void initComp() {
        this.comp = 0;
    }

    public void initCompEqua() {
        this.compEqua = 0;
    }

    public void initMovEqua() {
        this.movEqua = 0;
    }

    public double getCompEqua() {
        return compEqua;
    }

    public double getMovEqua() {
        return movEqua;
    }

    //------------------------------------------------
    public ArquivoJava(String nomearquivo) {
        try {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void truncate(long pos) //desloca eof
    {
        try {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc) {
        }
    }

    //semelhante ao feof() da linguagem C
    //verifica se o ponteiro esta no <EOF> do arquivo
    public boolean eof() {
        boolean retorno = false;
        try {
            if (arquivo.getFilePointer() == arquivo.length()) {
                retorno = true;
            }
        } catch (IOException e) {
        }
        return (retorno);
    }

    public int eofMerge() {
        Long retorno = null;
        try {
            if (arquivo.getFilePointer() == arquivo.length()) {
                retorno = arquivo.getFilePointer();
            }
        } catch (IOException e) {
        }
        return retorno.intValue();
    }

    public int fileSize() {
        try {
            return (int) arquivo.length() / Registro.length();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    //insere um Registro no final do arquivo, passado por parâmetro
    public void inserirRegNoFinal(Registro reg) {
        seekArq(fileSize());//ultimo byte
        reg.gravaNoArq(arquivo);
    }

    public void exibirArq() {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof()) {
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }

    public void exibirUmRegistro(int pos) {
        Registro aux = new Registro();
        seekArq(pos);
        System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos) {
        try {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e) {
        }
    }

    public void geraArq() {

        for (int i = 10; i > 0; i--) {
            inserirRegNoFinal(new Registro(i, "Nome " + i, 45));
        }
    }

    //GERA ARQUIVOS--
    //------------------------------------------------------------------------------
    public void geraArquivoOrdenado() {
        for (int i = 0; i < tamArquivo; i++) {
            inserirRegNoFinal(new Registro(i, "Nome " + i, 45));
        }
    }
    //------------------------------------------------------------------------------

    public void geraArquivoReverso() {
        for (int i = tamArquivo; i > 0; i--) {
            inserirRegNoFinal(new Registro(i, "Nome " + i, 45));
        }
    }
    //------------------------------------------------------------------------------

    public void geraArquivoRandomico() {
        Registro reg;
        Random gerador = new Random();
        try {
            for (int i = tamArquivo; i > 0; i--) {
                inserirRegNoFinal(new Registro(gerador.nextInt(999), "Nome " + i, 45));
            }
        } catch (Exception e) {
        }
    }

    public void copiaArquivo(RandomAccessFile arquivoOrigem) {
        try {
            Registro aux = new Registro();
            arquivoOrigem.seek(0);
            while (arquivoOrigem.getFilePointer() != arquivoOrigem.length()) {
                aux.leDoArq(arquivoOrigem);
                aux.gravaNoArq(arquivo);
            }
        } catch (IOException ex) {
            System.out.println("" + ex);
        }
    }

    public RandomAccessFile getFile() {
        return this.arquivo;
    }
//------------------------------------------------------------------------------
//COMPLEXIDADES

    public void complexidadeInsercaoDireta(int tipo, int n) {
        switch (tipo) {
            case 1:
                this.compEqua = n - 1;
                this.movEqua = 3 * (n - 1);
                break;
            case 2:
                this.compEqua = (n * n + n - 2) / 4;
                this.movEqua = (n ^ 2 + 9 * n - 10) / 4;
                break;
            case 3:
                this.compEqua = (n ^ 2 + n - 4) / 4;
                this.movEqua = (n ^ 2 + 3 * n - 4) / 2;
                break;
        }
    }

    public void complexidadeInsercaoBinaria(int tipo, int n) {
        this.compEqua = n * (((int) Math.log((double) n)) - (int) Math.log(Math.E));
        switch (tipo) {
            case 1:
                this.movEqua = 3 * (n - 1);
                break;
            case 2:
                this.movEqua = (n ^ 2 + 9 * n - 10) / 4;
                break;
            case 3:
                this.movEqua = (n ^ 2 + 3 * n - 4) / 2;
                break;
        }
    }

    public void complexidadeSelecaoDireta(int tipo, int n) {
        this.compEqua = (n ^ 2 - n) / 2;
        switch (tipo) {
            case 1:
                this.movEqua = 3 * (n - 1);
                break;
            case 2:
                this.movEqua = n * ((int) (Math.log((double) n) + Math.E));
                break;
            case 3:
                this.movEqua = n ^ 2 / 4 + 3 * (n - 1);
                break;

        }
    }

    public void complexidadeBolhaShake(int tipo, int n) {
        this.compEqua = (n ^ 2 - n) / 2;
        switch (tipo) {
            case 1:
                this.movEqua = 0;
                break;
            case 2:
                this.movEqua = 3 * (n ^ 2 - n) / 2;
                break;
            case 3:
                this.movEqua = 3 * (n ^ 2 - n) / 4;
                break;
        }
    }

    //.............................................................................
    /*

    insira aqui os métodos de Ordenação;            

     */
    public void insercaoDireta() {

        int pos;
        Registro regPos = new Registro();
        Registro regAux = new Registro();

        for (int i = 1; i < fileSize(); i++) {

            seekArq(i);
            regAux.leDoArq(arquivo);

            pos = i;

            seekArq(pos - 1);
            regPos.leDoArq(arquivo);

            this.comp++;
            while (pos > 0 && regAux.getCodigo() < regPos.getCodigo()) {
                seekArq(pos);
                regPos.gravaNoArq(arquivo);

                pos--;

                if ((pos - 1) >= 0) {
                    seekArq(pos - 1);
                    regPos.leDoArq(arquivo);
                }

                this.mov += 2;
                this.comp++;
            }

            this.comp++;
            seekArq(pos);
            regAux.gravaNoArq(arquivo);
            this.mov += 2;
        }
    }

    public int buscaBinaria(int chave, int tamanhoParteOrdenada) {
        int inicio = 0, fim = tamanhoParteOrdenada, meio = fim / 2;
        Registro regMeio = new Registro();

        seekArq(meio);
        regMeio.leDoArq(arquivo);
        while (inicio < fim && chave != regMeio.getCodigo()) {
            if (chave > regMeio.getCodigo()) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }

            meio = (inicio + fim) / 2;

            seekArq(meio);
            regMeio.leDoArq(arquivo);
        }

        return meio;
    }

    public void insercaoBinaria() {
        int pos;
        Registro regAux = new Registro();
        Registro regJ = new Registro();

        for (int i = 1; i < fileSize(); i++) {
            seekArq(i);
            regAux.leDoArq(arquivo);

            pos = buscaBinaria(regAux.getCodigo(), i);

            for (int j = i; j > pos; j--) {
                seekArq(j - 1);
                regJ.leDoArq(arquivo);
                regJ.gravaNoArq(arquivo);
                this.mov += 2;
                this.comp++;
            }

            seekArq(pos);
            regAux.gravaNoArq(arquivo);
            this.mov += 2;
            this.comp++;
        }
    }

    public void selecaoDireta() {

        int posMenor;

        Registro regMenor = new Registro();
        Registro regJ = new Registro();
        Registro regI = new Registro();
        for (int i = 0; i < fileSize(); i++) {
            seekArq(i);
            regI.leDoArq(arquivo);

            seekArq(i);
            regMenor.leDoArq(arquivo);

            posMenor = i;

            for (int j = i + 1; j < fileSize(); j++) {
                seekArq(j);
                regJ.leDoArq(arquivo);

                if (regJ.getCodigo() < regMenor.getCodigo()) {
                    seekArq(j);
                    regMenor.leDoArq(arquivo);
                    posMenor = j;
                }
                this.comp++;
            }

            seekArq(posMenor);
            regI.gravaNoArq(arquivo);

            seekArq(i);
            regMenor.gravaNoArq(arquivo);
            this.mov += 2;
        }
    }

    public void bolha() {
        int TL2 = fileSize();
        Registro regI = new Registro();
        Registro regIProx = new Registro();

        while (TL2 > 1) {
            for (int i = 0; i < TL2 - 1; i++) {
                seekArq(i);
                regI.leDoArq(arquivo);

                regIProx.leDoArq(arquivo);

                if (regI.getCodigo() > regIProx.getCodigo()) {
                    seekArq(i);
                    regIProx.gravaNoArq(arquivo);

                    regI.gravaNoArq(arquivo);
                    this.mov += 2;
                }
                this.comp++;
            }

            TL2--;
        }

    }

    public void shakeSort() {
        int TL2 = fileSize(), inicio = 0, i;
        Registro regI = new Registro();
        Registro regIProx = new Registro();

        while (inicio < TL2 - 1) {

            for (i = inicio; i < TL2 - 1; i++) {
                seekArq(i);
                regI.leDoArq(arquivo);

                regIProx.leDoArq(arquivo);

                if (regI.getCodigo() > regIProx.getCodigo()) {
                    seekArq(i);
                    regIProx.gravaNoArq(arquivo);

                    regI.gravaNoArq(arquivo);
                    this.mov += 2;
                }
                this.comp++;
            }

            TL2--;

            for (i = TL2 - 1; i > inicio; i--) {
                seekArq(i);
                regI.leDoArq(arquivo);

                seekArq(i - 1);
                regIProx.leDoArq(arquivo);

                if (regI.getCodigo() < regIProx.getCodigo()) {
                    seekArq(i - 1);
                    regI.gravaNoArq(arquivo);

                    regIProx.gravaNoArq(arquivo);
                    this.mov += 2;
                }
                this.comp++;
            }
            inicio++;
        }
    }

    public void heapSort() {
        int TL2 = fileSize(), pai, filhoEsquerda, filhoDireita, maiorFilho;

        Registro reg = new Registro();
        Registro regAux = new Registro();

        while (TL2 - 1 > 1) {
            for (pai = TL2 / 2 - 1; pai >= 0; pai--) {
                filhoEsquerda = 2 * pai + 1;
                filhoDireita = filhoEsquerda + 1;

                if (filhoDireita < TL2) {
                    seekArq(filhoEsquerda);
                    reg.leDoArq(arquivo);

                    seekArq(filhoDireita);
                    regAux.leDoArq(arquivo);

                    if (reg.getCodigo() < regAux.getCodigo()) {
                        maiorFilho = filhoEsquerda;
                    } else {
                        maiorFilho = filhoDireita;
                    }

                } else {
                    maiorFilho = filhoEsquerda;
                }

                seekArq(maiorFilho);
                reg.leDoArq(arquivo);

                seekArq(pai);
                regAux.leDoArq(arquivo);

                if (reg.getCodigo() > regAux.getCodigo()) {
                    seekArq(pai);
                    reg.gravaNoArq(arquivo);

                    seekArq(maiorFilho);
                    regAux.gravaNoArq(arquivo);
                    this.mov += 2;
                }
                this.comp++;
            }

            seekArq(TL2 - 1);
            reg.leDoArq(arquivo);

            seekArq(0);
            regAux.leDoArq(arquivo);

            seekArq(TL2 - 1);
            regAux.gravaNoArq(arquivo);

            seekArq(0);
            reg.gravaNoArq(arquivo);

            TL2--;
            this.mov += 2;
        }
    }

    public void shellSort() {
        int dist = 4, k, i, j;
        Registro reg = new Registro();
        Registro regAux = new Registro();

        while (dist > 0) {
            i = 0;
            while (i < dist) {
                j = i;

                while (j + dist < fileSize()) {
                    seekArq(j);
                    reg.leDoArq(arquivo);

                    seekArq(j + dist);
                    regAux.leDoArq(arquivo);

                    if (regAux.getCodigo() < reg.getCodigo()) {
                        seekArq(j);
                        regAux.gravaNoArq(arquivo);

                        seekArq(j + dist);
                        reg.gravaNoArq(arquivo);

                        k = j;

                        seekArq(k);
                        reg.leDoArq(arquivo);

                        seekArq(k - dist);
                        regAux.leDoArq(arquivo);

                        while (k - dist >= i && reg.getCodigo() < regAux.getCodigo()) {
                            seekArq(k - dist);
                            reg.gravaNoArq(arquivo);

                            seekArq(k);
                            regAux.gravaNoArq(arquivo);

                            k = k - dist;

                            seekArq(k);
                            reg.leDoArq(arquivo);

                            seekArq(k - dist);
                            regAux.leDoArq(arquivo);
                            this.comp += 2;
                        }
                    }
                    j = j + dist;
                    this.comp++;
                }
                i++;
            }
            dist = dist / 2;
        }
    }

    public void quickSP() {
        quickSemPivo(0, fileSize());
    }

    private void quickSemPivo(int ini, int fim) {
        int i = ini, j = fim;
        boolean flag = true;
        Registro regI = new Registro();
        Registro regJ = new Registro();

        while (i < j) {
            seekArq(i);
            regI.leDoArq(arquivo);

            seekArq(j);
            regJ.leDoArq(arquivo);

            if (flag) {
                while (i < j && regI.getCodigo() <= regJ.getCodigo()) {
                    i++;

                    seekArq(i);
                    regI.leDoArq(arquivo);
                    this.comp += 2;
                }
            } else {
                while (j > i && regJ.getCodigo() >= regI.getCodigo()) {
                    j--;

                    seekArq(j);
                    regJ.leDoArq(arquivo);
                    this.comp += 2;
                }

            }

            seekArq(i);
            regJ.gravaNoArq(arquivo);

            seekArq(j);
            regI.gravaNoArq(arquivo);

            flag = !flag;
            this.mov += 2;
        }

        this.comp++;
        if (ini < i - 1) {
            quickSemPivo(ini, i - 1);
        }
        this.comp++;
        if (j + 1 < fim) {
            quickSemPivo(j + 1, fim);
        }
    }

    public void quickCP() {
        quickComPivo(0, fileSize());
    }

    private void quickComPivo(int ini, int fim) {
        int i = ini, j = fim;

        Registro regI = new Registro();
        Registro regJ = new Registro();
        Registro regPivo = new Registro();

        seekArq((ini + fim) / 2);
        regPivo.leDoArq(arquivo);

        while (i < j) {
            seekArq(i);
            regI.leDoArq(arquivo);

            seekArq(j);
            regJ.leDoArq(arquivo);

            while (regI.getCodigo() < regPivo.getCodigo()) {
                i++;
                seekArq(i);
                regI.leDoArq(arquivo);
                this.comp++;
            }

            while (regJ.getCodigo() > regPivo.getCodigo()) {
                j--;
                seekArq(j);
                regJ.leDoArq(arquivo);
                this.comp++;
            }

            if (i <= j) {
                seekArq(i);
                regJ.gravaNoArq(arquivo);

                seekArq(j);
                regI.gravaNoArq(arquivo);

                i++;
                j--;
                this.comp++;
                this.mov++;
            }
        }
        this.comp++;
        if (ini < i - 1) {
            quickComPivo(ini, j - 1);
        }
        this.comp++;
        if (j + 1 < fim) {
            quickComPivo(i, fim);
        }
    }

    private int particao() {
        int posFinal = fileSize();
        int eof = eofMerge();
        Registro reg = new Registro();
        for (int i = 0; i < posFinal; i++) {
            seekArq(i);
            reg.leDoArq(arquivo);
            inserirRegNoFinal(reg);
            this.comp++;
        }

        return eof + 1;
    }

    private void fusao(int inicio, int seq) {
        int i = inicio, j = (inicio + fileSize()) / 2 + 1, k = 0, auxSeq = seq, seqI, seqJ;

        seqI = seq + i;
        seqJ = seq + j;
        Registro regI = new Registro();
        Registro regJ = new Registro();
        while (k < (inicio - 1)) {
            while (i < seqI && j < seqJ) {
                seekArq(i);
                regI.leDoArq(arquivo);

                seekArq(j);
                regJ.leDoArq(arquivo);

                if (regI.getCodigo() < regJ.getCodigo()) {
                    seekArq(k);
                    regI.gravaNoArq(arquivo);
                    i++;
                    this.comp++;
                    this.mov++;
                } else {
                    seekArq(k);
                    regJ.gravaNoArq(arquivo);
                    j++;
                    this.mov++;
                }
                k++;
                this.comp += 2;
            }

            while (i < seqI) {
                seekArq(i);
                regI.leDoArq(arquivo);

                seekArq(k);
                regI.gravaNoArq(arquivo);

                i++;
                k++;
                this.comp++;
                this.mov += 2;
            }

            while (j < seqJ) {
                seekArq(j);
                regJ.leDoArq(arquivo);

                seekArq(k);
                regJ.gravaNoArq(arquivo);

                j++;
                k++;
                this.comp++;
                this.mov += 2;
            }
            seq = seq = auxSeq;
            seqI = seq + i;
            seqJ = seq + j;
        }

        truncate(inicio - 1);
    }

    public void mergeSort() {
        int seq = 1, posArq;
        while (seq < fileSize()) {
            posArq = particao();
            fusao(posArq, seq);
            seq = seq * 2;
            this.comp++;
        }
    }

    public void executa() {
        geraArq();
        exibirArq();
    }
}
