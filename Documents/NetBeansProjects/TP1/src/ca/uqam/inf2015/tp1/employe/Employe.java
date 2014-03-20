package ca.uqam.inf2015.tp1.employe;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import java.io.IOException;

public class Employe {
    private FeuilleDeTemps feuileDeTemps               = null;
    private int            noEmploye;
    private char           typeEmploye;

    public Employe(int noEmploye) throws IOException {
        this.noEmploye = noEmploye;
        setTypeEmploye();
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