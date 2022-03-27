package unistaffsignup;


import java.sql.SQLException;
import java.sql.Statement;


public class SignUpModel {
	
	private final String  CONTACT_TABLE = "User";
	
	// Neuer User Erstellen
	
	public void CreateUser (Statement statement , String uString , String pString , String dString) throws SQLException {
		statement.execute(" INSERT INTO " + CONTACT_TABLE + " VALUES " + " ('" + uString +"' , '" + pString + "' , '" + dString + "')");
		statement.close();
		}
		
  
		}
			
		
		
		 
	


