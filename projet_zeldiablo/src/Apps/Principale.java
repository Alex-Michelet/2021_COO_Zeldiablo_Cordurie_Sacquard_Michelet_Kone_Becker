package Apps;

import moteurJeu.*;

/** Classe principale, lance le jeu */
public class Principale {

    /**
     * methode de lancement qui pemet de verifier rapidement l etat de l interface
     * graphique
     */
    public static void main(String[] args) throws Exception {

        Labyrinthe labyrinthe = new Labyrinthe("niveaux/lab3.txt");
        JeuZ jeu = new JeuZ(labyrinthe);

        DessinZ dessin = new DessinZ(jeu);

        MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);

        moteur.lancerJeu(700, 700);
    }

}