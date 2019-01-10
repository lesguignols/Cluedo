package controller;

import java.io.IOException;

import application.LanceurCluedo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ChoixJeuController {

    @FXML
    private CheckBox donjon;

    @FXML
    private CheckBox simpson;

    @FXML
    private CheckBox superCluedo;

    @FXML
    private CheckBox meereen;
    
    @FXML
    private Button suivant;
    
    @FXML
    private Button retour;

    @FXML
    void clickOnSuperCluedo(ActionEvent event) {
    	if (!meereen.isSelected() && !donjon.isSelected() && !simpson.isSelected() && superCluedo.isSelected()) {
			suivant.setDisable(false);
			LanceurCluedo.setType(1);
		}
		else {
			if (!superCluedo.isSelected()) {
				suivant.setDisable(true);
			}
		}
		donjon.setSelected(false);
		simpson.setSelected(false);
		meereen.setSelected(false);
    }

    @FXML
    void clickOnSimpson(ActionEvent event) {
    	if (!meereen.isSelected() && !donjon.isSelected() && simpson.isSelected() && !superCluedo.isSelected()) {
			suivant.setDisable(false);
			LanceurCluedo.setType(2);
		}
		else {
			if (!simpson.isSelected()) {
				suivant.setDisable(true);
			}
		}
		donjon.setSelected(false);
		meereen.setSelected(false);
		superCluedo.setSelected(false);
    }

    @FXML
    void clickOnMeereen(ActionEvent event) {
    	if (meereen.isSelected() && !donjon.isSelected() && !simpson.isSelected() && !superCluedo.isSelected()) {
			suivant.setDisable(false);
			LanceurCluedo.setType(4);
		}
		else {
			if (!meereen.isSelected()) {
				suivant.setDisable(true);
			}
		}
		donjon.setSelected(false);
		simpson.setSelected(false);
		superCluedo.setSelected(false);
    }

    @FXML
    void clickOnDonjon(ActionEvent event) {
    	if (!meereen.isSelected() && donjon.isSelected() && !simpson.isSelected() && !superCluedo.isSelected()) {
			suivant.setDisable(false);
			LanceurCluedo.setType(3);
		}
		else {
			if (!donjon.isSelected()) {
				suivant.setDisable(true);
			}
		}
		meereen.setSelected(false);
		simpson.setSelected(false);
		superCluedo.setSelected(false);
    }

    @FXML
    void clickOnSuivant(ActionEvent event) throws IOException {
    	AnchorPane anchorpane = null;
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(LanceurCluedo.class.getResource("../fenetre/CreationJoueur.fxml"));
		anchorpane = (AnchorPane) loader.load();
		LanceurCluedo.getBorderPane().setCenter(anchorpane);
		LanceurCluedo.getBorderPane().setBorder(null);
		LanceurCluedo.getBorderPane().setBottom(null);
		LanceurCluedo.getBorderPane().setTop(null);
    }

    @FXML
    void clickOnRetour(ActionEvent event) throws IOException {
		LanceurCluedo.setHyp(null);
		LanceurCluedo.setLs(null);
		LanceurCluedo.setLa(null);
		LanceurCluedo.setLl(null);
		LanceurCluedo.setLj(null);
		LanceurCluedo.setLc(null);
		LanceurCluedo.setLcj(null);
		LanceurCluedo.setNomJoueur(null);
		LanceurCluedo.setHypSuspect(null);
		LanceurCluedo.setHypArme(null);
		LanceurCluedo.setHypLieu(null);
		
    	BorderPane borderpane = null;
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(LanceurCluedo.class.getResource("../fenetre/MenuCluedo.fxml"));
		borderpane = (BorderPane) loader.load();
		LanceurCluedo.getBorderPane().setCenter(borderpane.getCenter());
		LanceurCluedo.getBorderPane().setBorder(null);
		LanceurCluedo.getBorderPane().setBottom(null);
		LanceurCluedo.getBorderPane().setTop(null);
    }

}
