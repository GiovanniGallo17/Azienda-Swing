package it.unibas.azienda.controllo;

import it.unibas.azienda.Applicazione;
import it.unibas.azienda.modello.Azienda;
import it.unibas.azienda.modello.Costanti;
import it.unibas.azienda.modello.Dipendente;
import it.unibas.azienda.vista.VistaDettagliAzienda;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloDettagliAzienda {

    private Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi nuovo dipendente");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_D);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl D"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Azienda aziendaSelezionata = (Azienda) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
            VistaDettagliAzienda vistaDettagli = Applicazione.getInstance().getVistaDettagliAzienda();
            String codiceFiscale = vistaDettagli.getCodiceFiscale();
            String nome = vistaDettagli.getNome();
            String cognome = vistaDettagli.getCognome();
            String sesso = vistaDettagli.getSesso();
            String giorno = vistaDettagli.getGiorno();
            String mese = vistaDettagli.getMese();
            String anno = vistaDettagli.getAnno();
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            String errori = convalida(codiceFiscale, nome, cognome, sesso, giorno, mese, anno);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Dipendente nuovoDipendente = new Dipendente(codiceFiscale, nome, cognome, new GregorianCalendar(interoAnno, interoMese-1, interoGiorno), sesso);
            aziendaSelezionata.aggiungiDipendente(nuovoDipendente);
            vistaDettagli.aggiornaDati();
        }

        private String convalida(String codiceFiscale, String nome, String cognome, String sesso, String giorno, String mese, String anno) {
            StringBuilder errori = new StringBuilder();
             Azienda aziendaSelezionata = (Azienda) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
            if (codiceFiscale.isEmpty()) {
                errori.append("Il codice fiscale e' obbligatorio\n");
            }
            if (nome.isEmpty()) {
                errori.append("Il nome e' obbligatorio\n");
            }
            if (cognome.isEmpty()) {
                errori.append("Il cognome e' obbligatorio\n");
            }
            if (sesso.isEmpty()) {
                errori.append("Il sesso e' obbligatorio\n");
            }
            if (giorno.isEmpty()) {
                errori.append("Il giorno e' obbligatorio\n");
            }
            if (mese.isEmpty()) {
                errori.append("Il mese e' obbligatorio\n");
            }
            if (anno.isEmpty()) {
                errori.append("L'anno e' obbligatorio\n");
            }
            try {
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            Calendar calendar = new GregorianCalendar();
            calendar.setLenient(false);
            calendar.set(interoAnno, interoMese-1, interoGiorno);
            calendar.getTime();
            } catch (Exception e) {
                errori.append("Data non corretta\n");
            }
            if (aziendaSelezionata.dipendenteGiaEsistente(codiceFiscale)) {
                errori.append("Domanda gia' presentata per il concorso scelto\n");
            }
            return errori.toString();
        }

    }
}
