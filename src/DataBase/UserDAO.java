package DataBase;

import Model.User;

public interface UserDAO <Login>{

	boolean verificaCredenziali(String username, String password, String tipoUtente, String id);
	void registraUtente(User user);
	String getNomeDottore(String Nome);
}


