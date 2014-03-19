package ca.uqam.inf2015.tp1.feuilleDeTemps;

//~--- non-JDK imports --------------------------------------------------------

import ca.uqam.inf2015.tp1.application.AppConfig;

//~--- JDK imports ------------------------------------------------------------

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

    public boolean estTeleTravail() throws IOException {
        boolean isTeleTravail = false;

        if ((noProjet
                >= AppConfig.getParametreRetournerUnDouble(
                    "CODE_REF_TELE_TRAVAIL")) && (noProjet
                        != AppConfig.getParametreRetournerUnDouble(
                            "CODE_REF_CONGES_FERIES")) && (noProjet
                                != AppConfig.getParametreRetournerUnDouble(
                                    "CODE_REF_CONGES_MALADIE")) && (noProjet
                                        != AppConfig.getParametreRetournerUnDouble(
                                            "CODE_REF_JOURNEE_VACANCE"))) {
            isTeleTravail = true;
        }

        return isTeleTravail;
    }

    public boolean estUnCongeMaladie() throws IOException {
        return TypeDeProjet(
            AppConfig.getParametreRetournerUnDouble("CODE_REF_CONGES_MALADIE"));
    }

    public boolean estUnCongeFerie() throws IOException {
        return TypeDeProjet(
            AppConfig.getParametreRetournerUnDouble("CODE_REF_CONGES_FERIES"));
    }

    public boolean estJourneeVacance() throws IOException {
        return TypeDeProjet(
            AppConfig.getParametreRetournerUnDouble(
                "CODE_REF_JOURNEE_VACANCE"));
    }

    private boolean TypeDeProjet(double typeProjet) {
        boolean estUnTypeDeProjet = false;

        if (noProjet == typeProjet) {
            estUnTypeDeProjet = true;
        }

        return estUnTypeDeProjet;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
