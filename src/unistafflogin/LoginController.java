package unistafflogin;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import databaseutility.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class LoginController implements Initializable {

	@FXML
	private Button loginButton;
	
	@FXML
    private Button signupButton;


	@FXML
	private ImageView myImageView;

	@FXML
	private PasswordField passwordTextField;

	@FXML
	private TextField usernameTextField;
	

	//Variabeln 
	Database database = new Database ();
	LoginModel loginModel = new LoginModel();

	@FXML
	void loginButtonKeyReleased(ActionEvent event) {

		String uString = usernameTextField.getText();
		String pString = passwordTextField.getText();

		Connection connection = database.getConnection();

		try {
			if(loginModel.isLogin(uString, pString, connection) ) {
				Stage stage = (Stage)loginButton.getScene().getWindow();
				stage.close();
				sucessLogin();	
			}
			else {
				// wrong Login Data
			   wrongLoginData();
			}
			}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	@FXML
    void supButtonKeyReleased(ActionEvent event) {
          
		signUpScreen();
		Stage stage = (Stage)signupButton.getScene().getWindow();
		stage.close();
    }

	@FXML
	void loginKeyReleased(KeyEvent event) {


	}
	public void sucessLogin () {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Stage stage = new Stage();
			Pane root = fxmlLoader.load(getClass().getResource("/unistaffsignup/KontakteScene.fxml").openStream());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Universtät Portal");
			stage.setResizable(false);
			stage.show();

			database.getConnection().close();

		} catch (Exception e) {

		}
	}
	
	public void wrongLoginData () {
		
		Stage stage = new Stage ();
		stage.setTitle("Nachricht");
		Label label = new Label("wrong username or password ");
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
	
	public void signUpScreen() {
		
		
		try {
			FXMLLoader fxmlLoader2 = new FXMLLoader();
			Stage stage = new Stage ();
			Pane root2 = fxmlLoader2.load(getClass().getResource("/unistaffsignup/SignupScreen.fxml").openStream());
			Scene scene2 = new Scene(root2);
			stage.setScene(scene2);
			stage.setTitle("Singup Screen");
			stage.setResizable(false);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boolean dbConnection = database.open();


	}


}
