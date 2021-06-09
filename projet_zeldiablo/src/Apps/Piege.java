package Apps;

public class Piege extends Case {

    /**
     * constructeur d une case piege qui fait prendre des degats lorsque le
     * personnage se place dessus
     * 
     * @param x = abscisse de la case
     * @param y = ordonnee de la case
     */
    public Piege(int x, int y) {
        super(x, y, true, null);
    }

}