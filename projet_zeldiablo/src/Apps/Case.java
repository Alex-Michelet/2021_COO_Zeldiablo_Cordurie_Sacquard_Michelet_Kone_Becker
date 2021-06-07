public abstract class Case {
    // Attributs
    private int caseX;
    private int caseY;
    private boolean estFranchissable;

    // Constructeur
    public Case(int x, int y, boolean f) {
        this.caseX = x;
        this.caseY = y;
        this.estFranchissable = f;
    }

    // getters
    public int getCaseX() {
        return this.caseX;
    }

    public int getCaseY() {
        return this.caseY;
    }

    public boolean estFranchissable() {
        return this.estFranchissable;
    }

}
