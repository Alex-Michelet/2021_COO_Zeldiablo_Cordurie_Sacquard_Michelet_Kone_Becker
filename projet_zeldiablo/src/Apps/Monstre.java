package Apps;

public abstract class Monstre implements Entite {

    private int posX, posY, vie, ptsAttaque;
    private boolean mort;

    public Monstre(int x, int y, int pv, int atk) {
        this.posX = x;
        this.posY = y;
        this.vie = pv;
        this.ptsAttaque = atk;
        this.mort = false;
    }

    public void attaquer(Entite victime) {
        victime.prendreDegats(ptsAttaque);
    }

    public void prendreDegats(int dgt) {
        int val = Math.abs(dgt);
        if (vie < val) {
            vie = 0;
        } else {
            vie -= val;
        }
    }

    public void deplacer(int x, int y) {
        if (!mort) {
            this.posX += x;
            this.posY += y;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPtsAttaque() {
        return ptsAttaque;
    }

    public int getVie() {
        return vie;
    }

    public boolean estMort() {
        return mort;
    }

}
