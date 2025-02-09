package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.User;

public class REGDAOimp implements RegistrazioneDAO {
	
	public void registraUtente(User user) throws SQLException {
	    String insertSQL = "INSERT INTO dottore (Email, Password, Nome, Cognome, Codice_Fiscale, Data_di_Nascita, Indirizzio, Tipo_di_utente, ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection con = DataBaseConnection.getInstance();
	         PreparedStatement pstmt = con.prepareStatement(insertSQL)) {

	        pstmt.setString(1, user.getEmail());
	        pstmt.setString(2, user.getPassword());
	        pstmt.setString(3, user.getNome());
	        pstmt.setString(4, user.getCognome());
	        pstmt.setString(5, user.getCodiceFiscale());
	        pstmt.setString(6, user.getDataNascita());
	        pstmt.setString(7, user.getIndirizzio());
	        pstmt.setString(8, user.getTipoUtente());
	        pstmt.setString(9, user.getIdSpecializzazione());

	        int rowsAffected = pstmt.executeUpdate();
	        System.out.println("Righe inserite: " + rowsAffected);  // Aggiungi questa linea per debug

	        if (rowsAffected == 0) {
	            throw new SQLException("Registrazione fallita, nessuna riga inserita.");
	        }
	        
	    } catch (SQLException e) {
	        System.err.println("Errore durante l'inserimento nel database: " + e.getMessage());
	        e.printStackTrace();
	        throw e;
	    }
	

	    
	}
	
	

		

	

}
