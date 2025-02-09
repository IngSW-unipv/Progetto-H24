package Model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import DataBase.InventarioDAOImp;
import DataBase.OrarioDottoreDAOimp;
import DataBase.PazienteDAOimp;
import DataBase.PrenotazioneDAOIMP;
import DataBase.REGDAOimp;
import DataBase.UserDAOimp;
import DataBase.VisitiDAOimp;
import view.HomePageDentista;
import view.HomePageOculista;
import view.HomePageOrtopedico;
import DataBase.RicevimentoDAOImpl;
import DataBase.ImpegnativaDAOimp;

public class Servizi {
    	public UserDAOimp userdaoimp;
	private VisitiDAOimp visitiDAO;
	private REGDAOimp registrazioneDAO;
	private PrenotazioneDAOIMP prenotazioneDAO;
	private RicevimentoDAOImpl ricevimentiDAO;
	private Object serviziDAO;
	private ImpegnativaDAOimp service;
	public PazienteDAOimp pazienti;
	public InventarioDAOImp inventer;
	public OrarioDottoreDAOimp orari;
	 public Servizi(Object registrazioneDAO, Object serviziDAO) {
	        this.userdaoimp = new UserDAOimp();
	       
	        this.setServiziDAO(serviziDAO);
	     
	    }
	
	
	public Servizi() {
		// TODO Auto-generated constructor stub
		 this.userdaoimp = new UserDAOimp();
		 this.ricevimentiDAO = new RicevimentoDAOImpl("DEFAULT"); 
		 this.prenotazioneDAO = new PrenotazioneDAOIMP();
		 this.visitiDAO = new VisitiDAOimp();
		 this.service = new ImpegnativaDAOimp("DEFAULT");
		 this.pazienti = new PazienteDAOimp("DEFAULT");
		 this.inventer = new InventarioDAOImp("DEFAULT");
		 this.orari = new OrarioDottoreDAOimp("defult");
		 this.registrazioneDAO = new REGDAOimp();
	}


	
	
	public void setTipoDiUtente(String tipoDiUtente) {
		  ricevimentiDAO.setTipoDiUtente(tipoDiUtente);
		prenotazioneDAO.setTipoDiUtente(tipoDiUtente);
		visitiDAO.setTipoDiUtente(tipoDiUtente);
		service.setTipoDiUtente(tipoDiUtente);
		pazienti.setTipoDiUtente(tipoDiUtente);
		inventer.setTipoDiUtente(tipoDiUtente);
		orari.setTipoDiUtente(tipoDiUtente);
		
	        if (ricevimentiDAO != null) {
	            ricevimentiDAO.setTipoDiUtente(tipoDiUtente);
	        } else {
	            throw new IllegalStateException("RicevimentoDAOImpl non è stato inizializzato.");
	        }
	    }// Imposta il tipo di utente
	
	public void registraUtente(User user) throws SQLException {
	    registrazioneDAO.registraUtente(user);
	}
	public List<Ricevimenti> getAllRicevimenti() throws SQLException {
        if (ricevimentiDAO != null) {
            return ricevimentiDAO.getAllRicevimenti();
        } else {
            throw new IllegalStateException("RicevimentoDAOImpl non è stato inizializzato.");
        }
    }

	public void addRicevimento(Ricevimenti ricevimento) throws SQLException {
        if (ricevimentiDAO != null) {
            ricevimentiDAO.addRicevimento(ricevimento);
        } else {
            throw new IllegalStateException("RicevimentoDAOImpl non è stato inizializzato.");
        }
    }

    public void deleteRicevimento(String codiceFiscale) throws SQLException {
        if (ricevimentiDAO != null) {
            ricevimentiDAO.deleteRicevimento(codiceFiscale);
        } else {
            throw new IllegalStateException("RicevimentoDAOImpl non è stato inizializzato.");
        }
    }
	
    public boolean serverificaCredenziali(String email, String password, String tipoUtente, String id) {
    	 if (userdaoimp == null) {
    	        throw new IllegalStateException("UserDAOimp non è stato inizializzato.");
    	    }
    	return userdaoimp.verificaCredenziali(email, password, tipoUtente, id);
    }
    public void addServizi(Impegnativa servizi) throws SQLException {
    	service.addServizi(servizi);
    }
    public void deleteServizi(String codiceFiscale) throws SQLException {
    	service.deleteServizi(codiceFiscale);
    }
    public List<Impegnativa> searchByCodiceFiscale(String codiceFiscale) throws SQLException {
    	return service.searchByCodiceFiscale(codiceFiscale);
    }
    public void aggiungiPrenotazione(Prenotazione prenotazione) throws SQLException {
        prenotazioneDAO.addPrenotazione(prenotazione);
    }

    public void eliminaTuttePrenotazioni() throws SQLException {
        prenotazioneDAO.eliminaTutti();
    }
	
	
	
	public String sergetnomedottore(String nome) {
		
		return userdaoimp.getNomeDottore(nome);
		
	}
	public void setTipoDiVisiti(String tipoDiVisiti) {
        visitiDAO = new VisitiDAOimp(); // Cambia dinamicamente il tipo di visitatore
    }

    public List<Visiti> getVisitiByDate(LocalDate date) throws SQLException {
        return visitiDAO.getVisitiByDate(date);
    }

    public void deleteVisiti(String codiceFiscale) throws SQLException {
        visitiDAO.deleteVisiti(codiceFiscale);
    }
    public void addPaziente(Paziente paziente) throws SQLException {
    	pazienti.addPaziente(paziente);
    }
    public void deletePaziente(String codiceFiscale) throws SQLException {
    	pazienti.deletePaziente(codiceFiscale);
    }
    public List<Paziente> getAllPazienti() throws SQLException {
    	return pazienti.getAllPazienti();
    }
    public void addMateriale(InventarioMateriale materiale) throws SQLException {
    	inventer.addMateriale(materiale);
    }
    public void deleteMateriale(String nomeMateriale) throws SQLException {
    	inventer.deleteMateriale(nomeMateriale);
    }
    public List<InventarioMateriale> getAllMateriali() throws SQLException {
    	return inventer.getAllMateriali();
    }
    public void orderMateriale(String nomeMateriale) throws SQLException {
    	inventer.orderMateriale(nomeMateriale);
    }
    public void addOrarioDottore(String cognome, String nome, String email, String numeroDiTelefono, String orario) throws SQLException {
    	orari.addOrarioDottore(cognome, nome, email, numeroDiTelefono, orario);
    }
    public void deleteOrarioDottore(String email) throws SQLException {
    	orari.deleteOrarioDottore(email);
    }
    public List<String[]> getAllOrariDottore() throws SQLException {
    	return orari.getAllOrariDottore();
    	}
    
    
	public void homePage(String Tipo_utente, String nomeDottore) {
		switch (Tipo_utente) {
		case "ORTOPEDICO":
		 new HomePageOrtopedico(nomeDottore, Tipo_utente).setVisible(true);
		 break;
		case "OCULISTA":
		 new HomePageOculista(nomeDottore, Tipo_utente).setVisible(true);
		 break;
		case "DENTISTA":
		 new HomePageDentista(nomeDottore, Tipo_utente).setVisible(true);
		 break;
		}
		 
	}


	public Object getServiziDAO() {
		return serviziDAO;
	}


	public void setServiziDAO(Object serviziDAO) {
		this.serviziDAO = serviziDAO;
	}

}
