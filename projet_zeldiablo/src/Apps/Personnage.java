package Apps;

import moteurJeu.Commande;

public class Personnage {
    /**
     * coordonnees d'un personnage
     */
    private int x, y;

    /**
     * Constructeur d'un personnage avec ses coordonnees
     * 
     * @param a abscisse
     * @param o ordonnee
     */
    public Personnage(int a, int o) {
        this.x = a;
        this.y = o;
    }

    /**
     * deplacer le personnage dans une direction
     * 
     * @param c la chaine permettant de deplacer le personnage (N,S, E ou O)
     */
    public void deplacer(int x, int y) {
        this.x += x;
        this.y += y;
    }

    /**
     * methode qui permet d'obtenir la coordonnee x du personnage
     * 
     * @return coordonnee x
     */
    public int getX() {
        return this.x;
    }

    /**
     * methode qui permet d'obtenir la coordonnee y du personnage
     * 
     * @return coordonnee y
     */
    public int getY() {
        return this.y;
    }
}