package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import java.io.IOException;

public class ValidationEmployeNormal extends Validation {
    
    public ValidationEmployeNormal(double min_par_jour, double min_par_semaine) throws IOException {
        super();
        minimum_minutes_par_jour = min_par_jour;
        minimum_minutes_par_semaine = min_par_semaine;
        maximum_minutes_par_semaine=AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE");
        setHeuresDeBureauParSemaine();
        setHeuresDeTeleTravailParSemaine();
    }
    
    @Override
    public String validerFeuilleDeTemps() throws IOException {
        String message = "";
        
        message += validerSemaine() + ',';
        
        return message;
    }

    @Override
    public String validerSemaine() throws IOException{
        String message = "";
        
        message += validerJoursOuvrables() + ',';
        message += validerFinDeSemaine() + ',';
        
        if (heuresDeBureauParSemaine < minimum_minutes_par_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MINIMUM_SEMAINE_BUREAU") + ',';
        } else if (heuresDeBureauParSemaine > maximum_minutes_par_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMAL_BUREAU_SEMAINE") + ',';
        }
        
        return message;
    }
    
    @Override
    public String validerJoursOuvrables() {
        String message = "";
        
        
        
        return message;
    }

    @Override
    public String validerFinDeSemaine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
