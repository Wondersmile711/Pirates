package jeu;

public class Joueur {
	private Pion pion;
	private int nbCoeurs = 5;
	private Effet effet = Effet.AUCUN;
	private De de1;
	private int resultatDe1;
	private int resultatDe2;
	private int resultatDe3;
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

	public void setDes(De de1, De de2) {
		this.de1 = de1;
		this.de2 = de2;
	}

	public Pion getPion() {
		return pion;
	}

	public int getNbCoeurs() {
		return nbCoeurs;
	}

	public int getResultatDe1() {
		return resultatDe1;
	}

	public int getResultatDe2() {
		return resultatDe2;
	}

	public int getResultatDe3() {
		return resultatDe3;
	}

	public void perdreCoeur(int coeurs) {
		nbCoeurs -= coeurs;
		if (nbCoeurs < 0) {
			nbCoeurs = 0;
		}
	}

	public int lancerDes() {
		resultatDe1 = de1.lancerDe();
		resultatDe2 = de2.lancerDe();
		return resultatDe1 + resultatDe2;
	}

	public void deplacerPion(int nbCases) {
		int numeroCaseActuelle = pion.getNumeroCaseActuelle();

		if (numeroCaseActuelle + nbCases > 29) {
			int deplacement = 29 - numeroCaseActuelle;
			int resultat = nbCases - deplacement;
			pion.setNumeroCaseActuelle(29 - resultat);
		} else {
			pion.setNumeroCaseActuelle(numeroCaseActuelle + nbCases);
		}
	}

	public int boireRhum() {
		if (nbCoeurs < 5) {
			nbCoeurs++;
		}
		int resultat = lancerDes();
		return -resultat;
	}

	public int pactiser() {
		perdreCoeur(2);
		De de3 = new De(6);
		resultatDe3 = de3.lancerDe();
		int resultat = lancerDes() + resultatDe3;
		return resultat;
	}

	public boolean estMort() {
		return nbCoeurs == 0;
	}
}
