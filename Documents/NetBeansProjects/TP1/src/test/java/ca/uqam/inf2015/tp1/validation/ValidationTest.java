package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.Projet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ValidationTest {

    public ValidationTest() {
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
    public void testGetNbreCongeParental() throws IOException {

        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        assertTrue(0 == instance.getNbreCongeParental());
    }

    
    @Test
    public void testGetHeuresDeBureauParSemaine() throws IOException {
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        assertTrue(0 == instance.getHeuresDeBureauParSemaine());
    }

    
    @Test
    public void testGetHeuresTeleTravailParSemaine() throws IOException {

        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        assertTrue(0 == instance.getHeuresTeleTravailParSemaine());
    }

    
    @Test
    public void testSetMinimum_minutes_par_jour() throws IOException {
        System.out.println("setMinimum_minutes_par_jour");
        double minimum_minutes_par_jour = 140.0;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMinimum_minutes_par_jour(minimum_minutes_par_jour);
        assertTrue(instance.getMinimum_minutes_par_jour() == minimum_minutes_par_jour);

    }

    
    @Test
    public void testSetMinimum_minutes_par_semaine() throws IOException {
        System.out.println("setMinimum_minutes_par_semaine");
        double minimum_minutes_par_semaine = 14.0;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMinimum_minutes_par_semaine(minimum_minutes_par_semaine);
        assertTrue(instance.getMinimum_minutes_par_semaine() == minimum_minutes_par_semaine);

    }

    
    @Test
    public void testSetMaximum_minutes_par_jour() throws IOException {
        System.out.println("setMaximum_minutes_par_jour");
        double maximum_minutes_par_jour = 1440.0;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMaximum_minutes_par_jour(maximum_minutes_par_jour);
        assertTrue(instance.getMaximum_minutes_par_jour() == maximum_minutes_par_jour);

    }

    
    @Test
    public void testSetMaximum_minutes_par_semaine() throws IOException {
        System.out.println("setMaximum_minutes_par_semaine");
        double maximum_minutes_par_semaine = 0.0;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMaximum_minutes_par_semaine(maximum_minutes_par_semaine);
        assertTrue(instance.getMaximum_minutes_par_semaine() == maximum_minutes_par_semaine);
    }

    
    @Test
    public void testSetMaximum_minutes_tele_travail_semaine() throws IOException {
        System.out.println("setMaximum_minutes_tele_travail_semaine");
        double maximum_minutes_tele_travail_semaine = 990.0;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMaximum_minutes_tele_travail_semaine(maximum_minutes_tele_travail_semaine);
        assertTrue(instance.getMaximum_minutes_tele_travail_semaine() == maximum_minutes_tele_travail_semaine);
    }

    
    @Test
    public void testValiderFeuilleDeTemps() throws Exception {
        System.out.println("validerFeuilleDeTemps");
        List<List<Projet>> jours = new ArrayList<List<Projet>>();
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(250, 676));
        projetsDuJour.add(Projet.construireProjet(55, 333));
        projetsDuJour.add(Projet.construireProjet(998, 480));
        jours.add(projetsDuJour);

        List<Projet> projetsDuJour1 = new ArrayList<Projet>();
        projetsDuJour1.add(Projet.construireProjet(559, 550));
        projetsDuJour1.add(Projet.construireProjet(998, 200));
        projetsDuJour1.add(Projet.construireProjet(666, 666));
        jours.add(projetsDuJour1);

        List<Projet> projetsDuJour2 = new ArrayList<Projet>();
        projetsDuJour2.add(Projet.construireProjet(399, 330));
        projetsDuJour2.add(Projet.construireProjet(790, 480));
        projetsDuJour2.add(Projet.construireProjet(790, 66));
        jours.add(projetsDuJour2);

        List<Projet> projetsDuJour3 = new ArrayList<Projet>();
        projetsDuJour3.add(Projet.construireProjet(700, 480));
        projetsDuJour3.add(Projet.construireProjet(999, 480));
        projetsDuJour3.add(Projet.construireProjet(791, 766));
        jours.add(projetsDuJour3);

        List<Projet> projetsDuJour4 = new ArrayList<Projet>();
        projetsDuJour4.add(Projet.construireProjet(555, 480));
        projetsDuJour4.add(Projet.construireProjet(400, 150));
        projetsDuJour4.add(Projet.construireProjet(490, 350));
        jours.add(projetsDuJour4);

        List<Projet> projetsDuJour5 = new ArrayList<Projet>();
        projetsDuJour5.add(Projet.construireProjet(830, 290));
        projetsDuJour5.add(Projet.construireProjet(831, 100));
        projetsDuJour5.add(Projet.construireProjet(9, 715));
        jours.add(projetsDuJour5);

        List<Projet> projetsDuJour6 = new ArrayList<Projet>();
        projetsDuJour6.add(Projet.construireProjet(998, 66));
        projetsDuJour6.add(Projet.construireProjet(996, 66));
        projetsDuJour6.add(Projet.construireProjet(911, 66));
        jours.add(projetsDuJour6);
        mock.setJours(jours);
        Validation instance = new Validation(mock);

        String expResult = ",L'employe a fait plus de 24h mais moins "
                + "de 32h pour le jour 1,L'employe n'a pas respecte le"
                + " nombre d'heures permis du conge ferie le jour 2,,Il"
                + " n'est pas permis d'avoir plusieurs activités avec le "
                + "même code de projet pour jour 3,,L'employe a exerce "
                + "d'autres activites pendant conge maladie ou parental "
                + "le jour 4,,L'employe a fait plus de 24h mais moins de "
                + "32h pour le jour 4,,,L'employe n'a pas respecte le nombre "
                + "d'heures permis du conge ferie le jour 2,L'employe n'a pas "
                + "droit au conge ferie pour le weekend 2,L'employe n'a pas "
                + "respecte le nombre d'heures permis du conge parental pour "
                + "le jour 2,L'employe n'a pas droit au conge parental pour "
                + "le weekend 2,,,";
        String result = instance.validerFeuilleDeTemps();
        assertEquals(expResult, result);

    }

    
    @Test
    public void testValiderSemaine() throws Exception {
        System.out.println("validerSemaine");
        List<List<Projet>> jours = new ArrayList<List<Projet>>();
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(990, 66));
        projetsDuJour.add(Projet.construireProjet(125, 66));
        projetsDuJour.add(Projet.construireProjet(998, 66));
        jours.add(projetsDuJour);

        List<Projet> projetsDuJour1 = new ArrayList<Projet>();
        projetsDuJour1.add(Projet.construireProjet(139, 66));
        projetsDuJour1.add(Projet.construireProjet(998, 66));
        projetsDuJour1.add(Projet.construireProjet(666, 66));
        jours.add(projetsDuJour1);

        List<Projet> projetsDuJour2 = new ArrayList<Projet>();
        projetsDuJour2.add(Projet.construireProjet(800, 66));
        projetsDuJour2.add(Projet.construireProjet(777, 480));
        projetsDuJour2.add(Projet.construireProjet(790, 66));
        jours.add(projetsDuJour2);

        List<Projet> projetsDuJour3 = new ArrayList<Projet>();
        projetsDuJour3.add(Projet.construireProjet(700, 66));
        projetsDuJour3.add(Projet.construireProjet(999, 480));
        projetsDuJour3.add(Projet.construireProjet(791, 66));
        jours.add(projetsDuJour3);

        List<Projet> projetsDuJour4 = new ArrayList<Projet>();
        projetsDuJour4.add(Projet.construireProjet(555, 480));
        projetsDuJour4.add(Projet.construireProjet(550, 66));
        projetsDuJour4.add(Projet.construireProjet(591, 66));
        jours.add(projetsDuJour4);

        List<Projet> projetsDuJour5 = new ArrayList<Projet>();
        projetsDuJour5.add(Projet.construireProjet(830, 66));
        projetsDuJour5.add(Projet.construireProjet(831, 66));
        projetsDuJour5.add(Projet.construireProjet(832, 66));
        jours.add(projetsDuJour5);

        List<Projet> projetsDuJour6 = new ArrayList<Projet>();
        projetsDuJour6.add(Projet.construireProjet(998, 66));
        projetsDuJour6.add(Projet.construireProjet(910, 66));
        projetsDuJour6.add(Projet.construireProjet(911, 66));
        jours.add(projetsDuJour6);
        mock.setJours(jours);
        Validation instance = new Validation(mock);

        String expResult = "L'employe n'a pas respecte le nombre d'heures "
                + "permis du conge ferie le jour 1,L'employe a exerce "
                + "d'autres activites pendant conge ferie ou vacance le "
                + "jour 1,,L'employe n'a pas travaille le nombre d'heures "
                + "minimal pour le jour 1,L'employe n'a pas respecte le nombre "
                + "d'heures permis du conge ferie le jour 2,,L'employe n'a pas "
                + "travaille le nombre d'heures minimal pour le jour 2,,"
                + "L'employe a exerce d'autres activites pendant conge maladie"
                + " ou parental le jour 4,,,,L'employe n'a pas respecte le nombre"
                + " d'heures permis du conge ferie le jour 2,L'employe n'a pas "
                + "droit au conge ferie pour le weekend 2,,";
        String result = instance.validerSemaine();
        assertEquals(expResult, result);

    }

    
    @Test
    public void testValiderJoursOuvrables() throws Exception {
        System.out.println("validerJoursOuvrables");
        List<List<Projet>> jours = new ArrayList<List<Projet>>();
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(999, 66));
        projetsDuJour.add(Projet.construireProjet(125, 66));
        projetsDuJour.add(Projet.construireProjet(998, 66));
        jours.add(projetsDuJour);

        List<Projet> projetsDuJour1 = new ArrayList<Projet>();
        projetsDuJour1.add(Projet.construireProjet(139, 66));
        projetsDuJour1.add(Projet.construireProjet(333, 66));
        projetsDuJour1.add(Projet.construireProjet(666, 66));
        jours.add(projetsDuJour1);

        List<Projet> projetsDuJour2 = new ArrayList<Projet>();
        projetsDuJour2.add(Projet.construireProjet(800, 66));
        projetsDuJour2.add(Projet.construireProjet(777, 66));
        projetsDuJour2.add(Projet.construireProjet(790, 66));
        jours.add(projetsDuJour2);

        List<Projet> projetsDuJour3 = new ArrayList<Projet>();
        projetsDuJour3.add(Projet.construireProjet(700, 66));
        projetsDuJour3.add(Projet.construireProjet(750, 66));
        projetsDuJour3.add(Projet.construireProjet(791, 66));
        jours.add(projetsDuJour3);

        List<Projet> projetsDuJour4 = new ArrayList<Projet>();
        projetsDuJour4.add(Projet.construireProjet(555, 66));
        projetsDuJour4.add(Projet.construireProjet(550, 66));
        projetsDuJour4.add(Projet.construireProjet(591, 66));
        jours.add(projetsDuJour4);

        List<Projet> projetsDuJour5 = new ArrayList<Projet>();
        projetsDuJour5.add(Projet.construireProjet(830, 66));
        projetsDuJour5.add(Projet.construireProjet(831, 66));
        projetsDuJour5.add(Projet.construireProjet(832, 66));
        jours.add(projetsDuJour5);

        List<Projet> projetsDuJour6 = new ArrayList<Projet>();
        projetsDuJour6.add(Projet.construireProjet(998, 66));
        projetsDuJour6.add(Projet.construireProjet(910, 66));
        projetsDuJour6.add(Projet.construireProjet(911, 66));
        jours.add(projetsDuJour6);
        mock.setJours(jours);
        Validation instance = new Validation(mock);

        String expResult = "L'employe n'a pas respecte le nombre d'heures "
                + "du conge maladie permis le jour 1,L'employe n'a pas "
                + "respecte le nombre d'heures permis du conge ferie le "
                + "jour 1,L'employe a exerce d'autres activites pendant "
                + "conge maladie ou parental le jour 1,,L'employe n'a pas "
                + "travaille le nombre d'heures minimal pour le jour 1,,"
                + "L'employe n'a pas travaille le nombre d'heures minimal "
                + "pour le jour 2,,L'employe n'a pas travaille le nombre d'"
                + "heures minimal pour le jour 3,,L'employe n'a pas travaille"
                + " le nombre d'heures minimal pour le jour 4,,L'employe n'a "
                + "pas travaille le nombre d'heures minimal pour le jour 5,";
        String result = instance.validerJoursOuvrables();

        assertEquals(expResult, result);

    }

    
    @Test
    public void testValiderFinDeSemaine() throws Exception {
        System.out.println("validerFinDeSemaine");
        List<List<Projet>> jours = new ArrayList<List<Projet>>();
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(999, 66));
        projetsDuJour.add(Projet.construireProjet(125, 66));
        projetsDuJour.add(Projet.construireProjet(998, 66));
        jours.add(projetsDuJour);

        List<Projet> projetsDuJour1 = new ArrayList<Projet>();
        projetsDuJour1.add(Projet.construireProjet(139, 66));
        projetsDuJour1.add(Projet.construireProjet(333, 66));
        projetsDuJour1.add(Projet.construireProjet(666, 66));
        jours.add(projetsDuJour1);

        List<Projet> projetsDuJour2 = new ArrayList<Projet>();
        projetsDuJour2.add(Projet.construireProjet(800, 66));
        projetsDuJour2.add(Projet.construireProjet(777, 66));
        projetsDuJour2.add(Projet.construireProjet(790, 66));
        jours.add(projetsDuJour2);

        List<Projet> projetsDuJour3 = new ArrayList<Projet>();
        projetsDuJour3.add(Projet.construireProjet(700, 66));
        projetsDuJour3.add(Projet.construireProjet(750, 66));
        projetsDuJour3.add(Projet.construireProjet(791, 66));
        jours.add(projetsDuJour3);

        List<Projet> projetsDuJour4 = new ArrayList<Projet>();
        projetsDuJour4.add(Projet.construireProjet(555, 66));
        projetsDuJour4.add(Projet.construireProjet(550, 66));
        projetsDuJour4.add(Projet.construireProjet(591, 66));
        jours.add(projetsDuJour4);

        List<Projet> projetsDuJour5 = new ArrayList<Projet>();
        projetsDuJour5.add(Projet.construireProjet(830, 66));
        projetsDuJour5.add(Projet.construireProjet(831, 66));
        projetsDuJour5.add(Projet.construireProjet(832, 66));
        jours.add(projetsDuJour5);

        List<Projet> projetsDuJour6 = new ArrayList<Projet>();
        projetsDuJour6.add(Projet.construireProjet(998, 66));
        projetsDuJour6.add(Projet.construireProjet(910, 66));
        projetsDuJour6.add(Projet.construireProjet(911, 66));
        jours.add(projetsDuJour6);

        Validation instance = new Validation(mock);
        mock.setJours(jours);
        String expResult = "L'employe n'a pas respecte le nombre"
                + " d'heures permis du conge ferie le jour 2,L'"
                + "employe n'a pas droit au conge ferie pour le"
                + " weekend 2,";
        String result = instance.validerFinDeSemaine();
        assertEquals(expResult, result);

    }

    
    @Test
    public void testValiderJourOuvrable() throws Exception {
        System.out.println("validerJourOuvrable");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(999, 66));
        projetsDuJour.add(Projet.construireProjet(125, 66));
        projetsDuJour.add(Projet.construireProjet(998, 66));
        projetsDuJour.add(Projet.construireProjet(997, 66));
        projetsDuJour.add(Projet.construireProjet(996, 66));
        int i = 3;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        String expResult = "L'employe n'a pas respecte le nombre"
                + " d'heures du conge maladie permis le jour 3,L'"
                + "employe n'a pas respecte le nombre d'heures "
                + "permis du conge ferie le jour 3,L'employe n'a "
                + "pas respecte le nombre d'heures de vacance pour"
                + " le jour 3,L'employe n'a pas respecte le nombre"
                + " d'heures permis du conge parental pour le jour"
                + " 3,L'employe a exerce d'autres activites pendant"
                + " conge maladie ou parental le jour 3,";
        String result = instance.validerJourOuvrable(projetsDuJour, i);
        assertEquals(expResult, result);

    }

    
    @Test
    public void testValiderJourFinDeSemaine() throws Exception {
        System.out.println("validerJourFinDeSemaine");
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();

        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(999, 66));
        projetsDuJour.add(Projet.construireProjet(125, 66));
        projetsDuJour.add(Projet.construireProjet(998, 66));
        int i = 0;
        Validation instance = new Validation(mock);
        String expResult = "L'employe n'a pas respecte le nombre d'heures du "
                + "conge maladie permis le jour 0,L'employe n'a pas droit au"
                + " conge maladie pour le weekend 0,L'employe n'a pas respecte"
                + " le nombre d'heures permis du conge ferie le jour 0,L'employe"
                + " n'a pas droit au conge ferie pour le weekend 0,";

        String result = instance.validerJourFinDeSemaine(projetsDuJour, i);

        assertEquals(expResult, result);

    }

    
    @Test
    public void testValiderProjet() throws Exception {
        System.out.println("validerProjet");
        Projet unProjet = Projet.construireProjet(998, 66);
        int i = 6;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        String expResult = "L'employe n'a pas respecte le nombre d'heures "
                + "permis du conge ferie le jour 6,";
        String result = instance.validerProjet(unProjet, i);

        assertEquals(expResult, result);

    }

    
    @Test
    public void testValiderJournee32h() throws Exception {
        System.out.println("validerJournee32h");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(100, 66));
        projetsDuJour.add(Projet.construireProjet(125, 66));
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        int i = 2;
        String expResult = "L'employe n'a pas respecte les restrictions pour "
                + "les journées de 32h pour le jour ,";
        String result = instance.validerJournee32h(projetsDuJour, i);

        assertEquals(expResult, result);
        
        projetsDuJour.add(Projet.construireProjet(997, 688 ));
        result = instance.validerJournee32h(projetsDuJour, i);
        expResult ="";
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testContientTravailBureau() throws Exception {
        System.out.println("contientTravailBureau");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(340, 480));
        projetsDuJour.add(Projet.construireProjet(159, 480));
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        boolean expResult = true;
        boolean result = instance.contientTravailBureau(projetsDuJour);
        assertEquals(expResult, result);

    }

    
    @Test
    public void testContientTeleTravail() throws Exception {
        System.out.println("contientTeleTravail");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(340, 480));
        projetsDuJour.add(Projet.construireProjet(159, 480));
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);

        boolean expResult = false;
        boolean result = instance.contientTeleTravail(projetsDuJour);
        assertEquals(expResult, result);

        projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(900, 480));
        projetsDuJour.add(Projet.construireProjet(901, 480));
        instance = new Validation(mock);
        expResult = true;
        result = instance.contientTeleTravail(projetsDuJour);

        assertEquals(expResult, result);

    }

    
    @Test
    public void testContientCongeFerie() throws Exception {
        System.out.println("contientCongeFerie");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(999, 66));
        projetsDuJour.add(Projet.construireProjet(125, 66));
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        boolean expResult = false;
        boolean result = instance.contientCongeFerie(projetsDuJour);

        assertEquals(expResult, result);

    }

    
    @Test
    public void testContientCongeMaladie() throws Exception {
        System.out.println("contientCongeMaladie");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(999, 480));
        projetsDuJour.add(Projet.construireProjet(999, 480));
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        boolean expResult = true;
        boolean result = instance.contientCongeMaladie(projetsDuJour);

        assertEquals(expResult, result);

        projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(990, 480));
        projetsDuJour.add(Projet.construireProjet(920, 480));
        instance = new Validation(mock);
        expResult = false;
        result = instance.contientCongeMaladie(projetsDuJour);

        assertEquals(expResult, result);

    }

    
    @Test
    public void testContientCongeVacances() throws Exception {
        System.out.println("contientCongeVacances");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(997, 480));
        projetsDuJour.add(Projet.construireProjet(997, 480));
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        boolean expResult = true;
        boolean result = instance.contientCongeVacances(projetsDuJour);
        assertEquals(expResult, result);

        projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(990, 480));
        projetsDuJour.add(Projet.construireProjet(920, 480));
        instance = new Validation(mock);
        expResult = false;
        result = instance.contientCongeMaladie(projetsDuJour);
        assertEquals(expResult, result);

    }

    
    @Test
    public void testContientCongeParental() throws Exception {
        System.out.println("contientCongeParental");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(996, 480));
        projetsDuJour.add(Projet.construireProjet(996, 480));
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        boolean expResult = true;
        boolean result = instance.contientCongeParental(projetsDuJour);
        assertEquals(expResult, result);

        projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(990, 480));
        projetsDuJour.add(Projet.construireProjet(920, 480));
        instance = new Validation(mock);
        expResult = false;
        result = instance.contientCongeMaladie(projetsDuJour);

        assertEquals(expResult, result);

    }

    
    @Test
    public void testContientMemeCodeProjetDans() throws Exception {
        System.out.println("contientMemeCodeProjetDans");
        List<Projet> projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(500, 40));
        projetsDuJour.add(Projet.construireProjet(500, 40));
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        boolean expResult = true;
        boolean result = instance.contientMemeCodeProjetDans(projetsDuJour);
        assertEquals(expResult, result);

        projetsDuJour = new ArrayList<Projet>();
        projetsDuJour.add(Projet.construireProjet(50, 40));
        projetsDuJour.add(Projet.construireProjet(500, 40));
        instance = new Validation(mock);
        expResult = false;
        result = instance.contientMemeCodeProjetDans(projetsDuJour);
        assertEquals(expResult, result);

    }

    @Test
    public void testSetMaximum_minutes_temps_transport_semaine() throws IOException {
        System.out.println("setMaximum_minutes_temps_transport_semaine");
        double maximum_minutes_temps_transport_semaine = 0.0;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMaximum_minutes_temps_transport_semaine(maximum_minutes_temps_transport_semaine);
        assertTrue(0.0 == instance.getMaximum_minutes_temps_transport_semaine());
        
        instance.setMaximum_minutes_temps_transport_semaine(300);
        assertTrue(300.0 == instance.getMaximum_minutes_temps_transport_semaine());
    }

    @Test
    public void testSetAppliquerCodeTransport() throws Exception {
        System.out.println("setAppliquerCodeTransport");
        int appliquerCodeTransport = 0;
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setAppliquerCodeTransport(appliquerCodeTransport);
        assertTrue(0 == instance.getAppliquerCodeTransport());
        
        instance.setAppliquerCodeTransport(1);
        assertTrue(1 == instance.getAppliquerCodeTransport());
        
        instance.setAppliquerCodeTransport(-1);
        assertTrue(-1 == instance.getAppliquerCodeTransport());
    }

    @Test
    public void testGetHeuresDeTransport() throws IOException {
        System.out.println("getHeuresDeTransport");
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        double expResult = 0.0;
        double result = instance.getHeuresDeTransport();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMinimum_minutes_par_semaine() throws IOException {
        System.out.println("getMinimum_minutes_par_semaine");
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMinimum_minutes_par_semaine(0.0);
        double expResult = 0.0;
        double result = instance.getMinimum_minutes_par_semaine();
        assertEquals(expResult, result, 0.0);
        
        instance.setMinimum_minutes_par_semaine(2560.0);
        expResult = 2560.0;
        result = instance.getMinimum_minutes_par_semaine();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMinimum_minutes_par_jour() throws IOException {
        System.out.println("getMinimum_minutes_par_jour");
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMinimum_minutes_par_jour(0.0);
        double expResult = 0.0;
        double result = instance.getMinimum_minutes_par_jour();
        assertEquals(expResult, result, 0.0);
        
        instance.setMinimum_minutes_par_jour(360.0);
        expResult = 360.0;
        result = instance.getMinimum_minutes_par_jour();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMaximum_minutes_par_jour() throws IOException {
        System.out.println("getMaximum_minutes_par_jour");
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMaximum_minutes_par_jour(0.0);
        double expResult = 0.0;
        double result = instance.getMaximum_minutes_par_jour();
        assertEquals(expResult, result, 0.0);
        
        instance.setMaximum_minutes_par_jour(360.0);
        expResult = 360.0;
        result = instance.getMaximum_minutes_par_jour();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMaximum_minutes_par_semaine() throws IOException {
        System.out.println("getMaximum_minutes_par_semaine");
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMaximum_minutes_par_semaine(0.0);
        double expResult = 0.0;
        double result = instance.getMaximum_minutes_par_semaine();
        assertEquals(expResult, result, 0.0);
        
        instance.setMaximum_minutes_par_semaine(2560.0);
        expResult = 2560.0;
        result = instance.getMaximum_minutes_par_semaine();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMaximum_minutes_tele_travail_semaine() throws IOException {
        System.out.println("getMaximum_minutes_tele_travail_semaine");
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMaximum_minutes_tele_travail_semaine(0.0);
        double expResult = 0.0;
        double result = instance.getMaximum_minutes_tele_travail_semaine();
        assertEquals(expResult, result, 0.0);
        
        instance.setMaximum_minutes_tele_travail_semaine(60.0);
        expResult = 60.0;
        result = instance.getMaximum_minutes_tele_travail_semaine();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMaximum_minutes_temps_transport_semaine() throws IOException {
        System.out.println("getMaximum_minutes_temps_transport_semaine");
        MockFeuilleDeTemps mock = new MockFeuilleDeTemps();
        Validation instance = new Validation(mock);
        instance.setMaximum_minutes_temps_transport_semaine(0.0);
        double expResult = 0.0;
        double result = instance.getMaximum_minutes_temps_transport_semaine();
        assertEquals(expResult, result, 0.0);
        
        instance.setMaximum_minutes_temps_transport_semaine(300.0);
        expResult = 300.0;
        result = instance.getMaximum_minutes_temps_transport_semaine();
        assertEquals(expResult, result, 0.0);
    }

}
