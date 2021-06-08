package Apps;

public abstract class Monstre implements Entite {
    /**
     * attributs du monstre
     */
    private int posX, posY, vie, ptsAttaque;
    private boolean mort;

    /**
     * Constructeur d'un personnage avec ses coordonnees
     * 
     * @param a   abscisse
     * @param o   ordonnee
     * @param pv  points de vie
     * @param atk points d'attaque
     */
    public Monstre(int a, int o, int pv, int atk) {
        this.posX = a;
        this.posY = o;
        this.vie = pv;
        this.ptsAttaque = atk;
        this.mort = false;
    }

    public void attaquer(Entite victime) {
        if (!estMort()) {
            victime.prendreDegats(ptsAttaque);
        }
    }

    public void prendreDegats(int dgt) {
        int val = Math.abs(dgt);
        if (vie < val) {
            vie = 0;
        } else {
            vie -= val;
        }
    }

    /**
     * deplacer le monstre dans une direction
     * 
     * @param x coordonnee x de deplacement (relatif)
     * @param y coordonnee y de deplacement (relatif)
     */
    public void deplacer(int x, int y) {
        if (!mort) {
            this.posX += x;
            this.posY += y;
        }
    }

    /**
     * methode qui permet d'obtenir la coordonnee x du monstre
     * 
     * @return coordonnee x
     */
    public int getPosX() {
        return posX;
    }

    /**
     * methode qui permet d'obtenir la coordonnee y du monstre
     * 
     * @return coordonnee y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * methode qui permet d'obtenir l'attaque du monstre
     * 
     * @return points d'attaque
     */
    public int getPtsAttaque() {
        return ptsAttaque;
    }

    /**
     * methode qui permet d'obtenir la vie du monstre
     * 
     * @return vie
     */
    public int getVie() {
        return vie;
    }

    /**
     * methode qui permet de savoir si le monstre est mort (le boolean est true) ou
     * vivant (false)
     * 
     * @return boolean
     */
    public boolean estMort() {
        return mort;
    }

}
