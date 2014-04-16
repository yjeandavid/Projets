/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uqam.inf2015.tp1.gestionDonnees;

import ca.uqam.inf2015.tp1.application.AppConfig;
import net.sf.json.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class JsonFactoryTest {
    
    public JsonFactoryTest() {
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

    @Test    public void testConstruireFichierJson() throws Exception {
        System.out.println("construireFichierJson");
        String messages = "";
        MockFileWriter mfw = new MockFileWriter();
        JsonFactory.construireFichierJson(messages, mfw);
        String expResult = "[]";
        String result = mfw.getWrittenData();
        assertEquals(expResult, result);
    }

    @Test
    public void testEcrireFichierJson() throws Exception {
        System.out.println("EcrireFichierJson");
        JSONArray messageArray = new JSONArray();
        MockFileWriter mfw = new MockFileWriter();
        JsonFactory.EcrireFichierJson(messageArray, mfw);
        String expResult = "[]";
        String result = mfw.getWrittenData();
        assertEquals(expResult, result);
        
        mfw = new MockFileWriter();
        messageArray.add(AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_TRAVAIL_PAR_JOUR"));
        JsonFactory.EcrireFichierJson(messageArray, mfw);
        expResult = "[\"" + AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_TRAVAIL_PAR_JOUR")
                    + "\"]";
        result = mfw.getWrittenData();
        assertEquals(expResult,result);
        
        mfw = new MockFileWriter();
        messageArray.add(AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_TRAVAIL_PAR_JOUR"));
        JsonFactory.EcrireFichierJson(messageArray, mfw);
        expResult = "[\"" + AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_TRAVAIL_PAR_JOUR")
                    + "\",\"" + AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_TRAVAIL_PAR_JOUR")
                    + "\"]";
        result = mfw.getWrittenData();
        assertEquals(expResult,result);
    }
    
}
