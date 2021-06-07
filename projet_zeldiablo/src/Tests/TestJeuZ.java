package Tests;

import Apps.*;

import static org.junit.Assert.*;
import org.junit.Test;
import moteurJeu.Commande;

public class TestJeuZ {
    /**
     * test de la construction d'un jeu
     */
    @Test 
    public void testCreaJeuZ() {
        // prepa des donnees 
        Personnage p = new Personnage(1,1);
        Labyrinthe l = new Labyrinthe("../../Niveaux/lab1.txt");
        JeuZ j = new JeuZ(p, l);

        // verif des donnees
        assertEquals("Il devrait y avoir un personnage", p, j.getAventurier());
        assertEquals("Il devrait y avoir un labyrinthe", l, j.getLabyrinthe());
    }

    /**
     * test deplacement dans un labyrinthe
     */
    @Test 
    public void testEvoluer() {
        // prepa des donnees
        Personnage p = new Personnage(1,1);
        Labyrinthe l = new Labyrinthe("../../niveaux/lab1.txt");
        JeuZ j = new JeuZ(p, l);
        Commande c = new Commande();
        //methode teste 
        j.evoluer(c.bas);
        //verif des donnees
        assertEquals("x devrait etre à 1", 1, j.getAventurier().getX());
        assertEquals("y devrait etre à 2", 2, j.getAventurier().getY());
    }

    /**
     * test deplacement sur un mur
     */
    @Test 
    public void testEvoluerMur() {
        //prepa des donnees 
        Personnage p = new Personnage(1,1);
        Labyrinthe l = new Labyrinthe("../../niveaux/lab1.txt");
        JeuZ j = new JeuZ(p, l);
        Commande c = new Commande();
        //methode teste 
        j.evoluer(c.gauche);
        //verif des donnees
        assertEquals("x devrait rester à 1", 1, j.getAventurier().getX());
        assertEquals("y devrait etre à 1", 1, j.getAventurier().getY());

    }

}