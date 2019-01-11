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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreationJoueurController {
    
    

    @FXML
    private TextField saisieNom1;

    @FXML
    private TextField saisieNom2;

    @FXML
    private TextField saisieNom3;

    @FXML
    private TextField saisieNom4;

    @FXML
    private TextField saisieNom5;

    @FXML
    private TextField saisieNom6;

    @FXML
    private Button retour;

    @FXML
    private Button commencer;

    @FXML
    private CheckBox vous1;

    @FXML
    private CheckBox vous2;

    @FXML
    private CheckBox vous3;

    @FXML
    private CheckBox vous4;

    @FXML
    private CheckBox vous5;

    @FXML
    private CheckBox vous6;
    
    @FXML
    private CheckBox j3;
    
    @FXML
    private CheckBox j4;
    
    @FXML
    private CheckBox j5;
    
    @FXML
    private CheckBox j6;
    
    @FXML
    private ComboBox<String> nbCarte1;
    
    @FXML
    private ComboBox<String> nbCarte2;
    
    @FXML
    private ComboBox<String> nbCarte3;
    
    @FXML
    private ComboBox<String> nbCarte4;
    
    @FXML
    private ComboBox<String> nbCarte5;
    
    @FXML
    private ComboBox<String> nbCarte6;
    
    @FXML
	void initialize() {
    	ObservableList<String> listeValeurs = FXCollections.observableArrayList();
    	listeValeurs.addAll("3", "4", "5", "6", "7", "9");
    	
    	nbCarte1.setItems(listeValeurs);
    	nbCarte2.setItems(listeValeurs);
    	nbCarte3.setItems(listeValeurs);
    	nbCarte4.setItems(listeValeurs);
    	nbCarte5.setItems(listeValeurs);
    	nbCarte6.setItems(listeValeurs);
    	
    	nbCarte1.setValue("3");
    	nbCarte2.setValue("3");
    	nbCarte3.setValue("3");
    	nbCarte4.setValue("3");
    	nbCarte5.setValue("3");
    	nbCarte6.setValue("3");
    }

    @FXML
    void clickOnVous1(ActionEvent event) {
    	vous2.setSelected(false);
    	vous3.setSelected(false);
    	vous4.setSelected(false);
    	vous5.setSelected(false);
    	vous6.setSelected(false);
    	
		commencer.setDisable(false);
    	
    	if (!vous1.isSelected()) {
    		commencer.setDisable(true);
    	}
    }

    @FXML
    void clickOnVous2(ActionEvent event) {
    	vous1.setSelected(false);
    	vous3.setSelected(false);
    	vous4.setSelected(false);
    	vous5.setSelected(false);
    	vous6.setSelected(false);
    	
		commencer.setDisable(false);
    	
    	if (!vous2.isSelected()) {
    		commencer.setDisable(true);
    	}
    }

    @FXML
    void clickOnVous3(ActionEvent event) {
    	vous1.setSelected(false);
    	vous2.setSelected(false);
    	vous4.setSelected(false);
    	vous5.setSelected(false);
    	vous6.setSelected(false);
    	
		commencer.setDisable(false);
    	
    	if (!vous3.isSelected()) {
    		commencer.setDisable(true);
    	}
    }

    @FXML
    void clickOnVous4(ActionEvent event) {
    	vous1.setSelected(false);
    	vous2.setSelected(false);
    	vous3.setSelected(false);
    	vous5.setSelected(false);
    	vous6.setSelected(false);
    	
		commencer.setDisable(false);
    	
    	if (!vous4.isSelected()) {
    		commencer.setDisable(true);
    	}
    }

    @FXML
    void clickOnVous5(ActionEvent event) {
    	vous1.setSelected(false);
    	vous2.setSelected(false);
    	vous3.setSelected(false);
    	vous4.setSelected(false);
    	vous6.setSelected(false);
    	
		commencer.setDisable(false);
    	
    	if (!vous5.isSelected()) {
    		commencer.setDisable(true);
    	}
    }

    @FXML
    void clickOnVous6(ActionEvent event) {
    	vous1.setSelected(false);
    	vous2.setSelected(false);
    	vous3.setSelected(false);
    	vous4.setSelected(false);
    	vous5.setSelected(false);
    	
		commencer.setDisable(false);
    	
    	if (!vous6.isSelected()) {
    		commencer.setDisable(true);
    	}
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
		
		loader.setLocation(LanceurCluedo.class.getResource("../fenetre/ChoixJeu.fxml"));
		anchorpane = (AnchorPane) loader.load();
		LanceurCluedo.getBorderPane().setCenter(anchorpane);
		LanceurCluedo.getBorderPane().setBorder(null);
		LanceurCluedo.getBorderPane().setBottom(null);
		LanceurCluedo.getBorderPane().setTop(null);
    }

    @FXML
    void clickOnCommencer(ActionEvent event) throws IOException {
    	boolean ok = false;
    	if (j3.isSelected()) {
    		if (!saisieNom1.getText().equals("") && !saisieNom2.getText().equals("") &&
    				!saisieNom2.getText().equals("")
    				&&
    				!saisieNom1.getText().equals(saisieNom2.getText()) &&
    				!saisieNom1.getText().equals(saisieNom3.getText()) &&
    				!saisieNom2.getText().equals(saisieNom3.getText())) {
    			ok = true;
    			LanceurCluedo.getLj().add(new Joueur(saisieNom1.getText(),"Red",1,vous1.isSelected(),Integer.parseInt(nbCarte1.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom2.getText(),"Red",2,vous2.isSelected(),Integer.parseInt(nbCarte2.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom3.getText(),"Red",3,vous3.isSelected(),Integer.parseInt(nbCarte3.getValue())));
    		}
    	}
    	else if (j4.isSelected()) {
    		if (!saisieNom1.getText().equals("") && !saisieNom2.getText().equals("") &&
    				!saisieNom3.getText().equals("") && !saisieNom4.getText().equals("")
    				&&
    				!saisieNom1.getText().equals(saisieNom2.getText()) &&
    				!saisieNom1.getText().equals(saisieNom3.getText()) &&
    				!saisieNom1.getText().equals(saisieNom4.getText()) &&
    				!saisieNom2.getText().equals(saisieNom3.getText()) &&
    				!saisieNom2.getText().equals(saisieNom4.getText()) &&
    				!saisieNom3.getText().equals(saisieNom4.getText())) {
    			ok = true;
    			LanceurCluedo.getLj().add(new Joueur(saisieNom1.getText(),"Red",1,vous1.isSelected(),Integer.parseInt(nbCarte1.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom2.getText(),"Red",2,vous2.isSelected(),Integer.parseInt(nbCarte2.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom3.getText(),"Red",3,vous3.isSelected(),Integer.parseInt(nbCarte3.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom4.getText(),"Red",4,vous4.isSelected(),Integer.parseInt(nbCarte4.getValue())));
    		}
    	}
    	else if (j5.isSelected()) {
    		if (!saisieNom1.getText().equals("") && !saisieNom2.getText().equals("") &&
    				!saisieNom3.getText().equals("") && !saisieNom4.getText().equals("") &&
    				!saisieNom5.getText().equals("")
    				&&
    				!saisieNom1.getText().equals(saisieNom2.getText()) &&
    				!saisieNom1.getText().equals(saisieNom3.getText()) &&
    				!saisieNom1.getText().equals(saisieNom4.getText()) &&
    				!saisieNom1.getText().equals(saisieNom5.getText()) &&
    				!saisieNom2.getText().equals(saisieNom3.getText()) &&
    				!saisieNom2.getText().equals(saisieNom4.getText()) &&
    				!saisieNom2.getText().equals(saisieNom5.getText()) &&
    				!saisieNom3.getText().equals(saisieNom4.getText()) &&
    				!saisieNom3.getText().equals(saisieNom5.getText()) &&
    				!saisieNom4.getText().equals(saisieNom5.getText())) {
    			ok = true;
    			LanceurCluedo.getLj().add(new Joueur(saisieNom1.getText(),"Red",1,vous1.isSelected(),Integer.parseInt(nbCarte1.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom2.getText(),"Red",2,vous2.isSelected(),Integer.parseInt(nbCarte2.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom3.getText(),"Red",3,vous3.isSelected(),Integer.parseInt(nbCarte3.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom4.getText(),"Red",4,vous4.isSelected(),Integer.parseInt(nbCarte4.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom5.getText(),"Red",5,vous5.isSelected(),Integer.parseInt(nbCarte5.getValue())));
    		}
    	}
    	else if (j6.isSelected()) {
    		if (!saisieNom1.getText().equals("") && !saisieNom2.getText().equals("") &&
    				!saisieNom3.getText().equals("") && !saisieNom4.getText().equals("") &&
    				!saisieNom5.getText().equals("") && !saisieNom6.getText().equals("")
    				&&
    				!saisieNom1.getText().equals(saisieNom2.getText()) &&
    				!saisieNom1.getText().equals(saisieNom3.getText()) &&
    				!saisieNom1.getText().equals(saisieNom4.getText()) &&
    				!saisieNom1.getText().equals(saisieNom5.getText()) &&
    				!saisieNom1.getText().equals(saisieNom6.getText()) &&
    				!saisieNom2.getText().equals(saisieNom3.getText()) &&
    				!saisieNom2.getText().equals(saisieNom4.getText()) &&
    				!saisieNom2.getText().equals(saisieNom5.getText()) &&
    				!saisieNom2.getText().equals(saisieNom6.getText()) &&
    				!saisieNom3.getText().equals(saisieNom4.getText()) &&
    				!saisieNom3.getText().equals(saisieNom5.getText()) &&
    				!saisieNom3.getText().equals(saisieNom6.getText()) &&
    				!saisieNom4.getText().equals(saisieNom5.getText()) &&
    				!saisieNom4.getText().equals(saisieNom6.getText()) &&
    				!saisieNom5.getText().equals(saisieNom6.getText()) 
    				) {
    			ok = true;
    			LanceurCluedo.getLj().add(new Joueur(saisieNom1.getText(),"Red",1,vous1.isSelected(),Integer.parseInt(nbCarte1.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom2.getText(),"Red",2,vous2.isSelected(),Integer.parseInt(nbCarte2.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom3.getText(),"Red",3,vous3.isSelected(),Integer.parseInt(nbCarte3.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom4.getText(),"Red",4,vous4.isSelected(),Integer.parseInt(nbCarte4.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom5.getText(),"Red",5,vous5.isSelected(),Integer.parseInt(nbCarte5.getValue())));
    			LanceurCluedo.getLj().add(new Joueur(saisieNom6.getText(),"Red",6,vous6.isSelected(),Integer.parseInt(nbCarte6.getValue())));
    		}
    	}
    	
    	if (ok) {
			LanceurCluedo.getLj().add(new Joueur("Le jeu", "White", 7, false,3));
    		LanceurCluedo.setLs(LanceurCluedo.getType());
    		LanceurCluedo.setLa(LanceurCluedo.getType());
    		LanceurCluedo.setLl(LanceurCluedo.getType());
    		AnchorPane anchorpane = null;
    		FXMLLoader loader = new FXMLLoader();
    		
    		loader.setLocation(LanceurCluedo.class.getResource("../fenetre/SaisieCarte.fxml"));
    		anchorpane = (AnchorPane) loader.load();
    		LanceurCluedo.getBorderPane().setCenter(anchorpane);
    		LanceurCluedo.getBorderPane().setBorder(null);
    		LanceurCluedo.getBorderPane().setBottom(null);
    		LanceurCluedo.getBorderPane().setTop(null);
    	}
    }
    
    @FXML
    void clickOnJ3(ActionEvent event) {
    	j4.setSelected(false);
    	j5.setSelected(false);
    	j6.setSelected(false);
    	
    	nbCarte4.setVisible(false);
    	saisieNom4.setVisible(false);
    	vous4.setVisible(false);

    	nbCarte5.setVisible(false);
    	saisieNom5.setVisible(false);
    	vous5.setVisible(false);

    	nbCarte6.setVisible(false);
    	saisieNom6.setVisible(false);
    	vous6.setVisible(false);
    	
    	if (!j3.isSelected()) {
    		j3.setSelected(true);
    	}
    }

    @FXML
    void clickOnJ4(ActionEvent event) {
    	j3.setSelected(false);
    	j5.setSelected(false);
    	j6.setSelected(false);
    	
    	nbCarte4.setVisible(true);
    	saisieNom4.setVisible(true);
    	vous4.setVisible(true);

    	nbCarte5.setVisible(false);
    	saisieNom5.setVisible(false);
    	vous5.setVisible(false);

    	nbCarte6.setVisible(false);
    	saisieNom6.setVisible(false);
    	vous6.setVisible(false);
    	
    	if (!j4.isSelected()) {
    		j3.setSelected(true);
        	
    		nbCarte4.setVisible(false);
        	saisieNom4.setVisible(false);
        	vous4.setVisible(false);
    	}
    }

    @FXML
    void clickOnJ5(ActionEvent event) {
    	j3.setSelected(false);
    	j4.setSelected(false);
    	j6.setSelected(false);
    	
    	nbCarte4.setVisible(true);
    	saisieNom4.setVisible(true);
    	vous4.setVisible(true);

    	nbCarte5.setVisible(true);
    	saisieNom5.setVisible(true);
    	vous5.setVisible(true);

    	nbCarte6.setVisible(false);
    	saisieNom6.setVisible(false);
    	vous6.setVisible(false);
    	
    	if (!j5.isSelected()) {
    		j3.setSelected(true);
        	
    		nbCarte4.setVisible(false);
        	saisieNom4.setVisible(false);
        	vous4.setVisible(false);

        	nbCarte5.setVisible(false);
        	saisieNom5.setVisible(false);
        	vous5.setVisible(false);
    	}
    }

    @FXML
    void clickOnJ6(ActionEvent event) {
    	j3.setSelected(false);
    	j4.setSelected(false);
    	j5.setSelected(false);
    	
    	nbCarte4.setVisible(true);
    	saisieNom4.setVisible(true);
    	vous4.setVisible(true);

    	nbCarte5.setVisible(true);
    	saisieNom5.setVisible(true);
    	vous5.setVisible(true);

    	nbCarte6.setVisible(true);
    	saisieNom6.setVisible(true);
    	vous6.setVisible(true);
    	
    	if (!j6.isSelected()) {
    		j3.setSelected(true);
        	
    		nbCarte4.setVisible(false);
        	saisieNom4.setVisible(false);
        	vous4.setVisible(false);

        	nbCarte5.setVisible(false);
        	saisieNom5.setVisible(false);
        	vous5.setVisible(false);

        	nbCarte6.setVisible(false);
        	saisieNom6.setVisible(false);
        	vous6.setVisible(false);
    	}
    }

}
