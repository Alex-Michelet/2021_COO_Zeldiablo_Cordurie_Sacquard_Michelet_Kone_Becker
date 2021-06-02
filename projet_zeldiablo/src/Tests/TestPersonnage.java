package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Apps.*;

public class TestPersonnage {
    
    /**
     * methode qui permet de tester qu un personnage se creer bien
     */
    @Test
    public void testCreaPerso(){

        //prepa des donnees
        Personnage p = new Personnage(2, 2);

        // verification
        assertEquals("L abscisse devrait etre de 2", 2, p.getX());
        assertEquals("L ordonnee devrait etre de 2", 2, p.getY());
    }

    /**
     * Test qui permet de verifier les deplacements
     */
    @Test
    public void testDeplacementPerso(){
        
        //prepa des donnee
        Personnage p = new Personnage(2, 2);

        //methode teste
        p.deplacer(3, 1);

        //verif
        assertEquals("L abscisse devrait etre de 5", 5, p.getX());
        assertEquals("L abscisse devrait etre de 3", 3, p.getY());
    }

}
