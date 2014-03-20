package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.Projet;
import java.io.IOException;
import java.util.List;

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
    public String validerJoursOuvrables() throws IOException {
        String message = "";
        List<List<Projet>> jours = feuilleDeTemps.getJours();
        
        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
            double       heureBureauJour;
            List<Projet> projectList = jours.get(numeroJour);

            heureBureauJour = FeuilleDeTemps.calculerHeuresBureauJour(projectList);

            if (heureBureauJour < minimum_minutes_par_jour) {
                message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MINIMUM_JOUR_BUREAU") + " "
                            + AppConfig.getParametreRetournerUnString("CLE_JOUR") + " " 
                            + String.valueOf(numeroJour + 1) + ',';
            } else if (heureBureauJour > maximum_minutes_par_jour) {
                if (heureBureauJour > 1920) {
                    message += AppConfig.getParametreRetournerUnString("MSG_MAXIMUM_HEURE_DE_BUREAU_PAR_JOURS") + " "
                                + String.valueOf(numeroJour + 1) + ',';
                } else if (heureBureauJour == 1920) {
                    message += validerJourOuvrable(projectList) + ',';
                }
            } else {
                message += validerJourOuvrable(projectList);
            }
        }
        return message;
    }

    @Override
    public String validerFinDeSemaine() throws IOException {
        String message = "";
        
        List<List<Projet>> jours = feuilleDeTemps.getJours();
        
        for (int numeroJour = 5; numeroJour < 7; ++numeroJour) {
            List<Projet> projectList = jours.get(numeroJour);
            
            message += validerJourFinDeSemaine(projectList);
        }
        
        return message;
    }

    @Override
    public String validerJourOuvrable(List<Projet> projetsDuJour) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String validerJourFinDeSemaine(List<Projet> projetDuJour) throws IOException {
        String message = "";
        
        for (int i = 0; i < projetDuJour.size(); ++i) {
            Projet unProjet = projetDuJour.get(i);
            
            if (unProjet.estJourneeVacance()) {
                message += ',';
            }
        }
        
        return message;
    }
    
    
}
