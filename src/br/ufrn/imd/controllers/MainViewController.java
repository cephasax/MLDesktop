package br.ufrn.imd.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.application.Main;
import br.ufrn.imd.domain.Diabets;
import br.ufrn.imd.domain.DiabetsController;
import br.ufrn.imd.domain.DiabetsItem;
import br.ufrn.imd.domain.MachineLearningModel;
import br.ufrn.imd.utils.DiabetsParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainViewController {

	private Main main;
	private File modelFile;
	private File dataFile;
	private MachineLearningModel mlm;
	private ArrayList<Diabets> data;
	private ObservableList<DiabetsItem> observableList;

	@FXML
	private AnchorPane anchor_main;

	@FXML
	private Button btn_choose;

	@FXML
	private Button btn_load;

	@FXML
	private Text txt_file_name;

	@FXML
	private TableView<DiabetsItem> tbl_data;

	@FXML
    private TableColumn<DiabetsItem, Boolean> col_option;

	@FXML
    private CheckBox checkbox_option;

	@FXML
	private TableColumn<DiabetsItem, Double> col_preg;

	@FXML
	private TableColumn<DiabetsItem, Double> col_plas;

	@FXML
	private TableColumn<DiabetsItem, Double> col_pres;

	@FXML
	private TableColumn<DiabetsItem, Double> col_skin;

	@FXML
	private TableColumn<DiabetsItem, Double> col_insu;

	@FXML
	private TableColumn<DiabetsItem, Double> col_mass;

	@FXML
	private TableColumn<DiabetsItem, Double> col_pedi;

	@FXML
	private TableColumn<DiabetsItem, Double> col_age;

	@FXML
	private TableColumn<DiabetsItem, String> col_class;

	@FXML
	private Button btn_classify;

	@FXML
    private Text txt_debug;

	@FXML
    private Button btn_load_data;

	@FXML
	public void chooseModelFile(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open .model file");
		fileChooser.getExtensionFilters().add(new ExtensionFilter(".model Files", "*.model"));
		this.modelFile = fileChooser.showOpenDialog(this.main.getPrimaryStage());
		if (modelFile != null) {
			txt_file_name.setText(modelFile.getAbsolutePath());
			txt_debug.setText("... model chosen successfully");
			btn_load.setDisable(false);
		}

		else {
			txt_file_name.setText("");
			txt_debug.setText("... model wasn't chosen");
			btn_load.setDisable(true);
		}
	}

	 @FXML
    public void loadModel(ActionEvent event) {
		 this.mlm = new MachineLearningModel(modelFile.getAbsolutePath());
		 mlm.loadModel();
		 txt_debug.setText("... model loaded successfully");
    }

    @FXML
    public void loadData(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open data file");
		fileChooser.getExtensionFilters().add(new ExtensionFilter(".csv Files", "*.csv"));
		this.dataFile = fileChooser.showOpenDialog(this.main.getPrimaryStage());
		if (dataFile != null) {
			txt_file_name.setText(dataFile.getAbsolutePath());
			txt_debug.setText("loading data...");
			this.data = new ArrayList<Diabets>();
			try {
				data = (ArrayList<Diabets>) DiabetsParser.csvToDiabetsData(dataFile.getAbsolutePath());
				this.observableList = FXCollections.observableArrayList(DiabetsItem.diabetsItensFromDiabetsList(data));

				populateTable();

				txt_debug.setText("data loaded successfully");
				btn_classify.setDisable(false);
			} catch (IOException e) {
				txt_debug.setText("unable to load data :(");
				e.printStackTrace();
			}
		}
    }

	@FXML
	void classifyData(ActionEvent event) {
		this.data.clear();
		this.data = DiabetsParser.DiabetsItensToDiabets(observableList);
		DiabetsController dc = new DiabetsController(mlm);
		for(Diabets d: data){
			d = dc.classifydiabets(d);
		}
		observableList.clear();
		observableList = FXCollections.observableArrayList(DiabetsItem.diabetsItensFromDiabetsList(data));
		tbl_data.setItems(observableList);
		txt_debug.setText("Data classified with the loaded ML model :)");
	}

	private void populateTable() {

		col_preg.setCellValueFactory(new PropertyValueFactory<DiabetsItem, Double>("preg"));
	    col_plas.setCellValueFactory(new PropertyValueFactory<DiabetsItem, Double>("plas"));
	    col_pres.setCellValueFactory(new PropertyValueFactory<DiabetsItem, Double>("pres"));
	    col_skin.setCellValueFactory(new PropertyValueFactory<DiabetsItem, Double>("skin"));
	    col_insu.setCellValueFactory(new PropertyValueFactory<DiabetsItem, Double>("insu"));
	    col_mass.setCellValueFactory(new PropertyValueFactory<DiabetsItem, Double>("mass"));
	    col_pedi.setCellValueFactory(new PropertyValueFactory<DiabetsItem, Double>("pedi"));
	    col_age.setCellValueFactory(new PropertyValueFactory<DiabetsItem, Double>("age"));
	    col_class.setCellValueFactory(new PropertyValueFactory<DiabetsItem, String>("diabetsClass"));
	    tbl_data.setItems(observableList);

	}


	public void setMainApp(Main main) {
		this.main = main;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

}
