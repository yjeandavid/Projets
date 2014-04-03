package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.Projet;
import java.io.IOException;
import java.util.List;

public class Validation {
    protected FeuilleDeTemps feuilleDeTemps = null;
    protected int nbreCongeParental = 0;
    protected double heuresDeBureauParSemaine = 0.0;
    protected double heuresTeleTravailParSemaine = 0.0;
    protected double minimum_minutes_par_semaine;
    protected double minimum_minutes_par_jour = 
                                AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PRODUCTION_PAR_JOUR");
    protected double maximum_minutes_par_jour = 
                                AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_BUREAU_PAR_JOUR");
    protected double maximum_minutes_par_semaine = 
                                AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE");
    protected double maximum_minutes_tele_travail_semaine = Double.MAX_VALUE;

    public Validation(FeuilleDeTemps feuilleDeTemps) throws IOException {
        this.feuilleDeTemps = feuilleDeTemps;
        setHeuresDeBureauParSemaine();
        setHeuresDeTeleTravailParSemaine();
    }
    
    private void setHeuresDeBureauParSemaine() throws IOException {
        heuresDeBureauParSemaine =
            feuilleDeTemps.calculerHeuresBureauParSemaine();
    }

    private void setHeuresDeTeleTravailParSemaine() throws IOException {
        heuresTeleTravailParSemaine =
            feuilleDeTemps.calculerHeuresTeleTravailParSemaine();
    }
    
    public void setMinimum_minutes_par_jour(double minimum_minutes_par_jour) {
        this.minimum_minutes_par_jour = minimum_minutes_par_jour;
    }

    public void setMinimum_minutes_par_semaine(double minimum_minutes_par_semaine) {
        this.minimum_minutes_par_semaine = minimum_minutes_par_semaine;
    }

    public void setMaximum_minutes_par_jour(double maximum_minutes_par_jour) {
        this.maximum_minutes_par_jour = maximum_minutes_par_jour;
    }

    public void setMaximum_minutes_par_semaine(double maximum_minutes_par_semaine) {
        this.maximum_minutes_par_semaine = maximum_minutes_par_semaine;
    }
    
    public void setMaximum_minutes_tele_travail_semaine(double maximum_minutes_tele_travail_semaine) {
        this.maximum_minutes_tele_travail_semaine = maximum_minutes_tele_travail_semaine;
    }
    
    public String validerFeuilleDeTemps() throws IOException {
        String message = "";
        
        message += validerSemaine() + ',';
        
        return message;
    }
    
    protected String validerSemaine() throws IOException {
        String message = "";
        
        message += validerJoursOuvrables() + ',';
        message += validerFinDeSemaine() + ',';
        
        if (nbreCongeParental > 1) {
            message += AppConfig.getParametreRetournerUnString("MSG_ABUS_CONGE_PARENTAL") + ',';
        }
        
        if (heuresDeBureauParSemaine < minimum_minutes_par_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MINIMUM_BUREAU_SEMAINE") + ',';
        } else if (heuresDeBureauParSemaine > maximum_minutes_par_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_BUREAU_SEMAINE") + ',';
        }
        if (heuresTeleTravailParSemaine > maximum_minutes_tele_travail_semaine) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_TELE_TRAVAIL") + ',';
        }
        
