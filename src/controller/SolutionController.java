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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SolutionController {

	@FXML
	private TableView<Carte> listeCarte;

	@FXML
	private TableColumn<Carte, String> nomCarte;

	@FXML
	private TableColumn<Carte, String> ej1;

	@FXML
	private TableColumn<Carte, String> ej2;

	@FXML
	private TableColumn<Carte, String> ej3;

	@FXML
	private TableColumn<Carte, String> ej4;

	@FXML
	private TableColumn<Carte, String> ej5;

	@FXML
	private TableColumn<Carte, String> ej6;

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
    private RadioButton boutonTout;

    @FXML
    private RadioButton boutonSuspect;

    @FXML
    private RadioButton boutonArme;

    @FXML
    private RadioButton boutonLieu;

	@FXML
	private Button saisir;

	@FXML
	private Button quitter;

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
			if (!c.getNom().equals("Suspects")) {
				listeSuspects.add(c.getNom());
			}
		}

		//ajout armes
		for (Carte c: LanceurCluedo.getLa()) {
			if (!c.getNom().equals("Armes")) {
				listeArmes.add(c.getNom());
			}
		}

		//ajout lieux
		for (Carte c: LanceurCluedo.getLl()) {
			if (!c.getNom().equals("Lieux")) {
				listeLieux.add(c.getNom());
			}
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


		ObservableList<Carte> listeCartes = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLc()) {
			listeCartes.add(c);
		}
		
		nomCarte.setCellValueFactory(new PropertyValueFactory<Carte,String>("nom"));
		ej1.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ1"));
		ej2.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ2"));
		ej3.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ3"));
		ej4.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ4"));
		ej5.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ5"));
		ej6.setCellValueFactory(new PropertyValueFactory<Carte,String>("etatJ6"));
		listeCarte.setItems(listeCartes);

		if ((LanceurCluedo.getLj().size() - 1) == 3) {
			ej1.setText(LanceurCluedo.getLj().get(0).getNom());
			ej2.setText(LanceurCluedo.getLj().get(1).getNom());
			ej3.setText(LanceurCluedo.getLj().get(2).getNom());

			ej4.setVisible(false);
			ej5.setVisible(false);
			ej6.setVisible(false);
		}
		else if ((LanceurCluedo.getLj().size() - 1) == 4) {
			ej1.setText(LanceurCluedo.getLj().get(0).getNom());
			ej2.setText(LanceurCluedo.getLj().get(1).getNom());
			ej3.setText(LanceurCluedo.getLj().get(2).getNom());
			ej4.setText(LanceurCluedo.getLj().get(3).getNom());

			ej5.setVisible(false);
			ej6.setVisible(false);
		}
		else if ((LanceurCluedo.getLj().size() - 1) == 5) {
			ej1.setText(LanceurCluedo.getLj().get(0).getNom());
			ej2.setText(LanceurCluedo.getLj().get(1).getNom());
			ej3.setText(LanceurCluedo.getLj().get(2).getNom());
			ej4.setText(LanceurCluedo.getLj().get(3).getNom());
			ej5.setText(LanceurCluedo.getLj().get(4).getNom());

			ej6.setVisible(false);

		}
		else if ((LanceurCluedo.getLj().size() - 1) == 6) {
			ej1.setText(LanceurCluedo.getLj().get(0).getNom());
			ej2.setText(LanceurCluedo.getLj().get(1).getNom());
			ej3.setText(LanceurCluedo.getLj().get(2).getNom());
			ej4.setText(LanceurCluedo.getLj().get(3).getNom());
			ej5.setText(LanceurCluedo.getLj().get(4).getNom());
			ej6.setText(LanceurCluedo.getLj().get(5).getNom());
		}
	}

	@FXML
	void clickOnSaisir(ActionEvent event) throws IOException {
		if (!choixDemandant.getValue().equals("") && !choixSuspect.getValue().equals("") && 
				!choixArme.getValue().equals("") && !choixLieu.getValue().equals("") &&
				!choixPasBon.getValue().equals("") && 
				!choixPasBon.getValue().equals(choixDemandant.getValue())) {
			int nbCarte = 0;
			if (LanceurCluedo.getLcj().contains(choixSuspect.getValue())){
				nbCarte++;
			}
			if (LanceurCluedo.getLcj().contains(choixArme.getValue())){
				nbCarte++;
			}
			if (LanceurCluedo.getLcj().contains(choixLieu.getValue())){
				nbCarte++;
			}

			if ((nbCarte == 3) && choixDemandant.getValue().equals(LanceurCluedo.getNomVous()) &&
					!choixPasBon.getValue().equals("Le jeu")) {
				
			}
			else {
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
				
				for (int i = 0; i < LanceurCluedo.getLj().size(); i++) {
					for (Joueur j: LanceurCluedo.getLj()) {
						j.maj();
					}
				}

				listHyp.setItems(listeH);
				
				for (Carte c: LanceurCluedo.getLs()) {
					listeCarte.getItems().remove(c);
				}
				for (Carte c: LanceurCluedo.getLa()) {
					listeCarte.getItems().remove(c);
				}
				for (Carte c: LanceurCluedo.getLl()) {
					listeCarte.getItems().remove(c);
				}
				ObservableList<Carte> listeCartes = FXCollections.observableArrayList();
				for (Carte c: LanceurCluedo.getLc()) {
					listeCartes.add(c);
				}
				listeCarte.setItems(listeCartes);
				
				boutonTout.setSelected(true);
				boutonSuspect.setSelected(false);
				boutonArme.setSelected(false);
				boutonLieu.setSelected(false);

				choixDemandant.setValue("");
				choixPasBon.setValue("");
				choixSuspect.setValue("");
				choixArme.setValue("");
				choixLieu.setValue("");
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
    void clickOnTout(ActionEvent event) {
		boutonSuspect.setSelected(false);
    	boutonArme.setSelected(false);
    	boutonLieu.setSelected(false);

		ObservableList<Carte> listeCartes = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLc()) {
			listeCartes.add(c);
		}

		listeCarte.setItems(listeCartes);
		
    	if (!boutonTout.isSelected()) {
    		boutonTout.setSelected(true);
    	}
    }
	
    @FXML
    void clickOnSuspect(ActionEvent event) {
    	boutonTout.setSelected(false);
    	boutonArme.setSelected(false);
    	boutonLieu.setSelected(false);

		ObservableList<Carte> listeCartes = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLs()) {
			listeCartes.add(c);
		}

		listeCarte.setItems(listeCartes);
		
    	if (!boutonSuspect.isSelected()) {
    		boutonSuspect.setSelected(true);
    	}
    }

    @FXML
    void clickOnArme(ActionEvent event) {
    	boutonTout.setSelected(false);
    	boutonSuspect.setSelected(false);
    	boutonLieu.setSelected(false);
    	
		ObservableList<Carte> listeCartes = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLa()) {
			listeCartes.add(c);
		}

		listeCarte.setItems(listeCartes);
    	
    	if (!boutonArme.isSelected()) {
    		boutonArme.setSelected(true);
    	}
    }

    @FXML
    void clickOnLieu(ActionEvent event) {
    	boutonTout.setSelected(false);
    	boutonArme.setSelected(false);
    	boutonSuspect.setSelected(false);

		ObservableList<Carte> listeCartes = FXCollections.observableArrayList();
		for (Carte c: LanceurCluedo.getLl()) {
			listeCartes.add(c);
		}

		listeCarte.setItems(listeCartes);
    	
    	if (!boutonLieu.isSelected()) {
    		boutonLieu.setSelected(true);
    	}
    }
}
