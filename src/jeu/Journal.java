package jeu;

public class Journal implements Affichage {

	private String nomJoueur1 = "Basile le tueur de Bulgares";
	private String nomJoueur2 = "Nicéphore la mort pâle des Sarrasins";

	@Override
	public void annoncerDebutJeu() {
		System.out.println(nomJoueur1 + " et " + nomJoueur2 + " sont prêts à parcourir les mers.");
	}

	@Override
	public void annoncerDebutTour(Joueur joueur) {
		Pion pion = joueur.getPion();
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		System.out.println(" ");
		System.out.println(nomJoueur + " démarre son tour.");
	}

	@Override
	public void annoncerGagnant(Joueur joueur) {
		Pion pion = joueur.getPion();
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		System.out.println(nomJoueur + " s'empare du trésor !");
	}

	@Override
	public void annoncerDeplacement(Pion pion, int nbCases) {
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		System.out.println(nomJoueur + " explore les océans " + nbCases + " cases.");
	}

	@Override
	public void annoncerArriverCase(Pion pion, int numeroCaseArrivee) {
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		System.out.println(nomJoueur + " a réussi à atteindre la case numéro " + numeroCaseArrivee + ".");
	}

	@Override
	public void annoncerEffetCase(Joueur joueur, int numeroCaseActuelle, Effet effetCase) {
		Pion pion = joueur.getPion();
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		switch (effetCase) {
		case Effet.RHUM:
			System.out.println(nomJoueur
					+ " est revitalisé et regagne 1 point de vie. Il est cependant ivre mort et reculera de son lancer de dés au prochain tour.");
		case Effet.PACTE:
			System.out.println(nomJoueur + " a vendu son âme au diable.");
			annoncerCoeursPerdus(joueur, 2);
			System.out.println(nomJoueur + " pourra lancer un dé supplémentaire au prochain tour.");
		default:

		}
	}

	@Override
	public void annoncerCoeursPerdus(Joueur joueur, int nbCoeurs) {
		Pion pion = joueur.getPion();
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		System.out.println(nomJoueur + " perd " + nbCoeurs + " points de vie.");
	}
}
