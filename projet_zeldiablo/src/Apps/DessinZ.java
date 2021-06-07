package Apps;

import moteurJeu.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class DessinZ implements DessinJeu {

    JeuZ jeu;

    public DessinZ(JeuZ j) {
        jeu = j;
    }

    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        Personnage p = jeu.getAventurier();
        g.fillArc(p.getX(), p.getY(), 20, 20, 0, 360);
    }

}