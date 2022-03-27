package unistaffsignup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import unistaffsignup.StudentContact;

public class StudentModel {
	
private final String  CONTACT_TABLE = "Student";
private final String QUERY_DATA_FROM_CONTACT_TABLE = " SELECT * FROM " + CONTACT_TABLE  ;
	
	// Neuer User Erstellen
	
	public void addStudent (Statement statement ,String id , String name , String adress,String phone,String depart) throws SQLException {
		statement.execute(" INSERT INTO " + CONTACT_TABLE + " VALUES " + " ('" + id + "' , '" + name + "' , '" + adress + "' , '" + phone + "' , '" + depart + "')");
		statement.close();
		}
	// Lade Studenten 
	
		public ObservableList<StudentContact> loadStudendts (Statement statement , ObservableList<StudentContact> list) throws SQLException{
			
			list = FXCollections.observableArrayList();
			
			ResultSet resultSet = statement.executeQuery(QUERY_DATA_FROM_CONTACT_TABLE);
			
			while (resultSet.next()) {
				String id = resultSet.getString(1);
				String name = resultSet.getString(5);
				String adress = resultSet.getString(2);		
				String phone = resultSet.getString(3);
				String depart = resultSet.getString(4);
				
				list.add(new StudentContact(id, name, adress, phone, depart));
			}
			
			statement.close();
			return list;
		}

}
