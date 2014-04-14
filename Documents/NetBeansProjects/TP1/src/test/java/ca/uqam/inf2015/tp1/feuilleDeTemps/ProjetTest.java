package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;
import java.io.IOException;
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
    public static void setUpClass() throws IOException {
        AppConfig.chargerParametres();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
   
    @Test
    public void testConstruireProjet() {
        System.out.println("construireProjet");
        int noProjet = 110;
        double minutes = 0.0;
        Projet result = null;
        result = Projet.construireProjet(noProjet, minutes);
        assertNotNull(result);
    }

    @Test
    public void testGetNoProjet() {
        System.out.println("getNoProjet");
        Projet instance = Projet.construireProjet(110, 300.0);
        int expResult = 110;
        int result = instance.getNoProjet();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        Projet instance = Projet.construireProjet(110, 300.0);
        double expResult = 300.0;
        double result = instance.getMinutes();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testEstTravailBureau() throws Exception {
        System.out.println("estTravailBureau");
        Projet instance = Projet.construireProjet(902, 500.0);
        boolean expResult = false;
        boolean result = instance.estTravailBureau();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(125, 420.0);
        expResult = true;
        result = instance.estTravailBureau();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(999, 420.0);
        expResult = false;
        result = instance.estTravailBureau();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(900, 420.0);
        expResult = true;
        result = instance.estTravailBureau();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(998, 420.0);
        expResult = false;
        result = instance.estTravailBureau();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(997, 420.0);
        expResult = false;
        result = instance.estTravailBureau();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(996, 420.0);
        expResult = false;
        result = instance.estTravailBureau();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(777, 5.0);
        expResult = false;
        result = instance.estTravailBureau();
        assertEquals(expResult, result);
    
    }

    @Test
    public void testEstTeleTravail() throws Exception {
        System.out.println("estTeleTravail");
        Projet instance = Projet.construireProjet(902, 500.0);
        boolean expResult = true;
        boolean result = instance.estTeleTravail();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(125, 420.0);
        expResult = false;
        result = instance.estTeleTravail();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(999, 420.0);
        expResult = false;
        result = instance.estTeleTravail();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(990, 420.0);
        expResult = true;
        result = instance.estTeleTravail();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(998, 420.0);
        expResult = false;
        result = instance.estTeleTravail();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(997, 420.0);
        expResult = false;
        result = instance.estTeleTravail();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(996, 420.0);
        expResult = false;
        result = instance.estTeleTravail();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(777, 5.0);
        expResult = false;
        result = instance.estTeleTravail();
        assertEquals(expResult, result);
    
    }

    @Test
    public void testEstUnCongeMaladie() throws Exception {
        System.out.println("estUnCongeMaladie");
        Projet instance = Projet.construireProjet(902, 500.0);
        boolean expResult = false;
        boolean result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(125, 420.0);
        expResult = false;
        result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(999, 420.0);
        expResult = true;
        result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(990, 420.0);
        expResult = false;
        result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(998, 420.0);
        expResult = false;
        result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(997, 420.0);
        expResult = false;
        result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(996, 420.0);
        expResult = false;
        result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(777, 5.0);
        expResult = false;
        result = instance.estUnCongeMaladie();
        assertEquals(expResult, result);
    
    }

    @Test
    public void testEstUnCongeFerie() throws Exception {
        System.out.println("estUnCongeFerie");
        Projet instance = Projet.construireProjet(902, 500.0);
        boolean expResult = false;
        boolean result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(125, 420.0);
        expResult = false;
        result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(999, 420.0);
        expResult = false;
        result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(990, 420.0);
        expResult = false;
        result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(998, 420.0);
        expResult = true;
        result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(997, 420.0);
        expResult = false;
        result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(996, 420.0);
        expResult = false;
        result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(777, 5.0);
        expResult = false;
        result = instance.estUnCongeFerie();
        assertEquals(expResult, result);
    
    }

    @Test
    public void testEstJourneeVacance() throws Exception {
        System.out.println("estJourneeVacance");
        Projet instance = Projet.construireProjet(902, 500.0);
        boolean expResult = false;
        boolean result = instance.estJourneeVacance();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(125, 420.0);
        expResult = false;
        result = instance.estJourneeVacance();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(999, 420.0);
        expResult = false;
        result = instance.estJourneeVacance();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(990, 420.0);
        expResult = false;
        result = instance.estJourneeVacance();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(998, 420.0);
        expResult = false;
        result = instance.estJourneeVacance();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(997, 420.0);
        expResult = true;
        result = instance.estJourneeVacance();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(996, 420.0);
        expResult = false;
        result = instance.estJourneeVacance();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(777, 5.0);
        expResult = false;
        result = instance.estJourneeVacance();
        assertEquals(expResult, result);
    
    }

    @Test
    public void testEstUnCongeParental() throws Exception {
        System.out.println("estUnCongeParental");
        Projet instance = Projet.construireProjet(902, 500.0);
        boolean expResult = false;
        boolean result = instance.estUnCongeParental();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(125, 420.0);
        expResult = false;
        result = instance.estUnCongeParental();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(999, 420.0);
        expResult = false;
        result = instance.estUnCongeParental();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(990, 420.0);
        expResult = false;
        result = instance.estUnCongeParental();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(998, 420.0);
        expResult = false;
        result = instance.estUnCongeParental();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(997, 420.0);
        expResult = false;
        result = instance.estUnCongeParental();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(996, 420.0);
        expResult = true;
        result = instance.estUnCongeParental();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(777, 5.0);
        expResult = false;
        result = instance.estUnCongeParental();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Projet.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Projet autreProjet = Projet.construireProjet(111, 0);
        Projet instance = Projet.construireProjet(110, 0);
        boolean expResult = false;
        boolean result = instance.equals(autreProjet);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testEstUnTempsTransport() throws Exception {
        System.out.println("estUnTempsTransport");
        Projet instance = Projet.construireProjet(902, 500.0);
        boolean expResult = false;
        boolean result = instance.estUnTempsTransport();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(125, 420.0);
        expResult = false;
        result = instance.estUnTempsTransport();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(999, 420.0);
        expResult = false;
        result = instance.estUnTempsTransport();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(990, 420.0);
        expResult = false;
        result = instance.estUnTempsTransport();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(998, 420.0);
        expResult = false;
        result = instance.estUnTempsTransport();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(997, 420.0);
        expResult = false;
        result = instance.estUnTempsTransport();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(996, 420.0);
        expResult = false;
        result = instance.estUnTempsTransport();
        assertEquals(expResult, result);
        
        instance = Projet.construireProjet(777, 5.0);
        expResult = true;
        result = instance.estUnTempsTransport();
        assertEquals(expResult, result);
    }
}