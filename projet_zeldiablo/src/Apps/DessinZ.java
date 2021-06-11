package Apps;

import moteurJeu.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

/**
 * Classe DessinZ qui implemente l'interface DessinJeu. Gere tout l'aspect
 * visuel du jeu
 */
public class DessinZ implements DessinJeu {

    /** Attribut jeu que l'on veut dessiner */
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
     * 
     * @param image
     */
    public void dessiner(BufferedImage image) {
        try {
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
            for (int i = 0; i < labyrinthe.getTailleX(); i++) {
                for (int j = 0; j < labyrinthe.getTailleY(); j++) {
                    if (tab[j][i] instanceof Mur) {
                        /*
                         * g.setColor(Color.RED); g.fillRect(i * lon, j * haut, lon, haut);
                         */

                        BufferedImage mur = ImageIO.read(new File("sprites/wall2.png"));
                        g.drawImage(mur, i * lon, j * haut, lon, haut, null);
                    } else if (tab[j][i] instanceof Sol) {
                        /*
                         * g.setColor(Color.GREEN); g.fillRect(i * lon, j * haut, lon, haut);
                         */

                        BufferedImage sol = ImageIO.read(new File("sprites/floor.png"));
                        g.drawImage(sol, i * lon, j * haut, lon, haut, null);
                        // de plus si il y a une arme sur le sol on l affiche
                        if (tab[j][i].getArme() != null) {

                            /*
                             * g.setColor(Color.LIGHT_GRAY); g.fillRect(i * lon + lon / 2, j * haut + haut /
                             * 2, lon - lon / 4, haut - haut / 4);
                             */

                            BufferedImage objetArme = ImageIO.read(new File("sprites/itemWeapon.png"));
                            g.drawImage(objetArme, i * lon, j * haut, lon, haut, null);

                        }
                    } else if (tab[j][i] instanceof Piege) {
                        /*
                         * g.setColor(Color.BLACK); g.fillRect(i * lon, j * haut, lon, haut);
                         */

                        BufferedImage piege = ImageIO.read(new File("sprites/trap.png"));
                        g.drawImage(piege, i * lon, j * haut, lon, haut, null);
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
            BufferedImage hero;
            if (p.etreMort()) {
                // g.setColor(Color.CYAN);
                hero = ImageIO.read(new File("sprites/HeroKO.png"));
            } else {
                if (p.estInvincible()) {
                    // g.setColor(Color.PINK);
                    hero = ImageIO.read(new File("sprites/InvincibleHero.png"));
                } else {
                    // g.setColor(Color.BLUE);
                    hero = ImageIO.read(new File("sprites/Hero.png"));
                }
            }
            // g.fillArc(p.getX() * lon, p.getY() * haut, lon, haut, 0, 360);
            g.drawImage(hero, p.getX() * lon, p.getY() * haut, lon, haut, null);

            ArrayList<Monstre> list = jeu.getListeMonstre();
            for (int i = 0; i < list.size(); i++) {
                int xMonstre = list.get(i).getX();
                int yMonstre = list.get(i).getY();
                /*
                 * g.setColor(Color.MAGENTA); g.fillArc(xMonstre * lon, yMonstre * haut, lon,
                 * haut, 0, 360);
                 */
                BufferedImage troll = ImageIO.read(new File("sprites/troll.png"));
                g.drawImage(troll, xMonstre * lon, yMonstre * haut, lon, haut, null);
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception");
        }
    }

}