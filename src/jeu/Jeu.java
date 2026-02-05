package jeu;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Plateau plateau;
	private Narrateur narrateur;
	
	public Jeu(Joueur joueur1, Joueur joueur2, Plateau plateau, Narrateur narrateur) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.plateau = plateau;
		this.narrateur = narrateur;
	}
}
