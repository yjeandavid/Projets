package ca.uqam.inf2015.tp1.employe;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTempsDDC2;
import java.io.IOException;

public class Employe {
    private FeuilleDeTemps feuileDeTemps               = null;
    private int            noEmploye;
    private char           typeEmploye;

    public Employe(int noEmploye) throws IOException {
        this.noEmploye = noEmploye;
        setTypeEmploye();
    }

    /*public String validerFeuilleDeTemps() throws IOException {
        String messages          = validerFeuilleDeTempsSelonType();
        String messageValidation = "";
        String theMessages[]     = messages.split(",");

        for (int i = 0; i < theMessages.length; ++i) {
            String aMessage = theMessages[i];

            if (!aMessage.isEmpty()) {
                messageValidation += aMessage + ',';
            }
        }

        if (!messageValidation.isEmpty()) {
            messageValidation = messageValidation.substring(0,
                    messageValidation.length() - 1);
        }

        return messageValidation;
    }

    private String validerFeuilleDeTempsSelonType() throws IOException {
        String messageValidation = "";

        if (typeEmploye
                == AppConfig.getParametreRetournerUnInt(
                    "EMPLOYE_ADMINISTRATION")) {
            messageValidation = validerSemaineTypeAdmin();
        } else if (typeEmploye
                   == AppConfig.getParametreRetournerUnInt(
                       "EMPLOYE_EXPLOITATION")) {
            messageValidation = validerSemaineTypeExploitation();
        } else if (typeEmploye
                   == AppConfig.getParametreRetournerUnInt(
                       "EMPLOYE_PRODUCTION")) {
            messageValidation = validerSemaineTypeProduction();
        }

        return messageValidation;
    }

    public String validerSemaineTypeAdmin() throws IOException {
        String messageValidation = "";

        messageValidation += validerJoursOuvrablesAdmin() + ',';
        messageValidation += validerHeuresTravailBureauParSemaine(
            AppConfig
                .getParametreRetournerUnDouble(
                    "MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE"), AppConfig
                        .getParametreRetournerUnDouble(
                            "MAXIMUM_MINUTES_BUREAU_ADMIN_SEMAINE")) + ',';
        messageValidation += validerHeuresTeleTravailParSemaine(
            AppConfig.getParametreRetournerUnDouble(
                "MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE")) + ',';
        messageValidation += validerJoursCongesMaladies();
        messageValidation += validerCongesFeries();
        messageValidation += new FeuilleDeTempsDDC2(feuileDeTemps,
                feuileDeTemps.getJours()).resultatFinalAdmin();

        return messageValidation;
    }

    public String validerSemaineTypeExploitation() throws IOException {
        String messageValidation = "";

        messageValidation += validerJoursOuvrablesNormal() + ',';
        messageValidation += validerHeuresTravailBureauParSemaine(
            AppConfig
                .getParametreRetournerUnDouble(
                    "MINIMUM_MINUTES_BUREAU_EXPLOITATION_SEMAINE"), AppConfig
                        .getParametreRetournerUnDouble(
                            "MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE")) + ',';
        messageValidation += validerJoursCongesMaladies();
        messageValidation += validerCongesFeries();
        messageValidation += new FeuilleDeTempsDDC2(feuileDeTemps,
                feuileDeTemps.getJours()).resultatFinalExploitation();

        return messageValidation;
    }

    public String validerSemaineTypeProduction() throws IOException {
        String messageValidation = "";

        messageValidation += validerJoursOuvrablesNormal() + ',';
        messageValidation += validerHeuresTravailBureauParSemaine(
            AppConfig
                .getParametreRetournerUnDouble(
                    "MINIMUM_MINUTES_BUREAU_PRODUCTION_SEMAINE"), AppConfig
                        .getParametreRetournerUnDouble(
                            "MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE")) + ',';
        messageValidation += validerJoursCongesMaladies();
        messageValidation += validerCongesFeries();
        messageValidation += new FeuilleDeTempsDDC2(feuileDeTemps,
                feuileDeTemps.getJours()).resultatFinalProduction();

        return messageValidation;
    }*/

