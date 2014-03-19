package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;
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

    public String validerJoursOuvrables(double minimumHeuresBureauParJour,
            double maximumHeuresBureauParJour)
            throws IOException {
        String messageValidation = "";

        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
            double       heureBureauJour;
            List<Projet> projectList = jours.get(numeroJour);

            heureBureauJour = calculerHeuresBureauJour(projectList);

            if (heureBureauJour < minimumHeuresBureauParJour) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_HEURES_MINIMUM_JOUR_BUREAU") + " "
                        + AppConfig.getParametreRetournerUnString("CLE_JOUR")
                        + " " + String.valueOf(numeroJour + 1) + ',';
            } else if (heureBureauJour > maximumHeuresBureauParJour) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_MAXIMUM_HEURE_DE_BUREAU_PAR_JOURS") + " "
                        + String.valueOf(numeroJour + 1) + ',';
            }
        }

        return messageValidation;
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

    private double calculerHeuresBureauJour(List<Projet> projetsDuJour)
            throws IOException {
        double heuresBureauJour = 0.0;

        for (int j = 0; j < projetsDuJour.size(); ++j) {
            Projet aProject = projetsDuJour.get(j);

            if (aProject.estTravailBureau()) {
                heuresBureauJour += (projetsDuJour.get(j)).getMinutes();
            }
        }

        return heuresBureauJour;
    }

    public double calculerHeuresTeleTravailJour(List<Projet> projetsDuJour)
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

    public String validerCongesMaladie(double heureCongesMaladies)
            throws IOException {
        String messageValidation =
            validerCongesMaladieSemaine(heureCongesMaladies);

        messageValidation += validerCongesMaladieFinSemaine();

        return messageValidation;
    }

    private String validerCongesMaladieSemaine(double heureCongesMaladies)
            throws IOException {
        String messageValidation = "";

        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
            double       heureCongeMaladie, msgErreur;
            List<Projet> projectList = jours.get(numeroJour);

            heureCongeMaladie = calculerHeuresCongeMaladie(projectList);
            msgErreur         = verifierCongeMaladie(projectList);

            if ((heureCongeMaladie != heureCongesMaladies)
                    && (heureCongeMaladie != -1) ) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_HEURES_CONGES_MALADIE") + " " + "pour la journee "
                                                 + " " + (numeroJour + 1) + ',';
            } 
            if (msgErreur == -2) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_AUTRE_ACTIVITE_CONGES_MALADIE") + " "
                        + "pour la journee " + (numeroJour + 1) + ',';
            }
        }

        return messageValidation;
    }

    private String validerCongesMaladieFinSemaine() throws IOException {
        String messageValidation = "";

        for (int numeroJour = 5; numeroJour < 7; ++numeroJour) {
            Boolean      isCongesMaladies;
            List<Projet> projectList = jours.get(numeroJour);

            isCongesMaladies = verifierCongeMaladieFinSemaine(projectList);

            if (isCongesMaladies) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_CONGES_MALADIE_FIN_DE_SEMAINE") + " "
                        + "pour la journee " + (numeroJour + 1) + ',';
            }
        }

        return messageValidation;
    }

    private Boolean verifierCongeMaladieFinSemaine(List<Projet> projectList)
            throws IOException {
        Boolean estUnCongeMaladie = false;

        if (!projectList.isEmpty()) {
            for (int projet = 0; projet < projectList.size(); ++projet) {
                Projet aProject = projectList.get(projet);

                if (aProject.estUnCongeMaladie()) {
                    estUnCongeMaladie = true;
                }
            }
        }

        return estUnCongeMaladie;
    }

    private double calculerHeuresCongeMaladie(List<Projet> projectList)
            throws IOException {
        double heuresCongesMaladies = -1;

        if (!projectList.isEmpty()) {
            for (int projet = 0; projet < projectList.size(); ++projet) {
                Projet aProject = projectList.get(projet);

                if (aProject.estUnCongeMaladie() && (projectList.size() == 1)) {
                    heuresCongesMaladies =
                        (projectList.get(projet)).getMinutes();
                } 
            }
        }

        return heuresCongesMaladies;
    }

    private int verifierCongeMaladie(List<Projet> projectList)
            throws IOException {
        int messageErreur = 0;

        if (!projectList.isEmpty()) {
            for (int projet = 0; projet < projectList.size(); ++projet) {
                Projet aProject = projectList.get(projet);

                if (aProject.estUnCongeMaladie() && (projectList.size() != 1)) {
                    messageErreur = -2;
                }
            }
        }

        return messageErreur;
    }

    public String validerCongesFeries(double heureCongesFeries)
            throws IOException {
        String messageValidation =
            validerCongesFeriesSemaine(heureCongesFeries);

        messageValidation += validerCongesFeriesFinSemaine();

        return messageValidation;
    }

    private String validerCongesFeriesSemaine(double heureCongesFeries)
            throws IOException {
        String messageValidation = "";

        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
            double heureCongeFeries;
            double msgErreur[] = new double[1];

            msgErreur[0] = 1;

            List<Projet> projectList = jours.get(numeroJour);

            heureCongeFeries = calculerHeuresCongeFeries(projectList,
                    msgErreur);

            if ((heureCongeFeries != heureCongesFeries)
                    && (heureCongeFeries != -1)) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_HEURES_CONGES_FERIE") + " " + "pour la journee " + " "
                                               + (numeroJour + 1) + ',';
            } else if (msgErreur[0] == -2) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_AUTRE_ACTIVITE_CONGES_FERIE") + "pour la journee "
                        + (numeroJour + 1) + ',';
            }
        }

        return messageValidation;
    }

    private double calculerHeuresCongeFeries(List<Projet> projectList,
            double messageErreur[])
            throws IOException {
        double heureCongesFeries = -1;

        if (!projectList.isEmpty()) {
            for (int projet = 0; projet < projectList.size(); ++projet) {
                Projet aProject = projectList.get(projet);

                if (aProject.estUnCongeFerie()) {
                    heureCongesFeries = (projectList.get(projet)).getMinutes();
                    messageErreur[0]  = verifierCongeFeries(projectList);
                }
            }
        }

        return heureCongesFeries;
    }

    private double verifierCongeFeries(List<Projet> projectList)
            throws IOException {
        int messageErreur = 0;

        if (!projectList.isEmpty()) {
            for (int projet = 0; projet < projectList.size(); ++projet) {
                Projet aProject = projectList.get(projet);

                if (!aProject.estUnCongeFerie()) {
                    messageErreur = -2;
                }
            }
        }

        return messageErreur;
    }

    private String validerCongesFeriesFinSemaine() throws IOException {
        String messageValidation = "";

        for (int numeroJour = 5; numeroJour < 7; ++numeroJour) {
            Double       estCongesFeriesFinSemaine;
            List<Projet> projectList = jours.get(numeroJour);

            estCongesFeriesFinSemaine = verifierCongeFeries(projectList);

            if (estCongesFeriesFinSemaine == -2) {
                messageValidation += AppConfig.getParametreRetournerUnString(
                    "MSG_CONGES_FERIE_FIN_DE_SEMAINE") + " "
                        + "pour la journee " + " " + (numeroJour + 1) + ',';
            }
        }

        return messageValidation;
    }

    private Boolean verifierCongeFerieFinSemaine(List<Projet> projectList)
            throws IOException {
        Boolean estUnCongeFerie = false;

        if (!projectList.isEmpty()) {
            for (int projet = 0; projet < projectList.size(); ++projet) {
                Projet aProject = projectList.get(projet);

                if (aProject.estUnCongeFerie()) {
                    estUnCongeFerie = true;
                }
            }
        }

        return estUnCongeFerie;
    }
}

