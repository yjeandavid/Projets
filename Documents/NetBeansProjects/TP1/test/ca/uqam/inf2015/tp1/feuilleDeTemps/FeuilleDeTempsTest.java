package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;
import java.io.IOException;
import java.util.ArrayList;
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
    public static void setUpClass() throws IOException {
        AppConfig.chargerParametres();
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
    }

    @Test
    public void testSetJours() {
        System.out.println("setJours");
        List<List<Projet>> jours = null;
        FeuilleDeTemps instance = new FeuilleDeTemps();
        instance.setJours(jours);
        List expResult = null;
        List result = instance.getJours();
        assertEquals(expResult, result);
        
        jours = new ArrayList();
        instance.setJours(jours);
        expResult = jours;
        result = instance.getJours();
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testCalculerHeuresBureauParSemaine1() throws Exception {
        System.out.println("calculerHeuresBureauParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        double result = instance.calculerHeuresBureauParSemaine();
    }

    @Test
    public void testCalculerHeuresBureauParSemaine2() throws Exception {
        System.out.println("calculerHeuresBureauParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        List<List<Projet>> jours = new ArrayList();
        List<Projet> projets = new ArrayList();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = instance.calculerHeuresBureauParSemaine();
        assertEquals(expResult, result, 0.0);
        
        Projet unProjet = Projet.construireProjet(125, 420.0);
        projets.add(unProjet);
        jours.add(projets);
        expResult = 420.0;
        result = instance.calculerHeuresBureauParSemaine();
        assertEquals(expResult, result, 0.0);
        
        unProjet = Projet.construireProjet(901, 420.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 420.0;
        result = instance.calculerHeuresBureauParSemaine();
        assertEquals(expResult, result, 0.0);
        
        unProjet = Projet.construireProjet(160, 300.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 720.0;
        result = instance.calculerHeuresBureauParSemaine();
        assertEquals(expResult, result, 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void testCalculerHeuresTeleTravailParSemaine1() throws Exception {
        System.out.println("calculerHeuresTeleTravailParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        double result = instance.calculerHeuresTeleTravailParSemaine();
    }

    @Test
    public void testCalculerHeuresTeleTravailParSemaine2() throws Exception {
        System.out.println("calculerHeuresTeleTravailParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        List<List<Projet>> jours = new ArrayList();
        List<Projet> projets = new ArrayList();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = instance.calculerHeuresTeleTravailParSemaine();
        assertEquals(expResult, result, 0.0);
        
        Projet unProjet = Projet.construireProjet(125, 420.0);
        projets.add(unProjet);
        jours.add(projets);
        expResult = 0.0;
        result = instance.calculerHeuresTeleTravailParSemaine();
        assertEquals(expResult, result, 0.0);
        
        unProjet = Projet.construireProjet(901, 420.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 420.0;
        result = instance.calculerHeuresTeleTravailParSemaine();
        assertEquals(expResult, result, 0.0);
        
        unProjet = Projet.construireProjet(160, 300.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 420.0;
        result = instance.calculerHeuresTeleTravailParSemaine();
        assertEquals(expResult, result, 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void testCalculerHeuresBureauJour1() throws Exception {
        System.out.println("calculerHeuresBureauJour");
        List<Projet> projetsDuJour = null;
        double result = FeuilleDeTemps.calculerHeuresBureauJour(projetsDuJour);
    }

    @Test
    public void testCalculerHeuresBureauJour2() throws Exception {
        System.out.println("calculerHeuresBureauJour");
        List<Projet> projetsDuJour = new ArrayList<>();
        double expResult = 0.0;
        double result = FeuilleDeTemps.calculerHeuresBureauJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        Projet unProjet = Projet.construireProjet(125, 420.0);
        projetsDuJour.add(unProjet);
        expResult = 420.0;
        result = FeuilleDeTemps.calculerHeuresBureauJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        unProjet = Projet.construireProjet(901, 420.0);
        projetsDuJour.add(unProjet);
        expResult = 420.0;
        result = FeuilleDeTemps.calculerHeuresBureauJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        unProjet = Projet.construireProjet(160, 300.0);
        projetsDuJour.add(unProjet);
        expResult = 720.0;
        result = FeuilleDeTemps.calculerHeuresBureauJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void testCalculerHeuresTeleTravailJour1() throws Exception {
        System.out.println("calculerHeuresTeleTravailJour");
        List<Projet> projetsDuJour = null;
        FeuilleDeTemps instance = new FeuilleDeTemps();
        double result = FeuilleDeTemps.calculerHeuresTeleTravailJour(projetsDuJour);
    }

    @Test
    public void testCalculerHeuresTeleTravailJour2() throws Exception {
        System.out.println("calculerHeuresTeleTravailJour");
        List<Projet> projetsDuJour = new ArrayList();
        double expResult = 0.0;
        double result = FeuilleDeTemps.calculerHeuresTeleTravailJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        Projet unProjet = Projet.construireProjet(125, 420.0);
        projetsDuJour.add(unProjet);
        expResult = 0.0;
        result = FeuilleDeTemps.calculerHeuresTeleTravailJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        unProjet = Projet.construireProjet(901, 420.0);
        projetsDuJour.add(unProjet);
        expResult = 420.0;
        result = FeuilleDeTemps.calculerHeuresTeleTravailJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        unProjet = Projet.construireProjet(160, 300.0);
        projetsDuJour.add(unProjet);
        expResult = 420.0;
        result = FeuilleDeTemps.calculerHeuresTeleTravailJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
    }
}