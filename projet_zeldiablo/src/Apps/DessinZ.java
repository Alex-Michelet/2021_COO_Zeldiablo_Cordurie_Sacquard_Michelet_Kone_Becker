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

        // on recupere les dimensions de la fenetre
        int w = image.getWidth();
        int h = image.getHeight();

        Labyrinthe labyrinthe = jeu.getLabyrinthe();
        // on defini les dimensions de la cases par rapport a la taille de la fenetre
        // et le nombre de cases choisi
        int lon = w / labyrinthe.getTailleX();
        int haut = h / labyrinthe.getTailleY();

        Case tab[][] = labyrinthe.getTableauCases();
        for (int i = 0; i < lon; i++) {
            for (int j = 0; j < haut; j++) {
                if (tab[j][i] instanceof Mur) {
                    g.setColor(Color.RED);
                    g.fillRect(i * lon, j * haut, lon, haut);
                } else if (tab[j][i] instanceof Sol) {
                    g.setColor(Color.GREEN);
                    g.fillRect(i * lon, j * haut, lon, haut);
                } else if (tab[j][i] instanceof Piege) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * lon, j * haut, lon, haut);
                } else {
                    System.out.println("Case non reconnue");
                }
            }
        }

        // on recupere le personnage du jeu
        Personnage p = jeu.getAventurier();

        // on affiche le personnage en prenant soin de modifier les coordonnees pour s
        // adapter
        // a la taille des cases du jeu
        g.setColor(Color.BLUE);
        g.fillArc(p.getX() * lon, p.getY() * haut, lon, haut, 0, 360);
    }

}