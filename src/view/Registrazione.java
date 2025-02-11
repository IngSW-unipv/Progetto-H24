
package view;
import javax.swing.*;
import Controller.DottoreController;
import Model.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@SuppressWarnings("serial")
public class Registrazione extends JFrame implements ActionListener {

    private DottoreController controller; 

    JButton chiuso = new JButton("CHIUSO");
    JButton conferma = new JButton("CONFERMA");
    JCheckBox showPasswordCheckBox = new JCheckBox("MOSTRA LA PASSWORD");

    JLabel emailLabel = new JLabel("EMAIL");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel nomeLabel = new JLabel("NOME");
    JLabel cognomeLabel = new JLabel("COGNOME");
    JLabel codiceFiscaleLabel = new JLabel("CODICE FISCALE");
    JLabel dataNascitaLabel = new JLabel("DATA DI NASCITA");
    JLabel indirizzioLabel = new JLabel("INDIRIZZO");
    JLabel idLabel = new JLabel("ID");

    public JTextField emailField = new JTextField(20);
    public JPasswordField passwordField = new JPasswordField(20);
    public JTextField nomeField = new JTextField(20);
    public JTextField cognomeField = new JTextField(20);
    public JTextField codiceFiscaleField = new JTextField(20);
    public JTextField dataNascitaField = new JTextField(20);
    public JTextField indirizzioField = new JTextField(20);
    public JTextField idField = new JTextField(20);

    JRadioButton ortopedicoRadio = new JRadioButton("ORTOPEDICO");
    JRadioButton oculistaRadio = new JRadioButton("OCULISTA");
    JRadioButton dentistaRadio = new JRadioButton("DENTISTA");
    ButtonGroup radioGroup = new ButtonGroup();

    JPanel panel = new JPanel(null);

    @SuppressWarnings("unused")
    public Registrazione(DottoreController controller) {
        this.controller = controller; 

        setTitle("REGISTRAZIONE");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel.add(emailLabel);
        emailLabel.setBounds(50, 30, 160, 40);
        panel.add(emailField);
        emailField.setBounds(200, 30, 250, 30);
        emailLabel.setFont(new Font("ALGERIAN", Font.ITALIC, 40));
        panel.add(passwordLabel);
        passwordLabel.setBounds(40, 80, 150, 30);
        panel.add(passwordField);
        passwordField.setBounds(200, 80, 250, 30);
        passwordLabel.setFont(new Font("ALGERIAN", Font.ITALIC, 25));
        panel.add(nomeLabel);
        nomeLabel.setBounds(50, 130, 160, 30);
        panel.add(nomeField);
        nomeField.setBounds(200, 130, 250, 30);
        nomeLabel.setFont(new Font("ALGERIAN", Font.ITALIC, 30));
        panel.add(cognomeLabel);
        cognomeLabel.setBounds(50, 180, 150, 30);
        panel.add(cognomeField);
        cognomeField.setBounds(200, 180, 250, 30);
        cognomeLabel.setFont(new Font("ALGERIAN", Font.ITALIC, 30));
        panel.add(codiceFiscaleLabel);
        codiceFiscaleLabel.setBounds(20, 230, 160, 30);
        panel.add(codiceFiscaleField);
        codiceFiscaleField.setBounds(200, 230, 250, 30);
        codiceFiscaleLabel.setFont(new Font("ALGERIAN", Font.ITALIC, 21));
        panel.add(dataNascitaLabel);
        dataNascitaLabel.setBounds(10, 280, 180, 30);
        panel.add(dataNascitaField);
        dataNascitaField.setBounds(200, 280, 250, 30);
        dataNascitaLabel.setFont(new Font("ALGERIAN", Font.ITALIC, 21));
        panel.add(indirizzioLabel);
        indirizzioLabel.setBounds(50, 330, 150, 30);
        panel.add(indirizzioField);
        indirizzioField.setBounds(200, 330, 250, 30);
        indirizzioLabel.setFont(new Font("ALGERIAN", Font.ITALIC, 30));
        panel.add(showPasswordCheckBox);
        showPasswordCheckBox.setBounds(200, 380, 250, 30);

        panel.add(ortopedicoRadio);
        ortopedicoRadio.setBounds(50, 430, 150, 30);
        panel.add(oculistaRadio);
        oculistaRadio.setBounds(200, 430, 150, 30);
        panel.add(dentistaRadio);
        dentistaRadio.setBounds(350, 430, 150, 30);
        radioGroup.add(ortopedicoRadio);
        radioGroup.add(oculistaRadio);
        radioGroup.add(dentistaRadio);

        panel.add(chiuso);
        chiuso.setBounds(80, 550, 150, 50);
        panel.add(conferma);
        conferma.setBounds(300, 550, 150, 50);
        idField.setBounds(getBounds());
        idField.setBounds(200, 480, 250, 30);
        idLabel.setBounds(50, 480, 150, 30);
        idLabel.setVisible(false);
       panel.add(idField);
       panel.add(idLabel);
        panel.setBackground(Color.decode("#89CFF0"));
        ortopedicoRadio.setBackground(Color.decode("#89CFF0"));
        oculistaRadio.setBackground(Color.decode("#89CFF0"));
        dentistaRadio.setBackground(Color.decode("#89CFF0"));
        showPasswordCheckBox.setBackground(Color.decode("#89CFF0"));
        
        showPasswordCheckBox.addActionListener(e -> togglePasswordVisibility());
        conferma.addActionListener(e -> registraUtente());
        chiuso.addActionListener(this);

        add(panel);
        idField.setVisible(false);
        ortopedicoRadio.addActionListener(this);
        oculistaRadio.addActionListener(this);
        dentistaRadio.addActionListener(this);
        
    }
    
  

   
    private void togglePasswordVisibility() {
        if (showPasswordCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chiuso) {
            System.exit(0);
        } else if(ortopedicoRadio.isSelected() || oculistaRadio.isSelected() || dentistaRadio.isSelected() ) {
            idField.setVisible(true);
            idLabel.setVisible(true);
        }
        }
    

