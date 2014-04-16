package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.employe.Employe;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public abstract class ValidationFactory {
	
    public static Validation construireValidationEmploye(Employe unEmploye) throws IOException {
        Validation validation = null;        
        JSONArray employeeConfig = AppConfig.getArray(String.valueOf(unEmploye.getTypeEmploye()));

		for (int i = 0; i < employeeConfig.size(); i++) {
			JSONObject obj = employeeConfig.getJSONObject(i);
			validation = new Validation(unEmploye.getFeuilleDeTemps());
			
            validation.setMinimum_minutes_par_semaine(obj.getDouble("MINIMUM_MINUTES_OFFICE_WEEK"));
            validation.setMaximum_minutes_tele_travail_semaine(obj.getDouble("MAXIMUM_MINUTES_HOME_WEEK"));
            validation.setMinimum_minutes_par_jour(obj.getDouble("MINIMUM_MINUTES_OFFICE_DAY"));
            validation.setMaximum_minutes_par_semaine(obj.getDouble("MAXIMUM_MINUTES_OFFICE_WEEK"));
            
            validation.setMaximum_minutes_temps_transport_semaine(obj.getDouble("MAXIMUM_MINUTES_TRANSPORT"));
            validation.setAppliquerCodeTransport(0);
            
//			maximumOfficePerDay = obj.getDouble("MAXIMUM_MINUTES_OFFICE_DAY");
		}
		
//        if (type == 'A') {
//            validation = new Validation(unEmploye.getFeuilleDeTemps());
//            validation.setMinimum_minutes_par_semaine(
//                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE"));
//            validation.setMaximum_minutes_tele_travail_semaine(
//                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE"));
//            validation.setMinimum_minutes_par_jour(
//                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_ADMIN_PAR_JOUR"));
//            validation.setMaximum_minutes_par_semaine(
//                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_BUREAU_ADMIN_SEMAINE"));
//            validation.setMaximum_minutes_temps_transport_semaine(
//                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_TEMPS_TRANSPORT_SEMAINE"));
//            validation.setAppliquerCodeTransport(0);
//        } else if (type == 'D' || type == 'C') {
//            validation = new Validation(unEmploye.getFeuilleDeTemps());
//            validation.setMinimum_minutes_par_semaine(
//                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_DIRECTEUR_SEMAINE"));
//            validation.setMinimum_minutes_par_jour(
//                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_DIRECTEUR_PAR_JOUR"));
//            validation.setMaximum_minutes_par_semaine(Double.MAX_VALUE);
//            if (type == 'D') {
//                validation.setAppliquerCodeTransport(1);
//                validation.setMaximum_minutes_temps_transport_semaine(
//                            AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_TEMPS_TRANSPORT_SEMAINE"));
//            } else {
//                validation.setAppliquerCodeTransport(0);
//                validation.setMaximum_minutes_temps_transport_semaine(Double.MAX_VALUE);
//            }
//        } else if (type == 'E') {
//            validation = new Validation(unEmploye.getFeuilleDeTemps());
//            validation.setMinimum_minutes_par_semaine(
//                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_EXPLOITATION_SEMAINE"));
//        } else {
//            validation = new Validation(unEmploye.getFeuilleDeTemps());
//            validation.setMinimum_minutes_par_semaine(
//                            AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PRODUCTION_SEMAINE"));
//        }
        
        return validation;
    }
}
