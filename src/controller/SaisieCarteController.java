package controller;

import java.io.IOException;
import java.util.ArrayList;

import application.LanceurCluedo;
import autre.Carte;
import autre.Hypothese;
import autre.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

public class SaisieCarteController {

	@FXML
	private Button retour;

	@FXML
	private Button suivant;

	@FXML
	private ChoiceBox<String> carte1;

	@FXML
	private ChoiceBox<String> carte2;

	@FXML
	private ChoiceBox<String> carte3;

	@FXML
	private ChoiceBox<String> carte4;

	@FXML
	private ChoiceBox<String> carte5;

	@FXML
	private ChoiceBox<String> carte6;

	@FXML
	private ChoiceBox<String> carte7;

	@FXML
	private ChoiceBox<String> carte8;

	@FXML
	private ChoiceBox<String> carte9;

	@FXML
	void initialize() {
		ObservableList<String> listeCartes = FXCollections.observableArrayList();

		for (Carte c: LanceurCluedo.getLs()) {
			listeCartes.add(c.getNom());
		}

		for (Carte c: LanceurCluedo.getLa()) {
			listeCartes.add(c.getNom());
		}

		for (Carte c: LanceurCluedo.getLl()) {
			listeCartes.add(c.getNom());
		}
		
		for (Joueur joueur: LanceurCluedo.getLj()) {
			if (joueur.isVous()) {
				if (joueur.getNbCarte() >= 3) {
					carte1.setVisible(true);
					carte2.setVisible(true);
					carte3.setVisible(true);
				}
				if (joueur.getNbCarte() >= 4) {
					carte4.setVisible(true);
				}
				if (joueur.getNbCarte() >= 5) {
					carte5.setVisible(true);
				}
				if (joueur.getNbCarte() >= 6) {
					carte6.setVisible(true);
				}
				if (joueur.getNbCarte() >= 7) {
					carte7.setVisible(true);
				}
				if (joueur.getNbCarte() >= 9) {
					carte8.setVisible(true);
					carte9.setVisible(true);
				}
			}
		}

		carte1.setItems(listeCartes);
		carte2.setItems(listeCartes);
		carte3.setItems(listeCartes);
		carte4.setItems(listeCartes);
		carte5.setItems(listeCartes);
		carte6.setItems(listeCartes);
		carte7.setItems(listeCartes);
		carte8.setItems(listeCartes);
		carte9.setItems(listeCartes);

		carte1.setValue("");
		carte2.setValue("");
		carte3.setValue("");
		carte4.setValue("");
		carte5.setValue("");
		carte6.setValue("");
		carte7.setValue("");
		carte8.setValue("");
		carte9.setValue("");
	}

