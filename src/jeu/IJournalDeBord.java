package jeu;

public interface IJournalDeBord {
	
	String annoncerDebutJeu();
	String annoncerDebutTour(Joueur joueur);
	String annoncerGagnant(Joueur joueur);
	String annoncerDeplacement(Pion pion, int nbCases);
	String annoncerArriverCase(Pion pion, Case caseArrivee);
	String annoncerEffetCase(Case caseActuelle);
	String annoncerCoeursPerdus(Joueur joueur, int nbCoeurs);
}
