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
    public String validerFeuilleDeTemps() {
        String message = "";
        
        return message;
    }

    @Override
    public String validerSemaine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String validerJoursOuvrables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String validerFinDeSemaine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String validerJourOuvrable(List<Projet> projetsDuJour, int i) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
