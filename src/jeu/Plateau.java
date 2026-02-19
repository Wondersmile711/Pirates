package jeu;

public class Plateau {
	private De de1;
	private De de2;
	private Effet[] cases = new Effet[30];

	public Plateau(De de1, De de2) {
		this.de1 = de1;
		this.de2 = de2;
	}

	public Effet[] getCases() {
		return cases;
	}

	public int lancerDes() {
		return de1.lancerDe() + de2.lancerDe();
	}
}
