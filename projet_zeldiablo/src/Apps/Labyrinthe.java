package Apps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Labyrinthe {
    private int xLong, yLong;
    private Case tab[][];

    /**
     * Constructeur d un Labyrinthe Un labyrinthe est compose de cases de types :
     * sol et mur Un labyrinthe lit un fichier texte et cree les cases en fonction
     * de celui ci quand il lit un S il cree un sol quand il lit un M il cree un mur
     * 
     * @param nomFichier
     */
    public Labyrinthe(String nomFichier) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(nomFichier)); // Lecteur
            String line = "";
            int j = 0;// Iterateur

            br.mark(0);
            while ((line = br.readLine()) != null) { // On parcourt le fichier pour connaître la taille du labyrinthe
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
            
            while ((line = br.readLine()) != null) { // On parcourt le fichier pour creer les cases correspondantes
                for (int i = 0; i < line.length(); i++) {
                    c = line.charAt(i);
                    if (c == 'S') {
                        tab[j][i] = new Sol(i, j);
                    } else if (c == 'M') {
                        tab[j][i] = new Mur(i, j);
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
     * @return tab
     */
    public Case[][] getTableauCases() {
        return this.tab;
    }

    /**
     * getTailleX
     * 
     * @return booleen indiquant si la case du labyrinthe est franchissable
     */

    public boolean estAccessible(int x, int y) {
        return (tab[y][x].estFranchissable());
    }
}
