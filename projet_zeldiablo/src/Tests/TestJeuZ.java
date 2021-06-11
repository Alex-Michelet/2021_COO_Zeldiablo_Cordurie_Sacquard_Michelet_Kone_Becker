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
        Personnage p = new Personnage(1,1, 15);
        Labyrinthe l = new Labyrinthe("niveaux/lab1.txt");
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
        Personnage p = new Personnage(2,3, 15);
        Labyrinthe l = new Labyrinthe("niveaux/lab1.txt");
        JeuZ j = new JeuZ(p, l);
        Commande c = new Commande();
        c.bas = true;

        //methode teste 
        j.deplacerPerso(c);

        //verif des donnees
        assertEquals("x devrait etre à 2", 2, j.getAventurier().getX());
        assertEquals("y devrait etre à 4", 4, j.getAventurier().getY());
    }

    /**
     * test deplacement sur un mur
     */
    @Test 
    public void testEvoluerMur() {
        //prepa des donnees 
        Personnage p = new Personnage(1,1, 15);
        Labyrinthe l = new Labyrinthe("niveaux/lab1.txt");
        JeuZ j = new JeuZ(p, l);
        Commande c = new Commande();
        c.gauche = true;
        //methode teste 
        j.evoluer(c);

        //verif des donnees
        assertEquals("x devrait rester à 1", 1, j.getAventurier().getX());
        assertEquals("y devrait etre à 1", 1, j.getAventurier().getY());

    }

    /**
     * test d un deplacement du perso sur un monstre
     * le perso ne doit pas bouger
     * il y a un montre en 1, 2
     */
    @Test
    public void testDeplacementSurEntite(){
        //prepa des donnees 
        Personnage p = new Personnage(1,1, 15);
        Labyrinthe l = new Labyrinthe("niveaux/lab1.txt");
        JeuZ j = new JeuZ(p, l);
        Commande c = new Commande();
        c.bas = true;
        //methode teste 
        j.evoluer(c);

        //verif des donnees
        assertEquals("x devrait rester à 1", 1, j.getAventurier().getX());
        assertEquals("y devrait etre à 1", 1, j.getAventurier().getY());
    }

    /**
     * test de la prise d arme dans le labyrinthe
     */
    @Test
    public void testPriseArme(){
        //prepa des donnees 
        Personnage p = new Personnage(8,1, 15);
        Labyrinthe l = new Labyrinthe("niveaux/lab2.txt");
        JeuZ j = new JeuZ(p, l);
        Commande c = new Commande();
        c.prendreArme = true;
        //methode teste 
        j.evoluer(c);

        //verif des donnees
        assertEquals("le perso devrait avoir une lance", true, p.getArme() instanceof Lance);
        assertEquals("La case devrait etre vide", null, l.getArmeCase(8, 1));
    }

    /**
     * test depose d arme quand le perso en a une
     * la case doit avoir l arme et le perso plus rien
     */
    @Test
    public void testDeposeArme(){
        //prepa des donnees 
        Personnage p = new Personnage(8,1, 15);
        Labyrinthe l = new Labyrinthe("niveaux/lab2.txt");
        JeuZ j = new JeuZ(p, l);
        Commande c = new Commande();
        c.prendreArme = true;

        //methode teste 
        j.evoluer(c);

        // premiere verif
        assertEquals("le perso devrait avoir une lance", true, p.getArme() instanceof Lance);
        assertEquals("La case devrait etre vide", null, l.getArmeCase(8, 1));

        // on est oblige d attendre un peu avant de relancer une commande
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Probleme d attente");
        }

        // relance de la methode
        c.prendreArme = true;
        j.evoluer(c);

        //verif des donnees
        assertEquals("le perso ne devrait pas etre arme", null, p.getArme());
        assertEquals("le case devrait avoir une lance", true, l.getArmeCase(8, 1) instanceof Lance);
    }

}