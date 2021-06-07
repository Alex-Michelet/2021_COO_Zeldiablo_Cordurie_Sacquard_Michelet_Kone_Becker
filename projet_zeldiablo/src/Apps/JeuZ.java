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
     * methode qui permet de faire evoluer le personnage
     * @param commande = direction du deplacement
     */
    public void evoluer(Commande commande){
        if(commande.bas){
            this.aventurier.deplacer(commande);
        }
        else if(commande.haut){
            this.aventurier.deplacer(commande);
        }
        else if(commande.droite){
            this.aventurier.deplacer(commande);
        }
        else if(commande.gauche){
            this.aventurier.deplacer(commande);
        }
    }

    /**
     * methode qui permet de savoir si le jeu est fini
     * pour le moment il ne s arrete pas
     * @return vrai que si le jeu est fini
     */
    public boolean etreFini(){
        return(false);
    }

    /**
     * getter aventurier du jeu
     * @return aventurier du jeu
     */
    public Personnage getAventurier(){
        return(this.aventurier);
    }

}