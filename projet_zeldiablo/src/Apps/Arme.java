package Apps;

public abstract class Arme {
    int degat;
    int portee;

    /**
     * Constructeur d une arme un arme fait des degats et a une porte d attaque
     * 
     * @param d
     * @param p
     */
    public Arme(int d, int p) {
        this.degat = d;
        this.portee = p;
    }

    /**
     * attaquer applique la methode subir degat d une entite et retire le nombre de
     * degats correspondant a l arme utilisee
     * 
     * @param e
     */
    public void attaquer(Entite e) {
        e.subirDegats(this.degat);
    }

}
