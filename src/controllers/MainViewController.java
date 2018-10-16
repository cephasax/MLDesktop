package controllers;

import java.io.File;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainViewController {

    @FXML
    private Button btn_choose;

    @FXML
    private Button btn_load;

    @FXML
    private Text txt_name;

    @FXML
    private TableView<?> tbl_data;

    private Main main;

    public void setMainApp(Main main) {
		this.main = main;
	}

    @FXML
    void chooseModelFile(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
	         new ExtensionFilter("Text Files", "*.txt"),
	         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
	         new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
	         new ExtensionFilter("All Files", "*.*"));
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		if (selectedFile != null) {
			System.out.println("show");
		}
    }
}
