package Apps;

import moteurJeu.*;

public class Principale {

    /**
     * methode de lancement qui pemet de verifier rapidement l etat de l interface
     * graphique
     */
    public static void main(String[] args) throws Exception {

        Personnage perso = new Personnage(1, 16, 15);
        Labyrinthe labyrinthe = new Labyrinthe("niveaux/lab1.txt");
        JeuZ jeu = new JeuZ(perso, labyrinthe);

        DessinZ dessin = new DessinZ(jeu);

        MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);

        moteur.lancerJeu(900, 900);
    }

}