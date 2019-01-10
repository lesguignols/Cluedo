package autre;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import application.LanceurCluedo;

public class Joueur {

	private String nom;
	private String couleur;
	private List<Carte> lc = new ArrayList<Carte>();
	private boolean vous;
	private int nbCarte;

	public Joueur(String nom, String couleur, boolean vous, int nbCarte) {
		this.nom = nom;
		this.couleur = couleur;
		this.vous = vous;
		this.nbCarte = nbCarte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public List<Carte> getLc() {
		return lc;
	}

	public void setLc(int type) {

		String lien = "";
		String etat = "O";
		String genre = "";
		//type == 1 => SuperCluedo
		if (type == 1) {
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					lien = "src\\autre\\liste\\Cluedo\\guilty.txt";
					genre = "Suspect";
				}
				else if (i == 1) {
					lien = "src\\autre\\liste\\Cluedo\\weapon.txt";
					genre = "Arme";
				}
				else if (i == 2) {
					lien = "src\\autre\\liste\\Cluedo\\places.txt";
					genre = "Lieu";
				}

				try{
					InputStream flux = new FileInputStream(lien); 
					InputStreamReader lecture = new InputStreamReader(flux);
					BufferedReader buff = new BufferedReader(lecture);
					String ligne;
					while ((ligne=buff.readLine())!=null){
						Carte c = new Carte(ligne,genre,etat);
						this.lc.add(c);
					}
					buff.close(); 
				}		
				catch (Exception e){
					System.out.println(e.toString());
				}

			}
		}
	}

	public void setLc(List<Carte> lc) {
		this.lc = lc;
	}

	public boolean isVous() {
		return vous;
	}

	public void setVous(boolean vous) {
		this.vous = vous;
	}

	public int getNbCarte() {
		return nbCarte;
	}

	public void setNbCarte(int nbCarte) {
		this.nbCarte = nbCarte;
	}

	public void maj() {
		for (Hypothese h: LanceurCluedo.getHyp()) {
			for (Joueur j: LanceurCluedo.getLj()) {
				if (j.getNom().equals(h.getJoueurPasOk())) {
					int nbCarteNonPossede = 0;
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(h.getSuspect()) && c.getEtat().equals("X")) ||
								(c.getNom().equals(h.getArme()) && c.getEtat().equals("X")) ||
								(c.getNom().equals(h.getLieu()) && c.getEtat().equals("X"))) {
							nbCarteNonPossede++;
						}
					}
					if (nbCarteNonPossede == 2) {
						for (Carte c: j.getLc()) {
							if ((c.getNom().equals(h.getSuspect()) && !c.getEtat().equals("X")) ||
									(c.getNom().equals(h.getArme()) && !c.getEtat().equals("X")) ||
									(c.getNom().equals(h.getLieu()) && !c.getEtat().equals("X"))) {
								c.setEtat("V");
							}
						}
					}
					for (Carte c: j.getLc()) {
						if (c.getEtat().equals("V")) {
							for (Joueur j1: LanceurCluedo.getLj()) {
								for (Carte c1: j1.getLc()) {
									if (c1.getNom().equals(c.getNom()) &&
											!j.getNom().equals(j1.getNom())) {
										c1.setEtat("X");
									}
								}
							}
						}
					}
				}
			}
		}

		for (Joueur j: LanceurCluedo.getLj()) {
			int nbCartePossede = 0;
			for (Carte c: j.getLc()) {
				if (c.getEtat().equals("V")) {
					nbCartePossede++;
				}
			}
			if (nbCartePossede == j.getNbCarte()) {
				for (Carte c: j.getLc()) {
					if (!c.getEtat().equals("V")) {
						c.setEtat("X");
					}
				}
			}
		}

		for (Joueur j: LanceurCluedo.getLj()) {
			for (Carte c: j.getLc()) {
				if (!c.getEtat().equals("X") && !c.getEtat().equals("X")) {
					int nbJoueurNePossedePas = 0;
					for (Joueur j1: LanceurCluedo.getLj()) {
						if (!j1.getNom().equals(j.getNom())) {
							for (Carte c1: j1.getLc()) {
								if (c.getNom().equals(c1.getNom()) && c1.getEtat().equals("X")) {
									nbJoueurNePossedePas++;
								}
							}
						}
					}
					if (nbJoueurNePossedePas == (LanceurCluedo.getLj().size() - 1)) {
						c.setEtat("V");
						for (Carte c2: j.getLc()) {
							if (c2.getGenre().equals(c.getGenre()) && !c2.getNom().equals(c.getNom())) {
								c2.setEtat("X");
							}
						}
					}
				}
			}
		}
	}
}
