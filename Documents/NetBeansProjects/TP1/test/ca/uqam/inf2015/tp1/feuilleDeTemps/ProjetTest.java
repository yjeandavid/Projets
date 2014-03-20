package ca.uqam.inf2015.tp1.feuilleDeTemps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProjetTest {
    
    public ProjetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConstruireProjet() {
        System.out.println("construireProjet");
        int noProjet = 0;
        double minutes = 0.0;
        Projet expResult = null;
        Projet result = Projet.construireProjet(noProjet, minutes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNoProjet() {
        System.out.println("getNoProjet");
        Projet instance = null;
        int expResult = 0;
        int result = instance.getNoProjet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        Projet instance = null;
        double expResult = 0.0;
        double result = instance.getMinutes();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstTravailBureau() throws Exception {
        System.out.println("estTravailBureau");
        Projet instance = null;
        boolean expResult = false;
        boolean result = instance.estTravailBureau();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstTeleTravail() throws Exception {
        System.out.println("estTeleTravail");
        Projet instance = null;
        boolean expResult = false;
        boolean result = instance.estTeleTravail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstUnCongeMaladie() throws Exception {
        System.out.println("estUnCongeMaladie");
        Projet instance = null;
        boolean expResult = false;
        boolean result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstUnCongeFerie() throws Exception {
        System.out.println("estUnCongeFerie");
        Projet instance = null;
        boolean expResult = false;
        boolean result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstJourneeVacance() throws Exception {
        System.out.println("estJourneeVacance");
        Projet instance = null;
        boolean expResult = false;
        boolean result = instance.estJourneeVacance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstUnCongeParental() throws Exception {
        System.out.println("estUnCongeParental");
        Projet instance = null;
        boolean expResult = false;
        boolean result = instance.estUnCongeParental();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}