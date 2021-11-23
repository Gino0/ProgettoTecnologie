/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author ginisi_gabriele
 */
public class GestionePacchetti {
        private DatagramSocket server;
    DatagramPacket pacchetto;
    String messaggioRicevuto;
    String votoClasse;

    public GestionePacchetti() throws SocketException {
        server = new DatagramSocket(2003);
    }

    public String ricevi() throws IOException {

        byte[] buffer = new byte[1500];

        pacchetto = new DatagramPacket(buffer, buffer.length);

        server.receive(pacchetto);

        byte[] dataReceived = pacchetto.getData(); // copia del buffer dichiarato sopra

        messaggioRicevuto = new String(dataReceived, 0, pacchetto.getLength());

        return messaggioRicevuto;
    }

    public void invia(String messaggio) throws IOException {
        String risposta = messaggio;

        byte[] responseBuffer = risposta.getBytes();

        DatagramPacket pacchettoRisposta = new DatagramPacket(responseBuffer, responseBuffer.length);

        pacchettoRisposta.setAddress(pacchetto.getAddress());

        pacchettoRisposta.setPort(pacchetto.getPort());

        server.send(pacchettoRisposta);
    }
}
