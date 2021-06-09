package Apps;

public abstract class Monstre extends Entite {
    /**
     * attributs du monstre
     */
    private int ad;

    /**
     * Constructeur d'un personnage avec ses coordonnees
     * 
     * @param a   abscisse
     * @param o   ordonnee
     * @param vie points de vie
     * @param atk points d'attaque
     */
    public Monstre(int a, int o, int vie, int atk) {
        super(a, o, vie);
        this.ad = atk;
    }

    /**
     * methode qui permet d attaque une un victime
     * 
     * @param victime = victime a attaquer
     */
    public void attaquer(Entite victime) {
        if (!this.etreMort()) {
            victime.prendreDegats(this.ad);
        }
    }

    /**
     * methode qui permet a un monstre de subir des degats
     * 
     * @param dgt = nombre de pv a retirer
     */
    public void prendreDegats(int dgt) {
        int val = Math.abs(dgt);

        if (this.getPv() < val) {
            this.setPv(0);
            this.setMort(true);
        } else {
            this.setPv(this.getPv() - val);
        }
    }

    /**
     * methode qui permet d'obtenir l'attaque du monstre
     * 
     * @return points d'attaque
     */
    public int getAd() {
        return ad;
    }

    public int getPortee() {
        return 1;
    }
}