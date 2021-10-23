package it.unibas.azienda.persistenza;

import it.unibas.azienda.modello.Archivio;
import it.unibas.azienda.modello.Azienda;
import it.unibas.azienda.modello.Costanti;
import it.unibas.azienda.modello.Dipendente;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DaoArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DaoException {
        Archivio archivio = new Archivio();
        Azienda a1 = new Azienda(198123543, "Magneti Marelli", "Melfi");
        a1.aggiungiDipendente(new Dipendente("MR1990M", "Mario", "Rossi", new GregorianCalendar(2021, Calendar.MARCH, 10), Costanti.MASCHIO));
        a1.aggiungiDipendente(new Dipendente("LP1992M", "Luca", "Pozzo", new GregorianCalendar(2021, Calendar.MARCH, 15), Costanti.MASCHIO));
        archivio.aggiungiAzienda(a1);
        Azienda a2 = new Azienda(798144548, "Barilla", "Melfi");
        a2.aggiungiDipendente(new Dipendente("SG1990M", "Simone", "Guerra", new GregorianCalendar(2021, Calendar.FEBRUARY, 1), Costanti.MASCHIO));
        a2.aggiungiDipendente(new Dipendente("MC1997F", "Maria", "Costa", new GregorianCalendar(2021, Calendar.MARCH, 1), Costanti.FEMMINA));
        archivio.aggiungiAzienda(a2);
        return archivio;
    }
}
