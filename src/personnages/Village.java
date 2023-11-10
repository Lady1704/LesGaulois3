package personnages;

public class Village {
    private String nom;
    private Chef chef;
    private Gaulois[] villageois;
    private int nbVillageois;

    public Village(String nom, int nbVillageoisMaximum) {
        this.nom = nom;
        this.villageois = new Gaulois[nbVillageoisMaximum];
        this.nbVillageois = 0;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterHabitant(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
        } else {
            System.out.println("Village plein");
        }
    }

    public Gaulois trouverHabitant(int numeroVillageois) {
        if (numeroVillageois >= 0 && numeroVillageois < nbVillageois) {
            return villageois[numeroVillageois];
        } else {
            System.out.println("Le villageois avec le numéro " + numeroVillageois + " n'existe pas dans ce village.");
            return null;
        }
    }

    public void afficherVillageois() {
        System.out.println("Chef du village : " + chef.getNom());
        for (Gaulois villageois : villageois) {
            if (villageois != null) {
                System.out.println("Villageois : " + villageois.getNom());
            }
        }
    }

    public static void main(String[] args) {
        Village village = new Village("Village des Irréductibles", 30);

        Chef chefAbraracourcix = new Chef("Chef Abraracourcix",6, village);
        village.setChef(chefAbraracourcix);
        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterHabitant(asterix);
        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterHabitant(obelix);
        village.afficherVillageois();
    }
}
