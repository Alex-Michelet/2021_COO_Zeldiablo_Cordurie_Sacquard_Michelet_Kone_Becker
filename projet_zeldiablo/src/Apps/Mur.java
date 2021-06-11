/**
 * Classe Mur
 * herite de le classe Case
 * une case type mur nest pas franchissable
 */
package Apps;

public class Mur extends Case {

    /**
     * construit un mur, un mur est une case non franchissable
     * 
     * @param x = abscisse de la case
     * @param y = ordonnee de la case
     */
    public Mur(int x, int y) {
        super(x, y, false, null);
    }

}
