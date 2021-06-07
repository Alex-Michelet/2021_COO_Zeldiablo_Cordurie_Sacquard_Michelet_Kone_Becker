package Apps;

import moteurJeu.*;

public class Principale {

    /**
     * methode de lancement qui pemet de verifier rapidement l etat de l interface graphique
     */
    public static void main(String[] args) throws Exception {
        
        Personnage perso = new Personnage(0, 0);
        JeuZ jeu = new JeuZ(perso);

        DessinZ dessin = new DessinZ(jeu);

        MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);

        moteur.lancerJeu(400, 400);

    }
    
}
