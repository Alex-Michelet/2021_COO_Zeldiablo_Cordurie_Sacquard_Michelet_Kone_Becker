package Apps;

import java.util.Timer;
import java.util.TimerTask;
import java.lang.InterruptedException;
import java.lang.Thread;

public class Personnage implements Entite {
    /**
     * coordonnees d'un personnage
     */

    private int vieMax;
    private boolean invincible;
    private Arme arme;

    /**
     * Constructeur d'un personnage initialisation des attributs
     * 
     * @param a abscisse
     * @param o ordonnee
     * @param vie vie
     */
    public Personnage(int a, int o, int vie) {
        super(a, o, vie);
        this.invincible = false;
        this.vieMax = vie;
        this.arme = null;
    }

    /**
     * methode qui incremente les pv actuelles de vie
     * 
     * @param vie
     */
    public void gagnerVie(int vie) {
        if (!mort ) {
            this.pv += Math.abs(vie);
        }
    }

    /**
     * methode qui decremente les pv actuels en prenant en compte l'etat du monstre
     * (invincibile, vivant...)
     * 
     * @param deg nombre de pv perdu
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
     * methode qui permet d attaquer une entite
     * 
     * @param victime
     */
    public void attaquer(Entite victime) {
        if (!mort) {
            if (this.arme != null) {
                this.arme.attaquer(victime);
            } else {
                victime.prendreDegats(1);
            }
        }
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
     * methode qui permet de savoir si le personnage est invincible si le boolean
     * est true
     * 
     * @return
     */
    public boolean estInvincible() {
        return this.invincible;
    }

    /**
     * timer pour l'invincibilite 
     */
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