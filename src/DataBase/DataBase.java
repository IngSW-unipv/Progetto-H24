package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
 
import java.sql.Statement;



public class DataBase {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/progetto", "root", "123456789");
   
            String  SQL = "CREATE TABLE  Persone (" +
                                    "Email VARCHAR(50) NOT NULL, " +
                                    "Password VARCHAR(25) NOT NULL, " +
                                    "Nome VARCHAR(20) NOT NULL, " +
                                    "Cognome VARCHAR(20) NOT NULL, " +
                                    "Codice_fiscale VARCHAR(30) NOT NULL, " +
                                    "Data_nascita DATE NOT NULL, " +
                                    "Indirizzo VARCHAR(30) NOT NULL)"+
                                    "ID VARCHAR(6)NOT NULL";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
 
            stmt.close();
            con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	
	}
