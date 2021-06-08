package Apps;

public interface Entite {
    public void attaquer(Entite victime);
    public void prendreDegats(int dgt);
    public boolean deplacer(int x, int y);
}