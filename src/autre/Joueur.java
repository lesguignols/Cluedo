package autre;

import application.LanceurCluedo;

public class Joueur {

	private String nom;
	private String couleur;
	private boolean vous;
	private int nbCarte;
	private int numJoueur;
	
	public Joueur() {
		this.nom = "";
		this.couleur = "";
		this.vous = false;
		this.nbCarte = 0;
		this.numJoueur = 0;
	}

	public Joueur(String nom, String couleur, int numJoueur, boolean vous, int nbCarte) {
		this.nom = nom;
		this.couleur = couleur;
		this.vous = vous;
		this.nbCarte = nbCarte;
		this.numJoueur = numJoueur;
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

	public int getNumJoueur() {
		return numJoueur;
	}

	public void maj() {
		for (Hypothese h: LanceurCluedo.getHyp()) {
			for (Joueur j: LanceurCluedo.getLj()) {
				if (j.getNom().equals(h.getJoueurPasOk())) {
					int nbCarteNonPossede = 0;
					for (Carte c: LanceurCluedo.getLc()) {
						if ((c.getNom().equals(h.getSuspect()) && c.getEtat(j.getNumJoueur()).equals("X")) ||
								(c.getNom().equals(h.getArme()) && c.getEtat(j.getNumJoueur()).equals("X")) ||
								(c.getNom().equals(h.getLieu()) && c.getEtat(j.getNumJoueur()).equals("X"))) {
							nbCarteNonPossede++;
						}
					}
					if (nbCarteNonPossede == 2) {
						for (Carte c: LanceurCluedo.getLc()) {
							if ((c.getNom().equals(h.getSuspect()) && !c.getEtat(j.getNumJoueur()).equals("X")) ||
									(c.getNom().equals(h.getArme()) && !c.getEtat(j.getNumJoueur()).equals("X")) ||
									(c.getNom().equals(h.getLieu()) && !c.getEtat(j.getNumJoueur()).equals("X"))) {
								c.setEtat(j.getNumJoueur(),"V");
							}
						}
					}
				}
			}
		}

		for (Joueur j: LanceurCluedo.getLj()) {
			int nbCartePossede = 0;
			for (Carte c: LanceurCluedo.getLc()) {
				if (c.getEtat(j.getNumJoueur()).equals("V")) {
					nbCartePossede++;
				}
			}
			if (nbCartePossede == j.getNbCarte()) {
				for (Carte c: LanceurCluedo.getLc()) {
					if (!c.getEtat(j.getNumJoueur()).equals("V") && 
							!c.getNom().equals("Suspects") &&
							!c.getNom().equals("Armes") &&
							!c.getNom().equals("Lieux")) {
						c.setEtat(j.getNumJoueur(),"X");
					}
				}
			}
		}

		for (Carte c: LanceurCluedo.getLc()) {
			int nbJoueurNePossedePas = 0;
			for (Joueur j: LanceurCluedo.getLj()) {
				if (c.getEtat(j.getNumJoueur()).equals("X") && !j.getNom().equals("Le jeu")) {
					nbJoueurNePossedePas++;
				}
			}
			if (nbJoueurNePossedePas == (LanceurCluedo.getLj().size() - 1)) {
				for (Joueur j: LanceurCluedo.getLj()) {
					if (!c.getEtat(j.getNumJoueur()).equals("X")) {
						c.setEtat(j.getNumJoueur(), "V");
					}
				}
			}
		}
	}
}