        return message;
    }
    
    protected String validerJoursOuvrables() throws IOException {
        String message = "";
        List<List<Projet>> jours = feuilleDeTemps.getJours();
        
        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
            List<Projet> projectList = jours.get(numeroJour);
            double heureBureauJour = FeuilleDeTemps.calculerHeuresBureauJour(projectList);
            message += validerJourOuvrable(projectList, numeroJour+1) + ',';
            
            if (heureBureauJour < minimum_minutes_par_jour) {
                message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MINIMUM_BUREAU_JOUR")
                            + String.valueOf(numeroJour + 1) + ',';
            } else if (heureBureauJour > maximum_minutes_par_jour) {
                if (heureBureauJour > 1920) {
                    message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_BUREAU_PAR_JOUR")
                                + String.valueOf(numeroJour + 1) + ',';
                } else if (heureBureauJour == 1920) {
                    message += validerJournee32h(projectList, numeroJour+1) + ',';
                } else {
                    message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_TRAVAIL_PAR_JOUR")
                                + String.valueOf(numeroJour + 1) + ',';
                }
            }
        }
        return message;
    }
    
    protected String validerFinDeSemaine() throws IOException {
        String message = "";
        
        List<List<Projet>> jours = feuilleDeTemps.getJours();
        
        for (int numeroJour = 5; numeroJour < 7; ++numeroJour) {
            List<Projet> projectList = jours.get(numeroJour);
            
            message += validerJourFinDeSemaine(projectList, numeroJour-4);
        }
        
        return message;
    }
    
    protected String validerJourOuvrable(List<Projet> projetsDuJour, int i) throws IOException {
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
            if (unProjet.getMinutes() == 0) {
                message += AppConfig.getParametreRetournerUnString("MSG_0_MINUTES_NON_PERMIS") + "jour " + i + ',';
            }
            message += validerProjet(unProjet, i);
        }
        
        if (contientMemeCodeProjetDans(projetsDuJour)) {
            message += AppConfig.getParametreRetournerUnString("MSG_MEME_NUMERO_DE_PROJET") + "jour "+ i + ',';
        }
        
        if ((disposeCongesMaladie || disposeCongesParental) && (disposeTeleTravail || disposeTravailBureau)) {
            message += AppConfig.getParametreRetournerUnString("MSG_AUTRE_ACTIVITE_CONGE_MALADIE") + i + ',';
        } else if ((disposeTravailBureau && disposeTeleTravail && (disposeCongesFerie || disposeCongesVacances))
                || ((disposeCongesFerie || disposeCongesVacances) && (disposeCongesMaladie || disposeCongesParental))) {
            message += AppConfig.getParametreRetournerUnString("MSG_AUTRE_ACTIVITE_CONGE_FERIE") + i + ',';
        }
        
        return message;
    }
    
    protected String validerJourFinDeSemaine(List<Projet> projetsDuJour, int i) throws IOException {
        String message = "";
        
        for (int j = 0; j < projetsDuJour.size(); ++j) {
            Projet unProjet = projetsDuJour.get(j);
            
            if (unProjet.getMinutes() == 0) {
                message += AppConfig.getParametreRetournerUnString("MSG_0_MINUTES_NON_PERMIS") + "weekend " + i + ',';
            }
            
            message += validerProjet(unProjet, i);
                
            if (contientMemeCodeProjetDans(projetsDuJour)) {
                message += AppConfig.getParametreRetournerUnString("MSG_MEME_NUMERO_DE_PROJET") + "weekend "+ i + ',';
            }
        
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
    
    protected String validerJournee32h(List<Projet> projetsDuJour, int i) throws IOException {
        String message = "";
        
        if (!contientCongeFerie(projetsDuJour) && !contientCongeVacances(projetsDuJour)) {
           message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_32") + ',';
        } else if (!contientTeleTravail(projetsDuJour) && !contientTravailBureau(projetsDuJour)) {
            message += AppConfig.getParametreRetournerUnString("MSG_HEURES_MAXIMUM_32") + ',';
        }
        
        return message;
    }
    
    protected boolean contientTravailBureau(List<Projet> projetsDuJour) throws IOException {
        boolean resultat = false;
        
        for (int i = 0; (i < projetsDuJour.size() && !resultat); ++i) {
            Projet unProjet = projetsDuJour.get(i);
            if (unProjet.estTravailBureau()) {
                resultat = true;
            }
        }
        
        return resultat;
    }

    protected boolean contientTeleTravail(List<Projet> projetsDuJour) throws IOException {
        boolean resultat = false;
        
        for (int i = 0; (i < projetsDuJour.size() && !resultat); ++i) {
            Projet unProjet = projetsDuJour.get(i);
            if (unProjet.estTeleTravail()) {
                resultat = true;
            }
        }
        
        return resultat;
    }

    protected boolean contientCongeFerie(List<Projet> projetsDuJour) throws IOException {
        boolean resultat = false;
        
        for (int i = 0; (i < projetsDuJour.size() && !resultat); ++i) {
            Projet unProjet = projetsDuJour.get(i);
            if (unProjet.estUnCongeFerie()) {
                resultat = true;
            }
        }
        
        return resultat;
    }

    protected boolean contientCongeMaladie(List<Projet> projetsDuJour) throws IOException {
        boolean resultat = false;
        
        for (int i = 0; (i < projetsDuJour.size() && !resultat); ++i) {
            Projet unProjet = projetsDuJour.get(i);
            if (unProjet.estUnCongeMaladie()) {
                resultat = true;
            }
        }
        
        return resultat;
    }

    protected boolean contientCongeVacances(List<Projet> projetsDuJour) throws IOException {
        boolean resultat = false;
        
        for (int i = 0; (i < projetsDuJour.size() && !resultat); ++i) {
            Projet unProjet = projetsDuJour.get(i);
            if (unProjet.estJourneeVacance()) {
                resultat = true;
            }
        }
        
        return resultat;
    }

    protected boolean contientCongeParental(List<Projet> projetsDuJour) throws IOException {
        boolean resultat = false;
        
        for (int i = 0; i < projetsDuJour.size(); ++i) {
            Projet unProjet = projetsDuJour.get(i);
            if (unProjet.estUnCongeParental()) {
                resultat = true;
                ++nbreCongeParental;
            }
        }
        
        return resultat;
    }
    
    protected boolean contientMemeCodeProjetDans(List<Projet> projetsDuJour) throws IOException {
        boolean resultat = false;
        
        for (int i = 0; (i <= projetsDuJour.size()-2 && !resultat); ++i) {
            Projet projet1 = projetsDuJour.get(i);
            for (int j = i+1; (j < projetsDuJour.size() && !resultat); ++j) {
                Projet projet2 = projetsDuJour.get(j);
                if (projet1.equals(projet2)) {
                    resultat = true;
                }
            }
        }
        
        return resultat;
    }
}
