package it.unibas.azienda.modello;

import java.util.ArrayList;
import java.util.List;

public class Azienda implements Comparable<Azienda> {
    
    private int partitaIva;
    private String denominazione;
    private String citta;
    private List<Dipendente> dipendenti = new ArrayList<>();

    public Azienda(int partitaIva, String denominazione, String citta) {
        this.partitaIva = partitaIva;
        this.denominazione = denominazione;
        this.citta = citta;
    }

    public int getPartitaIva() {
        return partitaIva;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public String getCitta() {
        return citta;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }
    
    public void aggiungiDipendente(Dipendente dipendente) {
        this.dipendenti.add(dipendente);
    }

    @Override
    public int compareTo(Azienda o) {
        return this.getDenominazione().compareTo(o.getDenominazione());
    }
    
    public boolean dipendenteGiaEsistente(String codiceFiscale) {
        for (Dipendente dipendente : dipendenti) {
            if(dipendente.getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }
    
}
