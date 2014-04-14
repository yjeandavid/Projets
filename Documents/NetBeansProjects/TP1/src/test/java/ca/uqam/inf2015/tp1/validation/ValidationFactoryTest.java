package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.employe.Employe;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.Projet;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ValidationFactoryTest {
    
    public ValidationFactoryTest() {
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
    public void testConstruireValidationEmploye() throws Exception {
        System.out.println("construireValidationEmploye");
        Employe unEmploye = new Employe(0);
        
        FeuilleDeTemps feuilleDeTemps = new FeuilleDeTemps();
        List<List<Projet>> jours = new ArrayList();
        List<Projet> projets = new ArrayList();
        Projet unProjet = Projet.construireProjet(125, 420.0);
        projets.add(unProjet);
        jours.add(projets);
        feuilleDeTemps.setJours(jours);
        unEmploye.setFeuilleDeTemps(feuilleDeTemps);
        ValidationFactory instance = new ValidationFactory (){};
        Validation result = instance.construireValidationEmploye(unEmploye);
        assertNotNull(result);
        
        Employe unEmploye1 = new Employe(1500);
        unEmploye1.setFeuilleDeTemps(feuilleDeTemps);
        result = ValidationFactory.construireValidationEmploye(unEmploye1);
        assertNotNull(result);
        
        Employe unEmploye2 = new Employe(2000);
        unEmploye2.setFeuilleDeTemps(feuilleDeTemps);
        result = ValidationFactory.construireValidationEmploye(unEmploye2);
        assertNotNull(result);
        
        Employe unEmploye3 = new Employe(5000);
        unEmploye3.setFeuilleDeTemps(feuilleDeTemps);
        result = ValidationFactory.construireValidationEmploye(unEmploye3);
        assertNotNull(result);
        
        Employe unEmploye4 = new Employe(6000);
        unEmploye4.setFeuilleDeTemps(feuilleDeTemps);
        result = ValidationFactory.construireValidationEmploye(unEmploye4);
        assertNotNull(result);
        
    }
    
}
