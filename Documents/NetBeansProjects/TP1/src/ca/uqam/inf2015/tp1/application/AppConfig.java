package ca.uqam.inf2015.tp1.application;

public class AppConfig {

    public static final int CODE_REF_TELE_TRAVAIL = 900;
    public static final int CODE_REF_CONGES_MALADIE = 999;
    public static final int CODE_REF_CONGES_FERIES = 998;

    public static final int CODE_REF_TYPE_EMPLOYE = 1000;
    public static final int CODE_REF_TYPE_EMPLOYE_CATEGORIE = 2000;
    
    public static final int MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE = 2160;
    public static final int MINIMUM_MINUTES_BUREAU_ADMIN_PAR_JOUR = 240;
    public static final int MINIMUM_MINUTES_BUREAU_PRODUCTION_SEMAINE = 2280;
    public static final int MINIMUM_MINUTES_BUREAU_PRODUCTION_PAR_JOUR = 360;
    public static final int MAXIMUM_MINUTES_OFFICE_WORK_BY_DAY = 1440;
    public static final int MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE = 2580;
    public static final int MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE = 600;
    public static final int MINIMUM_MINUTES_BUREAU_EXPLOITATION_SEMAINE = 2280;
    public static final int MINUTES_CONGES_MALADIE = 420;
    public static final int MINUTES_CONGES_FERIES = 420;
    
    public static final char EMPLOYE_ADMINISTRATION = 'A';
    public static final char EMPLOYE_EXPLOITATION = 'E';
    public static final char EMPLOYE_PRODUCTION = 'P';
   
    
    public static final String MSG_HEURES_MINIMUM_JOUR_BUREAU = "L'employe n'a "
            + "pas travaille le nombre d'heures minimal pour ";
    public static final String MSG_HEURES_MINIMUM_SEMAINE_BUREAU = "L'employe "
            + "n'a pas travaille le nombre d'heures minimal par semaine ";
    public static final String MSG_HEURES_MAXIMAL_BUREAU_SEMAINE = "L'employe a depasse"
            + " le nombre d'heures au bureau par semaine";
    public static final String MSG_MAXIMAL_HOURS_OFFICE_WORK_BY_DAY = "L'employe a depasse"
            + " le nombre d'heures au bureau pour jour";
    public static final String MSG_HEURES_MAXIMAL_TELE_TRAVAIL = "L'employe a"
            + " depasse le nombre d'heures de teletravail permis ";
    public static final String MSG_HEURES_CONGES_MALADIE = "L'employe n'a"
            + " pas respecte le nombre d'heures du conges maladie permis ";
    public static final String MSG_AUTRE_ACTIVITE_CONGES_MALADIE = "L'employe a"
            + " exerce d'autre activite le jour du conge maladie ";
    public static final String MSG_CONGES_MALADIE_FIN_DE_SEMAINE = "L'employe n'a"
            + " pas doit au conge maladie ";
    public static final String MSG_HEURES_CONGES_FERIE = "L'employe n'a"
            + " pas respecte le nombre d'heures du conge ferie permis ";
    public static final String MSG_AUTRE_ACTIVITE_CONGES_FERIE = "L'employe a"
            + " exerce d'autre activite autre que le teletravail le jour du conge ferie ";
    public static final String MSG_CONGES_FERIE_FIN_DE_SEMAINE = "L'employe n'a"
            + " pas doit au conge ferie ";
    
    public final static String CLE_NO_EMPLOYE	= "numero_employe";
    public final static String CLE_JOUR	   		= "jour";
    public final static String CLE_WEEKEND	   	= "weekend";
    public final static String CLE_PROJET	   	= "projet";
    public final static String CLE_MINUTES	   	= "minutes";
}
