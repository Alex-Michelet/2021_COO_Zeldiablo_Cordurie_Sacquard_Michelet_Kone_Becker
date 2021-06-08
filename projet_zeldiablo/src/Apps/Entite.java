package Apps;

public abstract class Entite {
    private int posX, posY, pv;
    private boolean mort;

    public Entite(int x, int y, int vie) {
        this.posX = x;
        this.posY = y;
        this.pv = vie;
        this.mort = false;
    }

    /**
     * methode qui permet d attaquer une entite
     * 
     * @param victime
     */
    public abstract void attaquer(Entite victime);

    /**
     * methode qui decremente les pv actuels en prenant en compte l'etat du monstre
     * (invincibile, vivant...)
     * 
     * @param dgt nombre de pv perdu
     */
    public abstract void prendreDegats(int dgt);

    /**
     * deplacer l entite dans une direction
     * 
     * @param x abscisse
     * @param y ordonnee
     */
    public void deplacer(int x, int y) {
        if (!mort) {
            this.posX += x;
            this.posY += y;
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
     * methode qui permet de savoir si le personnage est mort si le boolean est true
     * et vivant si il est false
     * 
     * @return mort
     */
    public boolean etreMort() {
        return this.mort;
    }

    /**
     * methode qui permet d'incrementer les pv de l entite 
     *
     * @param vie
     */
    public void setPv(int vie) {
        this.pv = vie;
    }

    public void setMort(boolean etat) {
        this.mort = etat;
    }
}