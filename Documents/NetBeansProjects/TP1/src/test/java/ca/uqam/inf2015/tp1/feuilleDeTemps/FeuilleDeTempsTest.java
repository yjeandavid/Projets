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
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
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

    /**
     * Test of calculerHeuresBureauParSemaine method, of class FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresBureauParSemaine() throws Exception {
        System.out.println("calculerHeuresBureauParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        List<List<Projet>> jours = new ArrayList();
        List<Projet> projets = new ArrayList();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = instance.calculerHeuresBureauParSemaine();

        assertEquals(expResult, result, 0.0);

        Projet unProjet = Projet.construireProjet(1, 420.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 420.0;
        result = instance.calculerHeuresBureauParSemaine();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerHeuresBureauParSemaineSansTransport method, of class
     * FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresBureauParSemaineSansTransport() throws Exception {
        System.out.println("calculerHeuresBureauParSemaineSansTransport");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        List<List<Projet>> jours = new ArrayList();
        List<Projet> projets = new ArrayList();
        instance.setJours(jours);
        double expResult = 0.0;

        double result = instance.calculerHeuresBureauParSemaineSansTransport();

        assertEquals(expResult, result, 0.0);

        Projet unProjet = Projet.construireProjet(188, 488.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 488.0;
        result = instance.calculerHeuresBureauParSemaineSansTransport();

        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calculerHeuresTeleTravailParSemaine method, of class
     * FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresTeleTravailParSemaine() throws Exception {
        System.out.println("calculerHeuresTeleTravailParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        List<List<Projet>> jours = new ArrayList();
        List<Projet> projets = new ArrayList();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = instance.calculerHeuresTeleTravailParSemaine();

        assertEquals(expResult, result, 0.0);

        Projet unProjet = Projet.construireProjet(188, 48.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 0.0;
        result = instance.calculerHeuresTeleTravailParSemaine();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calculerHeuresTeleTravailParSemaineAvecTransport method, of class
     * FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresTeleTravailParSemaineAvecTransport() throws Exception {
        System.out.println("calculerHeuresTeleTravailParSemaineAvecTransport");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        List<List<Projet>> jours = new ArrayList();
        List<Projet> projets = new ArrayList();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = instance.calculerHeuresTeleTravailParSemaineAvecTransport();

        assertEquals(expResult, result, 0.0);

        Projet unProjet = Projet.construireProjet(188, 489.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 0.0;
        result = instance.calculerHeuresTeleTravailParSemaineAvecTransport();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calculerHeuresTempsTransportParSemaine method, of class
     * FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresTempsTransportParSemaine() throws Exception {
        System.out.println("calculerHeuresTempsTransportParSemaine");
        FeuilleDeTemps instance = new FeuilleDeTemps();
        List<List<Projet>> jours = new ArrayList();
        List<Projet> projets = new ArrayList();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = instance.calculerHeuresTempsTransportParSemaine();
        assertEquals(expResult, result, 0.0);

        Projet unProjet = Projet.construireProjet(599, 389.0);
        projets = new ArrayList();
        projets.add(unProjet);
        jours.add(projets);
        expResult = 0.0;
        result = instance.calculerHeuresTempsTransportParSemaine();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerHeuresBureauJour method, of class FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresBureauJour() throws Exception {
        System.out.println("calculerHeuresBureauJour");
        List<Projet> projetsDuJour = new ArrayList();;
        List<List<Projet>> jours = new ArrayList();
        FeuilleDeTemps instance = new FeuilleDeTemps();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = FeuilleDeTemps.calculerHeuresBureauJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);

        Projet unProjet = Projet.construireProjet(599, 389.0);
        projetsDuJour = new ArrayList();
        projetsDuJour.add(unProjet);
        jours.add(projetsDuJour);
        expResult = 389.0;
        result = instance.calculerHeuresBureauJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calculerHeuresBureauJourSansTransport method, of class
     * FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresBureauJourSansTransport() throws Exception {
        System.out.println("calculerHeuresBureauJourSansTransport");
        List<Projet> projetsDuJour = new ArrayList();;
        List<List<Projet>> jours = new ArrayList();
        FeuilleDeTemps instance = new FeuilleDeTemps();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = FeuilleDeTemps.calculerHeuresBureauJourSansTransport(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        Projet unProjet = Projet.construireProjet(599, 389.0);
        projetsDuJour = new ArrayList();
        projetsDuJour.add(unProjet);
        jours.add(projetsDuJour);
        expResult = 389.0;
        result = instance.calculerHeuresBureauJourSansTransport(projetsDuJour);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calculerHeuresTeleTravailJour method, of class FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresTeleTravailJour() throws Exception {
        System.out.println("calculerHeuresTeleTravailJour");
        List<Projet> projetsDuJour = new ArrayList();;
        List<List<Projet>> jours = new ArrayList();
        FeuilleDeTemps instance = new FeuilleDeTemps();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = FeuilleDeTemps.calculerHeuresTeleTravailJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        Projet unProjet = Projet.construireProjet(599, 389.0);
        projetsDuJour = new ArrayList();
        projetsDuJour.add(unProjet);
        jours.add(projetsDuJour);
        expResult = 0.0;
        result = instance.calculerHeuresTeleTravailJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerHeuresTeleTravailJourAvecTransport method, of class
     * FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresTeleTravailJourAvecTransport() throws Exception {
        System.out.println("calculerHeuresTeleTravailJourAvecTransport");
        List<Projet> projetsDuJour = new ArrayList();;
        List<List<Projet>> jours = new ArrayList();
        FeuilleDeTemps instance = new FeuilleDeTemps();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = FeuilleDeTemps.calculerHeuresTeleTravailJourAvecTransport(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        Projet unProjet = Projet.construireProjet(4599, 389.0);
        projetsDuJour = new ArrayList();
        projetsDuJour.add(unProjet);
        jours.add(projetsDuJour);
        expResult = 389.0;
        result = instance.calculerHeuresTeleTravailJourAvecTransport(projetsDuJour);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerHeuresTransportJour method, of class FeuilleDeTemps.
     */
    @Test
    public void testCalculerHeuresTransportJour() throws Exception {
        System.out.println("calculerHeuresTransportJour");
        List<Projet> projetsDuJour = new ArrayList();;
        List<List<Projet>> jours = new ArrayList();
        FeuilleDeTemps instance = new FeuilleDeTemps();
        instance.setJours(jours);
        double expResult = 0.0;
        double result = FeuilleDeTemps.calculerHeuresTransportJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
        
        Projet unProjet = Projet.construireProjet(3599, 389.0);
        projetsDuJour = new ArrayList();
        projetsDuJour.add(unProjet);
        jours.add(projetsDuJour);
        expResult = 0.0;
        result = instance.calculerHeuresTransportJour(projetsDuJour);
        assertEquals(expResult, result, 0.0);
    }
}
