package jeu;

public class TestJeu {
	public static void main(String[] args) {
		Affichage journal = new Journal();
		Jeu jeu = new Jeu(journal);
		jeu.commencerJeu();
	}
}
