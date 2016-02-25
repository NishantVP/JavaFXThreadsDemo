package module.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUIupdate.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		//StartScreenController controller = fxmlLoader.<StartScreenController>getController();
		//controller.setSectionConfigList(sectionConfigList);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Dynamically Updating UI");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
