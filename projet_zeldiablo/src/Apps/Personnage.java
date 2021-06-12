package Apps;

import java.util.Timer;
import java.util.TimerTask;
import java.lang.InterruptedException;
import java.lang.Thread;

/**
 * classe qui extends la classe abstraite entite et qui represente le personnage
 */
public class Personnage extends Entite {

    /**
     * attributs d un personnage
     */
    private int vieMax; // la vie maximale du personnage
    private boolean invincible; // boolean true si le personnage est invincible et false si il ne l est pas
    private Arme arme; // l arme du pesronnage null si il n en possede pas
    private final int invincibleCoolDown = 5000;

    /**
     * Constructeur d'un personnage initialisation des attributs invincible a false
     * vieMax a vie et arme a null
     * 
     * @param a   abscisse
     * @param o   ordonnee
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
     * @param vie = vie a ajouter au personnage
     */
    public void gagnerVie(int vie) {

        if (!this.etreMort()){

            if(this.getPv() + vie > this.vieMax){
                this.setPv(this.vieMax);
            } 
            else{
                this.setPv(this.getPv() + Math.abs(vie));
            }
        }
    }

    /**
     * methode qui decremente les pv actuels en prenant en compte l'etat du monstre
     * (invincibile, vivant...)
     * 
     * @param deg nombre de pv perdu
     */
    public void prendreDegats(int deg){
        int val = Math.abs(deg);

        if ((!invincible) && (!etreMort())) {

            invincible = true;

            if (this.getPv() < val) {
                this.setPv(0);
            } 
            else{
                this.setPv(this.getPv() - val);
            }

            if (this.getPv() == 0) {
                this.setMort(true);
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

        // si le personnage est a portee on peut peut etre attaquer
        if (this.getDistance(victime) <= this.getPortee()) {

            if (!this.etreMort()) {
                if (this.arme != null) {
                    this.arme.attaquer(victime);
                } else {
                    victime.prendreDegats(1);
                }
            }
        }

    }

    /**
     * methode qui permet de prendre une arme et qui donne un proprietaire a l arme
     * 
     * @param a arme a ramasser
     */
    public void prendreArme(Arme a) {
        if (this.arme == null && a != null) {
            this.arme = a;
            this.arme.setPerso(this);
        }
    }

    /**
     * methode qui repose l arme si le personnage en possede une
     * 
     * @return l arme que le personnage possede si il en a une ou null
     */
    public Arme poserArme() {
        Arme res = null;
        if (this.arme != null) {
            res = this.arme;
            this.arme.setPerso(null);
            this.arme = null;
        }
        return res;
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
     * @return true si le personnage est invincible false sinon
     */
    public boolean estInvincible() {
        return this.invincible;
    }

    /**
     * methode qui permet d'obtenir la portee du personnage
     * 
     * @return la portee du personnage
     */
    public int getPortee() {
        int res = 1;
        if (this.arme != null) {
            res = this.arme.getPortee();
        }
        return res;
    }

    /**
     * getter de l arme
     * 
     * @return
     */
    public Arme getArme() {
        return (this.arme);
    }

    /**
     * cooldown pour l'invincibilite
     */
    class Cooldown extends TimerTask {
        @Override
        public void run() {
            try {
                Thread.sleep(invincibleCoolDown);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            invincible = false;
        }
    }
}