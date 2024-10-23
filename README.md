## SCOPO DEL PROGETTO

Il progetto **Lotteria** simula una semplice estrazione di numeri in cui quattro giocatori scelgono un numero casuale e tentano di vincere un premio. Il programma genera una tabella di numeri casuali, avente un numero di righe e colonne scelto dall'utente, i quali, se indovinati correttamente dai giocatori, permetteranno a quest'ultimi di vincere alcuni premi.

## PRINCIPALI CLASSI UTILIZZATE

### 1. **Lotteria**
La classe principale che avvia il processo di estrazione e gestisce l'interazione tra i giocatori e quest'ultima. All'interno del metodo `main`, in particolare, viene inizializzata la tabella di numeri e i vari thread per i giocatori vengono inizializzati, riuscnedo cosi a simulare la gara.


### 2. **Estrazione**
Questa classe rappresenta il thread responsabile di creare e gestire la tabella con i numeri estratti. Inoltre, possiede anche il compito di verificare se i numeri scelti dai giocatori coincidono con quelli presenti nella tabella.

### Metodo Principale:     `verifica(int numero, int idGiocatore)`

- Il metodo verifica se il numero selezionato dal giocatore esiste nella tabella di numeri estratti. Se il numero è presente e non è già stato scelto da un altro giocatore, il giocatore vince e il suo ID viene registrato nell'array `vincitori`, altrimenti il giocatore perde.
  

- **Parametri**:
    - `numero`: il numero scelto dal giocatore;
    - `idGiocatore`: l'ID del giocatore;
  
- **Funzionamento**:
    1. Se il numero di vincitori ha già raggiunto il limite di tre, il giocatore non può più vincere;
    2. Si scorre la matrice `matriceNum`, la quale contiene i numeri estratti, per verificare se il numero scelto dal giocatore è presente;
    3. Se il numero viene trovato ed è disponibile il giocatore viene registrato come vincitore;
    4. Se il numero non viene trovato o è già stato selezionato il giocatore non vince;

### 3. **Giocatore**
Ogni oggetto di questa classe rappresenta un giocatore partecipante all'estrazione. La classe estende la classe `Thread` e ogni giocatore funziona come un thread separato, scegliendo un numero casuale tra 1 e 100 e aspettando la verifica del numero scelto.

## LIBRERIE UTILIZZATE

Il progetto utilizza le seguenti librerie:

- `java.util.Random`: per generare numeri casuali utilizzati sia dai giocatori che per riempire la matrice dei numeri estratti.
- `java.util.logging`: per la gestione delle eccezioni e la registrazione di eventuali errori.
- `java.io.BufferedReader` e `java.io.InputStreamReader`: per la lettura dell'input utente.

## GESTIONE DEI POSSIBILI ERRORI

Il programma è progettato per gestire diversi possibili errori:

1. **Interruzione dei thread**: Se un thread viene interrotto in modo imprevisto durante l'attesa o l'esecuzione, con `InterruptedException`, l'errore viene gestito e registrato nel log senza interrompere l'intero programma;

2. **Superamento del numero massimo di vincitori**: Se un giocatore tenta di vincere quando ci sono già tre vincitori, il programma lo informerà che non può più vincere e terminerà l'esecuzione del suo thread;

## COMMENTO DELL'ESECUZIONE

1. L'utente inserisce il numero di righe e colonne della tabella che conterrà i numeri estratti;

2. Il thread `Estrazione` viene avviato e genera una tabella con numeri casuali da 1 a 100;

3. I quattro giocatori, ovvero i thread `Giocatore`, scelgono ciascuno un numero casuale e attendono il risultato dell'estrazione;

4. Il sistema verifica i numeri scelti dai giocatori e dichiara i vincitori, mostrando i primi tre posti;

5. Alla fine, viene mostrato il riepilogo dei vincitori.

