package Apps;

import moteurJeu.Commande;

public class Personnage {
    /**
     * coordonnees d'un personnage 
     */
    private int x, y;

    final static int LIMIT_X = 15, LIMIT_Y = 15;
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
	 * deplacer le personnage dans une direction
	 * 
	 * @param c
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 */
	public void deplacer(Commande c) {
		
		if (c.gauche) {
			this.x--;
			if (this.x < 0) {
                this.x = 0;
            }
		}
        if (c.droite) {
			this.x++;
			if (this.x >LIMIT_X) {
                this.x = LIMIT_X;
            }	
		}
        if (c.haut) {
			this.y--;
			if (this.y < 0) {
                this.y = 0;
            }
		}
        if (c.bas) {
			this.y++;
			if (this.y > LIMIT_Y) {
                this.y = LIMIT_Y;
            }
		}
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