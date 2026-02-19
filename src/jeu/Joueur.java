package jeu;

public class Joueur {
	private Pion pion;
	private int nbCoeurs = 5;
	private Effet effet = null;
	private De de1;
	private De de2;

	public Joueur(Pion pion) {
		this.pion = pion;
	}

	public Effet getEffet() {
		return effet;
	}

	public void setEffet(Effet effet) {
		this.effet = effet;
	}

	public Pion getPion() {
		return pion;
	}

	public void perdreCoeur(int coeurs) {
		nbCoeurs -= coeurs;
		if (nbCoeurs < 0) {
			nbCoeurs = 0;
		}
	}

	public int lancerDes() {
		return de1.lancerDe() + de2.lancerDe();
	}

	public void deplacerPion(int nbCases) {
		int numeroCaseActuelle = pion.getNumeroCaseActuelle();
		pion.setNumeroCaseActuelle(numeroCaseActuelle + nbCases);
	}

	public void boireRhum() {
		if (nbCoeurs < 5) {
			nbCoeurs++;
		}
		int resultat = lancerDes();
		deplacerPion(-resultat);
	}

	public void pactiser() {
		nbCoeurs = nbCoeurs - 2;
		De de3 = new De(6);
		int resultat = lancerDes() + de3.lancerDe();
		deplacerPion(resultat);
	}
}
