package it.unibas.azienda.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Archivio {

    private List<Azienda> aziende = new ArrayList<>();

    public List<Azienda> getAziende() {
        return aziende;
    }

    public void aggiungiAzienda(Azienda azienda) {
        this.aziende.add(azienda);
    }

    public List<Azienda> cercaAziendePerCitta(String citta) {
        List<Azienda> aziendePerCitta = new ArrayList<>();
        for (Azienda azienda : aziende) {
            if (azienda.getCitta().equalsIgnoreCase(citta)) {
                aziendePerCitta.add(azienda);
            }
        }
        Collections.sort(aziendePerCitta);
        return aziendePerCitta;
    }

    public boolean verificaArchivio() {
        for (Azienda azienda : aziende) {
            for (Dipendente dipendente : azienda.getDipendenti()) {
                for (int i=1; i<azienda.getDipendenti().size(); i++) {
                    if (azienda.getDipendenti().get(i-1).getCodiceFiscale().equalsIgnoreCase(dipendente.getCodiceFiscale())) {
                        return true;
                    }
//                     ciao sono Michele
                }
            }
        }
        return false;

    }
}
