/**
 * Classe Labyrinthe
 * modelise le labyrinthe dans lequel va se derouler le jeu
 * un labyrinthe est compose de case de type sol mur arme et piege
 */
package Apps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinthe {
    private int xLong, yLong;// longueur des lignes en x et y
    private Case tab[][];

    /**
     * Constructeur d un Labyrinthe Un labyrinthe est compose de cases de types :
     * sol et mur Un labyrinthe lit un fichier texte et cree les cases en fonction
     * de celui ci quand il lit un S il cree un sol quand il lit un M il cree un mur
     * 
     * @param nomFichier = chemin pour acceder au fichier du labyrinthe
     */
    public Labyrinthe(String nomFichier) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(nomFichier)); // Lecteur
            String line = "";
            int j = 0;// Iterateur

            br.mark(0);
            // On parcourt le fichier pour connaitre la taille du labyrinthe
            while ((line = br.readLine()) != null) { 
                // Longueur de la ligne
                this.xLong = line.length();
                // Nombre de ligne
                j++;
            }
            this.yLong = j;
            this.tab = new Case[this.yLong][this.xLong];

            j = 0;
            char c;

            br.close();
            br = new BufferedReader(new FileReader(nomFichier));

            // On parcourt le fichier pour creer les cases correspondantes
            while ((line = br.readLine()) != null) { 

                for(int i = 0; i < line.length(); i++){

                    c = line.charAt(i);

                    if(c == 'S'){
                        tab[j][i] = new Sol(i, j, null);
                    } 
                    else if(c == 'M'){
                        tab[j][i] = new Mur(i, j);
                    } 
                    else if (c == 'P'){
                        tab[j][i] = new Piege(i, j);
                    } 
                    else if (c == 'E'){
                        tab[j][i] = new Sol(i, j, new Epee());
                    } 
                    else if (c == 'L'){
                        tab[j][i] = new Sol(i, j, new Lance());
                    }
                    else if(c == 'C'){
                        tab[j][i] = new Sol(i, j, new Ceste());
                    }
                }
                j++;
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found Exception");
        } catch (IOException ioe) {
            System.out.println("IO Exception");
            ioe.printStackTrace();
        }
    }

    /**
     * estUnPiege Verifie si une case est un piege
     * 
     * @param a = abscisse de la case
     * @param o = ordonnee de la case
     * @return vraiq eu si la case est un piege
     */
    public boolean estUnPiege(int a, int o) {
        boolean p;
        if (tab[o][a] instanceof Piege) {
            p = true;
        } else {
            p = false;
        }
        return p;
    }

    /**
     * getTailleX
     * 
     * @return xLong
     */
    public int getTailleX() {
        return this.xLong;
    }

    /**
     * getTailleY
     * 
     * @return yLong
     */

    public int getTailleY() {
        return this.yLong;
    }

    /**
     * getTableauCase
     * 
     * @return le tableau de cases du labyrinthe
     */
    public Case[][] getTableauCases() {
        return this.tab;
    }

    /**
     * methode qui renvoie l arme du labyrinthe
     * @param x = abscisse de la case
     * @param y = ordonnee de la case
     * @return l arme potentielle qu il y a sur la case
     */
    public Arme getArmeCase(int x, int y) {
        return (tab[y][x].getArme());
    }

    /**
     * methode qui permet de savoir si la case indiquee est accessible
     * elle renvoie faux si les coordonnees sortent du tableau de cases
     * 
     * @param x = abscisse de la case
     * @param y = ordonnee de la case
     * 
     * @return vrai que si la case est franchissable
     */
    public boolean estAccessible(int x, int y) {
        boolean res = false;

        if(x >= 0 && x < this.xLong && y >= 0 && y < this.yLong){
            res = this.tab[y][x].estFranchissable();
        }
        return (res);
    }

    /**
     * methode qui permet de retirer une arme de la case du labyrinthe
     * 
     * @param x = abscisse de la case
     * @param y = ordonnee de la case
     */
    public void retirerArmeCase(int x, int y) {
        this.tab[y][x].retirerArme();
    }

    /**
     * methode qui permet d ajouter une arme sur l une des cases du labyrinthe
     * 
     * @param arme = arme a poser
     * @param x    = abscisse de la case
     * @param y    = ordonnee de la case
     */
    public void ajouterArmeCase(Arme arme, int x, int y) {
        this.tab[y][x].setArme(arme);
    }
}