package controller;

import java.io.IOException;

import application.LanceurCluedo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuCluedoController {
	
    @FXML
    private BorderPane borderpane;

	@FXML
	private Button jouer;

	@FXML
	private Button solution;

	@FXML
	private Button quitter;

	@FXML
	void clickOnJouer(ActionEvent event) {

	}

	@FXML
	void clickOnSolution(ActionEvent event) throws IOException {
		AnchorPane anchorpane = null;
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(LanceurCluedo.class.getResource("../fenetre/ChoixJeu.fxml"));
		anchorpane = (AnchorPane) loader.load();
		borderpane = LanceurCluedo.getBorderPane();
		borderpane.setCenter(anchorpane);
		borderpane.setBorder(null);
		borderpane.setBottom(null);
		borderpane.setTop(null);

	}

	@FXML
	void clickOnQuitter(ActionEvent event) {
		Stage stage = (Stage) quitter.getScene().getWindow();
		stage.close();
	}

}