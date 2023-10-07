package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[]equipements;
	private int nbEquipement;
	private String texte;
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
                equipements[nbEquipement] = equipement;
                nbEquipement++;
                System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " .");
                } else {
                    equipements[nbEquipement] = equipement;
                    nbEquipement++;
                    System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
                }
                break;
            default:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
        }
    }
    
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert force >= 0: "La force du romain ne peut pas être négative";
//		int forceAvant = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force < forceAvant: "La force du romain n'a pas diminué";
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
			case 0:
				parler("Aïe");
				break;
			default:
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
				break;
		// post condition la force a diminuée
				assert force < oldForce;
				return equipementEjecte;
		}
	
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du"
				+ " coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa"
					+ "force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null &&
						equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + ""
				+ "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				equipementEjecte[nbEquipementEjecte] =
						equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
