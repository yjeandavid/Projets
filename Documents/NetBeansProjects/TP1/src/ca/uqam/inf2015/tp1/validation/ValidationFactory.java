package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.employe.Employe;
import java.io.IOException;

public abstract class ValidationFactory{
    public static Validation construireValidationEmploye(Employe unEmploye) throws IOException {
        Validation validation;
        
        if (unEmploye.getTypeEmploye() == 'A') {
            validation = new ValidationEmployeDirection(
                            unEmploye.getFeuilleDeTemps(),
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE"),
                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE"),
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_ADMIN_PAR_JOUR"),
                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_BUREAU_ADMIN_SEMAINE"));
        } else if (unEmploye.getTypeEmploye() == 'D') {
            validation = new ValidationEmployeNormal(
                            unEmploye.getFeuilleDeTemps(),
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_DIRECTEUR_SEMAINE"));
        } else if (unEmploye.getTypeEmploye() == 'E') {
            validation = new ValidationEmployeNormal(
                            unEmploye.getFeuilleDeTemps(),
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_EXPLOITATION_SEMAINE"));
        } else {
            validation = new ValidationEmployeNormal(
                            unEmploye.getFeuilleDeTemps(),
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PRODUCTION_SEMAINE"));
        }
        
        return validation;
    }
}
