package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	public int getEffetPotionMin() {
        return effetPotionMin;
    }

    public int getEffetPotionMax() {
        return effetPotionMax;
    }
	public void preparerPotion() {
		Random random = new Random();
		int forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
		this.forcePotion = forcePotion;
		if (forcePotion > 7) {
			parler("J'ai préparé une super potion de force " + forcePotion + ".");
	    } else {
	    	parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion + ".");
	    }
	}
	public void booster(Gaulois gaulois) {
        if (gaulois.getNom().equals("Obélix")) {
            System.out.println("Le druide " + nom + " : Non, Obélix !... Tu n'auras pas de potion magique !");
        } else {
            Random random = new Random();
            int forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
            gaulois.boirePotion(forcePotion);
        }
    }
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		for (int i = 0; i < 5; i++) {
            System.out.println("Test " + (i + 1) + ":");
            panoramix.preparerPotion();
            System.out.println();
        }
	}
}
