package it.unibas.azienda.modello;

import java.util.Calendar;

public class Dipendente {
    
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Calendar dataAssunzione;
    private String sesso;

    public Dipendente(String codiceFiscale, String nome, String cognome, Calendar dataAssunzione, String sesso) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
        this.sesso = sesso;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Calendar getDataAssunzione() {
        return dataAssunzione;
    }

    public String getSesso() {
        return sesso;
    }
    
    
}
