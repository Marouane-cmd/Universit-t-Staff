package unistaffsignup;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import databaseutility.Database;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.cell.*;
public class StudentController implements Initializable{

	// Variabeln
	private Database database = new Database();
	private StudentModel studentModel = new StudentModel();
	private ObservableList<StudentContact> studentList ;
	
	
	
	@FXML
	private TextField idTextField;

	@FXML
	private TextField adressTextField;

	@FXML
	private TextField departmentTextField;

	@FXML
	private TextField nameTextField;


	@FXML
	private TextField phoneTextField;

	@FXML
	private Button sendDataButton;

	@FXML
	private TableView<StudentContact> studentTableView;

	@FXML
	private TableColumn<StudentContact, String> adressColumn;

	@FXML
	private TableColumn<StudentContact, String> departmentColumn;

	@FXML
	private TableColumn<StudentContact, String> nameColumn;


	@FXML
	private TableColumn<StudentContact, String> idColumn;

	
	@FXML
	private TableColumn<StudentContact, String> phoneColumn;

	@FXML
	void studentButtonAction(ActionEvent event) {

		addStudent();
		loadStudent();

		popUpConfirm();
		clearTextFields();
	}

	// Neu Student hinzufügen 

	public void addStudent()  {

		String name = nameTextField.getText();
		String adress = adressTextField.getText();
		String phone = phoneTextField.getText();
		String depart = departmentTextField.getText();
		String id =idTextField.getText();
		try {
			studentModel.addStudent(database.getStatement(), id, name, adress, phone, depart);
		} catch (SQLException e) {

	       e.printStackTrace();
		}

	}

	// Student hinzufügen in Datenbank bestätigt
	public void popUpConfirm() {

		Stage stage = new Stage ();
		stage.setTitle("Nachricht");
		Label label = new Label("success student insertion in Database");
		Button button = new Button("Ok");

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				stage.close();

			}
		});

		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(label,button);
		vBox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vBox,300,150);

		stage.setScene(scene);
		stage.showAndWait();
	}

	// Neu Student auf der Tabelle laden 
	
	


	public void loadStudent() {
		try {
			studentList = studentModel.loadStudendts(database.getStatement(), studentList);


		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		TableColumn<StudentContact,String> namColumn = new TableColumn<StudentContact,String>("Name");
		namColumn.setCellValueFactory(new PropertyValueFactory<StudentContact,String>("Name"));
        
		idColumn.setCellValueFactory(new PropertyValueFactory<StudentContact,String>("id")); 
		nameColumn.setCellValueFactory(new PropertyValueFactory<StudentContact,String>("studentName"));
		adressColumn.setCellValueFactory(new PropertyValueFactory<StudentContact,String>("adress"));
		phoneColumn.setCellValueFactory(new PropertyValueFactory<StudentContact,String>("phone"));
		departmentColumn.setCellValueFactory(new PropertyValueFactory<StudentContact,String>("department"));
	   

		studentTableView.setItems(studentList);

	}

	// Clear TextFields nach der Hinzufügen Bestätigung 

	public void clearTextFields() {

		nameTextField.clear();
		adressTextField.clear();
		phoneTextField.clear();
		departmentTextField.clear();
		idTextField.clear();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boolean dbConnection = database.open();	

		if(dbConnection) {
			loadStudent();
		}else {
			System.out.println("Error");
		}
	}

}

