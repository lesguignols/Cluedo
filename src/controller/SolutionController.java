package controller;

import java.io.IOException;

import application.LanceurCluedo;
import autre.Carte;
import autre.Hypothese;
import autre.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SolutionController {

	@FXML
	private AnchorPane pageSaisie;

	@FXML
	private Button saisie;

	@FXML
	private Button ajout;

	@FXML
	private Button maj;
	
	@FXML
	private Button quitter;

	@FXML
	private TableColumn<Hypothese, String> arme;

	@FXML
	private ComboBox<String> choixLieu;

	@FXML
	private ComboBox<String> choixJoueur;

	@FXML
	private ComboBox<String> choixPasBon;

	@FXML
	private ComboBox<String> choixSuspect;

	@FXML
	private ComboBox<String> choixArme;

	@FXML
	private TableColumn<Hypothese, String> suspect;

	@FXML
	private TableColumn<Hypothese, String> lieu;

	@FXML
	private TableColumn<Hypothese, String> joueurDemandant;

	@FXML
	private TableColumn<Hypothese, String> pasBon;

	@FXML
	private TableView<Hypothese> listeHyp;

	@FXML
	private TableView<Joueur> tabJoueur;

	@FXML
	private TableColumn<Joueur, String> joueur;

	@FXML
	private TableView<Carte> tabCarte;

	@FXML
	private TableColumn<Carte, String> carte;

	@FXML
	private TableColumn<Carte, String> possede;

	private ObservableList<Joueur> lj = FXCollections.observableArrayList();

	@FXML
	void initialize() {

		ObservableList<String> listeJoueursDemandant = FXCollections.observableArrayList();
		ObservableList<String> listeJoueursPasBon = FXCollections.observableArrayList();
		ObservableList<String> listeSuspects = FXCollections.observableArrayList();
		ObservableList<String> listeArmes = FXCollections.observableArrayList();
		ObservableList<String> listeLieux = FXCollections.observableArrayList();
		ObservableList<Carte> listeCartes = FXCollections.observableArrayList();



		for (Joueur j: LanceurCluedo.getLj()) {
			if (!j.getNom().equals("Le jeu")) {
				listeJoueursDemandant.add(j.getNom());
			}
			listeJoueursPasBon.add(j.getNom());
			lj.add(j);
		}

		//ajout suspects
		for (Carte c: LanceurCluedo.getLs()) {
			listeSuspects.add(c.getNom());
		}

		//ajout armes
		for (Carte c: LanceurCluedo.getLa()) {
			listeArmes.add(c.getNom());
		}

		//ajout lieux
		for (Carte c: LanceurCluedo.getLl()) {
			listeLieux.add(c.getNom());
		}

		choixJoueur.setItems(listeJoueursDemandant);
		choixPasBon.setItems(listeJoueursPasBon);
		choixSuspect.setItems(listeSuspects);
		choixArme.setItems(listeArmes);
		choixLieu.setItems(listeLieux);

		choixJoueur.setValue("");
		choixPasBon.setValue("");
		choixSuspect.setValue("");
		choixArme.setValue("");
		choixLieu.setValue("");

		suspect.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("suspect"));
		arme.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("arme"));
		lieu.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("lieu"));
		joueurDemandant.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("joueurDemandant"));
		pasBon.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("joueurPasOk"));


		joueur.setCellValueFactory(new PropertyValueFactory<Joueur,String>("nom"));
		tabJoueur.setItems(lj);

		carte.setCellValueFactory(new PropertyValueFactory<Carte,String>("nom"));
		possede.setCellValueFactory(new PropertyValueFactory<Carte,String>("etat"));
		for (Carte c: LanceurCluedo.getLc()) {
			listeCartes.add(c);
		}

		tabJoueur.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> afficheListeCarte(newValue));
		
		suspect.setText("Ta gueule");
	}

	private void afficheListeCarte(Joueur joueur) {
		if (joueur != null) {

			ObservableList<Carte> listeCartes = FXCollections.observableArrayList();
			tabCarte.setItems(null);
			for (Carte c: joueur.getLc()) {
				listeCartes.add(c);
			}
			tabCarte.setItems(listeCartes);
		}
	}

	@FXML
	void clickOnSaisir(ActionEvent event) throws IOException {
		if (!choixJoueur.getValue().equals("") && !choixSuspect.getValue().equals("") && 
				!choixArme.getValue().equals("") && !choixLieu.getValue().equals("") &&
				!choixPasBon.getValue().equals("") && 
				!choixPasBon.getValue().equals(choixJoueur.getValue())) {

			Hypothese hyp = new Hypothese(choixSuspect.getValue(),
					choixArme.getValue(),
					choixLieu.getValue(),
					choixJoueur.getValue(),
					choixPasBon.getValue());
			LanceurCluedo.getHyp().add(hyp);

			for (Joueur j: lj) {
				if (choixJoueur.getValue().equals(j.getNom()) && j.isVous() &&
						!choixPasBon.getValue().equals(j.getNom()) &&
						!choixPasBon.getValue().equals("Le jeu")) {
					Stage primaryStage = new Stage();
					BorderPane borderpane = null;
					FXMLLoader loader = new FXMLLoader();

					LanceurCluedo.setNomJoueur(choixPasBon.getValue());
					LanceurCluedo.setHypSuspect(choixSuspect.getValue());
					LanceurCluedo.setHypArme(choixArme.getValue());
					LanceurCluedo.setHypLieu(choixLieu.getValue());

					loader.setLocation(LanceurCluedo.class.getResource("../fenetre/CarteRevele.fxml"));
					borderpane = (BorderPane) loader.load();
					Scene scene = new Scene(borderpane);
					primaryStage.setScene(scene);
					primaryStage.initModality(Modality.WINDOW_MODAL);
					primaryStage.initOwner(LanceurCluedo.getPrimaryStage());
					primaryStage.show();
				}
			}
			
			for (Joueur j: LanceurCluedo.getLj()) {
				j.maj();
			}

			ObservableList<Hypothese> listeH = FXCollections.observableArrayList();
			for (Hypothese h: LanceurCluedo.getHyp()) {
				if (!listeH.contains(h)) {
					listeH.add(h);
				}
			}

			listeHyp.setItems(listeH);

			choixJoueur.setValue("");
			choixPasBon.setValue("");
			choixSuspect.setValue("");
			choixArme.setValue("");
			choixLieu.setValue("");
		}
	}

	@FXML
	void clickOnAjout(ActionEvent event) throws IOException {
		if ((tabJoueur.getSelectionModel().getSelectedItem() != null) &&
				!tabJoueur.getSelectionModel().getSelectedItem().getNom().equals("Le jeu")) {
			Stage primaryStage = new Stage();
			BorderPane borderpane = null;
			FXMLLoader loader = new FXMLLoader();

			LanceurCluedo.setNomJoueur(tabJoueur.getSelectionModel().getSelectedItem().getNom());

			loader.setLocation(LanceurCluedo.class.getResource("../fenetre/AjoutCarte.fxml"));
			borderpane = (BorderPane) loader.load();
			Scene scene = new Scene(borderpane);
			primaryStage.setScene(scene);
			primaryStage.initModality(Modality.WINDOW_MODAL);
			primaryStage.initOwner(LanceurCluedo.getPrimaryStage());
			primaryStage.show();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(ajout.getScene().getWindow());
			alert.setTitle("Pas de joueur sélectionné!");
			alert.setHeaderText("Veuillez sélectionner un joueur autre que \"Le jeu\"!");

			alert.showAndWait();
		}
	}
	
	@FXML
	void clickOnQuitter(ActionEvent event) throws IOException {
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
