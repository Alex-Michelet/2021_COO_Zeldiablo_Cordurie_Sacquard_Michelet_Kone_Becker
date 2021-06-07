package Apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class Labyrinthe {
    private int xLong, yLong;
    private Case tab[][];

    /**
     * Constructeur d un Labyrinthe Un labyrinthe est compose de cases de types :
     * sol et mur Un labyrinthe lit un fichier texte et cree les cases en fonction
     * de celui ci quand il lit un S il cree un sol quand il lit un M il cree un mur
     */
    public Labyrinthe(String nomFichier) {
        try {

            this.tab = new Case[this.yLong][this.xLong];
            // Lecteur
            BufferedReader br = new BufferedReader(new FileReader(nomFichier));
            String line = "";
            int j = 0;// Iterateur
            while ((line = br.readLine()) != null) {
                // Longueur de la ligne
                this.xLong = line.length();
                // Nombre de ligne
                j++;
            }
            this.yLong = j;
            j = 0;
            char c;

            while ((line = br.readLine()) != null) {
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
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found Exception");
        } catch (IOException ioe) {
            System.out.println("IO Exception");
        }
    }

    // getters
    public int getTailleX() {
        return this.xLong;
    }

    public int getTailleY() {
        return this.yLong;
    }

    public Case[][] getTableauCases() {
        return this.tab;
    }

    public boolean estAccessible(int x, int y) {
        return (tab[y][x].estFranchissable());
    }
}
