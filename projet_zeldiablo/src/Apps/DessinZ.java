package Apps;

import moteurJeu.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

public class DessinZ implements DessinJeu {

    JeuZ jeu;

    /**
     * constructeur qui permet au dessin de connaitre le jeu a afficher
     * 
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

        // on recupere les dimensions de la fenetre
        int w = image.getWidth();
        int h = image.getHeight();

        // on defini les dimensions de la cases par rapport a la taille de la fenetre
        // et le nombre de cases choisi
        int lon = w / jeu.getLabyrinthe().getXLong();
        int haut = h / jeu.getLabyrinthe().getYLong();

        // on recupere le personnage du jeu
        Personnage p = jeu.getAventurier();

        // on affiche le personnage en prenant soin de modifier les coordonnees pour s
        // adapter
        // a la taille des cases du jeu
        g.fillArc(p.getX() * lon, p.getY() * haut, lon, haut, 0, 360);
    }

}