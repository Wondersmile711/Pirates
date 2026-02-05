package jeu;

public class Joueur {
	private Pion pion;
	private String nom;
	private int nbCoeurs = 5;

	public Joueur(Pion pion, String nom) {
		this.pion = pion;
		this.nom = nom;
	}

	public void perdreCoeur() {
		nbCoeurs--;
	}

	public void deplacerPion(int nbCases) {
		// TODO
	}
}
