package unistaffsignup;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentContact {
    
	
	private  SimpleStringProperty id ;
	private SimpleStringProperty name ;
	private SimpleStringProperty adress ;
	private SimpleStringProperty phone ;
	private SimpleStringProperty department ;



	public StudentContact(String id ,String name,String adress,String phone,String department) {
		super();
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.adress = new SimpleStringProperty(adress);
		this.phone = new SimpleStringProperty(phone);
		this.department = new SimpleStringProperty(department);
	}


	// Getter and Setter

	public String getId() {
		return id.get();
	}


	public void setId(SimpleStringProperty id) {
		this.id = id;
	}


	public String getName() {
		return name.get();
	}

	public void setName(SimpleStringProperty name) {
		this.name = name;
	}


	public String getAdress() {
		return adress.get();
	}

	public void setAdress(SimpleStringProperty adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone.get();
	}



	public void setPhone(SimpleStringProperty phone) {
		this.phone = phone;
	}



	public String getDepartment() {
		return department.get();
	}



	public void setDepartment(SimpleStringProperty department) {
		this.department = department;
	}



}
