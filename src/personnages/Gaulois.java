package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nb_trophees;
	private Equipement[] trophees;
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.trophees[nb_trophees] = trophees[i];
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		String texte = " Le gaulois " + nom + " : ";
		return texte;
	}
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//		+ romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la "
				+ "mâchoire de " + romain.getNom());
		Equipement trophees[i] = romain.recevoirCoup((force / 3) *
				effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
				nb_trophees++) {
		}
		//return;
	}
	
	public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;
        if (forcePotion == 3) {
            parler("Merci Druide, je sens que ma force est 3 fois décuplée.");
        }
    }
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
		+ ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		Romain romain = new Romain("Minus", 4);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour");
		asterix.frapper(romain);
		asterix.boirePotion(3);
		
	}
}
