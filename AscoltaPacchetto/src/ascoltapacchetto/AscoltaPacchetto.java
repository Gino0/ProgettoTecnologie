/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascoltapacchetto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Guepe
 */
public class AscoltaPacchetto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
         DatagramSocket gestore = new DatagramSocket(2003);

        /*byte[] bufferRisposta = messaggio.getBytes();
        DatagramPacket pacchettoRisposta = new DatagramPacket(bufferRisposta, bufferRisposta.length);
        pacchettoRisposta.setAddress(indirizzo);
        pacchettoRisposta.setPort(2003);
        gestore.send(pacchettoRisposta);*/
        while(true){
            String scelta = " ";
            if(scelta.equals("r")){
                byte[] bufferRicevuto = new byte[1500];
                DatagramPacket pacchettoRicevuto = new DatagramPacket(bufferRicevuto, bufferRicevuto.length);
                gestore.receive(pacchettoRicevuto);
                byte[] bufferDatiRicevuto = pacchettoRicevuto.getData();
                String datiStringa = new String(Arrays.copyOfRange(bufferDatiRicevuto, 0, pacchettoRicevuto.getLength()));
                System.out.println(datiStringa);
            } else if (scelta.equals("s")){
                String messaggio = " ";
                byte[] bufferRisposta = messaggio.getBytes();
                DatagramPacket pacchettoRisposta = new DatagramPacket(bufferRisposta, bufferRisposta.length);
                pacchettoRisposta.setAddress(InetAddress.getLocalHost());
                pacchettoRisposta.setPort(2003);
                gestore.send(pacchettoRisposta); 
            }
        }
    }
}
