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

public class EmployeTest {
    
    public EmployeTest() {
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

    @Test(expected = NullPointerException.class)
    public void testGetNoEmplye1() throws Exception{
        System.out.println("getNoEmplye");
        Employe instance = new Employe(100);
    }

    @Test
    public void testGetNoEmplye2() throws IOException {
        System.out.println("getNoEmplye");
        AppConfig.chargerParametres();
        Employe instance = new Employe(100);
        int expResult = 100;
        int result = instance.getNoEmplye();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetNoEmploye() {
        System.out.println("setNoEmploye");
        int noEmploye = 0;
        Employe instance = null;
        instance.setNoEmploye(noEmploye);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFeuilleDeTemps() {
        System.out.println("getFeuilleDeTemps");
        Employe instance = null;
        FeuilleDeTemps expResult = null;
        FeuilleDeTemps result = instance.getFeuilleDeTemps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetfFeuilleDeTemps() {
        System.out.println("setfFeuilleDeTemps");
        FeuilleDeTemps timeSheet = null;
        Employe instance = null;
        instance.setfFeuilleDeTemps(timeSheet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTypeEmploye() {
        System.out.println("getTypeEmploye");
        Employe instance = null;
        char expResult = ' ';
        char result = instance.getTypeEmploye();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}