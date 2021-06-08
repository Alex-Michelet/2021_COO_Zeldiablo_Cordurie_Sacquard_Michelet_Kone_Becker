package Apps;

import moteurJeu.*;

public class JeuZ implements Jeu {

    /**
     * un jeu connait un aventurier
     */
    private Personnage aventurier;
    private Labyrinthe labyrinthe;

    /**
     * constructeur parametre qui permet de creer un jeu
     * 
     * @param p = personnage qui sera l aventurier du jeu ce constructeur lance une
     *          erreur si le personnage donne n est pas instancie
     */
    public JeuZ(Personnage p, Labyrinthe l) {
        if (p != null) {
            this.aventurier = p;
        } else {
            throw new Error("Un jeu DOIT connaitre un personnage");
        }
        if (l != null) {
            this.labyrinthe = l;
        } else {
            throw new Error("Un jeu DOIT connaitre un labyrinthe");
        }
    }

    /**
     * methode qui permet de faire evoluer le personnage
     * 
     * @param commande = direction du deplacement
     */
    public void evoluer(Commande commande) {

        // si le perso c est bien deplace on gere les pieges
        if (this.deplacerPerso(commande)) {

            // on recupere les coordonnees actuelles du personnage
            int xPersoActuel = this.aventurier.getX();
            int yPersoActuel = this.aventurier.getY();

            // on regarde si le personnage est arrive sur un piege
            if (this.labyrinthe.estUnPiege(xPersoActuel, yPersoActuel)) {

                // on fait subir des degats au personnage
                this.aventurier.prendreDegats(3);
            }
        }

    }

    /**
     * methode qui permet de deplacer le personnage
     * 
     * @param commande = commande utilisateur
     * @return vrai que si le deplacement a eu lieu
     */
    public boolean deplacerPerso(Commande commande) {

        boolean res = false;

        // on recupere les coordonnees de l aventurier
        int xPerso = this.aventurier.getX();
        int yPerso = this.aventurier.getY();

        // on verifie que l aventurier puisse bien aller a la case souhaitee
        if (commande.gauche) {
            if (xPerso > 0 && this.labyrinthe.estAccessible(xPerso - 1, yPerso)) {
                this.aventurier.deplacer(-1, 0);
            }
        }
        if (commande.droite) {
            if (xPerso < this.labyrinthe.getTailleX() - 1 && this.labyrinthe.estAccessible(xPerso + 1, yPerso)) {
                this.aventurier.deplacer(1, 0);
            }
        }
        if (commande.haut) {
            if (yPerso > 0 && this.labyrinthe.estAccessible(xPerso, yPerso - 1)) {
                this.aventurier.deplacer(0, -1);
            }
        }
        if (commande.bas) {
            if (yPerso < this.labyrinthe.getTailleY() - 1 && this.labyrinthe.estAccessible(xPerso, yPerso + 1)) {
                this.aventurier.deplacer(0, 1);
            }
        }

        // on verifie que le deplacement a bien eu lieu
        if (xPerso != this.aventurier.getX() || yPerso != this.aventurier.getY()) {
            res = true;
        }

        return (res);
    }

    /**
     * methode qui permet de savoir si le jeu est fini 
     * le jeu s arrete si le personnage meurt
     * 
     * @return vrai que si le jeu est fini
     */
    public boolean etreFini() {
        return (this.aventurier.etreMort());
    }

    /**
     * getter aventurier du jeu
     * 
     * @return aventurier du jeu
     */
    public Personnage getAventurier() {
        return (this.aventurier);
    }

    /**
     * getter labyrinthe
     * 
     * @return
     */
    public Labyrinthe getLabyrinthe() {
        return (this.labyrinthe);
    }

}