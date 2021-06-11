/**
 * Classe Case 
 * classe abstraite qui creee les cases du labyrinthe
 * il en decoulera plusieurs types de cases
 */
package Apps;

public abstract class Case {
    /**
     * Attributs d une case : position X position Y, etat(franchissable ou non),
     * arme si la case contient une arme
     */
    private int x;
    private int y;
    private boolean franchissable;
    private Arme weapon;

    /**
     * Construit une case
     * 
     * @param x
     * @param y
     * @param etat
     */
    public Case(int x, int y, boolean etat, Arme arme) {
        this.x = x;
        this.y = y;
        this.franchissable = etat;
        this.weapon = arme;
    }

    /**
     * permet de mettre une arme sur une case
     * 
     * @param arme
     */
    public void setArme(Arme arme) {
        this.weapon = arme;
    }

    /**
     * permet de retirer l arme de la case
     */
    public void retirerArme() {
        this.weapon = null;
    }

    /**
     * getX renvois la position X
     * 
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * getY renvois la position Y
     * 
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * getArme renvois une arme
     * 
     * @return weapon
     */
    public Arme getArme() {
        return this.weapon;
    }

    /**
     * estFranchissable
     * 
     * @return franchissable
     */
    public boolean estFranchissable() {
        return this.franchissable;
    }

}
