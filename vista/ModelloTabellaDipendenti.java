package it.unibas.azienda.vista;

import it.unibas.azienda.modello.Dipendente;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDipendenti extends AbstractTableModel {

    private List<Dipendente> dipendenti = new ArrayList<>();

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    @Override
    public int getRowCount() {
        return this.dipendenti.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dipendente dipendente = this.dipendenti.get(rowIndex);
        if (columnIndex == 0) {
            return dipendente.getCodiceFiscale();
        } else if (columnIndex == 1) {
            return dipendente.getNome();
        } else if (columnIndex == 2) {
            return dipendente.getCognome();
        } else if (columnIndex == 3) {
            DateFormat df = DateFormat.getDateInstance();
            return df.format(dipendente.getDataAssunzione().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice Fiscale";
        } else if (column == 1) {
            return "Nome";
        } else if (column == 2) {
            return "Cognome";
        } else if (column == 3) {
            return "Data assunzione";
        }
        return "";
    }
    
    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
