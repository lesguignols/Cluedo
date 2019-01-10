package autre;

public class Joueur {

	private String nom;
	private String couleur;
	private boolean vous;
	private int nbCarte;
	private int numJoueur;

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

	/*public void maj() {
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
	}*/
}
