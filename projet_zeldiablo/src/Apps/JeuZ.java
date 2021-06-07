package Apps;

import moteurJeu.*;

public class JeuZ implements Jeu{

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
    public JeuZ(Personnage p){
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

    /**
     * methode qui permet de faire evoluer le personnage
     * @param commande = direction du deplacement
     */
    public void evoluer(Commande commande){
        if(commande.bas){
            this.deplacerPerso(0, 1);
        }
        else if(commande.haut){
            this.deplacerPerso(0, -1);
        }
        else if(commande.droite){
            this.deplacerPerso(1, 0);
        }
        else if(commande.gauche){
            this.deplacerPerso(-1, 0);
        }
    }

    /**
     * methode qui permet de savoir si le jeu est fini
     * pour le moment il ne s arrete pas
     * @return
     */
    public boolean etreFini(){
        return(false);
    }

}