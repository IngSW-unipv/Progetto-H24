package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import view.Registrazione;
import Controller.DottoreController;

class TestRegistrazione {

    private Registrazione registrazione;

    @BeforeEach
    void setUp() {
       DottoreController controller = new DottoreController();
        registrazione = new Registrazione(controller);
    }

    @Test
    void testNomeNonVuoto() {
        registrazione.nomeField.setText("");
        assertFalse(registrazione.checkRequiredFields(), "Il nome non può essere vuoto");
    }

    @Test
    void testCognomeNonVuoto() {
        registrazione.cognomeField.setText("");
        assertFalse(registrazione.checkRequiredFields(), "Il cognome non può essere vuoto");
    }

    @Test
    void testEmailNonVuota() {
        registrazione.emailField.setText("");
        assertFalse(registrazione.checkRequiredFields(), "L'email non può essere vuota");
    }
    @Test
    void testEmailNonValida() {
        registrazione.emailField.setText("email_sbagliata"); // Formato errato
        assertFalse(registrazione.checkRequiredFields(), "Il test doveva fallire per email non valida.");
    }
    @Test
    void testCodiceFiscaleErrato() {
        registrazione.codiceFiscaleField.setText("123");
        assertFalse(registrazione.checkRequiredFields(), "Il test doveva fallire per codice fiscale errato.");
    }
    @Test
    void testPasswordTroppoCorta() {
        registrazione.passwordField.setText("abc12");
        assertFalse(registrazione.checkRequiredFields(), "Il test doveva fallire per password troppo corta.");
    }
    @Test
    void testEmailValida() {
        registrazione.emailField.setText("email@valida.com");
        assertTrue(registrazione.emailField.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"), "Formato email non valido");
    }

    @Test
    void testPasswordMinimoOttoCaratteri() {
        registrazione.passwordField.setText("12345");
        assertFalse(registrazione.passwordField.getPassword().length >= 8, "La password deve avere almeno 8 caratteri");
    }

    @Test
    void testCodiceFiscaleSediciCaratteri() {
        registrazione.codiceFiscaleField.setText("ABC123DEF456GHI7");
        assertTrue(registrazione.codiceFiscaleField.getText().length() == 16, "Il codice fiscale deve essere di 16 caratteri");
    }

    @Test
    void testDataNascitaCorretta() {
        registrazione.dataNascitaField.setText("12/12/2000");
        assertTrue(registrazione.dataNascitaField.getText().matches("^\\d{2}/\\d{2}/\\d{4}$"), "Formato data di nascita non valido");
    }

    @Test
    void testIndirizzoNonVuoto() {
        registrazione.indirizzioField.setText("");
        assertFalse(registrazione.checkRequiredFields(), "L'indirizzo non può essere vuoto");
    }
    @Test
    void testDataNascitaErrata() {
        registrazione.dataNascitaField.setText("12-12-2000"); // Formato errato
        assertFalse(registrazione.checkRequiredFields(), "Il test doveva fallire per formato data errato.");
    }

    @Test
    void testCheckRequiredFieldsCompleto() {
        registrazione.emailField.setText("test@example.com");
        registrazione.passwordField.setText("Test1234");
        registrazione.nomeField.setText("Mario");
        registrazione.cognomeField.setText("Rossi");
        registrazione.codiceFiscaleField.setText("ABC123DEF456GHI7");
        registrazione.dataNascitaField.setText("01/01/1990");
        registrazione.indirizzioField.setText("Via Roma 10");

        assertTrue(registrazione.checkRequiredFields(), "Tutti i campi devono essere compilati correttamente");
    }
}
