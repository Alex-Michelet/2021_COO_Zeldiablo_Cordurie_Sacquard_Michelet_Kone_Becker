package Apps;

import moteurJeu.*;

/** Classe principale, lance le jeu */
public class Principale {

    /**
     * methode de lancement qui pemet de verifier rapidement l etat de l interface
     * graphique
     */
    public static void main(String[] args) throws Exception {

        // on prepare les donnees du jeu
        Labyrinthe labyrinthe = new Labyrinthe("niveaux/lab3.txt");
        JeuZ jeu = new JeuZ(labyrinthe);

        // on prepare l interface graphique
        DessinZ dessin = new DessinZ(jeu);

        // on prepare le moteur graphique
        MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);

        // on lance le moteur de jeu
        moteur.lancerJeu(700, 700);
    }

}