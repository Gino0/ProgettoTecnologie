/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

/**
 *
 * @author Guepe
 */
public class pacchetto {
    private String indirizzo;
    private String operazione;
    private String messaggio;
    
    public pacchetto(){
        this.indirizzo = "";
        this.operazione = "";
        this.messaggio = "";
    }

    public pacchetto(String indirizzo, String operazione, String messaggio) {
        this.indirizzo = indirizzo;
        this.operazione = operazione;
        this.messaggio = messaggio;
    }

    public String getIndirizzo(){
        return indirizzo;
    }
    public String getOperazione() {
        return operazione;
    }
    public String getMessaggio() {
        return messaggio;
    }

    public void setIndirizzo(String indirizzo){
        this.indirizzo = indirizzo;
    }
    public void setOperazione(String operazione) {
        this.operazione = operazione;
    }
    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }
}
