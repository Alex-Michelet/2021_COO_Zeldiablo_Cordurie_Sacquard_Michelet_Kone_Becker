package Apps;

import moteurJeu.Commande;

public class Personnage {
    /**
     * coordonnees d'un personnage
     */
    private int posX, posY;

    /**
     * Constructeur d'un personnage avec ses coordonnees
     * 
     * @param a abscisse
     * @param o ordonnee
     */
    public Personnage(int a, int o) {
        this.posX = a;
        this.posY = o;
    }

    /**
     * deplacer le personnage dans une direction
     * 
     * @param c la chaine permettant de deplacer le personnage (N,S, E ou O)
     */
    public void deplacer(int x, int y) {
        this.posX += x;
        this.posY += y;
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
}