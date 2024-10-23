/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author tommaso pignatta
 */
public class Giocatore extends Thread{
    private int idGiocatore;
    private String nomeGiocatore;
    private Estrazione estrazione;
    private int numeroSel;
  
    public Giocatore(int idGiocatore, String nomeGiocatore, Estrazione estrazione){
        this.idGiocatore=idGiocatore;
        this.nomeGiocatore=nomeGiocatore;
        this.estrazione=estrazione;
        this.numeroSel= (int)(Math.random()*100)*1;
    }

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
        System.out.println("IL GIOCATORE "+nomeGiocatore+" HA SCELTO IL NUMERO "+numeroSel+";");
        for(int i=3; i>0; i--){
            System.out.println(i);
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore sleep");
            }
        }
        System.out.println("HO VERIFICATO IL NUMERO INSERITO DAL GIOCATORE "+idGiocatore+";");
        estrazione.verifica(numeroSel, idGiocatore);
    }
}
