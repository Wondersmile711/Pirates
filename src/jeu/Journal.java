package jeu;

public class Journal implements Affichage {

	private String nomJoueur1 = "Basile le tueur de Bulgares";
	private String nomJoueur2 = "Nicéphore la mort pâle des Sarrasins";

	@Override
	public void annoncerDebutJeu() {
		// TODO Auto-generated method stub
	}

	@Override
	public void annoncerDebutTour(Joueur joueur) {
		// TODO Auto-generated method stub
	}

	@Override
	public void annoncerGagnant(Joueur joueur) {
		// TODO Auto-generated method stub
	}

	@Override
	public void annoncerDeplacement(Pion pion, int nbCases) {
		// TODO Auto-generated method stub
	}

	@Override
	public void annoncerArriverCase(Pion pion, Case caseArrivee) {
		// TODO Auto-generated method stub
	}

	@Override
	public void annoncerEffetCase(Case caseActuelle) {
		// TODO Auto-generated method stub
	}

	@Override
	public void annoncerCoeursPerdus(Joueur joueur, int nbCoeurs) {
		// TODO Auto-generated method stub
	}
}
