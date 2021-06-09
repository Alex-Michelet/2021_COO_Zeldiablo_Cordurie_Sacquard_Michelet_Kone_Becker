package Apps;

public abstract class Case {
    /**
     * Attributs d un case position X position Y
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
     * getX
     * 
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * getY
     * 
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * getArme
     * 
     * @return l arme
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
