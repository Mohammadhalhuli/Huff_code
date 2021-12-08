package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.Table;
import application.InterFaceController;
import application.InterFaceController;
import application.Table;
import application.Table;

public class Statistic_Controller {

	@FXML
	private Button Header;

	@FXML
	private Button HuffmanCode;

	@FXML
	private Button Back;

	@FXML
	private TextArea TArea;

	@FXML
	private TableView<Table> tableV;

	private ObservableList<Table> data = FXCollections.observableArrayList();

	@FXML
	void Header_Button(ActionEvent event) {

		// To bring The compress file name.
		if (InterFaceController.outFileName.contains("\\")) {
			String FileNmae[] = InterFaceController.outFileName.replace('\\', '*').split("\\*");
			InterFaceController.outFileName = FileNmae[FileNmae.length - 1];
		}

		// Display all data on the text area.
		TArea.appendText("Header \n\n");
		TArea.appendText("File Name : " + InterFaceController.file_Compress.getName() + "\n");
		TArea.appendText("Compressed File Name : " + InterFaceController.outFileName + "\n");
		TArea.appendText("Original File Size : " + InterFaceController.originalSize + " Byte. \n");
		TArea.appendText("Compression File Size : " + InterFaceController.compressedSize + " Byte. \n");

		int ratio = (int) (1-(InterFaceController.compressedSize / (double) InterFaceController.originalSize) * 100);
		TArea.appendText("Ratio For Compressing : " + ratio + "%\n\n");


		for (int i = 0; i < InterFaceController.huffCodeArraySize; i++) {

			TArea.appendText(InterFaceController.huffCodeArray[i].huffCode + "");
		}

	}

	@FXML
	void HuffmanCode_Button(ActionEvent event) {
		for (int i = 0; i < tableV.getItems().size(); i++) {
			tableV.getItems().clear();
		}

		TableColumn<Table, String> char_tbl = new TableColumn<Table, String>("Characters");
		char_tbl.setMinWidth(140);
		char_tbl.setCellValueFactory(new PropertyValueFactory<Table, String>("Characters"));

		TableColumn<Table, String> freq_tbl = new TableColumn<Table, String>("Frequency");
		freq_tbl.setMinWidth(140);
		freq_tbl.setCellValueFactory(new PropertyValueFactory<Table, String>("Frequency"));

		TableColumn<Table, String> huff_tbl = new TableColumn<Table, String>("HuffmanCode");
		huff_tbl.setMinWidth(140);
		huff_tbl.setCellValueFactory(new PropertyValueFactory<Table, String>("HuffmanCode"));

		tableV.getColumns().addAll(char_tbl, freq_tbl, huff_tbl);

		// Display the content on the Table View.
		for (int i = 0; i < InterFaceController.huffCodeArraySize; i++) {

			data.add(new Table(InterFaceController.huffCodeArray[i].character + "",
					InterFaceController.huffCodeArray[i].counter + "", InterFaceController.huffCodeArray[i].huffCode ));
		}
		tableV.setItems(data);

	}

	@FXML
	void Back_Button(ActionEvent event) {
		try {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("InterFace.fxml")));
			stage.setScene(scene);
			stage.show();

		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
