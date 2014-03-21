package ca.uqam.inf2015.tp1.employe;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class EmployeTest {
    Employe instance;
    
    public EmployeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        AppConfig.chargerParametres();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        instance = new Employe(100);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Pour lancer ce test il faut retirer le code dans @BeforeClass et dans @Before
     * @throws Exception 
     */
    /*@Test(expected = NullPointerException.class)
    public void testGetNoEmploye1() throws Exception{
        System.out.println("getNoEmplye");
        instance = new Employe(100);
    }*/

    @Test
    public void testGetNoEmploye2() throws IOException {
        System.out.println("getNoEmplye");
        AppConfig.chargerParametres();
        int expResult = 100;
        int result = instance.getNoEmploye();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetNoEmploye() throws IOException {
        System.out.println("setNoEmploye");
        AppConfig.chargerParametres();
        int noEmploye = 300;
        instance.setNoEmploye(noEmploye);
        assertEquals(noEmploye, instance.getNoEmploye());
    }

    @Test
    public void testGetFeuilleDeTemps() throws IOException {
        System.out.println("getFeuilleDeTemps");
        FeuilleDeTemps expResult = null;
        FeuilleDeTemps result = instance.getFeuilleDeTemps();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetFeuilleDeTemps() throws IOException {
        System.out.println("setfFeuilleDeTemps");
        FeuilleDeTemps timeSheet = null;
        instance.setFeuilleDeTemps(timeSheet);
        FeuilleDeTemps expResult = null;
        FeuilleDeTemps result = instance.getFeuilleDeTemps();
        assertEquals(expResult, result);
        
        timeSheet = new FeuilleDeTemps();
        instance.setFeuilleDeTemps(timeSheet);
        expResult = timeSheet;
        result = instance.getFeuilleDeTemps();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTypeEmploye() throws IOException {
        System.out.println("getTypeEmploye");
        char expResult = 'A';
        char result = instance.getTypeEmploye();
        assertEquals(expResult, result);
        
        instance.setNoEmploye(1000);
        expResult = 'P';
        result = instance.getTypeEmploye();
        assertEquals(expResult, result);
        
        instance.setNoEmploye(2000);
        expResult = 'E';
        result = instance.getTypeEmploye();
        assertEquals(expResult, result);
        
        instance.setNoEmploye(5000);
        result = instance.getTypeEmploye();
        assertEquals(expResult, result);
        
        instance.setNoEmploye(5001);
        expResult = 'D';
        result = instance.getTypeEmploye();
        assertEquals(expResult, result);
    }
}