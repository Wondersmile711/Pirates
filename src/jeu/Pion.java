package jeu;

public class Pion {
	private Couleur couleur;
	private int numeroCaseActuelle = 0;

	public Pion(Couleur couleur) {
		this.couleur = couleur;
	}

	public int getNumeroCaseActuelle() {
		return numeroCaseActuelle;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setNumeroCaseActuelle(int numeroCaseActuelle) {
		this.numeroCaseActuelle = numeroCaseActuelle;
	}
}
