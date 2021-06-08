package Apps;

import java.util.Timer;
import java.util.TimerTask;

public class Personnage {
    /**
     * coordonnees d'un personnage
     */
    private int posX, posY;
    private boolean invincible;

    /**
     * Constructeur d'un personnage avec ses coordonnees
     * 
     * @param a abscisse
     * @param o ordonnee
     */
    public Personnage(int a, int o) {
        this.posX = a;
        this.posY = o;
        this.invincible = false;
    }

    /**
     * deplacer le personnage dans une direction
     * 
     * @param c la chaine permettant de deplacer le personnage (N,S, E ou O)
     */
    public void deplacer(int x, int y) {
        this.posX += x;
        this.posY += y;
    }

    public void prendreDegat(int deg) {
        int val = Math.abs(deg);
        if ((!invincible) && (!etreMort())) {
            invincible = true;
            Timer t = new Timer();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Invulnerable BRAVO");
                    Thread.sleep(5 * 1000);
                    System.out.println("attention aie aie aie etc");
                    invincible = false;
                };
            };
            if (pv < val) {
                pv = 0;
            } else {
                pv -= val;
            }
            System.out.println("les degats sont pris : pv = " + getPv());

        }
    }

    /**
     * methode qui permet d'obtenir la coordonnee x du personnage
     * 
     * @return coordonnee x
     */
    public int getX() {
        return this.posX;
    }

    /**
     * methode qui permet d'obtenir la coordonnee y du personnage
     * 
     * @return coordonnee y
     */
    public int getY() {
        return this.posY;
    }
}