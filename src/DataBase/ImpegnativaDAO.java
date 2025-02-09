package DataBase;

import java.sql.SQLException;
import java.util.List;

import Model.Impegnativa;

public interface ImpegnativaDAO {
	void addServizi(Impegnativa servizi) throws SQLException;
    void deleteServizi(String codiceFiscale) throws SQLException;
    List<Impegnativa> searchByCodiceFiscale(String codiceFiscale ) throws SQLException;
  //  List<Servizi> getAllServices() throws SQLException;

	
	}
    
