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
		int deplacement = plateau.lancerDes();
		journal.annoncerDeplacement(joueur.getPion(), deplacement);
		joueur.deplacerPion(deplacement);
		journal.annoncerArriverCase(joueur.getPion(), joueur.getPion().getCaseActuelle());
	}

	public boolean verifierFinJeu() {
		Pion pion1 = joueur1.getPion();
		Pion pion2 = joueur2.getPion();

		Case casePion1 = pion1.getCaseActuelle();
		Case casePion2 = pion2.getCaseActuelle();

		if (casePion1.getNumeroCase() == 29) {
			gagnant = joueur1;
		} else if (casePion2.getNumeroCase() == 29) {
			gagnant = joueur2;
		}

		return (casePion1.getNumeroCase() == 29 || casePion2.getNumeroCase() == 29);
	}

	public void commencerJeu() {
		Pion pion1 = new Pion(Couleur.BLEU);
		Pion pion2 = new Pion(Couleur.ROUGE);

		joueur1 = new Joueur(pion1);
		joueur2 = new Joueur(pion2);

		plateau = new Plateau(new De(6), new De(6));

		journal.annoncerDebutJeu();
		while (!verifierFinJeu()) {
			debutTour(joueur1);
			debutTour(joueur2);
		}
		journal.annoncerGagnant(gagnant);
	}
}
