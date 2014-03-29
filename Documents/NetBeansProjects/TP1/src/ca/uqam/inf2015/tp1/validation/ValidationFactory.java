package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.employe.Employe;
import java.io.IOException;

public abstract class ValidationFactory{
    public static Validation construireValidationEmploye(Employe unEmploye) throws IOException {
        Validation validation;
        
        if (unEmploye.getTypeEmploye() == 'A') {
            validation = new Validation(unEmploye.getFeuilleDeTemps());
            validation.setMinimum_minutes_par_semaine(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE"));
            validation.setMaximum_minutes_tele_travail_semaine(
                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE"));
            validation.setMinimum_minutes_par_jour(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_ADMIN_PAR_JOUR"));
            validation.setMaximum_minutes_par_semaine(
                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_BUREAU_ADMIN_SEMAINE"));
        } else if (unEmploye.getTypeEmploye() == 'D') {
            validation = new Validation(unEmploye.getFeuilleDeTemps());
            validation.setMinimum_minutes_par_semaine(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_DIRECTEUR_SEMAINE"));
        } else if (unEmploye.getTypeEmploye() == 'E') {
            validation = new Validation(unEmploye.getFeuilleDeTemps());
            validation.setMinimum_minutes_par_semaine(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_EXPLOITATION_SEMAINE"));
        } else {
            validation = new Validation(unEmploye.getFeuilleDeTemps());
            validation.setMinimum_minutes_par_semaine(
                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PRODUCTION_SEMAINE"));
        }
        
        return validation;
    }
}
