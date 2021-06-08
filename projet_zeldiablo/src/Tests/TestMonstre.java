package Tests;

import Apps.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestMonstre {

    /**
     * test de la creation d un monstre
     */
    @Test
    public void testCreationMonstre(){
        //prepa des donnees
        Troll t = new Troll(3, 3);

        // verifiation
        assertEquals("Le troll devrait etre en abscisse 3", 3, t.getX());
        assertEquals("Le troll devrait etre en ordonnee 3", 3, t.getY());
    }

    /**
     * test methode subirDegats
     * qui doit retirer des pv au monstre
     */
    @Test
    public void testPrendreDegats(){
        //prepa des donnees
        Troll t = new Troll(2, 2);

        //methode testee
        t.prendreDegats(2);

        // verif
        assertEquals("Le troll devrait avoir 3 pv", 3, t.getPv());

        //methode testee
        t.prendreDegats(2);

        // verif
        assertEquals("Le troll devrait avoir 1 pv", 1, t.getPv());

        //methode testee
        t.prendreDegats(2);

        // verif
        assertEquals("Le troll devrait avoir 0 pv", 0, t.getPv());
        assertEquals("Le monstre devrait etre mort", true, t.etreMort());

    }

    /**
     * test methode de deplacement
     */
    @Test
    public void testDeplacement(){
        // prepa des donnees
        Troll t = new Troll(3, 1);

        //methode testee
        t.deplacer(-1, 5);

        //verif
        assertEquals("L abscisse devrait etre 2", 2, t.getX());
        assertEquals("L abscisse devrait etre 6", 6, t.getY());
    }
    
}
