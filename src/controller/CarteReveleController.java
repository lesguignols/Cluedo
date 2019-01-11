package controller;

import application.LanceurCluedo;
import autre.Carte;
import autre.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CarteReveleController {

	@FXML
	private ChoiceBox<String> carte;

	@FXML
	private Button ok;
	
	@FXML
    private Label nom;

	@FXML
	void initialize() {
		ObservableList<String> listeCartes = FXCollections.observableArrayList();
		
		nom.setText(LanceurCluedo.getNomJoueur() + " vous a révélé quelle carte?");

		listeCartes.add(LanceurCluedo.getHypSuspect());
		listeCartes.add(LanceurCluedo.getHypArme());
		listeCartes.add(LanceurCluedo.getHypLieu());

		carte.setItems(listeCartes);
		carte.setValue(listeCartes.get(0));
	}

	@FXML
	void clickOnOk(ActionEvent event) {
		boolean peutFermer = false;
		if (carte.getValue().equals(LanceurCluedo.getHypSuspect()) ||
				carte.getValue().equals(LanceurCluedo.getHypArme()) ||
				carte.getValue().equals(LanceurCluedo.getHypLieu())) {
			if (!LanceurCluedo.getLcj().contains(carte.getValue())) {
				for (Joueur j: LanceurCluedo.getLj()) {
					for (Carte c: LanceurCluedo.getLc()) {
						if (c.getNom().equals(carte.getValue())) {
							if (j.getNom().equals(LanceurCluedo.getNomJoueur())) {
								c.setEtat(j.getNumJoueur(), "V");
								peutFermer = true;
							}
						}
					}
				}
				
				if (peutFermer) {
					Stage stage = (Stage) ok.getScene().getWindow();
			    	stage.close();
				}
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
	            alert.initOwner(ok.getScene().getWindow());
	            alert.setTitle("Erreur dans la carte donnée!");
	            alert.setHeaderText("Impossible, cette carte est à vous!");
	            //alert.setContentText(errorMessage);

	            alert.showAndWait();
			}
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(ok.getScene().getWindow());
            alert.setTitle("Erreur dans la carte donnée!");
            alert.setHeaderText("Veuillez sélectionner la bonne carte!");
            //alert.setContentText(errorMessage);

            alert.showAndWait();
		}
	}

}
