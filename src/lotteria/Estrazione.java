/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

/**
 *
 * @author tommaso pignatta
 */
public class Estrazione extends Thread {
    private int numero;
    public int vincitori[];
    private int N;
    private int [][] matriceNum;
    private int contaVin;
    private boolean [][] numVincenti; //tabella dei numeri vincenti utilizzata per verificare se il numero scelto è gia stato azzeccato
    
    /**
     * 
     * Metodo costruttore
     */   
    public Estrazione(int N) {
        this.N=N;
        this.vincitori = new int [3];
        this.matriceNum = new int [N][N];
        this.contaVin=0;
        this.numVincenti = new boolean [N][N];
    }

    /**
    * 
    * Metodo per visualizzare la matrice dei numeri estratti
    */
    public void stampaMatrice() {
        System.out.println("TABELLA DEI NUMERI ESTRATTI: \n");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(matriceNum[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    /**
    * 
    * Metodo per visualizzare i vincitori dell'estrazione
    */
    public void stampaVincitori() {
        // stampa array dei vincitori
        System.out.println("VINCITORI: ");
        for(int i=0; i<contaVin; i++){
            System.out.println("POSIZIONE: "+(i+1)+" ID GIOCATORE: "+vincitori[i]);
        }
        }

    /**
    * 
    * Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    * @param numero numero scelto dal giocatore
    * @param idGiocatore id del giocatore
    */
    public void verifica(int numero, int idGiocatore) {
        if(contaVin>=3){
            System.out.println("IL GIOCATORE CON ID "+idGiocatore+"NON PUO' PIU' VINCERE PREMI;");
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(matriceNum[i][j] == numero && !numVincenti[i][j]){
                    numVincenti[i][j]=true;
                    vincitori[contaVin]=idGiocatore;
                    contaVin++;
                    System.out.println("IL GIOCATORE "+idGiocatore+" HA SCELTO IL NUMERO "+numero+" E HA VINTO!!!");
                    return;
                }
            }
        }
        System.out.println("IL GIOCATORE CON ID "+idGiocatore+" HA SCELTO IL NUMERO "+numero+" MA NON HA VINTO;");
    }

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
        System.out.println("INIZIO DELL'ESTRAZIONE!!!");
        
        Random random=new Random();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                matriceNum[i][j]=random.nextInt(100)+1;
                numVincenti[i][j]=false;
            }
        }
         stampaMatrice();   
    }
}


