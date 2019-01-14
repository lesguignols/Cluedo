package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import autre.Carte;
import autre.Hypothese;
import autre.Joueur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class LanceurCluedo extends Application {

	private static Stage primaryStage;
	private static BorderPane rootLayout;
	private static int type;
	private static ArrayList<Joueur> lj = new ArrayList<Joueur>();
	private static ArrayList<Carte> ls = new ArrayList<Carte>();
	private static ArrayList<Carte> la = new ArrayList<Carte>();
	private static ArrayList<Carte> ll = new ArrayList<Carte>();
	private static ArrayList<Carte> lc = new ArrayList<Carte>();
	private static ArrayList<String> lcj = new ArrayList<String>();
	private static ArrayList<Hypothese> hyp = new ArrayList<Hypothese>();
	private static String nomJoueur = "";
	private static String nomVous = "";
	private static String hypSuspect = "";
	private static String hypArme = "";
	private static String hypLieu = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		LanceurCluedo.primaryStage = primaryStage;
		LanceurCluedo.primaryStage.setTitle("Menu Cluedo");
		LanceurCluedo.primaryStage.getIcons().add(new Image("image/cluedo.jpg"));
		initRootLayout();
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LanceurCluedo.class.getResource("../fenetre/MenuCluedo.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BorderPane getBorderPane() {
		return LanceurCluedo.rootLayout;
	}

	public static void setBorderPane(BorderPane borderpane) {
		LanceurCluedo.rootLayout = borderpane;
	}

	public static ArrayList<Carte> getLs() {
		return ls;
	}

	public static void setLs(int t) {
		String lien = "";
		String genre = "Suspect";
		//type == 1 => SuperCluedo
		if (t == 1) {
			lien = "src\\autre\\liste\\Cluedo\\guilty.txt";

			try{
				InputStream flux = new FileInputStream(lien); 
				InputStreamReader lecture = new InputStreamReader(flux);
				BufferedReader buff = new BufferedReader(lecture);
				String ligne;
				Carte carte = new Carte("Suspects",genre);
				carte.setEtat(0, "-");
				ls.add(carte);
				lc.add(carte);
				while ((ligne=buff.readLine())!=null){
					Carte c = new Carte(ligne,genre);
					ls.add(c);
					lc.add(c);
				}
				buff.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
		}

	}

	public static ArrayList<Carte> getLa() {
		return la;
	}

	public static void setLa(int t) {
		String lien = "";
		String genre = "Arme";
		//type == 1 => SuperCluedo
		if (t == 1) {
			lien = "src\\autre\\liste\\Cluedo\\weapon.txt";

			try{
				InputStream flux = new FileInputStream(lien); 
				InputStreamReader lecture = new InputStreamReader(flux);
				BufferedReader buff = new BufferedReader(lecture);
				String ligne;
				Carte carte = new Carte("Armes",genre);
				carte.setEtat(0, "-");
				la.add(carte);
				lc.add(carte);
				while ((ligne=buff.readLine())!=null){
					Carte c = new Carte(ligne,genre);
					la.add(c);
					lc.add(c);
				}
				buff.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
		}
	}

	public static ArrayList<Carte> getLl() {
		return ll;
	}

	public static void setLl(int t) {
		String lien = "";
		String genre = "Lieu";
		//type == 1 => SuperCluedo
		if (t == 1) {
			lien = "src\\autre\\liste\\Cluedo\\places.txt";

			try{
				InputStream flux = new FileInputStream(lien); 
				InputStreamReader lecture = new InputStreamReader(flux);
				BufferedReader buff = new BufferedReader(lecture);
				String ligne;
				Carte carte = new Carte("Lieux",genre);
				carte.setEtat(0, "-");
				ll.add(carte);
				lc.add(carte);
				while ((ligne=buff.readLine())!=null){
					Carte c = new Carte(ligne,genre);
					ll.add(c);
					lc.add(c);
				}
				buff.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
		}
	}

	public static ArrayList<Hypothese> getHyp() {
		return hyp;
	}

	public static void setHyp(ArrayList<Hypothese> hyp) {
		LanceurCluedo.hyp = hyp;
	}

	public static ArrayList<Carte> getLc() {
		return lc;
	}

	public static void setLc(ArrayList<Carte> lc) {
		LanceurCluedo.lc = lc;
	}

	public static ArrayList<String> getLcj() {
		return lcj;
	}

	public static void setLcj(ArrayList<String> lcj) {
		LanceurCluedo.lcj = lcj;
	}
	
	public static int getType() {
		return type;
	}

	public static void setType(int type) {
		LanceurCluedo.type = type;
	}

	public static ArrayList<Joueur> getLj() {
		return lj;
	}

	public static void setLj(ArrayList<Joueur> lj) {
		LanceurCluedo.lj = lj;
	}

	public static String getNomJoueur() {
		return nomJoueur;
	}

	public static void setNomJoueur(String nomJoueur) {
		LanceurCluedo.nomJoueur = nomJoueur;
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static String getHypSuspect() {
		return hypSuspect;
	}

	public static void setHypSuspect(String hypSuspect) {
		LanceurCluedo.hypSuspect = hypSuspect;
	}

	public static String getHypArme() {
		return hypArme;
	}

	public static void setHypArme(String hypArme) {
		LanceurCluedo.hypArme = hypArme;
	}

	public static String getHypLieu() {
		return hypLieu;
	}

	public static void setHypLieu(String hypLieu) {
		LanceurCluedo.hypLieu = hypLieu;
	}

	public static void setLs(ArrayList<Carte> ls) {
		LanceurCluedo.ls = ls;
	}

	public static void setLa(ArrayList<Carte> la) {
		LanceurCluedo.la = la;
	}

	public static void setLl(ArrayList<Carte> ll) {
		LanceurCluedo.ll = ll;
	}

	public static String getNomVous() {
		return nomVous;
	}

	public static void setNomVous(String nomVous) {
		LanceurCluedo.nomVous = nomVous;
	}


}
