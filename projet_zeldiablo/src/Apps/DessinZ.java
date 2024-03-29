package Apps;

import moteurJeu.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

/**
 * Classe DessinZ qui implemente l'interface DessinJeu. Gere tout l'aspect
 * visuel du jeu
 */
public class DessinZ implements DessinJeu {

    /** Attribut jeu que l'on veut dessiner */
    JeuZ jeu;
    BufferedImage mur, piege, sol, epee, lance, ceste, persoMort, perso, persoInv, troll, fant;

    /**
     * constructeur qui permet au dessin de connaitre le jeu a afficher
     * 
     * @param j = jeu a afficher
     */
    public DessinZ(JeuZ j) {
        jeu = j;

        // on prepare les images
        try {

            // prepa des types de cases
            this.mur = ImageIO.read(new File("sprites/wall2.png"));
            this.sol = ImageIO.read(new File("sprites/floor.png"));
            this.piege = ImageIO.read(new File("sprites/trap.png"));

            // prepa des types d armes
            this.epee = ImageIO.read(new File("sprites/sword.png"));
            this.lance = ImageIO.read(new File("sprites/mySpear2.png"));
            this.ceste = ImageIO.read(new File("sprites/ceste.png"));

            // prepa etats du personnage
            this.perso = ImageIO.read(new File("sprites/Hero.png"));
            this.persoInv = ImageIO.read(new File("sprites/InvincibleHero.png"));
            this.persoMort = ImageIO.read(new File("sprites/HeroKO.png"));

            //prepa des types de monstres
            this.troll = ImageIO.read(new File("sprites/troll.png"));
            this.fant = ImageIO.read(new File("sprites/ghost.png"));
            
        } catch (IOException e) {
            System.out.println("Probleme pour trouver les images");
        }
    }

    /**
     * methode qui permet de dessiner le jeu
     * 
     * @param image
     */
    public void dessiner(BufferedImage image) {

        // on recupere le contexte graphique
        Graphics2D g = (Graphics2D) image.getGraphics();

        // on recupere les dimensions de la fenetre
        int w = image.getWidth();
        int h = image.getHeight();

        // on recupere le labyrinthe du jeu
        Labyrinthe labyrinthe = jeu.getLabyrinthe();

        // on defini les dimensions de la cases par rapport a la taille de la fenetre
        // et le nombre de cases choisi
        int lon = w / labyrinthe.getTailleX();
        int haut = h / labyrinthe.getTailleY();

        // on parcours le labyrinthe du jeu pour afficher les types de cases
        for(int i = 0; i < labyrinthe.getTailleX(); i++){
            for(int j = 0; j < labyrinthe.getTailleY(); j++){

                // si la case n est pas franchissable c est un mur
                if(!labyrinthe.estAccessible(i, j)){
                    /*
                     * g.setColor(Color.RED); g.fillRect(i * lon, j * haut, lon, haut);
                     */

                    g.drawImage(this.mur, i * lon, j * haut, lon, haut, null);

                } 
                else if(labyrinthe.estAccessible(i, j)){

                    // si la case est franchissable c est un sol ou un piege
                    if(labyrinthe.estUnPiege(i, j)){
                        g.drawImage(this.piege, i * lon, j * haut, lon, haut, null);
                    }
                    else{
                        g.drawImage(this.sol, i * lon, j * haut, lon, haut, null);
                    }

                    /*
                     * g.setColor(Color.GREEN); g.fillRect(i * lon, j * haut, lon, haut);
                     */


                    // de plus si il y a une arme sur la case on l affiche
                    if(labyrinthe.getArmeCase(i, j) != null){

                        Arme a = labyrinthe.getArmeCase(i, j);
                        String typeArme = a.getType();

                        // si la portee est de 1 c est une epee
                        if(typeArme.equals("epee")){
                            g.drawImage(this.epee, i * lon, j * haut, lon, haut, null);
                        }
                        else if(typeArme.equals("lance")){

                            // si la portee est de 2 c est une lance
                            g.drawImage(this.lance, i * lon, j * haut, lon, haut, null);
                        }
                        else if(typeArme.equals("ceste")){
                            g.drawImage(this.ceste, i * lon, j * haut, lon, haut, null);
                        }

                        /*
                         * g.setColor(Color.LIGHT_GRAY); g.fillRect(i * lon + lon / 2, j * haut + haut /
                         * 2, lon - lon / 4, haut - haut / 4);
                         */


                    }
                }
            }
        }

        // on recupere le personnage du jeu
        Personnage p = jeu.getAventurier();

        // on affiche le personnage en prenant soin de modifier les coordonnees pour s
        // adapter
        // a la taille des cases du jeu

        if(p.etreMort()){
            g.drawImage(this.persoMort, p.getX() * lon, p.getY() * haut, lon, haut, null);
        } 
        else{

            if(p.estInvincible()){
                // g.setColor(Color.PINK);
                g.drawImage(this.persoInv, p.getX() * lon, p.getY() * haut, lon, haut, null);
            } 
            else{
                // g.setColor(Color.BLUE);
                g.drawImage(this.perso, p.getX() * lon, p.getY() * haut, lon, haut, null);
            }
        }

        // on dessine une barre de vie pour le personnage
        int longueurBarreVie = (p.getPv() * lon)/p.getVieMax();
        g.setColor(Color.RED);
        g.fillRect(p.getX() * lon, (p.getY() + 1) * haut - haut/8, longueurBarreVie, haut/8);

        // g.fillArc(p.getX() * lon, p.getY() * haut, lon, haut, 0, 360);

        ArrayList<Monstre> list = jeu.getListeMonstre();

        for(int i = 0; i < list.size(); i++){

            Monstre m = list.get(i);

            int xMonstre = m.getX();
            int yMonstre = m.getY();
            /*
             * g.setColor(Color.MAGENTA); g.fillArc(xMonstre * lon, yMonstre * haut, lon,
             * haut, 0, 360);
             */
            String typeMonstre = m.getType();

            // si les donnes correspondent a celle d un troll on dessine un troll
            if(typeMonstre.equals("troll")){
                g.drawImage(this.troll, xMonstre * lon, yMonstre * haut, lon, haut, null);

                // on dessine une barre de vie pour le troll
                longueurBarreVie = (m.getPv() * lon)/5;
                g.setColor(Color.RED);
                g.fillRect(m.getX() * lon, (m.getY() + 1) * haut - haut/8, longueurBarreVie, haut/8);
            }
            else if(typeMonstre.equals("fantome")){
                // de meme si elles correspondent a celle d un fantome
                g.drawImage(this.fant, xMonstre * lon, yMonstre * haut, lon, haut, null);

                // on dessine une barre de vie pour le fantome
                longueurBarreVie = (m.getPv() * lon)/5;
                g.setColor(Color.RED);
                g.fillRect(m.getX() * lon, (m.getY() + 1) * haut - haut/8, longueurBarreVie, haut/8);
            }

        }
    }

}