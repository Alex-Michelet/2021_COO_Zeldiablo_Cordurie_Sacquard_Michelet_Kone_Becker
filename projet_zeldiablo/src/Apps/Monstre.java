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
     * @param vie  points de vie
     * @param atk points d'attaque
     */
    public Monstre(int a, int o, int vie, int atk) {
        super(a, o, vie);
        this.ad = atk;
    }


    public void attaquer(Entite victime) {
        if (!estMort()) {
            victime.prendreDegats(ptsAttaque);
        }
    }

    public void prendreDegats(int dgt) {
        int val = Math.abs(dgt);
        if (this.getPv() < val) {
            this.setPv(0);
        } else {
            this.setPv(-val);
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
}
