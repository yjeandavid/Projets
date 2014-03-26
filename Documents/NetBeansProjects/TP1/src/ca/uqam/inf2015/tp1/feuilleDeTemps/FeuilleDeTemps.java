package ca.uqam.inf2015.tp1.feuilleDeTemps;

import java.io.IOException;
import java.util.List;

public class FeuilleDeTemps {
    private List<List<Projet>> jours;

    public FeuilleDeTemps() {}

    public List<List<Projet>> getJours() {
        return jours;
    }

    public void setJours(List<List<Projet>> jours) {
        this.jours = jours;
    }

    public double calculerHeuresBureauParSemaine() throws IOException {
        double heuresBureauSemaine = 0.0;

        for (int numeroJour = 0; numeroJour < jours.size(); ++numeroJour) {
            List<Projet> projectList = jours.get(numeroJour);

            heuresBureauSemaine += calculerHeuresBureauJour(projectList);
        }

        return heuresBureauSemaine;
    }

    public double calculerHeuresTeleTravailParSemaine() throws IOException {
        double heuresTeleTravailSemaine = 0.0;

        for (int numeroJour = 0; numeroJour < jours.size(); ++numeroJour) {
            List<Projet> projectList = jours.get(numeroJour);

            heuresTeleTravailSemaine +=
                calculerHeuresTeleTravailJour(projectList);
        }

        return heuresTeleTravailSemaine;
    }

    public static double calculerHeuresBureauJour(List<Projet> projetsDuJour)
            throws IOException {
        double heuresBureauJour = 0.0;

        for (int j = 0; j < projetsDuJour.size(); ++j) {
            Projet aProject = projetsDuJour.get(j);

            if (!aProject.estTeleTravail()) {
                heuresBureauJour += (projetsDuJour.get(j)).getMinutes();
            }
        }

        return heuresBureauJour;
    }

    public static double calculerHeuresTeleTravailJour(List<Projet> projetsDuJour)
            throws IOException {
        double heuresTeleTravailJour = 0.0;

        for (int j = 0; j < projetsDuJour.size(); ++j) {
            Projet aProject = projetsDuJour.get(j);

            if (aProject.estTeleTravail()) {
                heuresTeleTravailJour += (projetsDuJour.get(j)).getMinutes();
            }
        }

        return heuresTeleTravailJour;
    }
}