    public String validerJoursOuvrablesAdmin() throws IOException {
        return feuileDeTemps
            .validerJoursOuvrables(
                AppConfig
                    .getParametreRetournerUnDouble(
                        "MINIMUM_MINUTES_BUREAU_ADMIN_PAR_JOUR"), AppConfig
                            .getParametreRetournerUnDouble(
                                "MAXIMUM_MINUTES_OFFICE_WORK_BY_DAY"));
    }

    public String validerJoursOuvrablesNormal() throws IOException {
        return feuileDeTemps.validerJoursOuvrables(
                AppConfig.getParametreRetournerUnDouble("MINIMUM_MINUTES_BUREAU_PRODUCTION_PAR_JOUR"), 
                AppConfig.getParametreRetournerUnDouble("MAXIMUM_MINUTES_OFFICE_WORK_BY_DAY"));
    }

    /*public String validerHeuresTravailBureauParSemaine(
            double minimumHeuresDeBureauParSemaine,
            double maximumHeuresDeBureauParSemaine)
            throws IOException {
        String messageValidation = "";

        if (heuresDeBureauParSemaine < minimumHeuresDeBureauParSemaine) {
            messageValidation += AppConfig.getParametreRetournerUnString(
                "MSG_HEURES_MINIMUM_SEMAINE_BUREAU") + ',';
        } else if (heuresDeBureauParSemaine > maximumHeuresDeBureauParSemaine) {
            messageValidation += AppConfig.getParametreRetournerUnString(
                "MSG_HEURES_MAXIMAL_BUREAU_SEMAINE") + ',';
        }

        return messageValidation;
    }

    public String validerHeuresTeleTravailParSemaine(
            double maximumHeuresTeleTravailParSemaine)
            throws IOException {
        String messageValidation = "";

        if (heuresTeleTravailParSemaine > maximumHeuresTeleTravailParSemaine) {
            messageValidation += AppConfig.getParametreRetournerUnString(
                "MSG_HEURES_MAXIMAL_TELE_TRAVAIL") + ',';
        }

        return messageValidation;
    }*/

    private String validerJoursCongesMaladies() throws IOException {
        return feuileDeTemps.validerCongesMaladie(
            AppConfig.getParametreRetournerUnDouble("MINUTES_CONGES_MALADIE"));
    }

    private String validerCongesFeries() throws IOException {
        return feuileDeTemps.validerCongesFeries(
            AppConfig.getParametreRetournerUnDouble("MINUTES_CONGES_FERIES"));
    }

    public int getNoEmplye() {
        return noEmploye;
    }

    public void setNoEmploye(int noEmploye) {
        this.noEmploye = noEmploye;
    }

    public FeuilleDeTemps getFeuilleDeTemps() {
        return feuileDeTemps;
    }

    public void setfFeuilleDeTemps(FeuilleDeTemps timeSheet) {
        this.feuileDeTemps = timeSheet;
    }

    public char getTypeEmploye() {
        return typeEmploye;
    }

    private void setTypeEmploye() throws IOException {
        if (noEmploye < AppConfig.getParametreRetournerUnDouble("CODE_REF_TYPE_EMPLOYE")) {
            typeEmploye = AppConfig.getParametreRetournerUnChar("EMPLOYE_ADMINISTRATION");
        } else if (noEmploye < AppConfig.getParametreRetournerUnDouble("CODE_REF_TYPE_EMPLOYE_CATEGORIE")) {
            typeEmploye = AppConfig.getParametreRetournerUnChar("EMPLOYE_DEVELOPPEMENT");
        } else if (noEmploye < AppConfig.getParametreRetournerUnDouble("CODE_REF_TYPE_EMPLOYE_DIRECTEUR")) {
            typeEmploye = AppConfig.getParametreRetournerUnChar("EMPLOYE_EXPLOITATION");
        } else {
            typeEmploye = AppConfig.getParametreRetournerUnChar("EMPLOYE_DIRECTEUR");
        }
    }
}