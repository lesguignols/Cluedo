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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SolutionController {

	@FXML
	private TableView<Carte> listeSuspect;

	@FXML
	private TableColumn<Carte, String> suspect;

	@FXML
	private TableColumn<Carte, String> sj1;

	@FXML
	private TableColumn<Carte, String> sj2;

	@FXML
	private TableColumn<Carte, String> sj3;

	@FXML
	private TableColumn<Carte, String> sj4;

	@FXML
	private TableColumn<Carte, String> sj5;

	@FXML
	private TableColumn<Carte, String> sj6;

	@FXML
	private TableView<Carte> listeArme;

	@FXML
	private TableColumn<Carte, String> arme;

	@FXML
	private TableColumn<Carte, String> aj1;

	@FXML
	private TableColumn<Carte, String> aj2;

	@FXML
	private TableColumn<Carte, String> aj3;

	@FXML
	private TableColumn<Carte, String> aj4;

	@FXML
	private TableColumn<Carte, String> aj5;

	@FXML
	private TableColumn<Carte, String> aj6;

	@FXML
	private TableView<Carte> listeLieu;

	@FXML
	private TableColumn<Carte, String> lieu;

	@FXML
	private TableColumn<Carte, String> lj1;

	@FXML
	private TableColumn<Carte, String> lj2;

	@FXML
	private TableColumn<Carte, String> lj3;

	@FXML
	private TableColumn<Carte, String> lj4;

	@FXML
	private TableColumn<Carte, String> lj5;

	@FXML
	private TableColumn<Carte, String> lj6;

	@FXML
	private TableView<Hypothese> listHyp;

	@FXML
	private TableColumn<Hypothese, String> suspectHyp;

	@FXML
	private TableColumn<Hypothese, String> armeHyp;

	@FXML
	private TableColumn<Hypothese, String> lieuHyp;

	@FXML
	private TableColumn<Hypothese, String> demandantHyp;

	@FXML
	private TableColumn<Hypothese, String> pasBonHyp;

	@FXML
	private ComboBox<String> choixSuspect;

	@FXML
	private ComboBox<String> choixArme;

	@FXML
	private ComboBox<String> choixLieu;

	@FXML
	private ComboBox<String> choixDemandant;

	@FXML
	private ComboBox<String> choixPasBon;

	@FXML
	private Button saisir;

	@FXML
	private Button quitter;
	
    @FXML
    private MenuItem maj;

	@FXML
	void initialize() {
		ObservableList<String> listeJoueursDemandant = FXCollections.observableArrayList();
		ObservableList<String> listeJoueursPasBon = FXCollections.observableArrayList();
		ObservableList<String> listeSuspects = FXCollections.observableArrayList();
		ObservableList<String> listeArmes = FXCollections.observableArrayList();
		ObservableList<String> listeLieux = FXCollections.observableArrayList();

		//liste des joueurs
		for (Joueur j: LanceurCluedo.getLj()) {
			if (!j.getNom().equals("Le jeu")) {
				listeJoueursDemandant.add(j.getNom());
			}
			listeJoueursPasBon.add(j.getNom());
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

		choixSuspect.setItems(listeSuspects);
		choixArme.setItems(listeArmes);
		choixLieu.setItems(listeLieux);
		choixDemandant.setItems(listeJoueursDemandant);
		choixPasBon.setItems(listeJoueursPasBon);

		choixSuspect.setValue("");
		choixArme.setValue("");
		choixLieu.setValue("");
		choixDemandant.setValue("");
		choixPasBon.setValue("");

		suspectHyp.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("suspect"));
		armeHyp.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("arme"));
		lieuHyp.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("lieu"));
		demandantHyp.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("joueurDemandant"));
		pasBonHyp.setCellValueFactory(new PropertyValueFactory<Hypothese,String>("joueurPasOk"));


		ObservableList<Carte> listeCartesSuspects = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLs()) {
			listeCartesSuspects.add(c);
		}
		suspect.setCellValueFactory(new PropertyValueFactory<Carte,String>("nom"));
		sj1.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ1"));
		sj2.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ2"));
		sj3.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ3"));
		sj4.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ4"));
		sj5.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ5"));
		sj6.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ6"));
		listeSuspect.setItems(listeCartesSuspects);


		ObservableList<Carte> listeCartesArmes = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLa()) {
			listeCartesArmes.add(c);
		}
		arme.setCellValueFactory(new PropertyValueFactory<Carte,String>("nom"));
		aj1.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ1"));
		aj2.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ2"));
		aj3.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ3"));
		aj4.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ4"));
		aj5.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ5"));
		aj6.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ6"));
		listeArme.setItems(listeCartesArmes);


		ObservableList<Carte> listeCartesLieux = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLl()) {
			listeCartesLieux.add(c);
		}
		lieu.setCellValueFactory(new PropertyValueFactory<Carte,String>("nom"));
		lj1.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ1"));
		lj2.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ2"));
		lj3.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ3"));
		lj4.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ4"));
		lj5.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ5"));
		lj6.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ6"));
		listeLieu.setItems(listeCartesLieux);

		if ((LanceurCluedo.getLj().size() - 1) == 3) {
			sj1.setText(LanceurCluedo.getLj().get(0).getNom());
			sj2.setText(LanceurCluedo.getLj().get(1).getNom());
			sj3.setText(LanceurCluedo.getLj().get(2).getNom());

			aj1.setText(LanceurCluedo.getLj().get(0).getNom());
			aj2.setText(LanceurCluedo.getLj().get(1).getNom());
			aj3.setText(LanceurCluedo.getLj().get(2).getNom());

			lj1.setText(LanceurCluedo.getLj().get(0).getNom());
			lj2.setText(LanceurCluedo.getLj().get(1).getNom());
			lj3.setText(LanceurCluedo.getLj().get(2).getNom());

			sj4.setVisible(false);
			sj5.setVisible(false);
			sj6.setVisible(false);

			aj4.setVisible(false);
			aj5.setVisible(false);
			aj6.setVisible(false);

			lj4.setVisible(false);
			lj5.setVisible(false);
			lj6.setVisible(false);
		}
		else if ((LanceurCluedo.getLj().size() - 1) == 4) {
			sj1.setText(LanceurCluedo.getLj().get(0).getNom());
			sj2.setText(LanceurCluedo.getLj().get(1).getNom());
			sj3.setText(LanceurCluedo.getLj().get(2).getNom());
			sj4.setText(LanceurCluedo.getLj().get(3).getNom());

			aj1.setText(LanceurCluedo.getLj().get(0).getNom());
			aj2.setText(LanceurCluedo.getLj().get(1).getNom());
			aj3.setText(LanceurCluedo.getLj().get(2).getNom());
			aj4.setText(LanceurCluedo.getLj().get(3).getNom());

			lj1.setText(LanceurCluedo.getLj().get(0).getNom());
			lj2.setText(LanceurCluedo.getLj().get(1).getNom());
			lj3.setText(LanceurCluedo.getLj().get(2).getNom());
			lj4.setText(LanceurCluedo.getLj().get(3).getNom());

			sj5.setVisible(false);
			sj6.setVisible(false);

			aj5.setVisible(false);
			aj6.setVisible(false);

			lj5.setVisible(false);
			lj6.setVisible(false);
		}
		else if ((LanceurCluedo.getLj().size() - 1) == 5) {
			sj1.setText(LanceurCluedo.getLj().get(0).getNom());
			sj2.setText(LanceurCluedo.getLj().get(1).getNom());
			sj3.setText(LanceurCluedo.getLj().get(2).getNom());
			sj4.setText(LanceurCluedo.getLj().get(3).getNom());
			sj5.setText(LanceurCluedo.getLj().get(4).getNom());

			aj1.setText(LanceurCluedo.getLj().get(0).getNom());
			aj2.setText(LanceurCluedo.getLj().get(1).getNom());
			aj3.setText(LanceurCluedo.getLj().get(2).getNom());
			aj4.setText(LanceurCluedo.getLj().get(3).getNom());
			aj5.setText(LanceurCluedo.getLj().get(4).getNom());

			lj1.setText(LanceurCluedo.getLj().get(0).getNom());
			lj2.setText(LanceurCluedo.getLj().get(1).getNom());
			lj3.setText(LanceurCluedo.getLj().get(2).getNom());
			lj4.setText(LanceurCluedo.getLj().get(3).getNom());
			lj5.setText(LanceurCluedo.getLj().get(4).getNom());

			sj6.setVisible(false);

			aj6.setVisible(false);

			lj6.setVisible(false);
		}
		else if ((LanceurCluedo.getLj().size() - 1) == 5) {
			sj1.setText(LanceurCluedo.getLj().get(0).getNom());
			sj2.setText(LanceurCluedo.getLj().get(1).getNom());
			sj3.setText(LanceurCluedo.getLj().get(2).getNom());
			sj4.setText(LanceurCluedo.getLj().get(3).getNom());
			sj5.setText(LanceurCluedo.getLj().get(4).getNom());
			sj6.setText(LanceurCluedo.getLj().get(5).getNom());

			aj1.setText(LanceurCluedo.getLj().get(0).getNom());
			aj2.setText(LanceurCluedo.getLj().get(1).getNom());
			aj3.setText(LanceurCluedo.getLj().get(2).getNom());
			aj4.setText(LanceurCluedo.getLj().get(3).getNom());
			aj5.setText(LanceurCluedo.getLj().get(4).getNom());
			aj6.setText(LanceurCluedo.getLj().get(5).getNom());

			lj1.setText(LanceurCluedo.getLj().get(0).getNom());
			lj2.setText(LanceurCluedo.getLj().get(1).getNom());
			lj3.setText(LanceurCluedo.getLj().get(2).getNom());
			lj4.setText(LanceurCluedo.getLj().get(3).getNom());
			lj5.setText(LanceurCluedo.getLj().get(4).getNom());
			lj6.setText(LanceurCluedo.getLj().get(5).getNom());
		}
	}

	@FXML
	void clickOnSaisir(ActionEvent event) throws IOException {
		if (!choixDemandant.getValue().equals("") && !choixSuspect.getValue().equals("") && 
				!choixArme.getValue().equals("") && !choixLieu.getValue().equals("") &&
				!choixPasBon.getValue().equals("") && 
				!choixPasBon.getValue().equals(choixDemandant.getValue())) {

			Hypothese hyp = new Hypothese(choixSuspect.getValue(),
					choixArme.getValue(),
					choixLieu.getValue(),
					choixDemandant.getValue(),
					choixPasBon.getValue());
			LanceurCluedo.getHyp().add(hyp);

			for (Joueur j: LanceurCluedo.getLj()) {
				if (choixDemandant.getValue().equals(j.getNom()) && j.isVous() &&
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
					primaryStage.showAndWait();
				}
			}

			ObservableList<Hypothese> listeH = FXCollections.observableArrayList();
			for (Hypothese h: LanceurCluedo.getHyp()) {
				if (!listeH.contains(h)) {
					listeH.add(h);
				}
			}

			listHyp.setItems(listeH);
			listeSuspect.setItems(null);
			listeArme.setItems(null);
			listeLieu.setItems(null);

			ObservableList<Carte> listeCartesSuspects = FXCollections.observableArrayList();
			for (Carte c: LanceurCluedo.getLs()) {
				listeCartesSuspects.add(c);
			}
			listeSuspect.setItems(listeCartesSuspects);

			ObservableList<Carte> listeCartesArmes = FXCollections.observableArrayList();
			for (Carte c: LanceurCluedo.getLa()) {
				listeCartesArmes.add(c);
			}
			listeArme.setItems(listeCartesArmes);

			ObservableList<Carte> listeCartesLieux = FXCollections.observableArrayList();
			for (Carte c: LanceurCluedo.getLl()) {
				listeCartesLieux.add(c);
			}
			listeLieu.setItems(listeCartesLieux);

			choixDemandant.setValue("");
			choixPasBon.setValue("");
			choixSuspect.setValue("");
			choixArme.setValue("");
			choixLieu.setValue("");

			for (Carte c: listeCartesLieux) {
				System.out.println(c.string());
			}
		}
	}

	@FXML
	void clickOnQuitter(ActionEvent event) throws IOException {
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

		BorderPane borderpane = null;
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(LanceurCluedo.class.getResource("../fenetre/MenuCluedo.fxml"));
		borderpane = (BorderPane) loader.load();
		LanceurCluedo.getBorderPane().setCenter(borderpane.getCenter());
		LanceurCluedo.getBorderPane().setBorder(null);
		LanceurCluedo.getBorderPane().setBottom(null);
		LanceurCluedo.getBorderPane().setTop(null);
	}
	
	@FXML
	void maj(ActionEvent event) {
		listeSuspect.setItems(null);
		/*ObservableList<Carte> listeCartesSuspects = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLs()) {
			listeCartesSuspects.add(c);
		}
		listeSuspect.setItems(listeCartesSuspects);*/

		ObservableList<Carte> listeCartesArmes = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLa()) {
			listeCartesArmes.add(c);
		}
		listeArme.setItems(listeCartesArmes);

		ObservableList<Carte> listeCartesLieux = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLl()) {
			listeCartesLieux.add(c);
		}
		listeLieu.setItems(listeCartesLieux);
	}
}
