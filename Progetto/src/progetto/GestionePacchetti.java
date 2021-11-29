/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 *
 * @author ginisi_gabriele
 */
public class GestionePacchetti {
   DatagramSocket gestore;
    
    public GestionePacchetti() throws SocketException {
        this.gestore = new DatagramSocket(2003);
    }
    
    public void Invio(String messaggio, InetAddress indirizzo) throws IOException{
        byte[] bufferRisposta = messaggio.getBytes();
        DatagramPacket pacchettoRisposta = new DatagramPacket(bufferRisposta, bufferRisposta.length);
        pacchettoRisposta.setAddress(indirizzo);
        pacchettoRisposta.setPort(2003); 
        gestore.send(pacchettoRisposta);
    }
    
    public String Ricevi() throws IOException{
        byte[] bufferRicevuto = new byte[1500];
        DatagramPacket pacchettoRicevuto = new DatagramPacket(bufferRicevuto, bufferRicevuto.length);
        gestore.receive(pacchettoRicevuto);
        byte[] bufferDatiRicevuto = pacchettoRicevuto.getData();
        String datiStringa = new String(Arrays.copyOfRange(bufferDatiRicevuto, 0, pacchettoRicevuto.getLength()));
        return datiStringa;
    }
}