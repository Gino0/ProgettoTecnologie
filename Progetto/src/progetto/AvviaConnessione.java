/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guepe
 */
public class AvviaConnessione  extends Thread {
       private gestione gestore;

    public AvviaConnessione() {
        this.gestore = null;
    }
    
    public AvviaConnessione(gestione gestore) {
        this.gestore = gestore;
    }

    @Override
    public void run() {

        //Non mi è arrivato un pacchetto da lui, allora gli invio "c;NICKNAME"
        System.out.println("Non è arrivato un pacchetto, allora lo invio io");
        InvioPacchetto("c;NICKNAME;", gestore.getIndirizzo());
            
                pacchetto pacchettoTemp = null;
                do{
                    pacchettoTemp = gestore.IsPresenteInListaPacchettiConnessione(gestore.getIndirizzoStringa());
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AvviaConnessione.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Aspettando la risposta...");
                } while(pacchettoTemp == null);
                
 }
