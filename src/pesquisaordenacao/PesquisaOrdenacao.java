/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisaordenacao;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Rafael Delanhese
 */
public class PesquisaOrdenacao extends Application {

    Button botao_inicio, btnCombsort, btnCountingsort, btnRadixsort;
    Button[] vetButton = new Button[7];
    Button[] vetButtonCounting = new Button[10];
    Button[] vetButtonCountingEntrada = new Button[7];
    Button[][] matButton = new Button[7][10];
    int[] vet = new int[7];
    private final int tempo = 1000;

    public void radixSort() {
        int tempoRadix = 1000;
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                //VETOR DE ORDENAÇÃO
                for (int i = 0; i < vetButton.length; i++) {
                    final int pos = i;
                    final int valor = vet[i];

                    vetButton[pos].setLayoutY(80);
                    vetButton[pos].setPrefSize(50, 50);
                    Platform.runLater(() -> vetButton[pos].setText("" + valor));
                    Platform.runLater(() -> vetButton[pos].setLayoutX(20));
                    Platform.runLater(() -> vetButton[pos].setLayoutX(pos * 80));
                }
                //---------------------------------

                //MATRIZ
                int valor = 150;
                for (int j = 0; j < 7; j++) {
                    final int posJ = j;                    
                    for (int i = 0; i < vetButton.length; i++) {
                        final int pos = i;                        

                        matButton[posJ][pos].setLayoutY(valor);                       
                        matButton[posJ][pos].setPrefSize(50, 50);
                        matButton[posJ][pos].setStyle("-fx-background-color: #5A4FCF");
                        Platform.runLater(() ->  matButton[posJ][pos].setText("" + 0));
                        Platform.runLater(() ->  matButton[posJ][pos].setLayoutX(20));
                        Platform.runLater(() ->  matButton[posJ][pos].setLayoutX(pos * 80));
                    }
                    valor += 70;
                }

                for (int digit = 0; digit < 3; digit++) {
                    int power = (int) Math.pow(10, digit + 1);
                   
                    int n[] = new int[10];

                    for (int i = 0; i < vetButton.length; i++) {
                        int num = Integer.parseInt(vetButton[i].getText());
                        final int posY = n[(num % power) / (power / 10)];
                        final int posX = (num % power) / (power / 10);
                        
                        final int numMat = num;
                        matButton[posY][posX].setStyle("-fx-background-color: #FFFF00");
                        Platform.runLater(() ->  matButton[posY][posX].setText("" + numMat));
                                                
                        n[(num % power) / (power / 10)]++;
                        Thread.sleep(tempoRadix);
                    }
                    
                    Thread.sleep(3000);
                    
                    int c = 0;
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 7; j++) {
                            if (j < n[i]) {
                                final int posVet = c;
                                final int valorMat = Integer.parseInt(matButton[j][i].getText());
                                vetButton[posVet].setStyle("-fx-background-color: #00FF00");
                                Platform.runLater(() -> vetButton[posVet].setText("" + valorMat));
                                c++;
                                Thread.sleep(tempoRadix);
                            } else {
                                break;
                            }
                        }
                    }
                }
                return null;
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    public void countingSort() {
        int tempoCounting = 1000;
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                //VETOR DE ORDENAÇÃO
                for (int i = 0; i < vetButton.length; i++) {
                    final int pos = i;
                    final int valor = vet[i];

                    vetButton[pos].setLayoutY(200);
                    vetButton[pos].setPrefSize(50, 50);
                    Platform.runLater(() -> vetButton[pos].setText("" + valor));
                    Platform.runLater(() -> vetButton[pos].setLayoutX(20));
                    Platform.runLater(() -> vetButton[pos].setLayoutX(pos * 80));
                }
                //---------------------------------

                //VETOR DE CONTAGEM
                for (int i = 0; i < vetButtonCounting.length; i++) {
                    final int pos = i;

                    vetButtonCounting[pos].setLayoutY(300);
                    vetButtonCounting[pos].setPrefSize(50, 50);
                    Platform.runLater(() -> vetButtonCounting[pos].setText("" + 0));
                    Platform.runLater(() -> vetButtonCounting[pos].setLayoutX(20));
                    Platform.runLater(() -> vetButtonCounting[pos].setLayoutX(pos * 80));
                }
                //------------------------

                //CONTA
                for (int i = 0; i < vetButton.length; i++) {
                    final int posValor = Integer.parseInt(vetButton[i].getText());
                    final int valor = Integer.parseInt(vetButtonCounting[posValor].getText());
                    final int valorAtualizado = valor + 1;
                    vetButtonCounting[posValor].setStyle("-fx-background-color: #00FF00");
                    Platform.runLater(() -> vetButtonCounting[posValor].setText("" + valorAtualizado));
                    Thread.sleep(tempoCounting);
                }

                //SOMA VALORES
                for (int i = 1; i < vetButtonCounting.length; i++) {
                    final int posI = i;
                    final int posIMenos = i - 1;

                    int valorI = Integer.parseInt(vetButtonCounting[posI].getText());
                    int valorIMenos = Integer.parseInt(vetButtonCounting[posIMenos].getText());

                    final int valor = valorIMenos + valorI;

                    vetButtonCounting[posI].setStyle("-fx-background-color: #FFD700");
                    Platform.runLater(() -> vetButtonCounting[posI].setText("" + valor));
                    Thread.sleep(tempoCounting);
                }

                //VETOR AUXILIAR               
                for (int i = 0; i < vetButtonCountingEntrada.length; i++) {
                    final int pos = i;

                    vetButtonCountingEntrada[pos].setLayoutY(400);
                    vetButtonCountingEntrada[pos].setPrefSize(50, 50);
                    Platform.runLater(() -> vetButtonCountingEntrada[pos].setText("" + 0));
                    Platform.runLater(() -> vetButtonCountingEntrada[pos].setLayoutX(20));
                    Platform.runLater(() -> vetButtonCountingEntrada[pos].setLayoutX(pos * 80));
                }
                //------------------------

                //-----------------------
                //ORDENA
                for (int i = 0; i < vetButton.length; i++) {
                    final int posI = i;
                    final int posVetButton = Integer.parseInt(vetButton[posI].getText());
                    int posVetCounting = Integer.parseInt(vetButtonCounting[posVetButton].getText());
                    posVetCounting--;

                    final int posVCC = posVetCounting;
                    final int valorVetButton = Integer.parseInt(vetButton[posI].getText());

                    vetButtonCountingEntrada[posVCC].setStyle("-fx-background-color: #5A4FCF");
                    Platform.runLater(() -> vetButtonCountingEntrada[posVCC].setText("" + valorVetButton));
                    Thread.sleep(tempoCounting);
                }

                //COLOCA VALORES ORDENADOS NO VETOR ORIGINAL
                for (int i = 0; i < vetButton.length; i++) {
                    final int posI = i;

                    vetButtonCountingEntrada[posI].setStyle("-fx-background-color: #00FF00");
                    final int vVBCE = Integer.parseInt(vetButtonCountingEntrada[posI].getText());

                    vetButton[posI].setStyle("-fx-background-color: #00FF00");
                    Platform.runLater(() -> vetButton[posI].setText("" + vVBCE));
                    Thread.sleep(tempoCounting);
                }
                return null;
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    public void combSort() {
        Task task;
        task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                for (int i = 0; i < vetButton.length; i++) {
                    final int pos = i;
                    final int valor = vet[i];

                    vetButton[pos].setLayoutY(200);
                    vetButton[pos].setPrefSize(50, 50);
                    Platform.runLater(() -> vetButton[pos].setText("" + valor));
                    Platform.runLater(() -> vetButton[pos].setLayoutX(20));
                    Platform.runLater(() -> vetButton[pos].setLayoutX(pos * 80));
                }

                int gap = (int) (vetButton.length / 1.3);
                int i = 0;
                while (gap > 0 && i != vetButton.length - 1) {
                    i = 0;
                    while ((i + gap) < vetButton.length) {
                        final int fI = i;
                        final int fGap = gap;
                        if (Integer.parseInt(vetButton[fI].getText()) > Integer.parseInt(vetButton[fI + fGap].getText())) {
                            final int aux = Integer.parseInt(vetButton[i].getText());
                            vetButton[fI].setStyle("-fx-background-color: #FF9C00");
                            vetButton[fI + fGap].setStyle("-fx-background-color: #516ADA");
                            Thread.sleep(tempo);
                            Platform.runLater(() -> vetButton[fI].setText("" + vetButton[fI + fGap].getText()));
                            Platform.runLater(() -> vetButton[fI + fGap].setText("" + aux));
                            Thread.sleep(tempo);
                            vetButton[fI].setStyle("-fx-background-color: #FF0000");
                            vetButton[fI + fGap].setStyle("-fx-background-color: #FF0000");
                        }
                        i++;
                    }
                    gap = (int) (gap / 1.3);
                }

                return null;
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    public void gnomeSort() {

        Task task;
        task = new Task<Void>() {

            /*
            CHAMAR OUTRO MÉTODO DE MOSTRA BOOTÕES AQUI, ELE DÁ PAU PQ INICIALIZA DUAS TRHEAD POR ISSO NÃO ORDENA
             */
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < vetButton.length; i++) {
                    final int pos = i;
                    final int valor = vet[i];

                    vetButton[pos].setLayoutY(200);
                    vetButton[pos].setPrefSize(50, 50);
                    Platform.runLater(() -> vetButton[pos].setText("" + valor));
                    Platform.runLater(() -> vetButton[pos].setLayoutX(20));
                    Platform.runLater(() -> vetButton[pos].setLayoutX(pos * 80));
                    Thread.sleep(100);
                }
                int pivo = 0;
                while (pivo < (vetButton.length - 1)) {
                    final int auxPivo = pivo;
                    if (Integer.parseInt(vetButton[auxPivo].getText()) > Integer.parseInt(vetButton[auxPivo + 1].getText())) {
                        final int auxValor = Integer.parseInt(vetButton[auxPivo].getText());

                        //MUDA BOTÕES                        
                        vetButton[auxPivo].setStyle("-fx-background-color: #FF9C00");
                        vetButton[auxPivo + 1].setStyle("-fx-background-color: #516ADA");

                        Thread.sleep(tempo);
                        Platform.runLater(() -> vetButton[auxPivo].setText("" + vetButton[auxPivo + 1].getText()));
                        Platform.runLater(() -> vetButton[auxPivo + 1].setText("" + auxValor));
                        Thread.sleep(tempo);

                        //MUDA BOTÕES
                        vetButton[auxPivo].setStyle("-fx-background-color: #F93F3F");
                        vetButton[auxPivo + 1].setStyle("-fx-background-color: #F93F3F");

                        if (pivo > 0) {
                            pivo -= 2;
                        }
                    }
                    pivo++;
                    Thread.sleep(tempo);
                }
                return null;
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

    }

    public void populaVet() {
        vet[0] = 9;
        vet[1] = 8;
        vet[2] = 7;
        vet[3] = 1;
        vet[4] = 5;
        vet[5] = 2;
        vet[6] = 3;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Pesquisa e Ordenação");
        AnchorPane pane = new AnchorPane();

        botao_inicio = new Button();
        botao_inicio.setLayoutX(10);
        botao_inicio.setLayoutY(15);
        botao_inicio.setText("Gnome Sort");

        btnCombsort = new Button();
        btnCombsort.setLayoutX(100);
        btnCombsort.setLayoutY(15);
        btnCombsort.setText("Comb Sort");

        btnCountingsort = new Button();
        btnCountingsort.setLayoutX(180);
        btnCountingsort.setLayoutY(15);
        btnCountingsort.setText("Couting Sort");

        btnRadixsort = new Button();
        btnRadixsort.setLayoutX(280);
        btnRadixsort.setLayoutY(15);
        btnRadixsort.setText("Radix Sort");

        botao_inicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                populaVet();
                gnomeSort();
            }
        });

        btnCombsort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                combSort();
            }
        });

        btnCountingsort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                countingSort();
            }
        });

        btnRadixsort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                radixSort();
            }
        });

        //INICIALIZA OS BOTÕES
        for (int i = 0; i < vetButton.length; i++) {
            vetButton[i] = new Button();
        }
        populaVet();

        //INICIALIZA BOTÕES COUNTING
        for (int i = 0; i < vetButtonCounting.length; i++) {
            vetButtonCounting[i] = new Button();
        }

        //INICIALIZA BOTÕES COUNTING AUXILIXAR
        for (int i = 0; i < vetButtonCountingEntrada.length; i++) {
            vetButtonCountingEntrada[i] = new Button();
        }

        //INICIALIZA MATRIX RADIX
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                matButton[i][j] = new Button();
            }
        }

        //ADICIONA MATRIZ NO PAINEL
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                pane.getChildren().add(matButton[i][j]);
            }
        }

        pane.getChildren().addAll(botao_inicio,
                btnCombsort,
                btnCountingsort,
                btnRadixsort,
                vetButton[0], vetButton[1], vetButton[2], vetButton[3], vetButton[4], vetButton[5], vetButton[6],
                vetButtonCounting[0], vetButtonCounting[1], vetButtonCounting[2], vetButtonCounting[3], vetButtonCounting[4], vetButtonCounting[5], vetButtonCounting[6], vetButtonCounting[7], vetButtonCounting[8], vetButtonCounting[9],
                vetButtonCountingEntrada[0], vetButtonCountingEntrada[1], vetButtonCountingEntrada[2], vetButtonCountingEntrada[3], vetButtonCountingEntrada[4], vetButtonCountingEntrada[5], vetButtonCountingEntrada[6]);
        Scene scene = new Scene(pane, 640, 700);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
