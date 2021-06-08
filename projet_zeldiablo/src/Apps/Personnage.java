package Apps;

import java.util.Timer;
import java.util.TimerTask;
import java.lang.InterruptedException;
import java.lang.Thread;

public class Personnage {
    /**
     * coordonnees d'un personnage
     */

    private int posX, posY, pv, vieMax;
    private boolean mort, invincible;

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
        this.pv = 15;
        this.vieMax = 15;
        this.mort = false;
    }

    /**
     * deplacer le personnage dans une direction
     * 
     * @param c la chaine permettant de deplacer le personnage (N,S, E ou O)
     */
    public void deplacer(int x, int y) {
        if (!mort) {
            this.posX += x;
            this.posY += y;
        }
    }

    /**
     * methode qui incremente les pv actuelles de vie
     * 
     * @param vie
     */
    public void gagnerVie(int vie) {
        if (!mort) {
            this.pv += Math.abs(vie);
        }
    }

    /**
     * methode qui decremente les pv actuelles de vie
     * 
     * @param deg
     */
    public void prendreDegats(int deg) {
        int val = Math.abs(deg);
        if ((!invincible) && (!etreMort())) {

            invincible = true;

            if (pv < val) {
                pv = 0;
            } else {
                pv -= val;
            }
            if (pv == 0) {
                this.mort = true;
            }

            TimerTask timerTask = new Cooldown();
            Timer timer = new Timer(true);
            timer.schedule(timerTask, 0);
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

    /**
     * methode qui permet d'obtenir la vie actuelle du personnage
     * 
     * @return pv
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * methode qui permet d'obtenir la vie maximal du personnage
     * 
     * @return vieMax
     */
    public int getVieMax() {
        return this.vieMax;
    }

    /**
     * methode qui permet de savoir si le personnage est mort si le boolean est true
     * et vivant si il est false
     * 
     * @return
     */
    public boolean etreMort() {
        return this.mort;
    }

    /**
     * methode qui permet de savoir si le personnage est invincible si le boolean
     * est true
     * 
     * @return
     */
    public boolean estInvincible() {
        return this.invincible;
    }

    class Cooldown extends TimerTask {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            invincible = false;
        }
    }
}