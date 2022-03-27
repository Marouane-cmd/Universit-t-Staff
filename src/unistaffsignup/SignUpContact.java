package unistaffsignup;

import javafx.beans.property.SimpleStringProperty;

public class SignUpContact {

	private SimpleStringProperty userName ;
	private SimpleStringProperty password;
	private SimpleStringProperty department ;


	public SignUpContact(String userName, String password,String department) {
		super();
		this.userName = new SimpleStringProperty(userName);
		this.password = new SimpleStringProperty(password);
		this.department = new SimpleStringProperty(department);
	}

    // Getter and Setter 
	
	public SimpleStringProperty getUserName() {
		return userName;
	}

	public void setUserName(SimpleStringProperty userName) {
		this.userName = userName;
	}

	public SimpleStringProperty getPassword() {
		return password;
	}

	public void setPassword(SimpleStringProperty password) {
		this.password = password;
	}

	public SimpleStringProperty getDepartment() {
		return department;
	}

	public void setDepartment(SimpleStringProperty department) {
		this.department = department;
	}




}
