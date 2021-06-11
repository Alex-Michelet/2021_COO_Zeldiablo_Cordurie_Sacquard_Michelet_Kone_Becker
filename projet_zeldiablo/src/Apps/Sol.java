/**
 * Classe Sol 
 * herite de la classe Case
 * cree une case franchissable
 */
package Apps;

public class Sol extends Case {

    /**
     * constructeur d un sol qui fait une case franchissable
     * 
     * @param x = abscisse de la case
     * @param y = ordonnee de la case
     */
    public Sol(int x, int y, Arme arme) {
        super(x, y, true, arme);
    }

}
