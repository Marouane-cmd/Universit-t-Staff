package unistafflogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application{
	 

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	   Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
	   Scene scene = new Scene(root);
	   primaryStage.setScene(scene);
	   primaryStage.setTitle("Universitšt Portal");
	   primaryStage.setResizable(false);
       primaryStage.show();		
	}
  
	
	public static void main(String[] args) {
		launch(args);
	}
}
