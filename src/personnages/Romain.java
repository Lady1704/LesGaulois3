package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[]equipements;
	private int nbEquipement;
	public Romain(String nom, int force) {
		this.nom = nom;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
		if (force < 0) {
			this.force = -1;
		} else {
			this.force = force;
		}
	}
	
	public String getNom() {
		return nom;
	}

    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 0:
			ajouterEquipement(equipement);
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " .");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            default:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
        }
    }

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}
    
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force >= 0: "La force du romain ne peut pas être négative";
		int forceAvant = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert force < forceAvant: "La force du romain n'a pas diminué";
	}
	
	public static void main(String[] args) {
		Romain romain = new Romain("Minus", 6);
		System.out.println(romain.prendreParole());
		romain.parler("Bonjour");
		romain.recevoirCoup(1);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		Equipement casque1 = Equipement.CASQUE;
		Equipement casque2 = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		romain.sEquiper(casque1);
	    romain.sEquiper(casque2);
	    romain.sEquiper(bouclier);
	    romain.sEquiper(casque1);
	}
}
