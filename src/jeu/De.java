package jeu;

import java.security.SecureRandom;
import java.util.Random;

public class De {
	private int valeurMax;
	private Random random;

	public De(int valeurMax) {
		this.valeurMax = valeurMax;
	}

	public int lancerDe() {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return random.nextInt(1, valeurMax + 1);
	}

}
