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
    
    public Validation() throws IOException {
        maximum_minutes_par_jour = AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_OFFICE_WORK_BY_DAY");
    }
    
    public void setHeuresDeBureauParSemaine() throws IOException {
        heuresDeBureauParSemaine =
            feuilleDeTemps.calculerHeuresBureauParSemaine();
    }

    public void setHeuresDeTeleTravailParSemaine() throws IOException {
        heuresTeleTravailParSemaine =
            feuilleDeTemps.calculerHeuresTeleTravailParSemaine();
    }
    
    public abstract String validerFeuilleDeTemps() throws IOException;
    public abstract String validerSemaine() throws IOException;
    public abstract String validerJoursOuvrables() throws IOException;
    public abstract String validerFinDeSemaine() throws IOException;
    public abstract String validerJourOuvrable(List<Projet> projetsDuJour, int i) throws IOException;
    public abstract String validerJourFinDeSemaine(List<Projet> projetsDuJour, int i) throws IOException;
    public abstract String validerProjet(Projet unProjet, int i) throws IOException;
    public abstract boolean contientTravailBureau(List<Projet> projetsDuJour) throws IOException;
    public abstract boolean contientTeleTravail(List<Projet> projetsDuJour) throws IOException;
    public abstract boolean contientCongeFerie(List<Projet> projetsDuJour) throws IOException;
    public abstract boolean contientCongeMaladie(List<Projet> projetsDuJour) throws IOException;
    public abstract boolean contientCongeVacances(List<Projet> projetsDuJour) throws IOException;
    public abstract boolean contientCongeParental(List<Projet> projetsDuJour) throws IOException;
}
