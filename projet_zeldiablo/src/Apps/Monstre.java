package Apps;

/**
 * classe abstraite qui extends entite et qui defini un monstre
 */
public abstract class Monstre extends Entite {
    /**
     * attributs du monstre 
     */
    private int ad; // degats du monstre
    private int portee; // portee du monstre
    private String type;

    /**
     * Constructeur d'un monstre
     * 
     * @param a   abscisse
     * @param o   ordonnee
     * @param vie points de vie
     * @param atk points d'attaque
     * @param port portee
     * @param type_monstre = le type de monstre que l on cree
     */
    public Monstre(int a, int o, int vie, int atk, int port, String type_monstre){
        super(a, o, vie);
        this.ad = atk;
        this.portee = port;
        this.type = type_monstre;
    }

    /**
     * methode qui permet d attaque une un victime
     * que si il n est pas mort et si il est a portee
     * 
     * @param victime = victime a attaquer
     */
    public void attaquer(Entite victime){
        if(this.getDistance(victime) <= this.portee){
            if(!this.etreMort()){
                victime.prendreDegats(this.ad);
            }

        }
    }

    /**
     * methode qui permet a un monstre de subir des degats
     * 
     * @param dgt = nombre de pv a retirer
     */
    public void prendreDegats(int dgt) {
        int val = Math.abs(dgt);

        if (this.getPv() < val) {
            this.setPv(0);
            this.setMort(true);
        } else {
            this.setPv(this.getPv() - val);
        }
    }

    /**
     * methode qui permet d'obtenir l'attaque du monstre
     * 
     * @return points d'attaque
     */
    public int getAd() {
        return ad;
    }

    /**
     * methode qui permet d'obtenir la portee du monstre
     * 
     * @return la portee du monstres
     */
    public int getPortee() {
        return this.portee;
    }

    /**
     * getter du type de monstre
     * @return le type du monstre
     */
    public String getType(){
        return(this.type);
    }
}