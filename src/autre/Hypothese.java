package autre;

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
		//this.modifListeCarte();
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

	/*private void modifListeCarte() {
		int numJD = -1, numJPO = -2, iterateur = 0;
		for (Joueur j: LanceurCluedo.getLj()) {
			if (j.getNom().equals(this.joueurDemandant)) {
				numJD = iterateur;
			}
			if (j.getNom().equals(this.joueurPasOk)) {
				numJPO = iterateur;
			}
			iterateur++;
		}

		//Joueur qui demande est celui qui n'est pas OK => personnes n'a les cartes sauf lui ou le jeu.
		if (numJPO == LanceurCluedo.getLj().size()) {
			for (Joueur j: LanceurCluedo.getLj()) {
				if (!j.getNom().equals(joueurDemandant) && !j.getNom().equals("Le jeu")) {
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) ||
								c.getNom().equals(this.arme) ||
								c.getNom().equals(this.lieu)) 
								&&
								(!c.getEtat().equals("V"))) {
							c.setEtat("X");
						}
					}
				}
				else if (j.getNom().equals("Le jeu")) {
					int nbCarteNonPossede = 0;
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) && c.getEtat().equals("X")) ||
								(c.getNom().equals(this.arme) && c.getEtat().equals("X")) ||
								(c.getNom().equals(this.lieu) && c.getEtat().equals("X"))) {
							nbCarteNonPossede++;
						}
					}
					for (Carte c: j.getLc()) {
						if (nbCarteNonPossede == 2) {
							if ((c.getNom().equals(this.suspect) && !c.getEtat().equals("X")) || 
									(c.getNom().equals(this.arme) && !c.getEtat().equals("X")) ||
									(c.getNom().equals(this.lieu) && !c.getEtat().equals("X"))) {
								c.setEtat("V");
							}
						}
						else if (nbCarteNonPossede != 2){
							if ((c.getNom().equals(this.suspect) || 
									c.getNom().equals(this.arme) || 
									c.getNom().equals(this.lieu))
									&&
									(!c.getEtat().equals("V") && !c.getEtat().equals("X"))) {
								if (!c.getEtat().equals("O")) {
									c.setEtat(c.getEtat() + "!");
								}
								else if (c.getEtat().equals("O")) {
									c.setEtat("!");
								}
							}
						}
					}
				}
			}
		}


		//le joueur qui demande se trouve avant le joueur pas OK dans la liste => les joueurs entre les 2 
		//n'ont pas les cartes.
		else if (numJD < numJPO) {
			int i = 0;
			for (Joueur j: LanceurCluedo.getLj()) {
				//le joueur est entre celui qui a demandé et celui qui n'est pas OK
				if (i > numJD && i < numJPO && !j.getNom().equals("Le jeu")) {
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) ||
								c.getNom().equals(this.arme) ||
								c.getNom().equals(this.lieu)) 
								&&
								(!c.getEtat().equals("V"))) {
							c.setEtat("X");
						}
					}
				}
				//le joueur est celui qui a demandé
				else if (i == numJD) {

					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) || 
								c.getNom().equals(this.arme) || 
								c.getNom().equals(this.lieu))
								&&
								(!c.getEtat().equals("V") && !c.getEtat().equals("X"))) {
							if (!c.getEtat().equals("O")) {
								c.setEtat(c.getEtat() + "?");
							}
							else if (c.getEtat().equals("O")) {
								c.setEtat("?");
							}
						}
					}
				}
				//le joueur est celui qui n'est pas OK
				else if (i == numJPO) {
					int nbCarteNonPossede = 0;
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) && c.getEtat().equals("X")) ||
								(c.getNom().equals(this.arme) && c.getEtat().equals("X")) ||
								(c.getNom().equals(this.lieu) && c.getEtat().equals("X"))) {
							nbCarteNonPossede++;
						}
					}
					for (Carte c: j.getLc()) {
						if (nbCarteNonPossede == 2) {
							if ((c.getNom().equals(this.suspect) && !c.getEtat().equals("X")) || 
									(c.getNom().equals(this.arme) && !c.getEtat().equals("X")) ||
									(c.getNom().equals(this.lieu) && !c.getEtat().equals("X"))) {
								c.setEtat("V");
							}
						}
						else if (nbCarteNonPossede != 2){
							if ((c.getNom().equals(this.suspect) || 
									c.getNom().equals(this.arme) || 
									c.getNom().equals(this.lieu))
									&&
									(!c.getEtat().equals("V") && !c.getEtat().equals("X"))) {
								if (!c.getEtat().equals("O")) {
									c.setEtat(c.getEtat() + "!");
								}
								else if (c.getEtat().equals("O")) {
									c.setEtat("!");
								}
							}
						}
					}
				}
				else if (j.getNom().equals("Le jeu")) {
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) || 
								c.getNom().equals(this.arme) || 
								c.getNom().equals(this.lieu))
								&&
								(!c.getEtat().equals("V") && !c.getEtat().equals("X"))) {
							if (!c.getEtat().equals("O")) {
								c.setEtat(c.getEtat() + "?");
							}
							else if (c.getEtat().equals("O")) {
								c.setEtat("?");
							}
						}
					}
				}
				i++;
			}
		}


		//le joueur qui demande se trouve après le joueur pas OK dans la liste => les joueurs qui ne sont pas
		//entre les 2 dans la liste n'ont pas les cartes.
		else if (numJD > numJPO) {
			int i = 0;
			for (Joueur j: LanceurCluedo.getLj()) {
				//le joueur est entre celui qui a demandé et celui qui n'est pas OK
				if ((i > numJD || i < numJPO) && !j.getNom().equals("Le jeu")) {
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) ||
								c.getNom().equals(this.arme) ||
								c.getNom().equals(this.lieu)) 
								&&
								(!c.getEtat().equals("V"))) {
							c.setEtat("X");
						}
					}
				}
				//le joueur est celui qui n'est pas OK
				else if (i == numJPO) {
					int nbCarteNonPossede = 0;
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) && c.getEtat().equals("X")) ||
								(c.getNom().equals(this.arme) && c.getEtat().equals("X")) ||
								(c.getNom().equals(this.lieu) && c.getEtat().equals("X"))) {
							nbCarteNonPossede++;
						}
					}
					for (Carte c: j.getLc()) {
						if (nbCarteNonPossede == 2) {
							if ((c.getNom().equals(this.suspect) && !c.getEtat().equals("X")) || 
									(c.getNom().equals(this.arme) && !c.getEtat().equals("X")) ||
									(c.getNom().equals(this.lieu) && !c.getEtat().equals("X"))) {
								c.setEtat("V");
							}
						}
						else if (nbCarteNonPossede != 2){
							if ((c.getNom().equals(this.suspect) || 
									c.getNom().equals(this.arme) || 
									c.getNom().equals(this.lieu))
									&&
									(!c.getEtat().equals("V") && !c.getEtat().equals("X"))) {
								if (!c.getEtat().equals("O")) {
									c.setEtat(c.getEtat() + "!");
								}
								else if (c.getEtat().equals("O")) {
									c.setEtat("!");
								}
							}
						}
					}
				}
				//le joueur est celui qui a demandé
				else if (i == numJD) {
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) || 
								c.getNom().equals(this.arme) || 
								c.getNom().equals(this.lieu))
								&&
								(!c.getEtat().equals("V") && !c.getEtat().equals("X"))) {
							if (!c.getEtat().equals("O")) {
								c.setEtat(c.getEtat() + "?");
							}
							else if (c.getEtat().equals("O")) {
								c.setEtat("?");
							}
						}
					}
				}
				else if (j.getNom().equals("Le jeu")) {
					for (Carte c: j.getLc()) {
						if ((c.getNom().equals(this.suspect) || 
								c.getNom().equals(this.arme) || 
								c.getNom().equals(this.lieu))
								&&
								(!c.getEtat().equals("V") && !c.getEtat().equals("X"))) {
							if (!c.getEtat().equals("O")) {
								c.setEtat(c.getEtat() + "?");
							}
							else if (c.getEtat().equals("O")) {
								c.setEtat("?");
							}
						}
					}
				}
				i++;
			}
		}

		for (Joueur j: LanceurCluedo.getLj()) {
			for (Joueur j1: LanceurCluedo.getLj()) {
				if (!j.getNom().equals(j1.getNom())) {
					for (Carte c: j.getLc()) {
						for (Carte c1: j1.getLc()) {
							if (c.getNom().equals(c1.getNom()) && c1.getEtat().equals("V")) {
								c.setEtat("X");
							}
						}
					}
				}
			}
		}
	}*/
}
