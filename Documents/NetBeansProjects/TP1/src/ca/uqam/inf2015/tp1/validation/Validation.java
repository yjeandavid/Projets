package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.Projet;
import java.io.IOException;
import java.util.List;

public abstract class Validation {
    protected FeuilleDeTemps feuilleDeTemps = null;
    protected double heuresDeBureauParSemaine = 0.0;
    protected double heuresTeleTravailParSemaine = 0.0;
    protected double minimum_minutes_par_jour;
    protected double minimum_minutes_par_semaine;
    protected double maximum_minutes_par_jour;
    protected double maximum_minutes_par_semaine;
    
    protected Validation() throws IOException {
        maximum_minutes_par_jour = AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_BUREAU_PAR_JOUR");
    }
    
    protected void setHeuresDeBureauParSemaine() throws IOException {
        heuresDeBureauParSemaine =
            feuilleDeTemps.calculerHeuresBureauParSemaine();
    }

    protected void setHeuresDeTeleTravailParSemaine() throws IOException {
        heuresTeleTravailParSemaine =
            feuilleDeTemps.calculerHeuresTeleTravailParSemaine();
    }
    
    public abstract String validerFeuilleDeTemps() throws IOException;
    protected abstract String validerSemaine() throws IOException;
    protected abstract String validerJoursOuvrables() throws IOException;
    protected abstract String validerFinDeSemaine() throws IOException;
    protected abstract String validerJourOuvrable(List<Projet> projetsDuJour, int i) throws IOException;
    protected abstract String validerJourFinDeSemaine(List<Projet> projetsDuJour, int i) throws IOException;
    protected abstract String validerProjet(Projet unProjet, int i) throws IOException;
    
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
        
        for (int i = 0; (i < projetsDuJour.size() && !resultat); ++i) {
            Projet unProjet = projetsDuJour.get(i);
            if (unProjet.estUnCongeParental()) {
                resultat = true;
            }
        }
        
        return resultat;
    }
}
