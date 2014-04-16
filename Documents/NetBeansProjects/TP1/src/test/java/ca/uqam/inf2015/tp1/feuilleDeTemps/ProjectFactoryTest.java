package ca.uqam.inf2015.tp1.feuilleDeTemps;

import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProjectFactoryTest {

    public ProjectFactoryTest() {
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
    public void testConstruireProjetAPartirDeFichierJson() throws Exception {
        System.out.println("construireProjetAPartirDeFichierJson");
        JSONObject rootElt = new JSONObject();
        JSONArray element = new JSONArray();
        JSONObject elementContain = new JSONObject();
        elementContain.accumulate("projet", 125);
        elementContain.accumulate("minutes", 420);
        element.add(elementContain);

        rootElt.accumulate("jour1", element);
        rootElt.accumulate("jour2", element);
        rootElt.accumulate("jour3", element);
        rootElt.accumulate("jour4", element);
        rootElt.accumulate("jour5", element);
        rootElt.accumulate("weekend1", element);
        rootElt.accumulate("weekend2", element);  
        ProjectFactory projet = new ProjectFactory(){};
        List<List<Projet>> result = projet.construireProjetAPartirDeFichierJson(rootElt);
        assertNotNull(result);

    }

}
