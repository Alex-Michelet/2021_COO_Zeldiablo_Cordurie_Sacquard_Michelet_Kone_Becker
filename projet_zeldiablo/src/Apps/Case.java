package Apps;

public abstract class Case {
    // Attributs
    private int x;
    private int y;
    private boolean estFranchissable;

    // Constructeur
    public Case(int x, int y, boolean f) {
        this.x = x;
        this.y = y;
        this.estFranchissable = f;
    }

    // getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // methode qui permet de savoir so la case est franchissable
    public boolean estFranchissable() {
        return this.estFranchissable;
    }

}
