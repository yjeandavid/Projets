package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;
import java.io.IOException;

public class Projet {
    private double minutes;
    private int    noProjet;

    private Projet(int noProjet, double minutes) {
        setNoProjet(noProjet);
        setMinutes(minutes);
    }

    public static Projet construireProjet(int noProjet, double minutes) {
        return new Projet(noProjet, minutes);
    }

    public int getNoProjet() {
        return noProjet;
    }

    public double getMinutes() {
        return minutes;
    }

    private void setNoProjet(int noProjet) {
        this.noProjet = noProjet;
    }

    private void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    public boolean estTravailBureau() throws IOException {
        boolean isTravailBureau = false;
        
        if (noProjet <= AppConfig.getParametreRetournerUnDouble("CODE_REF_TELE_TRAVAIL")
              && noProjet != AppConfig.getParametreRetournerUnDouble("CODE_REF_TEMPS_TRANSPORT")) {
            isTravailBureau = true;
        }
        
        return isTravailBureau;
    }
    
    public boolean equals(Projet autreProjet) {
        return noProjet == autreProjet.getNoProjet();
    }
    
    public boolean estTeleTravail() throws IOException {
        boolean isTeleTravail = false;

        if ((AppConfig.getParametreRetournerUnDouble("CODE_REF_TELE_TRAVAIL") < noProjet
                && noProjet < AppConfig.getParametreRetournerUnDouble("CODE_REF_CONGE_PARENTAL"))
            || noProjet > AppConfig.getParametreRetournerUnDouble("CODE_REF_CONGE_MALADIE")) {
            isTeleTravail = true;
        }

        return isTeleTravail;
    }

    public boolean estUnCongeMaladie() throws IOException {
        boolean isCongeMaladie = false;
        
        if (noProjet == AppConfig.getParametreRetournerUnDouble("CODE_REF_CONGE_MALADIE")) {
            isCongeMaladie = true;
        }
        
        return isCongeMaladie;
    }

    public boolean estUnCongeFerie() throws IOException {
        boolean isCongeFerie = false;
        
        if (noProjet == AppConfig.getParametreRetournerUnDouble("CODE_REF_CONGE_FERIE")) {
            isCongeFerie = true;
        }
        
        return isCongeFerie;
    }

    public boolean estJourneeVacance() throws IOException {
        boolean isCongeVacance = false;
        
        if (noProjet == AppConfig.getParametreRetournerUnDouble("CODE_REF_CONGE_VACANCE")) {
            isCongeVacance = true;
        }
        
        return isCongeVacance;
    }

    public boolean estUnCongeParental() throws IOException {
        boolean isCongeParental = false;
        
        if (noProjet == AppConfig.getParametreRetournerUnDouble("CODE_REF_CONGE_PARENTAL")) {
            isCongeParental = true;
        }
        
        return isCongeParental;
    }
    
    public boolean estUnTempsTransport() throws IOException {
        boolean isTempsTransport = false;
        
        if (noProjet == AppConfig.getParametreRetournerUnDouble("CODE_REF_TEMPS_TRANSPORT")) {
            isTempsTransport = true;
        }
        
        return isTempsTransport;
    }
}