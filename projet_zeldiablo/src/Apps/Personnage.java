package Apps;


public class Personnage {
    /**
     * coordonnees d'un personnage
     */
    private int posX, posY, pv, vieMax;
    private boolean mort;
    /**
     * Constructeur d'un personnage avec ses coordonnees
     * 
     * @param a abscisse
     * @param o ordonnee
     */
    public Personnage(int a, int o) {
        this.posX = a;
        this.posY = o;
        this.pv = 15;
        this.vieMax = 15;
        this.mort = false;
    }

    /**
     * deplacer le personnage dans une direction
     * 
     * @param c la chaine permettant de deplacer le personnage (N,S, E ou O)
     */
    public void deplacer(int x, int y) {
        if (!mort) {
            this.posX += x;
            this.posY += y;
        }
    }

    /**
     * methode qui incremente les pv actuelles de vie
     * 
     * @param vie
     */
    public void gagnerVie(int vie) {
        if (!mort) {
            this.pv+=Math.abs(vie);
        }
    }

    /**
     * methode qui decremente les pv actuelles de vie
     * @param vie
     */
    public void perdreVie(int vie) {
        if (!mort) {
            this.pv-=Math.abs(vie);
            if (this.pv <= 0) {
                this.mort = true;
            }
        }
    }

    /**
     * methode qui permet d'obtenir la coordonnee x du personnage
     * 
     * @return coordonnee x
     */
    public int getX() {
        return this.posX;
    }

    /**
     * methode qui permet d'obtenir la coordonnee y du personnage
     * 
     * @return coordonnee y
     */
    public int getY() {
        return this.posY;
    }

    /**
     * methode qui permet d'obtenir la vie actuelle du personnage
     * 
     * @return pv
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * methode qui permet d'obtenir la vie maximal du personnage
     * 
     * @return vieMax
     */
    public int getVieMax() {
        return this.vieMax;
    }

    /**
     * methode qui permet de savoir si le personnage est mort si le boolean est true et vivant si il est false 
     * @return
     */
    public boolean etreMort() {
        return this.mort;
    }
}