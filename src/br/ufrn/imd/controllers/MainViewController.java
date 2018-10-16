package br.ufrn.imd.controllers;

import br.ufrn.imd.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainViewController {

	@FXML
    private AnchorPane anchor_main;

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

    }
    
}
