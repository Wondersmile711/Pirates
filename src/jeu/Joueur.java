package jeu;

public class Joueur {
	private Pion pion;
	private int nbCoeurs = 5;
	private Effet effet = Effet.AUCUN;
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

	public void setDes(De de1, De de2) {
		this.de1 = de1;
		this.de2 = de2;
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
		if (nbCoeurs > 1) {
			perdreCoeur(2);
		}
		De de3 = new De(6);
		int resultat = lancerDes() + de3.lancerDe();
		return resultat;
	}
}
