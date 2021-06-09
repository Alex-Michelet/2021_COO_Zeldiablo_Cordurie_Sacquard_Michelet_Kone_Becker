package Apps;

public class Mur extends Case {

    /**
     * constructeur d un mur qui permet de faire une case non franchissable
     * @param x = abscisse de la case
     * @param y = ordonnee de la case
     */
    public Mur(int x, int y){
        super(x, y, false, null);
    }
    
}
