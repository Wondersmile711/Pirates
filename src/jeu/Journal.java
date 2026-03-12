package jeu;

public class Journal implements Affichage {

	private String nomJoueur1 = "Basile le tueur de Bulgares";
	private String nomJoueur2 = "Nicéphore la mort pâle des Sarrasins";

	@Override
	public void annoncerDebutJeu() {
		System.out.println(nomJoueur1 + " et " + nomJoueur2 + " sont prêts à parcourir les mers.");
		System.out.println("Appuyez sur Entrée pour commencer le jeu.");
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
		System.out
				.println(nomJoueur + " démarre son tour. Il possède actuellement " + joueur.getNbCoeurs() + " coeurs.");
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
		System.out.println(nomJoueur + " explore les océans de " + nbCases + " cases.");
	}

	@Override
	public void annoncerArriverCase(Pion pion, int numeroCaseArrivee) {
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		System.out.println(nomJoueur + " a réussi à atteindre la case numéro " + (numeroCaseArrivee + 1) + ".");
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
			if (joueur.getNbCoeurs() < 5) {
				System.out.println(nomJoueur
						+ " est revitalisé et regagne 1 coeur. Il est cependant ivre mort et reculera de son lancer de dés au prochain tour.");
			} else {
				System.out.println(nomJoueur
						+ " est revitalisé mais ne peut pas regagner de coeurs car il est déjà en pleine santé. "
						+ "Il est cependant ivre mort et reculera de son lancer de dés au prochain tour.");
			}
			break;
		case Effet.PACTE:
			System.out.println(nomJoueur + " a vendu son âme au diable.");
			annoncerCoeursPerdus(joueur, 2);
			System.out.println(nomJoueur + " pourra lancer un dé supplémentaire au prochain tour.");
			break;
		default:
			break;

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

	@Override
	public void annoncerMortJoueur(Joueur joueur) {
		Pion pion = joueur.getPion();
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		System.out.println(nomJoueur + " a succombé aux mers déchaînées.");
	}

	@Override
	public void passerTourSuivant() {
		System.out.println("Appuyez sur Entrée pour passer au tour suivant ");
	}

	public void afficherResultatDes(Joueur joueur, Effet effet) {
		Pion pion = joueur.getPion();
		String nomJoueur;
		if (pion.getCouleur() == Couleur.BLEU) {
			nomJoueur = nomJoueur1;
		} else {
			nomJoueur = nomJoueur2;
		}
		if (effet == Effet.PACTE) {
			System.out.println(nomJoueur + " lance les dés et obtient " + joueur.getResultatDe1() + ", "
					+ joueur.getResultatDe2() + " et " + joueur.getResultatDe3());
		} else {
			System.out.println(nomJoueur + " lance les dés et obtient " + joueur.getResultatDe1() + " et "
					+ joueur.getResultatDe2());
		}
	}
}