	@FXML
	void clickOnRetour(ActionEvent event) throws IOException {
		LanceurCluedo.setHyp(new ArrayList<Hypothese>());
		LanceurCluedo.setLs(new ArrayList<Carte>());
		LanceurCluedo.setLa(new ArrayList<Carte>());
		LanceurCluedo.setLl(new ArrayList<Carte>());
		LanceurCluedo.setLj(new ArrayList<Joueur>());
		LanceurCluedo.setLc(new ArrayList<Carte>());
		LanceurCluedo.setLcj(new ArrayList<String>());
		LanceurCluedo.setNomJoueur("");
		LanceurCluedo.setHypSuspect("");
		LanceurCluedo.setHypArme("");
		LanceurCluedo.setHypLieu("");
		
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
	void clickOnSuivant(ActionEvent event) throws IOException {
		boolean ok = false;
		int numJoueur = 1;
		for (Joueur joueur: LanceurCluedo.getLj()) {
			if (joueur.isVous()) {
				if (joueur.getNbCarte() == 3) {
					if (!carte1.getValue().equals("") &&
							!carte2.getValue().equals("") &&
							!carte3.getValue().equals("") &&
							!carte1.getValue().equals(carte2.getValue()) &&
							!carte1.getValue().equals(carte3.getValue()) &&
							!carte2.getValue().equals(carte3.getValue())) {
						ok = true;
						for (Carte c: LanceurCluedo.getLc()) {
							if (c.getNom().equals(carte1.getValue()) ||
									c.getNom().equals(carte2.getValue()) ||
									c.getNom().equals(carte3.getValue())) {
								c.setEtat(numJoueur, "V");
								LanceurCluedo.getLcj().add(c.getNom());
							}
							else if (!c.getNom().equals(carte1.getValue()) &&
									!c.getNom().equals(carte2.getValue()) &&
									!c.getNom().equals(carte3.getValue())) {
								c.setEtat(numJoueur, "X");
							}
						}
					}
				}

				else if (joueur.getNbCarte() == 4) {
					if (!carte1.getValue().equals("") &&
							!carte2.getValue().equals("") &&
							!carte3.getValue().equals("") &&
							!carte4.getValue().equals("") &&
							!carte1.getValue().equals(carte2.getValue()) &&
							!carte1.getValue().equals(carte3.getValue()) &&
							!carte1.getValue().equals(carte4.getValue()) &&

							!carte2.getValue().equals(carte3.getValue()) &&
							!carte2.getValue().equals(carte4.getValue()) &&

							!carte3.getValue().equals(carte4.getValue())) {
						ok = true;
						for (Carte c: LanceurCluedo.getLc()) {
							if (c.getNom().equals(carte1.getValue()) ||
									c.getNom().equals(carte2.getValue()) ||
									c.getNom().equals(carte3.getValue()) ||
									c.getNom().equals(carte4.getValue())) {
								c.setEtat(numJoueur, "V");
								LanceurCluedo.getLcj().add(c.getNom());
							}
							else if (!c.getNom().equals(carte1.getValue()) &&
									!c.getNom().equals(carte2.getValue()) &&
									!c.getNom().equals(carte3.getValue()) &&
									!c.getNom().equals(carte4.getValue())) {
								c.setEtat(numJoueur, "X");
							}
						}
					}
				}

				else if (joueur.getNbCarte() == 5) {
					if (!carte1.getValue().equals("") &&
							!carte2.getValue().equals("") &&
							!carte3.getValue().equals("") &&
							!carte4.getValue().equals("") &&
							!carte5.getValue().equals("") &&

							!carte1.getValue().equals(carte2.getValue()) &&
							!carte1.getValue().equals(carte3.getValue()) &&
							!carte1.getValue().equals(carte4.getValue()) &&
							!carte1.getValue().equals(carte5.getValue()) &&

							!carte2.getValue().equals(carte3.getValue()) &&
							!carte2.getValue().equals(carte4.getValue()) &&
							!carte2.getValue().equals(carte5.getValue()) &&

							!carte3.getValue().equals(carte4.getValue()) &&
							!carte3.getValue().equals(carte5.getValue()) &&

							!carte4.getValue().equals(carte5.getValue())) {
						ok = true;
						for (Carte c: LanceurCluedo.getLc()) {
							if (c.getNom().equals(carte1.getValue()) ||
									c.getNom().equals(carte2.getValue()) ||
									c.getNom().equals(carte3.getValue()) ||
									c.getNom().equals(carte4.getValue()) ||
									c.getNom().equals(carte5.getValue())) {
								c.setEtat(numJoueur, "V");
								LanceurCluedo.getLcj().add(c.getNom());
							}
							else if (!c.getNom().equals(carte1.getValue()) &&
									!c.getNom().equals(carte2.getValue()) &&
									!c.getNom().equals(carte3.getValue()) &&
									!c.getNom().equals(carte4.getValue()) &&
									!c.getNom().equals(carte5.getValue())) {
								c.setEtat(numJoueur, "X");
							}
						}
					}
				}

				else if (joueur.getNbCarte() == 6) {
					if (!carte1.getValue().equals("") &&
							!carte2.getValue().equals("") &&
							!carte3.getValue().equals("") &&
							!carte4.getValue().equals("") &&
							!carte5.getValue().equals("") &&
							!carte6.getValue().equals("") &&

							!carte1.getValue().equals(carte2.getValue()) &&
							!carte1.getValue().equals(carte3.getValue()) &&
							!carte1.getValue().equals(carte4.getValue()) &&
							!carte1.getValue().equals(carte5.getValue()) &&
							!carte1.getValue().equals(carte6.getValue()) &&

							!carte2.getValue().equals(carte3.getValue()) &&
							!carte2.getValue().equals(carte4.getValue()) &&
							!carte2.getValue().equals(carte5.getValue()) &&
							!carte2.getValue().equals(carte6.getValue()) &&

							!carte3.getValue().equals(carte4.getValue()) &&
							!carte3.getValue().equals(carte5.getValue()) &&
							!carte3.getValue().equals(carte6.getValue()) &&

							!carte4.getValue().equals(carte5.getValue()) &&
							!carte4.getValue().equals(carte6.getValue()) &&

							!carte5.getValue().equals(carte6.getValue())) {
						ok = true;
						for (Carte c: LanceurCluedo.getLc()) {
							if (c.getNom().equals(carte1.getValue()) ||
									c.getNom().equals(carte2.getValue()) ||
									c.getNom().equals(carte3.getValue()) ||
									c.getNom().equals(carte4.getValue()) ||
									c.getNom().equals(carte5.getValue()) ||
									c.getNom().equals(carte6.getValue())) {
								c.setEtat(numJoueur, "V");
								LanceurCluedo.getLcj().add(c.getNom());
							}
							else if (!c.getNom().equals(carte1.getValue()) &&
									!c.getNom().equals(carte2.getValue()) &&
									!c.getNom().equals(carte3.getValue()) &&
									!c.getNom().equals(carte4.getValue()) &&
									!c.getNom().equals(carte5.getValue()) &&
									!c.getNom().equals(carte6.getValue())) {
								c.setEtat(numJoueur, "X");
							}
						}
					}
				}

				else if (joueur.getNbCarte() == 7) {
					if (!carte1.getValue().equals("") &&
							!carte2.getValue().equals("") &&
							!carte3.getValue().equals("") &&
							!carte4.getValue().equals("") &&
							!carte5.getValue().equals("") &&
							!carte6.getValue().equals("") &&
							!carte7.getValue().equals("") &&

							!carte1.getValue().equals(carte2.getValue()) &&
							!carte1.getValue().equals(carte3.getValue()) &&
							!carte1.getValue().equals(carte4.getValue()) &&
							!carte1.getValue().equals(carte5.getValue()) &&
							!carte1.getValue().equals(carte6.getValue()) &&
							!carte1.getValue().equals(carte7.getValue()) &&

							!carte2.getValue().equals(carte3.getValue()) &&
							!carte2.getValue().equals(carte4.getValue()) &&
							!carte2.getValue().equals(carte5.getValue()) &&
							!carte2.getValue().equals(carte6.getValue()) &&
							!carte2.getValue().equals(carte7.getValue()) &&

							!carte3.getValue().equals(carte4.getValue()) &&
							!carte3.getValue().equals(carte5.getValue()) &&
							!carte3.getValue().equals(carte6.getValue()) &&
							!carte3.getValue().equals(carte7.getValue()) &&

							!carte4.getValue().equals(carte5.getValue()) &&
							!carte4.getValue().equals(carte6.getValue()) &&
							!carte4.getValue().equals(carte7.getValue()) &&

							!carte5.getValue().equals(carte6.getValue()) &&
							!carte5.getValue().equals(carte7.getValue()) &&

							!carte6.getValue().equals(carte7.getValue())) {
						ok = true;
						for (Carte c: LanceurCluedo.getLc()) {
							if (c.getNom().equals(carte1.getValue()) ||
									c.getNom().equals(carte2.getValue()) ||
									c.getNom().equals(carte3.getValue()) ||
									c.getNom().equals(carte4.getValue()) ||
									c.getNom().equals(carte5.getValue()) ||
									c.getNom().equals(carte6.getValue()) ||
									c.getNom().equals(carte7.getValue())) {
								c.setEtat(numJoueur, "V");
								LanceurCluedo.getLcj().add(c.getNom());
							}
							else if (!c.getNom().equals(carte1.getValue()) &&
									!c.getNom().equals(carte2.getValue()) &&
									!c.getNom().equals(carte3.getValue()) &&
									!c.getNom().equals(carte4.getValue()) &&
									!c.getNom().equals(carte5.getValue()) &&
									!c.getNom().equals(carte6.getValue()) &&
									!c.getNom().equals(carte7.getValue())) {
								c.setEtat(numJoueur, "X");
							}
						}
					}
				}

				else if (joueur.getNbCarte() == 9) {
					if (!carte1.getValue().equals("") &&
							!carte2.getValue().equals("") &&
							!carte3.getValue().equals("") &&
							!carte4.getValue().equals("") &&
							!carte5.getValue().equals("") &&
							!carte6.getValue().equals("") &&
							!carte7.getValue().equals("") &&
							!carte8.getValue().equals("") &&
							!carte9.getValue().equals("") &&

							!carte1.getValue().equals(carte2.getValue()) &&
							!carte1.getValue().equals(carte3.getValue()) &&
							!carte1.getValue().equals(carte4.getValue()) &&
							!carte1.getValue().equals(carte5.getValue()) &&
							!carte1.getValue().equals(carte6.getValue()) &&
							!carte1.getValue().equals(carte7.getValue()) &&
							!carte1.getValue().equals(carte8.getValue()) &&
							!carte1.getValue().equals(carte9.getValue()) &&

							!carte2.getValue().equals(carte3.getValue()) &&
							!carte2.getValue().equals(carte4.getValue()) &&
							!carte2.getValue().equals(carte5.getValue()) &&
							!carte2.getValue().equals(carte6.getValue()) &&
							!carte2.getValue().equals(carte7.getValue()) &&
							!carte2.getValue().equals(carte8.getValue()) &&
							!carte2.getValue().equals(carte9.getValue()) &&

							!carte3.getValue().equals(carte4.getValue()) &&
							!carte3.getValue().equals(carte5.getValue()) &&
							!carte3.getValue().equals(carte6.getValue()) &&
							!carte3.getValue().equals(carte7.getValue()) &&
							!carte3.getValue().equals(carte8.getValue()) &&
							!carte3.getValue().equals(carte9.getValue()) &&

							!carte4.getValue().equals(carte5.getValue()) &&
							!carte4.getValue().equals(carte6.getValue()) &&
							!carte4.getValue().equals(carte7.getValue()) &&
							!carte4.getValue().equals(carte8.getValue()) &&
							!carte4.getValue().equals(carte9.getValue()) &&

							!carte5.getValue().equals(carte6.getValue()) &&
							!carte5.getValue().equals(carte7.getValue()) &&
							!carte5.getValue().equals(carte8.getValue()) &&
							!carte5.getValue().equals(carte9.getValue()) &&

							!carte6.getValue().equals(carte7.getValue()) &&
							!carte6.getValue().equals(carte8.getValue()) &&
							!carte6.getValue().equals(carte9.getValue()) &&

							!carte7.getValue().equals(carte8.getValue()) &&
							!carte7.getValue().equals(carte9.getValue()) &&

							!carte8.getValue().equals(carte9.getValue())) {
						ok = true;
						for (Carte c: LanceurCluedo.getLc()) {
							if (c.getNom().equals(carte1.getValue()) ||
									c.getNom().equals(carte2.getValue()) ||
									c.getNom().equals(carte3.getValue()) ||
									c.getNom().equals(carte4.getValue()) ||
									c.getNom().equals(carte5.getValue()) ||
									c.getNom().equals(carte6.getValue()) ||
									c.getNom().equals(carte7.getValue()) ||
									c.getNom().equals(carte8.getValue()) ||
									c.getNom().equals(carte9.getValue())) {
								c.setEtat(numJoueur, "V");
								LanceurCluedo.getLcj().add(c.getNom());
							}
							else if (!c.getNom().equals(carte1.getValue()) &&
									!c.getNom().equals(carte2.getValue()) &&
									!c.getNom().equals(carte3.getValue()) &&
									!c.getNom().equals(carte4.getValue()) &&
									!c.getNom().equals(carte5.getValue()) &&
									!c.getNom().equals(carte6.getValue()) &&
									!c.getNom().equals(carte7.getValue()) &&
									!c.getNom().equals(carte8.getValue()) &&
									!c.getNom().equals(carte9.getValue())) {
								c.setEtat(numJoueur, "X");
							}
						}
					}
				}

				if (ok) {
					AnchorPane anchorpane = null;
					FXMLLoader loader = new FXMLLoader();

					loader.setLocation(LanceurCluedo.class.getResource("../fenetre/Solution.fxml"));
					anchorpane = (AnchorPane) loader.load();
					LanceurCluedo.getBorderPane().setCenter(anchorpane);
					LanceurCluedo.getBorderPane().setBorder(null);
					LanceurCluedo.getBorderPane().setBottom(null);
					LanceurCluedo.getBorderPane().setTop(null);
				}
			}
		}
	}

}
