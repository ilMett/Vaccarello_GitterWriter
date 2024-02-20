package com.example.vaccarello_mattia_gitter_writer;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Parola extends AppCompatActivity {
    private String tradITA;
    private String tradENG;
    private String tradSPA;
    private ArrayList<Parola> parolePredisposte = new ArrayList<>();
    private int rand = 0;
    private int min = 1;
    private int max = 19;

    public Parola(String tradITA, String tradENG, String tragSPA) {
        this.tradITA = tradITA;
        this.tradENG = tradENG;
        this.tradSPA = tragSPA;
    }

    public Parola(){
        this.tradITA = "tradITA";
        this.tradENG = "tradENG";
        this.tradSPA = "tragSPA";
    }

    //getter and setter
    public String getTradITA() {
        return tradITA;
    }

    public String setTradITA(String tradITA) {
        this.tradITA = tradITA;
        return tradITA;
    }

    public String getTradENG() {
        return tradENG;
    }

    public String setTradENG(String tradENG) {
        this.tradENG = tradENG;
        return tradENG;
    }

    public String getTradSPA() {
        return tradSPA;
    }

    public String setTradSPA(String tradSPA) {
        this.tradSPA = tradSPA;
        return tradSPA;
    }

    public ArrayList<Parola> getParolePredisposte() {
        return parolePredisposte;
    }

    //generazione numeri casuali
    public int genetazioneNumeri(){
        for(int j = min; j <= max; j++) {
            int getRandomValue = (int) (Math.random() * (max - min)) + min;
            rand = getRandomValue;
        }
        return rand;
    }
    //inizializzazione arrylist
    public void inizializzazione(){
        parolePredisposte.add(new Parola("macchina", "car", "máquina"));
        parolePredisposte.add(new Parola("ciao", "hello", "hola"));
        parolePredisposte.add(new Parola("tavolo", "table", "mesa"));
        parolePredisposte.add(new Parola("tastiera", "keyboard", "teclado"));
        parolePredisposte.add(new Parola("zaino", "backpack", "mochila"));
        parolePredisposte.add(new Parola("custodia", "custody", "custodia"));
        parolePredisposte.add(new Parola("schermo", "display", "pantalla"));
        parolePredisposte.add(new Parola("matematica", "maths", "matemáticas"));
        parolePredisposte.add(new Parola("stampante", "printer", "impresora"));
        parolePredisposte.add(new Parola("stanza", "room", "habitación"));
        parolePredisposte.add(new Parola("cane","dog","perro"));
        parolePredisposte.add(new Parola("gatto","cat","gato"));
        parolePredisposte.add(new Parola("vaso","jar","frasco"));
        parolePredisposte.add(new Parola("albero","tree", "árbol"));
        parolePredisposte.add(new Parola("neve", "snow", "nieve"));
        parolePredisposte.add(new Parola("zucca", "pumpking", "calabaza"));
        parolePredisposte.add(new Parola("patata", "potato", "papa"));
        parolePredisposte.add(new Parola("insegnante", "teacher", "maestro"));
        parolePredisposte.add(new Parola("minuto", "minute", "minuto"));
    }
}
