/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisaordenacao.LDE;

import java.util.Random;

/**
 *
 * @author Rafael Delanhese
 */
public class Lista {

    private No inicio;
    private No fim;

    public Lista() {
    }

    public Lista(No inicio, No fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public void inicializa() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirInicio(int info) {
        No no = new No(info, inicio, null);

        if (inicio == null) {
            inicio = fim = no;
        } else {
            inicio.setAnt(no);
            inicio = no;
        }
    }

    public void inserirFim(int info) {
        No no = new No(info, null, fim);

        if (fim == null) {
            inicio = fim = no;
        } else {
            fim.setProx(no);
            fim = no;
        }

    }

    public void insereDadosLista() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            inserirInicio(i);
        }
    }

    public void exibir() {
        No aux = inicio;

        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
    }

    //MÉTODOS DE ORDENAÇÃO
    public void insercaoDireta() {
        int auxInfo;
        No pPos;
        No pI;

        for (pI = inicio.getProx(); pI != null; pI = pI.getProx()) {
            auxInfo = pI.getInfo();
            pPos = pI;

            while (pPos.getAnt() != null && auxInfo < pPos.getAnt().getInfo()) {
                pPos.setInfo(pPos.getAnt().getInfo());
                pPos = pPos.getAnt();
            }

            pPos.setInfo(auxInfo);
        }
    }

    public void selecaoDireta() {
        int menor;
        No pMenor, pI, pJ;

        for (pI = inicio; pI.getProx() != null; pI = pI.getProx()) {

            menor = pI.getInfo();
            pMenor = pI;

            for (pJ = pI.getProx(); pJ != null; pJ = pJ.getProx()) {
                if (pJ.getInfo() < menor) {
                    menor = pJ.getInfo();
                    pMenor = pJ;
                }
            }

            pMenor.setInfo(pI.getInfo());
            pI.setInfo(menor);
        }
    }

    public void bolha() {
        int auxInfo;
        No auxFim = fim;
        No pI;

        while (auxFim.getAnt() != null) {
            for (pI = inicio; pI.getProx() != null; pI = pI.getProx()) {
                if (pI.getInfo() > pI.getProx().getInfo()) {
                    auxInfo = pI.getProx().getInfo();
                    pI.getProx().setInfo(pI.getInfo());
                    pI.setInfo(auxInfo);
                }
            }
            auxFim = auxFim.getAnt();
        }
    }

    public void shake() {
        int auxInfo;
        No pInicio = inicio;
        No pFim = fim;
        No pI;
        while (pInicio != pFim) {
            for (pI = pInicio; pI != pFim; pI = pI.getProx()) {
                if (pI.getInfo() > pI.getProx().getInfo()) {
                    auxInfo = pI.getProx().getInfo();
                    pI.getProx().setInfo(pI.getInfo());
                    pI.setInfo(auxInfo);
                }
            }

            pFim = pFim.getAnt();
            
            if (pInicio != pFim) {
                for (pI = pFim; pI != pInicio; pI = pI.getAnt()) {
                    if (pI.getInfo() < pI.getAnt().getInfo()) {
                        auxInfo = pI.getAnt().getInfo();
                        pI.getAnt().setInfo(pI.getInfo());
                        pI.setInfo(auxInfo);
                    }
                }

                pInicio = pInicio.getProx();
            }
        }
    }
}
