package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.InterruptedException;
import java.util.concurrent.TimeUnit;
import Apps.*;
import jdk.jfr.Timestamp;

public class TestPersonnage {

    /**
     * methode qui permet de tester qu un personnage se creer bien
     */
    @Test
    public void testCreaPerso() {

        // prepa des donnees
        Personnage p = new Personnage(2, 2, 15);

        // verification
        assertEquals("L abscisse devrait etre de 2", 2, p.getX());
        assertEquals("L ordonnee devrait etre de 2", 2, p.getY());
    }

    /**
     * test qui permet de verifier si le personnage perd de la vie
     */
    @Test
    public void testPrendreDegatsEtInvincible() {
        // prepa des donnee
        Personnage p = new Personnage(2, 2, 15);

        // methode teste
        p.prendreDegats(3);// les degats sont pris
        p.prendreDegats(3);// le joueur est invincible et ne prend pas ces degats

        // verif
        assertEquals("la vie devrait etre de 12", 12, p.getPv());
        assertEquals("le joueur devrait etre invincible", true, p.estInvincible());

        // Attente de 5 secondes
        try {
            TimeUnit.MILLISECONDS.sleep(5010);
        } catch (InterruptedException e) {
            System.out.println("probleme");
        }
        // fin de l'invincibilite, les degats sont pris
        p.prendreDegats(3);
        assertEquals("le joueur ne devrait plus etre invincible", true, p.estInvincible());
        assertEquals("la vie devrait etre de 9", 9, p.getPv());

        // Attente de 4 secondes
        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("probleme");
        }
        // toujours invincible, pas de degats
        p.prendreDegats(3);
        assertEquals("le joueur ne devrait plus etre invincible", true, p.estInvincible());
        assertEquals("la vie devrait etre de 9", 9, p.getPv());

        // Attente de 5 secondes, fin de l'invincibilite
        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("probleme");
        }
        assertEquals("le joueur ne devrait plus etre invincible", false, p.estInvincible());
        assertEquals("la vie devrait etre de 9", 9, p.getPv());
        System.out.println("Fin du test");
    }

    @Test
    public void testPrendreDegatsInvincible() {
        // prepa des donnee
        Personnage p = new Personnage(2, 2, 15);

        // methode teste
        p.prendreDegats(3);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("probleme");
        }

        assertEquals("le joueur ne devrait plus etre invincible", false, p.estInvincible());
        assertEquals("la vie devrait etre de 12", 12, p.getPv());
    }

    /**
     * test qui permet de verifier si le personnage gagne de la vie
     */
    @Test
    public void testGagnerVie() {
        // prepa des donnee
        Personnage p = new Personnage(2, 2, 15);
        p.prendreDegats(3);

        // methode teste
        p.gagnerVie(1);

        // verif
        assertEquals("la vie devrait etre de 13", 13, p.getPv());
    }

    /**
     * Test qui permet de verifier les deplacements
     */
    @Test
    public void testDeplacer() {

        // prepa des donnee
        Personnage p = new Personnage(2, 2, 15);

        // methode teste
        p.deplacer(3, 1);

        // verif
        assertEquals("L abscisse devrait etre de 5", 5, p.getX());
        assertEquals("L ordonnee devrait etre de 3", 3, p.getY());

    }

    /**
     * test qui permet de verifier que le personnage ne peux pas se deplacer si il
     * est mort
     */
    @Test
    public void testDeplacerPersoMort() {
        // prepa des donnee
        Personnage p = new Personnage(2, 2, 15);
        p.prendreDegats(15);

        // methode teste
        p.deplacer(3, 1);

        // verif
        assertEquals("L abscisse devrait etre de 2", 2, p.getX());
        assertEquals("L ordonnee devrait etre de 2", 2, p.getY());
        assertEquals("la vie devrait etre a 0", 0, p.getPv());
    }
}