    private void registraUtente() {
        String tipoUtente = ortopedicoRadio.isSelected() ? "ORTOPEDICO" :
                oculistaRadio.isSelected() ? "OCULISTA" :
                dentistaRadio.isSelected() ? "DENTISTA" : null;
       if (!checkRequiredFields()) {
            JOptionPane.showMessageDialog(this, "Compila tutti i campi!", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        User user = new User(
                emailField.getText().trim(),
                new String(passwordField.getPassword()).trim(),
                nomeField.getText().trim(),
                cognomeField.getText().trim(),
                codiceFiscaleField.getText().trim(),
                dataNascitaField.getText().trim(),
                indirizzioField.getText().trim(),
                tipoUtente,
                idField.getText().trim()
        );

        try {
            controller.registraUtente(user);
            JOptionPane.showMessageDialog(this, "Registrazione effettuata!", "Successo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante la registrazione.", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
    

  
    public boolean checkRequiredFields() {
	    String email = emailField.getText().trim();
	    String password = new String(passwordField.getPassword()).trim();
	    String nome = nomeField.getText().trim();
	    String cognome = cognomeField.getText().trim();
	    String codiceFiscale = codiceFiscaleField.getText().trim();
	    String dataNascita = dataNascitaField.getText().trim();
	    String indirizzio = indirizzioField.getText().trim();

	    // Controllo che nessun campo sia vuoto
	    if (email.isEmpty() || password.isEmpty() || nome.isEmpty() || cognome.isEmpty() ||
	        codiceFiscale.isEmpty() || dataNascita.isEmpty() || indirizzio.isEmpty()) {
	        return false;
	    }

	    // Controllo che l'email abbia un formato valido
	    if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	        return false;
	    }

	    // Controllo che la password abbia almeno 8 caratteri e un numero
	    if (password.length() < 8 || !password.matches(".*\\d.*")) {
	        return false;
	    }

	    // Controllo che il codice fiscale abbia 16 caratteri alfanumerici
	    if (!codiceFiscale.matches("^[A-Z0-9]{16}$")) {
	        return false;
	    }

	    // Controllo che la data di nascita abbia il formato corretto
	    if (!dataNascita.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
	        return false;
	    }

	    return true;
	}


    public static void main(String[] args) {
        DottoreController controller = new DottoreController();
        new Registrazione(controller).setVisible(true);
    }

   
}