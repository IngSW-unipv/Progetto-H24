package DataBase;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Model.Visiti;

public interface VisitiDAO {
  public  List<Visiti> getVisitiByDate(LocalDate date) throws SQLException;
  public void deleteVisiti(String codiceFiscale) throws SQLException;
    void setTipoDiUtente(String tipoDiUtente);
    
}
