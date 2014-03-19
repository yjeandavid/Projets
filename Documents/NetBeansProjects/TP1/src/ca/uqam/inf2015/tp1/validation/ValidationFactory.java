package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import java.io.IOException;

public abstract class ValidationFactory{
    public static Validation construireValidationEmploye(char typeEmploye) throws IOException {
        Validation validation;
        
        if (typeEmploye == 'A') {
            validation = new ValidationEmployeDirection(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE"),
                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE"));
        } else if (typeEmploye == 'D') {
            validation = new ValidationEmployeDirection(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_DIRECTEUR_SEMAINE"),
                            Double.MAX_VALUE);
        } else if (typeEmploye == 'E') {
            validation = new ValidationEmployeNormal(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PRODUCTION_PAR_JOUR"),
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_EXPLOITATION_PAR_SEMAINE"));
        } else {
            validation = new ValidationEmployeNormal(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PRODUCTION_PAR_JOUR"),
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PRODUCTION_PAR_SEMAINE"));
        }
        
        return validation;
    }
}
