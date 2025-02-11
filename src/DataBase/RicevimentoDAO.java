package DataBase;

import java.sql.SQLException;
import java.util.List;

import Model.Ricevimenti;


public interface RicevimentoDAO {
    void addRicevimento(Ricevimenti ricevimento) throws SQLException;
    void deleteRicevimento(String codiceFiscale) throws SQLException;
   List<Ricevimenti> getAllRicevimenti() throws SQLException;
}
