package Apps;

public class Ceste extends Arme {

    /**
     * constructeur d un ceste qui possede 1 de degat et 1 de portee
     */
    public Ceste() {
        super(1, 1);
    }

    public void attaquer(Entite e) {
        super.attaquer(e);
        this.perso.gagnerVie(1);
    }
}