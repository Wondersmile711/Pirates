package jeu;

public class Joueur {
	private Pion pion;
	private int nbCoeurs = 5;

	public Joueur(Pion pion) {
		this.pion = pion;
	}

	public void perdreCoeur() {
		nbCoeurs--;
	}

	public void deplacerPion(int nbCases) {
		Case caseActuelle = pion.getCaseActuelle();
		caseActuelle.setNumeroCase(caseActuelle.getNumeroCase() + nbCases);
	}

	public Pion getPion() {
		return pion;
	}
}
