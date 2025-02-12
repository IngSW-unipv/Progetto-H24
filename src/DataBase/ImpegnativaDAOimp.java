package DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Impegnativa;

public class ImpegnativaDAOimp implements ImpegnativaDAO {

    private String tipoDiUtente; 

   
    public ImpegnativaDAOimp(String tipoDiUtente) {
        this.tipoDiUtente = tipoDiUtente;
    }


    public String getTipoDiUtente() {
        return tipoDiUtente;
    }

    public void setTipoDiUtente(String tipoDiUtente) {
        this.tipoDiUtente = tipoDiUtente;
    }

    @Override
    public void addImpegnativa(Impegnativa servizi) throws SQLException {
        String sql = "INSERT INTO impegnativa (PREZZO, DESCRIZIONE_DELLE_MALATTIA, TRATTAMENTO, CODICE_FISCALE, Tipo_di_utente) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DataBaseConnection.getInstance();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, servizi.getPrezzo());
            pstmt.setString(2, servizi.getDescrizioneMalattia());
            pstmt.setString(3, servizi.getTrattamento());
            pstmt.setString(4, servizi.getCodiceFiscale());
            pstmt.setString(5, tipoDiUtente); // Tipo di utente associato

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Servizio aggiunto con successo. Righe inserite: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Errore durante l'aggiunta del servizio: " + e.getMessage());
            throw e;
        }
    }

    public void deleteImpegnativa(String codiceFiscale) throws SQLException {
        String sql = "DELETE FROM impegnativa WHERE CODICE_FISCALE = ? AND Tipo_di_utente = ?";
        
        try (Connection conn = DataBaseConnection.getInstance();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codiceFiscale);
            pstmt.setString(2, tipoDiUtente); // Filtra per tipo di utente

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Servizio eliminato con successo per CODICE_FISCALE: " + codiceFiscale);
            } else {
                System.out.println("Nessun servizio trovato per CODICE_FISCALE: " + codiceFiscale);
            }
        } catch (SQLException e) {
            System.err.println("Errore durante l'eliminazione del servizio: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Impegnativa> searchByCodiceFiscale(String codiceFiscale) throws SQLException {
        String sql = "SELECT PREZZO, DESCRIZIONE_DELLE_MALATTIA, TRATTAMENTO, CODICE_FISCALE FROM impegnativa WHERE CODICE_FISCALE = ? AND Tipo_di_utente = ?";
        List<Impegnativa> serviziList = new ArrayList<>();
        if (tipoDiUtente == null || tipoDiUtente.isEmpty()) {
            throw new IllegalArgumentException("Tipo di utente non specificato. Assicurati che l'utente sia autenticato correttamente.");
        }
        try (Connection conn = DataBaseConnection.getInstance();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codiceFiscale);
            pstmt.setString(2, tipoDiUtente); // Filtra per tipo di utente

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Impegnativa servizio = new Impegnativa(
                        rs.getString("PREZZO"),
                        rs.getString("DESCRIZIONE_DELLE_MALATTIA"),
                        rs.getString("TRATTAMENTO"),
                        rs.getString("CODICE_FISCALE"),
                        tipoDiUtente // Aggiunge il tipo di utente corrente
                    );
                    serviziList.add(servizio);
                }
            }
        } catch (SQLException e) {
            System.err.println("Errore durante la ricerca per CODICE_FISCALE: " + codiceFiscale + " e Tipo_di_utente: " + tipoDiUtente);
            throw e;
        }

        return serviziList;
    }
}
