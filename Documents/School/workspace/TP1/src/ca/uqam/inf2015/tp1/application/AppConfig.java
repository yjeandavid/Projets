package ca.uqam.inf2015.tp1.application;

public class AppConfig {

    public static final int CODE_REF_TELE_TRAVAIL = 900;
    public static final int CODE_REF_TYPE_EMPLOYE = 1000;
    public static final int MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE = 2160;
    public static final int MINIMUM_MINUTES_BUREAU_ADMIN_PAR_JOUR = 240;
    public static final int MINIMUM_MINUTES_BUREAU_NORMAL_SEMAINE = 2280;
    public static final int MINIMUM_MINUTES_BUREAU_NORMAL_PAR_JOUR = 360;
    public static final int MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE = 2580;
    public static final int MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE = 600;
    
    public static final char EMPLOYE_ADMINISTRATION = 'A';
    public static final char EMPLOYE_NORMAL = 'N';
    
    public static final String MSG_HEURES_MINIMUM_JOUR_BUREAU = "L'employe n'a "
            + "pas travaille le nombre d'heures minimal par jours ouvrables.";
    public static final String MSG_HEURES_MINIMUM_SEMAINE_BUREAU = "L'employe "
            + "n'a pas travaille le nombre d'heures minimal par semaine.";
    public static final String MSG_HEURES_MAXIMAL_BUREAU = "L'employe a depasse"
            + " le nombre d'heures au bureau.";
    public static final String MSG_HEURES_MAXIMAL_TELE_TRAVAIL = "L'employe a"
            + " depasse le nombre d'heures de teletravail permis.";
    
    public final static String CLE_NO_EMPLOYE	= "numero_employe";
    public final static String CLE_JOUR	   		= "jour";
    public final static String CLE_WEEKEND	   	= "weekend";
    public final static String CLE_PROJET	   	= "projet";
    public final static String CLE_MINUTES	   	= "minutes";
}
