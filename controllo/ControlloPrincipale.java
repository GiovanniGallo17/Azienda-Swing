package it.unibas.azienda.controllo;

import it.unibas.azienda.Applicazione;
import it.unibas.azienda.modello.Archivio;
import it.unibas.azienda.modello.Azienda;
import it.unibas.azienda.modello.Costanti;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action AzioneCerca = new AzioneCerca();
    private Action azioneSeleziona = new AzioneSeleziona();

    public Action getAzioneSeleziona() {
        return azioneSeleziona;
    }

    public Action getAzioneCerca() {
        return AzioneCerca;
    }

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Seleziona");
            this.putValue(SHORT_DESCRIPTION, "Seleziona azienda");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Azienda> listaAziende = (List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            int rigaSelezionata = Applicazione.getInstance().getVistaPrincipale().getAziendaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Selezionare prima una azienda");
                return;
            }
            Azienda aziendaSelezionata = listaAziende.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBean(Costanti.AZIENDA_SELEZIONATA, aziendaSelezionata);
            Applicazione.getInstance().getVistaDettagliAzienda().visualizza();
        }

    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca aziende");
            this.putValue(SHORT_DESCRIPTION, "Cerca aziende nella citta' inserita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl A"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            String citta = Applicazione.getInstance().getVistaPrincipale().getCampoCitta();
            if (citta.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Inserire una citta'");
            }
            List<Azienda> aziendePerCitta = archivio.cercaAziendePerCitta(citta);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, aziendePerCitta);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
            Applicazione.getInstance().getControlloPrincipale().getAzioneSeleziona().setEnabled(true);
        }

    }
}
