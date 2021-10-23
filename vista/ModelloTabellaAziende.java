package it.unibas.azienda.vista;

import it.unibas.azienda.modello.Azienda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAziende extends AbstractTableModel {

    private List<Azienda> aziende = new ArrayList<>();

    public List<Azienda> getAziende() {
        return aziende;
    }

    public void setAziende(List<Azienda> aziende) {
        this.aziende = aziende;
    }

    @Override
    public int getRowCount() {
        return this.aziende.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Azienda azienda = this.aziende.get(rowIndex);
        if (columnIndex == 0) {
            return azienda.getPartitaIva();
        } else if (columnIndex == 1) {
            return azienda.getDenominazione();
        } else if (columnIndex == 2) {
            return azienda.getCitta();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Partita IVA";
        } else if (column == 1) {
            return "Denominazione";
        } else if (column == 2) {
            return "Citta'";
        }
        return "";
    }
    
    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
