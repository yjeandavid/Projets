package ca.uqam.inf2015.tp1.feuilleDeTemps;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FeuilleDeTempsTest {
    
    public FeuilleDeTempsTest() {
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
    public void testGetJours() {
        System.out.println("getJours");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        List expResult = null;
        List result = instance.getJours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetJours() {
        System.out.println("setJours");
        List<List<Projet>> jours = null;
        FeuilleDeTemps instance = new FeuilleDeTemps();
        instance.setJours(jours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculerHeuresBureauParSemaine() throws Exception {
        System.out.println("calculerHeuresBureauParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        double expResult = 0.0;
        double result = instance.calculerHeuresBureauParSemaine();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculerHeuresTeleTravailParSemaine() throws Exception {
        System.out.println("calculerHeuresTeleTravailParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        double expResult = 0.0;
        double result = instance.calculerHeuresTeleTravailParSemaine();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculerHeuresBureauJour() throws Exception {
        System.out.println("calculerHeuresBureauJour");
        List<Projet> projetsDuJour = null;
        double expResult = 0.0;
        double result = FeuilleDeTemps.calculerHeuresBureauJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculerHeuresTeleTravailJour() throws Exception {
        System.out.println("calculerHeuresTeleTravailJour");
        List<Projet> projetsDuJour = null;
        FeuilleDeTemps instance = new FeuilleDeTemps();
        double expResult = 0.0;
        double result = instance.calculerHeuresTeleTravailJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}