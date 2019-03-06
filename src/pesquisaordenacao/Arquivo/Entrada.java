/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisaordenacao.Arquivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Rafael Delanhese
 */
public class Entrada {

    public static String leString(String msg) {
        String line = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            System.out.println(msg);
            line = br.readLine();
        } catch (Exception e) {
        }
        return line;
    }

    public static int leInteger(String msg) {
        String line = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            System.out.println(msg);
            line = br.readLine();
            int retorno = Integer.valueOf(line);
            return retorno;
        } catch (Exception e) {
            return -1;
        }
    }
}
