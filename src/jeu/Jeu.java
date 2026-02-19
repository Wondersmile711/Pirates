package jeu;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Plateau plateau;
	private Affichage journal;
	private Joueur gagnant;

	public Jeu(Affichage journal) {
		this.journal = journal;
	}

	public void debutTour(Joueur joueur) {
		journal.annoncerDebutTour(joueur);
		Effet effet = joueur.getEffet();

		switch (effet) {
		case Effet.RHUM:
			joueur.boireRhum();
		case Effet.PACTE:
			joueur.pactiser();
		default:
			int deplacement = joueur.lancerDes();
			joueur.deplacerPion(deplacement);
		}

		Pion pion = joueur.getPion();
		int numeroCaseActuelle = pion.getNumeroCaseActuelle();
		// journal.annoncerDeplacement(pion, deplacement);
		journal.annoncerArriverCase(pion, numeroCaseActuelle + 1);
		joueur.setEffet(plateau.getCases()[numeroCaseActuelle]);
		journal.annoncerEffetCase(joueur, numeroCaseActuelle, joueur.getEffet());
	}

	public boolean verifierFinJeu() {
		Pion pion1 = joueur1.getPion();
		Pion pion2 = joueur2.getPion();

		int casePion1 = pion1.getNumeroCaseActuelle();
		int casePion2 = pion2.getNumeroCaseActuelle();

		if (casePion1 == 29) {
			gagnant = joueur1;
		} else if (casePion2 == 29) {
			gagnant = joueur2;
		}

		return (casePion1 == 29 || casePion2 == 29);
	}

	public void commencerJeu() {
		Pion pion1 = new Pion(Couleur.BLEU);
		Pion pion2 = new Pion(Couleur.ROUGE);

		joueur1 = new Joueur(pion1);
		joueur2 = new Joueur(pion2);

		De de1 = new De(6);
		De de2 = new De(6);

		plateau = new Plateau(de1, de2);

		journal.annoncerDebutJeu();
		while (!verifierFinJeu()) {
			debutTour(joueur1);
			debutTour(joueur2);
		}
		journal.annoncerGagnant(gagnant);
	}
}
