package ca.uqam.inf2015.tp1.exceptions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MissingArgumentsExceptionTest {
    
    public MissingArgumentsExceptionTest() {
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
        String result = "Vous devez donner 2 fichiers .json en entree.";
        MockMissingArgumentsException mock = new MockMissingArgumentsException();
        MissingArgumentsException instance = new MissingArgumentsException();
        instance.souleverException();
        instance = mock;
        instance.souleverException();
        assertEquals(mock.fichier.get(0), result);
        assertTrue(mock.fichier.get(0).equals(result));
        
        
    
}
}
