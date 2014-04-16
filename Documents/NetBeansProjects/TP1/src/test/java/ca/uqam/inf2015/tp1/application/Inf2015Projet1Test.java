package ca.uqam.inf2015.tp1.application;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Inf2015Projet1Test {

    public Inf2015Projet1Test() {
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
    public void testMain() {
        System.out.println("main");
        String[] args = new String[2];
        args[0] = "/user/Desktop/file.json";
        args[1] = "/user/Desktop/out.json";
        MockInf2015Projet1 mok = new MockInf2015Projet1();
        MockInf2015Projet1 instance = new MockInf2015Projet1();
        instance = mok;
        instance.main(args);
        assertEquals(mok.getItem(0), args[0]);
    }

    

}
