package Apps;

public class Piege extends Case {
    private boolean estAmorce;

    /**
     * constructeur d une case piege qui fait prendre des degats lorsque le
     * personnage se place dessus
     * 
     * @param x = abscisse de la case
     * @param y = ordonnee de la case
     */
    public Piege(int x, int y, boolean etat) {
        super(x, y, true);
        this.estAmorce = etat;
    }

    /**
     * getEtatPiege
     * 
     * @return estAmorce
     */
    public boolean getEtatPiege() {
        return this.estAmorce;
    }

}
