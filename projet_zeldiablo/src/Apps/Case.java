package Apps;

public abstract class Case {
    /**
     * Attributs d un case position X position Y
     */
    private int x;
    private int y;
    private boolean estFranchissable;

    /**
     * Construit une case
     * 
     * @param x
     * @param y
     * @param f
     */
    public Case(int x, int y, boolean f) {
        this.x = x;
        this.y = y;
        this.estFranchissable = f;
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
     * @return estFranchissable
     */
    public boolean estFranchissable() {
        return this.estFranchissable;
    }

}
