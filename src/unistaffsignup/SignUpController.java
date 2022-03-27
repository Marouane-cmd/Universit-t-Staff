package unistaffsignup;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import databaseutility.Database;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import unistafflogin.LoginApp;
import unistafflogin.LoginController;

public class SignUpController implements Initializable  {

	// Variabeln
	private Database database = new Database();
	private SignUpModel signupModel = new SignUpModel();

	private ObservableList<SignUpContact> signup ;

	@FXML
	private TextField departmentTextField;

	@FXML
	private TextField passwordTextField;

	@FXML
	private TextField usernameTextField;
	@FXML
	private Button backButton;

	@FXML
	private Button sendDataButton;

	@FXML
	void backButtonAction(ActionEvent event) {

		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/unistafflogin/Scene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Universität Portal");
			primaryStage.setResizable(false);
			primaryStage.show();

			// Login Screen nicht mehr erscheinen 

			Stage stage = (Stage)backButton.getScene().getWindow();
			stage.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void sendDataAction(ActionEvent event) {

		String type = departmentTextField.getText();
		if (type.equalsIgnoreCase("Computer Science") || type.equalsIgnoreCase("Information Science") || type.equalsIgnoreCase("Information Technologie")) {
			signUp();
			backButtonAction(event);
		}
		else {
			popUpDepartment();
			System.out.println("Department don't exist");
		}
	}

	// Neu Sign Up 

	public void signUp() {

		String username = usernameTextField.getText();
		String password = passwordTextField.getText();
		String department = departmentTextField.getText();

		try {

			signupModel.CreateUser(database.getStatement(), username, password, department);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void popUpDepartment () {
		
		Stage stage = new Stage ();
		stage.setTitle("Nachricht");
		Label label = new Label("Department don't exist");
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boolean dbConnection = database.open();		
	}

}
