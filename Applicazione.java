package it.unibas.azienda;

import it.unibas.azienda.controllo.ControlloDettagliAzienda;
import it.unibas.azienda.controllo.ControlloFrame;
import it.unibas.azienda.controllo.ControlloPrincipale;
import it.unibas.azienda.modello.Modello;
import it.unibas.azienda.persistenza.DaoArchivio;
import it.unibas.azienda.persistenza.IDAOArchivio;
import it.unibas.azienda.vista.Frame;
import it.unibas.azienda.vista.VistaDettagliAzienda;
import it.unibas.azienda.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {
    
    private static Applicazione singleton = new Applicazione();
    
    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }
    
    private Modello modello;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloFrame controlloFrame;
    private ControlloPrincipale controlloPrincipale;
    private IDAOArchivio daoArchivio;
    private VistaDettagliAzienda vistaDettagliAzienda;
    private ControlloDettagliAzienda controlloDettagliAzienda;

    public VistaDettagliAzienda getVistaDettagliAzienda() {
        return vistaDettagliAzienda;
    }

    public ControlloDettagliAzienda getControlloDettagliAzienda() {
        return controlloDettagliAzienda;
    }

    public Modello getModello() {
        return modello;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public ControlloFrame getControlloFrame() {
        return controlloFrame;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }
    
    private void inizializza() {
        this.modello = new Modello();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.controlloFrame = new ControlloFrame();
        this.controlloPrincipale = new ControlloPrincipale();
        this.daoArchivio = new DaoArchivio();
        this.vistaDettagliAzienda = new VistaDettagliAzienda(frame, true);
        this.controlloDettagliAzienda = new ControlloDettagliAzienda();
        this.vistaDettagliAzienda.inizializza();
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    };
}
