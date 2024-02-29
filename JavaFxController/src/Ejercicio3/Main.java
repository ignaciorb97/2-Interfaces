package Ejercicio3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Cargar el archivo FXML
		Parent root = FXMLLoader.load(getClass().getResource("Ejercicio3Controladores.fxml"));

		Scene scene = new Scene(root, 600, 350);
		primaryStage.setScene(scene);
		primaryStage.setTitle("GridPane");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
