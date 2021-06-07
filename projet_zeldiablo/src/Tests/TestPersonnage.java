package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Apps.*;
import jdk.jfr.Timestamp;
import moteurJeu.*;

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
        p.deplacer(c.gauche);

        //verif
        assertEquals("L abscisse devrait etre de 1", 1, p.getX());
        
    }

    /**
     * Test qui permet de verifier si le personnage ne peux pas se deplacer en dehors de l environnement 
     */
    @Test 
    public void testDeplacementPersoDehors() {
        //prepa des donnee
        Personnage p = new Personnage(0, 0);

        //methode teste
        p.deplacer(c.gauche);

        //verif
        assertEquals("L abscisse devrait rester à 0", 0, p.getX());
    }
    

}
