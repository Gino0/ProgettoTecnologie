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
 * @author ginisi_gabriele
 */
public class CConnessione extends Thread {
    private gestione gestore;

    public CConnessione() {
        this.gestore = null;
    }
    
    public CConnessione(gestione gestore) {
        this.gestore = gestore;
    }

}
