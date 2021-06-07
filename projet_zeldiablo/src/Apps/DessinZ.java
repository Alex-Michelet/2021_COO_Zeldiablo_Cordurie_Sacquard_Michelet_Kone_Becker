package Apps;

import moteurJeu.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

public class DessinZ implements DessinJeu {

    private int TAILLE_CASE = 20;

    JeuZ jeu;

    /**
     * constructeur qui permet au dessin de connaitre le jeu a afficher
     * @param j = jeu a afficher
     */
    public DessinZ(JeuZ j) {
        jeu = j;
    }

    /**
     * methode qui permet de dessiner le jeu
     */
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLUE);
        Personnage p = jeu.getAventurier();
        // on affiche le personnage en prenant soin de modifier les coordonnees pour s adapter 
        // a la taille des cases du jeu
        g.fillArc(p.getX() * TAILLE_CASE, p.getY() * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE, 0, 360);
    }

}