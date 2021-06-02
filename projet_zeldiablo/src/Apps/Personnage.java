package Apps;

public class Personnage {
    /**
     * coordonnees d'un personnage 
     */
    private int x, y;

    /**
     * Constructeur d'un personnage avec ses coordonnees
     * @param a abscisse
     * @param o ordonnee
     */
    public Personnage(int a, int o) {
        this.x = a;
        this.y = o;
    }

    /**
     * methode qui permet de deplacer le personnage
     * @param dx deplacement sur l'axe des abscisses
     * @param dy deplacement sur l'axe des ordonnees
     */    
    public void deplacer(int dx, int dy) {
        this.x+=dx;
        this.y+=dy;
    }

    /**
     * methode qui permet d'obtenir la coordonnee x du personnage
     * @return coordonnee x
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * methode qui permet d'obtenir la coordonnee y du personnage
     * @return coordonnee y
     */
    public int getY() {
        return this.y;
    }
}