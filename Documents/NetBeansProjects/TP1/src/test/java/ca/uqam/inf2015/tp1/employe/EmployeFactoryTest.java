package ca.uqam.inf2015.tp1.employe;

import ca.uqam.inf2015.tp1.exceptions.MissingDataInJSONFileException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class EmployeFactoryTest {
    
    public EmployeFactoryTest() {
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
    public void testConstruireEmployeAPartirDeFichierJson() throws Exception {
        System.out.println("construireEmployeAPartirDeFichierJson");
        String filePath = "configurationTests/Cas1.json";
        List<Employe> expResult = null;
        EmployeFactory instance = new EmployeFactory(){};
        List<Employe> result = instance.construireEmployeAPartirDeFichierJson(filePath);
        assertNotNull( result);
         
    }
    
    @Test(expected = MissingDataInJSONFileException.class)
    public void testConstruireEmployeAPartirDeFichierJson1() throws Exception {
        System.out.println("construireEmployeAPartirDeFichierJson1");
        String filePath = "";
        List<Employe> expResult = null;
        EmployeFactory instance = new EmployeFactory(){};
        List<Employe> result = instance.construireEmployeAPartirDeFichierJson(filePath);
        assertNotNull( result);
         
    }
}
