package Controller;
import Model.InventarioMateriale;
import Model.Paziente;
import Model.Prenotazione;
import Model.Ricevimenti;
import Model.Servizi;
import Model.Impegnativa;
import Model.User;
import Model.Visiti;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class DottoreController {

	public DottoreController() {
        this.servizio = new Servizi();
       
    }
	
	private Servizi servizio;
	private String tipoUtente;
	
	public DottoreController(String tipoUtente) {
	this.servizio = new Servizi(); // Inizializza Servizi
        servizio.setTipoDiUtente(tipoUtente);
        this.tipoUtente = tipoUtente;
        this.servizio.setTipoDiUtente(tipoUtente);
        
	    if (tipoUtente == null || tipoUtente.trim().isEmpty()) {
	        throw new IllegalArgumentException("Il tipo di utente non può essere null o vuoto.");
	        
	    }
	    
	}
	
	
	public void registraUtente(User user) throws SQLException {
	       
	       servizio.registraUtente(user);
	   }
	public void setTipoDiUtente(String tipoDiUtente) {
	    servizio.setTipoDiUtente(tipoDiUtente); // Passa il tipo di utente al servizio
	}
	    public void aggiungiPrenotazione(Prenotazione prenotazione) throws SQLException {
	        servizio.aggiungiPrenotazione(prenotazione);
	    }

	    public void eliminaTuttePrenotazioni() throws SQLException {
	        servizio.eliminaTuttePrenotazioni();
	    }
   
	    public boolean converificred(String email, String password, String tipoUtente, String id) {
	        return servizio.serverificaCredenziali(email, password, tipoUtente, id);
	    }
	
	
	
	
	    public void conHomepage(String Tipo_utente, String nomeDottore) {
		servizio.homePage(Tipo_utente, nomeDottore);;
	    }
	
	
	
	
	    public String congetnomedott(String nome) {
		return servizio.sergetnomedottore(nome);
	    };
	
	    public List<Visiti> getVisitiByDate(LocalDate date) throws SQLException {
            return servizio.getVisitiByDate(date);
            }
	    public void deleteVisiti(String codiceFiscale) throws SQLException {
            servizio.deleteVisiti(codiceFiscale);
    	    }
    	    public List<Ricevimenti> getAllRicevimenti() throws SQLException {
	        return servizio.getAllRicevimenti();
	    }

	    public void addRicevimento(Ricevimenti ricevimento) throws SQLException {
	        servizio.addRicevimento(ricevimento);
	    }

	    public void deleteRicevimento(String codiceFiscale) throws SQLException {
	        servizio.deleteRicevimento(codiceFiscale);
	    }
	    public void addServizi(Impegnativa servizi) throws SQLException {
	    	servizio.addServizi(servizi);
	    }
	    public void deleteServizi(String codiceFiscale) throws SQLException {
	    	servizio.deleteServizi(codiceFiscale);
	    }
	    public List<Impegnativa> searchByCodiceFiscale(String codiceFiscale) throws SQLException {
	    	return servizio.searchByCodiceFiscale(codiceFiscale);
	    }
	    public List<Paziente> getAllPazienti() throws SQLException {
	    	return servizio.getAllPazienti();
	    }
	    public void deletePaziente(String codiceFiscale) throws SQLException {
	    	servizio.deletePaziente(codiceFiscale);
	    }
	    public void addPaziente(Paziente paziente) throws SQLException {
	    	servizio.addPaziente(paziente);
	    }
	    public void addMateriale(InventarioMateriale materiale) throws SQLException {
	    	servizio.addMateriale(materiale);
	    }
	    public void deleteMateriale(String nomeMateriale) throws SQLException {
	    	servizio.deleteMateriale(nomeMateriale);
	    }
	    public List<InventarioMateriale> getAllMateriali() throws SQLException {
	    	return servizio.getAllMateriali();
	    }
	    public void orderMateriale(String nomeMateriale) throws SQLException {
	    	servizio.orderMateriale(nomeMateriale);
	    }
	    public void addOrarioDottore(String cognome, String nome, String email, String numeroDiTelefono, String orario) throws SQLException {
	    	servizio.addOrarioDottore(cognome, nome, email, numeroDiTelefono, orario);
	    }
	    public void deleteOrarioDottore(String email) throws SQLException {
	    	servizio.deleteOrarioDottore(email);
	    }
	    public List<String[]> getAllOrariDottore() throws SQLException {
	    	return servizio.getAllOrariDottore();
	    }
	    public String getTipoUtente() {
			return tipoUtente;
	    }
	    public void setTipoUtente(String tipoUtente) {
			this.tipoUtente = tipoUtente;
	    }

}
