package Apps;

public abstract class Case {
    /**
     * Attributs d un case position X position Y
     */
    private int x;
    private int y;
    private boolean franchissable;

    /**
     * Construit une case
     * 
     * @param x
     * @param y
     * @param etat
     */
    public Case(int x, int y, boolean etat) {
        this.x = x;
        this.y = y;
        this.franchissable = f;
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
     * estFranchissable
     * 
     * @return franchissable
     */
    public boolean estFranchissable() {
        return this.franchissable;
    }

}
