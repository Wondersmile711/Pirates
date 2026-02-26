package jeu;

import java.security.SecureRandom;
import java.util.Random;

public class Plateau {
	private De de1;
	private De de2;
	private Effet[] cases = new Effet[30];
	private Random random;

	public Plateau(De de1, De de2) {
		this.de1 = de1;
		this.de2 = de2;

		for (int i = 0; i < 30; i++) {
			cases[i] = Effet.AUCUN;
		}
	}

	public Effet[] getCases() {
		return cases;
	}

	public void placerEffets() {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int nbCasesRhum = 3;
		int nbCasesPacte = 3;

		do {
			int numeroCaseRhum = random.nextInt(1, 29);
			int numeroCasePacte = random.nextInt(1, 29);

			if (nbCasesRhum != 0 && cases[numeroCaseRhum] == Effet.AUCUN) {
				cases[numeroCaseRhum] = Effet.RHUM;
				nbCasesRhum--;
			}

			if (nbCasesPacte != 0 && cases[numeroCasePacte] == Effet.AUCUN) {
				cases[numeroCasePacte] = Effet.PACTE;
				nbCasesPacte--;
			}
		} while (nbCasesRhum != 0 || nbCasesPacte != 0);
	}
}
