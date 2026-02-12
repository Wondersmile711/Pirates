package jeu;

public class Pion {
	private Couleur couleur;
	private Case caseActuelle;

	public Pion(Couleur couleur) {
		this.couleur = couleur;
		caseActuelle = new Case();
	}

	public Case getCaseActuelle() {
		return caseActuelle;
	}
}
