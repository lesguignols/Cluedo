package autre;

public class Carte {

	private String nom;
	private String etat;
	private String genre;
	
	public Carte(String nom, String genre, String etat) {
		this.nom = nom;
		this.genre = genre;
		this.etat = etat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
