package autre;

public class Carte {

	private String nom;
	private String etatJ1;
	private String etatJ2;
	private String etatJ3;
	private String etatJ4;
	private String etatJ5;
	private String etatJ6;
	private String etatJeu;
	private String genre;
	
	public Carte(String nom, String genre) {
		this.nom = nom;
		this.genre = genre;
		this.etatJ1 = "O";
		this.etatJ2 = "O";
		this.etatJ3 = "O";
		this.etatJ4 = "O";
		this.etatJ5 = "O";
		this.etatJ6 = "O";
		this.etatJeu = "O";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtatJ1() {
		return etatJ1;
	}

	public String getEtatJ2() {
		return etatJ2;
	}

	public String getEtatJ3() {
		return etatJ3;
	}

	public String getEtatJ4() {
		return etatJ4;
	}

	public String getEtatJ5() {
		return etatJ5;
	}

	public String getEtatJ6() {
		return etatJ6;
	}

	public String getEtatJeu() {
		return etatJeu;
	}
	
	public void setEtat(int numJoueur, String etat) {
		if (etat.equals("V")) {
			if (numJoueur == 1) {
				this.etatJ1 = "V";
				this.etatJ2 = "X";
				this.etatJ3 = "X";
				this.etatJ4 = "X";
				this.etatJ5 = "X";
				this.etatJ6 = "X";
				this.etatJeu = "X";
			}
			else if (numJoueur == 2) {
				this.etatJ1 = "X";
				this.etatJ2 = "V";
				this.etatJ3 = "X";
				this.etatJ4 = "X";
				this.etatJ5 = "X";
				this.etatJ6 = "X";
				this.etatJeu = "X";
			}
			else if (numJoueur == 3) {
				this.etatJ1 = "X";
				this.etatJ2 = "X";
				this.etatJ3 = "V";
				this.etatJ4 = "X";
				this.etatJ5 = "X";
				this.etatJ6 = "X";
				this.etatJeu = "X";
			}
			else if (numJoueur == 4) {
				this.etatJ1 = "X";
				this.etatJ2 = "X";
				this.etatJ3 = "X";
				this.etatJ4 = "V";
				this.etatJ5 = "X";
				this.etatJ6 = "X";
				this.etatJeu = "X";
			}
			else if (numJoueur == 5) {
				this.etatJ1 = "X";
				this.etatJ2 = "X";
				this.etatJ3 = "X";
				this.etatJ4 = "X";
				this.etatJ5 = "V";
				this.etatJ6 = "X";
				this.etatJeu = "X";
			}
			else if (numJoueur == 6) {
				this.etatJ1 = "X";
				this.etatJ2 = "X";
				this.etatJ3 = "X";
				this.etatJ4 = "X";
				this.etatJ5 = "X";
				this.etatJ6 = "V";
				this.etatJeu = "X";
			}
			else if (numJoueur == 7) {
				this.etatJ1 = "X";
				this.etatJ2 = "X";
				this.etatJ3 = "X";
				this.etatJ4 = "X";
				this.etatJ5 = "X";
				this.etatJ6 = "X";
				this.etatJeu = "V";
			}
		}
		else if (etat.equals("X")) {
			if (numJoueur == 1) {
				this.etatJ1 = "X";
			}
			else if (numJoueur == 2) {
				this.etatJ2 = "X";
			}
			else if (numJoueur == 3) {
				this.etatJ3 = "X";
			}
			else if (numJoueur == 4) {
				this.etatJ4 = "X";
			}
			else if (numJoueur == 5) {
				this.etatJ5 = "X";
			}
			else if (numJoueur == 6) {
				this.etatJ6 = "X";
			}
			else if (numJoueur == 7) {
				this.etatJeu = "X";
			}
		}
		else if (etat.equals("!")) {
			if (numJoueur == 1) {
				this.etatJ1 = "!";
			}
			else if (numJoueur == 2) {
				this.etatJ2 = "!";
			}
			else if (numJoueur == 3) {
				this.etatJ3 = "!";
			}
			else if (numJoueur == 4) {
				this.etatJ4 = "!";
			}
			else if (numJoueur == 5) {
				this.etatJ5 = "!";
			}
			else if (numJoueur == 6) {
				this.etatJ6 = "!";
			}
			else if (numJoueur == 7) {
				this.etatJeu = "!";
			}
		}
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
