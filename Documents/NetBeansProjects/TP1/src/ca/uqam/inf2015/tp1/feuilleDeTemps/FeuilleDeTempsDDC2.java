package ca.uqam.inf2015.tp1.feuilleDeTemps;

//~--- non-JDK imports --------------------------------------------------------

import ca.uqam.inf2015.tp1.application.AppConfig;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.List;

public class FeuilleDeTempsDDC2 {
    private FeuilleDeTemps     feuileDeTemps = null;
    private List<List<Projet>> jours;

    public FeuilleDeTempsDDC2(FeuilleDeTemps feuileDeTemps,
                              List<List<Projet>> jours) {
        this.feuileDeTemps = feuileDeTemps;
        this.jours         = jours;
    }

    public String resultatFinalAdmin() {
        return "try" + ',';
    }

    public String resultatFinalExploitation() {
        return "try" + ',';
    }

    public String resultatFinalProduction() throws IOException {
        return validerJournneeVacance();
    }

    public String validerJournneeVacance() throws IOException {
        String messageValidation = "";

        messageValidation = validerJournneeVacanceSemaine(
            AppConfig.configurations.getDouble("MINUTES_JOURNEE_VACANCE"));
        messageValidation += validerJournneeVacanceFinSemaine();

        return messageValidation;
    }

    private String validerJournneeVacanceSemaine(double heureJournneesVacance)
            throws IOException {
        String messageValidation = "";

        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
            double       heureJournneeVacance;
            List<Projet> projectList = jours.get(numeroJour);

            heureJournneeVacance = calculerJourneeVacance(projectList);

            if ((heureJournneeVacance != heureJournneesVacance)
                    && (heureJournneeVacance != -2)) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_JOURNEE_VACANCE") + (numeroJour + 1) + ',';
            }
        }

        return messageValidation;
    }

   

    private String validerJournneeVacanceFinSemaine() throws IOException {
        String messageValidation = "";

        for (int numeroJour = 5; numeroJour < 7; ++numeroJour) {
            Double       estJourneeVacance;
            List<Projet> projectList = jours.get(numeroJour);

            estJourneeVacance = calculerJourneeVacance(projectList);

            if (estJourneeVacance == -2) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_JOURNEE_VACANCE_FIN_DE_SEMAINE") + (numeroJour + 1)
                        + ',';
            }
        }

        return messageValidation;
    }
    
     private double calculerJourneeVacance(List<Projet> projectList)
            throws IOException {
        int messageErreur = 0;

        if (!projectList.isEmpty()) {
            for (Projet aProject : projectList) {
                if (!aProject.estJourneeVacance()) {
                    messageErreur = -2;
                }
            }
        }

        return messageErreur;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
