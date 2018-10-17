package br.ufrn.imd.application;

import java.io.IOException;

import br.ufrn.imd.controllers.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	public AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Machine Learnin Simple Example - Desktop");
		try {
			showMainView();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void showMainView() throws IOException {
		// Carrega a tela principal
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("main.fxml"));
		rootLayout = (AnchorPane) loader.load();

		// Mostra a cena
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();

		MainViewController controller = loader.getController();
		controller.setMainApp(this);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}



}
