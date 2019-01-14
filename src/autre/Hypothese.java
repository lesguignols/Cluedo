package autre;

import application.LanceurCluedo;

public class Hypothese {

	private String suspect;
	private String arme;
	private String lieu;
	private String joueurDemandant;
	private String joueurPasOk;

	public Hypothese(String suspect, String arme, String lieu, String joueurDemandant, String joueurPasOk) {
		this.suspect = suspect;
		this.arme = arme;
		this.lieu = lieu;
		this.joueurDemandant = joueurDemandant;
		this.joueurPasOk = joueurPasOk;
		this.modifListeCarte();
	}

	public String getSuspect() {
		return suspect;
	}

	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}

	public String getArme() {
		return arme;
	}

	public void setArme(String arme) {
		this.arme = arme;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getJoueurDemandant() {
		return joueurDemandant;
	}

	public void setJoueurDemandant(String joueurDemandant) {
		this.joueurDemandant = joueurDemandant;
	}

	public String getJoueurPasOk() {
		return joueurPasOk;
	}

	public void setJoueurPasOk(String joueurPasOk) {
		this.joueurPasOk = joueurPasOk;
	}

	private void modifListeCarte() {
		Joueur joueurDemandant = new Joueur(), joueurPasOk = new Joueur();
		for (Joueur j: LanceurCluedo.getLj()) {
			if (j.getNom().equals(this.joueurDemandant)) {
				joueurDemandant = j;
			}
			if (j.getNom().equals(this.joueurPasOk)) {
				joueurPasOk = j;
			}
		}
		
		int nbCarteNonPossede = 0;
		for (Carte c: LanceurCluedo.getLc()) {
			if ((c.getNom().equals(this.suspect) ||
					c.getNom().equals(this.arme) ||
					c.getNom().equals(this.lieu)) &&
					c.getEtat(joueurPasOk.getNumJoueur()).equals("X")) {
				nbCarteNonPossede++;
			}
		}
		
		for (Carte c: LanceurCluedo.getLc()) {
			//on cherche les bonnes cartes
			if (c.getNom().equals(this.suspect) || c.getNom().equals(this.arme) || c.getNom().equals(this.lieu)) {
				//modifie la valeur de l'état de la carte pour le joueur demandant
				if (c.getEtat(joueurDemandant.getNumJoueur()).equals("O")) {
					c.setEtat(joueurDemandant.getNumJoueur(), "?");
				}
				else if (!c.getEtat(joueurDemandant.getNumJoueur()).equals("V") && 
							!c.getEtat(joueurDemandant.getNumJoueur()).equals("X")) {
					c.setEtat(joueurDemandant.getNumJoueur(), c.getEtat(joueurDemandant.getNumJoueur()) + "?");
				}
				
				//modifie la valeur de l'état de la carte pour le joueur pas ok
				if (nbCarteNonPossede == 2) {
					if (!c.getEtat(joueurPasOk.getNumJoueur()).equals("X")) {
						c.setEtat(joueurPasOk.getNumJoueur(), "V");
					}
				}
				else {
					if (c.getEtat(joueurPasOk.getNumJoueur()).equals("O")) {
						c.setEtat(joueurPasOk.getNumJoueur(), "!");
					}
					else if (!c.getEtat(joueurPasOk.getNumJoueur()).equals("V") && 
								!c.getEtat(joueurPasOk.getNumJoueur()).equals("X")) {
						c.setEtat(joueurPasOk.getNumJoueur(), c.getEtat(joueurPasOk.getNumJoueur()) + "!");
					}
				}
				
				//modifie la valeur de l'état de la carte des autres joueurs
				for (Joueur j: LanceurCluedo.getLj()) {
					//le joueur demandant est avant le joueur pas OK dans la liste
					if ((joueurDemandant.getNumJoueur() < joueurPasOk.getNumJoueur()) &&
							(j.getNumJoueur() > joueurDemandant.getNumJoueur()) &&
							(j.getNumJoueur() < joueurPasOk.getNumJoueur())) {
						c.setEtat(j.getNumJoueur(), "X");
					}
					
					//le joueur pas OK est avant le joueur demandant dans la liste
					if (joueurDemandant.getNumJoueur() > joueurPasOk.getNumJoueur() &&
							(j.getNumJoueur() > joueurDemandant.getNumJoueur() ||
							 j.getNumJoueur() < joueurPasOk.getNumJoueur())) {
						c.setEtat(j.getNumJoueur(), "X");
					}
				}
			}
		}
	}
}
