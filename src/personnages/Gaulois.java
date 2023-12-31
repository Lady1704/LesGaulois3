package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		 
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
		+ romain.getNom());
		romain.recevoirCoup(force / 3);
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
