/**
 * Classe Arme
 * classe abstraite qui creee des armes
 * en decoulera plusieurs types d arme
 */
package Apps;

public abstract class Arme {
    int degat;
    int portee;
    Personnage perso;
    String typeArme;

    /**
     * Constructeur d une arme un arme fait des degats et a une porte d attaque
     * 
     * @param d = degats de l arme
     * @param p = portee de l arme
     * @param type = type de l arme
     */
    public Arme(int d, int p, String type){
        this.degat = d;
        this.portee = p;
        this.perso = null;
        this.typeArme = type;
    }

    /**
     * attaquer applique la methode subir degat d une entite et retire le nombre de
     * degats correspondant a l arme utilisee
     * 
     * @param e
     */
    public void attaquer(Entite e) {
        e.prendreDegats(this.degat);
    }

    /**
     * methode qui permet d affecter un personnage a l arme
     * @param p = le perso a affecter
     */
    public void setPerso(Personnage p) {
        this.perso = p;
    }

    /**
     * getter de la portee de l arme
     * @return la portee de l arme
     */
    public int getPortee() {
        return this.portee;
    }

    /**
     * getter des degats de l arme
     * @return les degats de l arme
     */
    public int getDegats(){
        return(this.degat);
    }

    /**
     * getter du peros de l arme
     * @return le perso affecte a l arme
     */
    public Personnage getPersonnage(){
        return(this.perso);
    }

    /**
     * getter du type de l arme
     * @return le type de l arme
     */
    public String getType(){
        return(this.typeArme);
    }
}
