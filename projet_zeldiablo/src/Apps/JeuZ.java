package Apps;

import moteurJeu.*;

public class JeuZ implements Jeu{

    /**
     * un jeu connait un aventurier
     */
    private Personnage aventurier;
    private Labyrinthe labyrinthe;

    /**
     * constructeur parametre qui permet de creer un jeu 
     * @param p = personnage qui sera l aventurier du jeu
     * ce constructeur lance une erreur si le personnage donne
     * n est pas instancie
     */
    public JeuZ(Personnage p, Labyrinthe l){
        if(p != null){
            this.aventurier = p;
        }
        else{
            throw new Error("Un jeu DOIT connaitre un personnage");
        }
        if(l != null){
            this.labyrinthe = l;
        }
        else{
            throw new Error("Un jeu DOIT connaitre un labyrinthe");
        }
    }

    /**
     * methode qui permet de faire evoluer le personnage
     * @param commande = direction du deplacement
     */
    public void evoluer(Commande commande){
        // on recupere les coordonnees de l aventurier
        int xPerso = this.aventurier.getX();
        int yPerso = this.aventurier.getY();

        // on verifie que l aventurier puisse bien aller a la case souhaitee
        if (commande.gauche) {
			if (xPerso > 0 && this.labyrinthe.estAccessible(xPerso - 1, yPerso)) {
                this.aventurier.deplacer(-1, 0);
            }
		}
        if (commande.droite && this.labyrinthe.estAccessible(xPerso + 1, yPerso)) {
			if (xPerso < this.labyrinthe.getTailleX()) {
                this.aventurier.deplacer(1, 0);
            }	
		}
        if (commande.haut) {
			if (yPerso > 0 && this.labyrinthe.estAccessible(xPerso, yPerso - 1)) {
                this.aventurier.deplacer(0, -1);
            }
		}
        if (commande.bas && this.labyrinthe.estAccessible(xPerso, yPerso + 1)) {
			if (yPerso < this.labyrinthe.getTailleY()) {
                this.aventurier.deplacer(0, 1);
            }
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

    /**
     * getter labyrinthe
     * @return
     */
    public Labyrinthe getLabyrinthe(){
        return(this.labyrinthe);
    }

}