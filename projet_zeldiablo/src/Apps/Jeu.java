package Apps;

public class Jeu{

    /**
     * un jeu connait un aventurier
     */
    private Personnage aventurier;

    /**
     * methode qui permet de deplacer le presonnage du jeu
     * @param dx = deplacement sur l axe x
     * @param dy = deplacement dur l axe y
     */
    public void deplacerPerso(int dx, int dy){

        this.aventurier.deplacer(dx, dy);

    }

}