package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.Projet;
import java.io.IOException;
import java.util.List;

public class ValidationEmployeNormal extends Validation {
    
    public ValidationEmployeNormal(FeuilleDeTemps feuilleDeTemps, double min_par_jour, double min_par_semaine) throws IOException {
        super();
        this.feuilleDeTemps = feuilleDeTemps;
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
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MINIMUM_BUREAU_SEMAINE") + ',';
        } else if (heuresDeBureauParSemaine > maximum_minutes_par_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_BUREAU_SEMAINE") + ',';
        }
        
        return message;
    }
    
    @Override
    public String validerJoursOuvrables() throws IOException {
        String message = "";
        List<List<Projet>> jours = feuilleDeTemps.getJours();
        
        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
            List<Projet> projectList = jours.get(numeroJour);
            double heureBureauJour = FeuilleDeTemps.calculerHeuresBureauJour(projectList);

            if (heureBureauJour < minimum_minutes_par_jour) {
                message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MINIMUM_BUREAU_JOUR")
                            + String.valueOf(numeroJour + 1) + ',';
            } else if (heureBureauJour > maximum_minutes_par_jour) {
                if (heureBureauJour > 1920) {
                    message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_BUREAU_PAR_JOUR")
                                + String.valueOf(numeroJour + 1) + ',';
                } else if (heureBureauJour == 1920) {
                    message += validerJourOuvrable(projectList, numeroJour+1) + ',';
                } else {
                    message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_TRAVAIL_PAR_JOUR")
                                + String.valueOf(numeroJour + 1) + ',';
                }
            } else {
                message += validerJourOuvrable(projectList, numeroJour+1);
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
            
            message += validerJourFinDeSemaine(projectList, numeroJour-4);
        }
        
        return message;
    }

    @Override
    public String validerJourOuvrable(List<Projet> projetsDuJour, int i) throws IOException {
        String message = "";
        boolean disposeTravailBureau, disposeTeleTravail, disposeCongesFerie, disposeCongesMaladie;
        boolean disposeCongesVacances, disposeCongesParental;
        
        disposeTravailBureau = contientTravailBureau(projetsDuJour);
        disposeTeleTravail = contientTeleTravail(projetsDuJour);
        disposeCongesFerie = contientCongeFerie(projetsDuJour);
        disposeCongesMaladie = contientCongeMaladie(projetsDuJour);
        disposeCongesVacances = contientCongeVacances(projetsDuJour);
        disposeCongesParental = contientCongeParental(projetsDuJour);
        
        for (int j = 0; j < projetsDuJour.size(); ++j) {
            Projet unProjet = projetsDuJour.get(j);
            message += validerProjet(unProjet, i);
        }
        
        if (disposeTravailBureau && disposeTeleTravail && (disposeCongesFerie || disposeCongesVacances)) {
            message += AppConfig.getParametreRetournerUnString("MSG_AUTRE_ACTIVITE_CONGE_FERIE") + i + ',';
        } else if ((disposeCongesMaladie || disposeCongesParental) && (disposeTeleTravail || disposeTravailBureau)) {
            message += AppConfig.getParametreRetournerUnString("MSG_AUTRE_ACTIVITE_CONGE_MALADIE") + i + ',';
        } 
        
        return message;
    }

    @Override
    public String validerJourFinDeSemaine(List<Projet> projetsDuJour, int i) throws IOException {
        String message = "";
        
        for (int j = 0; j < projetsDuJour.size(); ++j) {
            Projet unProjet = projetsDuJour.get(j);
            
            if (unProjet.estJourneeVacance()) {
                message += AppConfig.getParametreRetournerUnString("MSG_CONGE_VACANCE_FIN_DE_SEMAINE") + i + ',';
            } else if (unProjet.estUnCongeFerie()) {
                message += AppConfig.getParametreRetournerUnString("MSG_CONGE_FERIE_FIN_DE_SEMAINE") + i + ',';
            } else if (unProjet.estUnCongeMaladie()) {
                message += AppConfig.getParametreRetournerUnString("MSG_CONGE_MALADIE_FIN_DE_SEMAINE") + i + ',';
            } else if (unProjet.estUnCongeParental()) {
                message += AppConfig.getParametreRetournerUnString("MSG_CONGE_PARENTAL_FIN_DE_SEMAINE") + i + ',';
            }
        }
        
        return message;
    }
    
    @Override
    public String validerProjet(Projet unProjet, int i) throws IOException {
        String message = "";
        
        if (unProjet.estJourneeVacance() 
                && unProjet.getMinutes() != AppConfig.getParametreRetournerUnDouble("MINUTES_CONGE_VACANCE")) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_CONGE_VACANCE") + i + ',';
        } else if (unProjet.estUnCongeFerie()
                    && unProjet.getMinutes() != AppConfig.getParametreRetournerUnDouble("MINUTES_CONGE_FERIE")) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_CONGE_FERIE") + i + ',';
        } else if (unProjet.estUnCongeMaladie()
                    && unProjet.getMinutes() != AppConfig.getParametreRetournerUnDouble("MINUTES_CONGE_MALADIE")) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_CONGE_MALADIE") + i + ',';
        } else if (unProjet.estUnCongeParental()
                    && unProjet.getMinutes() != AppConfig.getParametreRetournerUnDouble("MINUTES_CONGE_PARENTAL")) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_CONGE_PARENTAL") + i + ',';
        }
        
        return message;
    }

    @Override
    protected String validerJournee32h(List<Projet> projetsDuJour, int i) throws IOException {
        String message = "";
        
        if (!contientCongeFerie(projetsDuJour) || !contientCongeVacances(projetsDuJour)) {
           message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_32") + ',';
        } else if (!contientTeleTravail(projetsDuJour) || !contientTravailBureau(projetsDuJour)) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_32") + ',';
        }
        
        return message;
    }
}
