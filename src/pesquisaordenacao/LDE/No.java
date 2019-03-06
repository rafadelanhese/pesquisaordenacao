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
public class No {
    
    private int info;
    private No prox;
    private No ant;

    public No() {
    }
    
    public No(int info, No prox, No ant) {
        this.info = info;
        this.prox = prox;
        this.ant = ant;
    }       

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }        
}
