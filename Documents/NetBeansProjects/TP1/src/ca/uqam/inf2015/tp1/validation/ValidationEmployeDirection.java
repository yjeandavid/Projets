package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.Projet;
import java.io.IOException;
import java.util.List;

public class ValidationEmployeDirection extends Validation {
    protected double maximum_minutes_tele_travail_semaine;
    
    public ValidationEmployeDirection(FeuilleDeTemps feuilleDeTemps, double min_par_semaine, double max_tele_travail) throws IOException {
        super();
        this.feuilleDeTemps = feuilleDeTemps;
        minimum_minutes_par_semaine = min_par_semaine;
        maximum_minutes_tele_travail_semaine =  max_tele_travail;
        minimum_minutes_par_jour = AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PAR_JOUR");
        maximum_minutes_par_semaine = AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_BUREAU_ADMIN_SEMAINE");
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
    public String validerSemaine() throws IOException {
        String message = "";
        
        message += validerJoursOuvrables() + ',';
        message += validerFinDeSemaine() + ',';
        
        if (heuresDeBureauParSemaine < minimum_minutes_par_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MINIMUM_BUREAU_SEMAINE") + ',';
        } else if (heuresDeBureauParSemaine > maximum_minutes_par_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMAL_BUREAU_SEMAINE") + ',';
        }
        if (heuresTeleTravailParSemaine > maximum_minutes_tele_travail_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMAL_TELE_TRAVAIL") + ',';
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
                message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MINIMUM_JOUR_BUREAU")
                            + String.valueOf(numeroJour + 1) + ',';
            } else if (heureBureauJour > maximum_minutes_par_jour) {
                if (heureBureauJour > 1920) {
                    message += AppConfig.getParametreRetournerUnString("MSG_MAXIMUM_HEURE_DE_BUREAU_PAR_JOURS")
                                + String.valueOf(numeroJour + 1) + ',';
                } else if (heureBureauJour == 1920) {
                    message += validerJourOuvrable(projectList, numeroJour+1) + ',';
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
        double heureBureauJour = FeuilleDeTemps.calculerHeuresBureauJour(projetsDuJour);
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
            message += AppConfig.getParametreRetournerUnString("MSG_AUTRE_ACTIVITE_CONGES_FERIE_VACANCES") + i + ',';
        } else if ((disposeCongesMaladie || disposeCongesParental) && (disposeTeleTravail || disposeTravailBureau)) {
            message += AppConfig.getParametreRetournerUnString("MSG_AUTRE_ACTIVITE_CONGES_MALADIE_PARENTAL") + i + ',';
        } 
        
        return message;
    }

    @Override
    public String validerJourFinDeSemaine(List<Projet> projetsDuJour, int i) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String validerProjet(Projet unProjet, int i) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contientTravailBureau(List<Projet> projetsDuJour) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contientTeleTravail(List<Projet> projetsDuJour) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contientCongeFerie(List<Projet> projetsDuJour) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contientCongeMaladie(List<Projet> projetsDuJour) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contientCongeVacances(List<Projet> projetsDuJour) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contientCongeParental(List<Projet> projetsDuJour) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
