package it.unibas.azienda.persistenza;

import it.unibas.azienda.modello.Archivio;


public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DaoException;
    
}
