package jeu;

import java.util.Scanner;

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

		Pion pion = joueur.getPion();

		journal.afficherResultatDes(joueur, effet);
		journal.annoncerDeplacement(pion, deplacement);
		joueur.deplacerPion(deplacement);
		int numeroCaseActuelle = pion.getNumeroCaseActuelle();
		journal.annoncerArriverCase(pion, numeroCaseActuelle);

		joueur.setEffet(plateau.getCases()[numeroCaseActuelle]);
		journal.annoncerEffetCase(joueur, numeroCaseActuelle, joueur.getEffet());
	}

	public boolean verifierFinJeu() {
		Pion pion1 = joueur1.getPion();
		Pion pion2 = joueur2.getPion();

		int casePion1 = pion1.getNumeroCaseActuelle();
		int casePion2 = pion2.getNumeroCaseActuelle();

		if (casePion1 == 29 || joueur2.estMort()) {
			gagnant = joueur1;
		} else if (casePion2 == 29 || joueur1.estMort()) {
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
		joueur1.setDes(de1, de2);
		joueur2.setDes(de1, de2);

		plateau.placerEffets();

		Scanner scanner = new Scanner(System.in);

		journal.annoncerDebutJeu();

		scanner.nextLine();

		while (!verifierFinJeu()) {
			debutTour(joueur1);
			if (!verifierFinJeu()) {
				journal.passerTourSuivant();
				scanner.nextLine();
			}

			if (!verifierFinJeu()) {
				debutTour(joueur2);
				if (!verifierFinJeu()) {
					journal.passerTourSuivant();
					scanner.nextLine();
				}
			}

		}

		if (joueur1.estMort()) {
			journal.annoncerMortJoueur(joueur1);
		} else if (joueur2.estMort()) {
			journal.annoncerMortJoueur(joueur2);
		}

		journal.annoncerGagnant(gagnant);
	}
}
