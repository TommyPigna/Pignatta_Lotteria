/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author tommaso pignatta
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("INSERISCI IL NUMERO DI RIGHE E DI COLONNE DELLA TABELLA CONTENENTE I NUMERI ESTRATTI: \n");
        //Scanner scanner=new Scanner(System.in);
        //int num=scanner.nextInt();
        BufferedReader br=new BufferedReader(
        new InputStreamReader(System.in)
        );
        int num=0;
        
        try {
            num = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRORE NELL'INSERIMENTO DEL NUMERO!");
        }
        
        
        
        
        
        Estrazione e=new Estrazione(num);
        e.start();
        try {
            e.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            }
        Giocatore g=new Giocatore(1, "Tommaso", e);
        Giocatore g1=new Giocatore(2, "Cristian", e);
        Giocatore g2=new Giocatore(3, "Riccardo", e);
        Giocatore g3=new Giocatore(4, "Filippo", e);
        
        
        g.start();
        try{
        g.join();
        }
        catch(InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        g1.start();
        try{
            g1.join();
        }
        catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g2.start();
        try{
          g2.join();
        }
        catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g3.start();
        try{
            g3.join();
        }
        catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("PRIMO POSTO: GIOCATORE "+e.vincitori[0]);
        System.out.println("SECONDO POSTO: GIOCATORE "+e.vincitori[1]);
        System.out.println("TERZO POSTO: GIOCATORE "+e.vincitori[2]);
        
        // Istanza ed avvio del thread Estrazione
        // Istanza di alcuni thread Giocatore
    }
    // Avvio dei thread Giocatori
        // Comunicazione fine gioco
}
    