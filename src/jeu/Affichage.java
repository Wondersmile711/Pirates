package jeu;

public interface Affichage {

	void annoncerDebutJeu();

	void annoncerDebutTour(Joueur joueur);

	void annoncerGagnant(Joueur joueur);

	void annoncerDeplacement(Pion pion, int nbCases);

	void annoncerArriverCase(Pion pion, int numeroCaseArrivee);

	void annoncerEffetCase(Joueur joueur, int numeroCaseActuelle, Effet effetCase);

	void annoncerCoeursPerdus(Joueur joueur, int nbCoeurs);
}
