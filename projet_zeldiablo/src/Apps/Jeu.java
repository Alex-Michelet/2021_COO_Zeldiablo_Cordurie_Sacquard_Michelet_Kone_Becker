package Apps;

public class Jeu{

    /**
     * un jeu connait un aventurier
     */
    private Personnage aventurier;

    /**
     * constructeur parametre qui permet de creer un jeu 
     * @param p = personnage qui sera l aventurier du jeu
     * ce constructeur lance une erreur si le personnage donne
     * n est pas instancie
     */
    public Jeu(Personnage p){
        if(p != null){
            this.aventurier = p;
        }
        else{
            throw new Error("Un jeu DOIT connaitre un personnage");
        }
    }

    /**
     * methode qui permet de deplacer le presonnage du jeu
     * @param dx = deplacement sur l axe x
     * @param dy = deplacement dur l axe y
     */
    public void deplacerPerso(int dx, int dy){

        this.aventurier.deplacer(dx, dy);

    }

}