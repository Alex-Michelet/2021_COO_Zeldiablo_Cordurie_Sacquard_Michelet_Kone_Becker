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
     * test qui permet de verifier si le personnage perd de la vie
     */
    @Test 
    public void testPerdreVie() {
        //prepa des donnee
        Personnage p = new Personnage(2, 2);

        //methode teste
        p.perdreVie(3);

        //verif
        assertEquals("la vie devrait etre de 12", 12, p.getPv());
    }

    /**
     * test qui permet de verifier si le personnage gagne de la vie 
     */
    @Test 
    public void testGagnerVie() {
        //prepa des donnee
        Personnage p = new Personnage(2, 2);
        p.perdreVie(3);

        //methode teste
        p.gagnerVie(1);

        //verif
        assertEquals("la vie devrait etre de 13", 13, p.getX());
    }
    /**
     * Test qui permet de verifier les deplacements
     */
    @Test
    public void testDeplacer(){
        
        //prepa des donnee
        Personnage p = new Personnage(2, 2);

        //methode teste
        p.deplacer(3, 1);

        //verif
        assertEquals("L abscisse devrait etre de 5", 5, p.getX());
        assertEquals("L ordonnee devrait etre de 3", 3, p.getY());
        
    }

    /**
     * test qui permet de verifier que le personnage ne peux pas se deplacer si il est mort
     */
    @Test 
    public void testDeplacerPersoMort() {
        //prepa des donnee
        Personnage p = new Personnage(2, 2);
        p.perdreVie(15);

        //methode teste
        p.deplacer(3, 1);

        //verif
        assertEquals("L abscisse devrait etre de 2", 2, p.getX());
        assertEquals("L ordonnee devrait etre de 2", 2, p.getY());
        assertEquals("la vie devrait etre a 0", 0, p.getPv());
    }
}
