package ca.uqam.inf2015.tp1.exceptions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MissingDataInJSONFileExceptionTest {
    
    public MissingDataInJSONFileExceptionTest() {
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
    public void testSouleverException() {
        System.out.println("souleverException");
        String result = "Le fichier JSON d'entrée contient une (ou plusieurs) erreur(s).";
        MissingDataInJSONFileException instance = new MissingDataInJSONFileException();
        MockMissingDataInJSONFileException mok = new MockMissingDataInJSONFileException();
        instance.souleverException();
        instance = mok;
        instance.souleverException(); 
        assertEquals(mok.fichier.get(0), result);
    }
    
}
