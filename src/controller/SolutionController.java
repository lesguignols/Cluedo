package controller;

import application.LanceurCluedo;
import autre.Carte;
import autre.Hypothese;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private Button quitter;
    
    @FXML
    void initialize() {
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
			sj5.setVisible(false);
			sj6.setVisible(false);

			aj5.setVisible(false);
			aj6.setVisible(false);

			lj5.setVisible(false);
			lj6.setVisible(false);
		}
		else if ((LanceurCluedo.getLj().size() - 1) == 5) {
			sj6.setVisible(false);

			aj6.setVisible(false);

			lj6.setVisible(false);
		}
    }

    @FXML
    void clickOnSaisir(ActionEvent event) {

    }

    @FXML
    void clickOnQuitter(ActionEvent event) {

    }

}
