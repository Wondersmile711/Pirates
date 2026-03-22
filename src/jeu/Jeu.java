package jeu;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Plateau plateau;
	private Affichage journal;
	private Joueur gagnant;
	private int difficulte;

	public Jeu(Affichage journal) {
		this.journal = journal;
		difficulte = journal.choisirDifficulte();
	}

	private void debutTour(Joueur joueur) {
		Effet effet = joueur.getEffet();
		int deplacement;

		switch (effet) {
		case Effet.RHUM:
			deplacement = joueur.boireRhum();
			break;
		case Effet.PACTE:
			deplacement = joueur.pactiser();
			break;
		default:
			deplacement = joueur.lancerDes();
			break;
		}

		journal.annoncerDebutTour(joueur);

		Pion pion = joueur.getPion();

		journal.afficherResultatDes(joueur, effet);
		journal.annoncerDeplacement(pion, deplacement);
		joueur.deplacerPion(deplacement);
		int numeroCaseActuelle = pion.getNumeroCaseActuelle();
		journal.annoncerArriverCase(pion, numeroCaseActuelle);

		joueur.setEffet(plateau.getCases()[numeroCaseActuelle]);
		journal.annoncerEffetCase(joueur, numeroCaseActuelle, joueur.getEffet());
		joueur.gererCoeurs();
		if (joueur.estMort()) {
			journal.annoncerMortJoueur(joueur);
		}
	}

	private boolean verifierFinJeu() {
		Pion pion1 = joueur1.getPion();
		Pion pion2 = joueur2.getPion();

		int casePion1 = pion1.getNumeroCaseActuelle();
		int casePion2 = pion2.getNumeroCaseActuelle();

		if (casePion1 == 29 || joueur2.estMort()) {
			gagnant = joueur1;
			return true;
		} else if (casePion2 == 29 || joueur1.estMort()) {
			gagnant = joueur2;
			return true;
		} else {
			return false;
		}
	}

	public void commencerJeu() {
		Pion pion1 = new Pion(Couleur.BLEU);
		Pion pion2 = new Pion(Couleur.ROUGE);

		joueur1 = new Joueur(pion1);
		joueur2 = new Joueur(pion2);

		De de1 = new De(6);
		De de2 = new De(6);

		plateau = new Plateau(de1, de2, difficulte);
		joueur1.setDes(de1, de2);
		joueur2.setDes(de1, de2);

		plateau.placerEffets();

		journal.annoncerDebutJeu();

		do {
			debutTour(joueur1);
			if (!verifierFinJeu()) {
				journal.passerTourSuivant();
				debutTour(joueur2);
				if (!verifierFinJeu()) {
					journal.passerTourSuivant();
				}
			}
		} while (!verifierFinJeu());
		journal.annoncerGagnant(gagnant);
	}
}
