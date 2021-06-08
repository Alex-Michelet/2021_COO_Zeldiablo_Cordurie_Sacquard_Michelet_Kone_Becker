package Tests;

import Apps.*;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestLabyrinthe {

    /**
     * test de la construction d un labyrinthe simple
     */
    @Test
    public void testCreaLabyrinthe(){
        //prepa des donnees
        Labyrinthe l = new Labyrinthe("niveaux/lab1.txt");

        //verification des donnees
        assertEquals("La case devrait etre un mur donc inaccessible", false, l.estAccessible(0, 0));
        assertEquals("La case devrait etre un sol donc accessible", true, l.estAccessible(1, 1));
    }
    
}