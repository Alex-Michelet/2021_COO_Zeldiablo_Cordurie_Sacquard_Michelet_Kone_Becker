package Apps;

/**
 * les fantomes sont des monstres relativements faibles 
 * mais ayant la particularite de passer au travers des murs
 */
public class Fantome extends Monstre {

    /**
     * constructeur parametre d un fantome qui initialise les coordonnees du fantome
     * @param x = abscisse du fantome
     * @param y = ordonnee du fantome
     */
    public Fantome(int x, int y){
        // un fantome a 5 pv 1 de portee et fais 1 point de degats
        super(x, y, 5, 1, 1);
    }
    
}
