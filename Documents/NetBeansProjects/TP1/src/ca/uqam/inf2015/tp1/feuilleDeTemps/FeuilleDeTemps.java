package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;
import java.util.List;

public class FeuilleDeTemps {
    
    private List<List<Projet>> jours;
    
    public FeuilleDeTemps(){}
   
    public List<List<Projet>> getJours() 
    {
            return jours;
    }

    public void setJours(List<List<Projet>> jours) 
    {
            this.jours = jours;
    }

    public String validerJoursOuvrables(int minimumHeuresBureauParJour)
    {
        String messageValidation = "";
        final short NBRE_JOURS_OUVRABLES = 5;

        for (int numeroJour = 0; numeroJour < NBRE_JOURS_OUVRABLES; 
                ++numeroJour)
        {
            double heureBureauJour;
            List<Projet> projectList = jours.get(numeroJour);
            heureBureauJour = calculerHeuresBureauJour(projectList);
            if (heureBureauJour < minimumHeuresBureauParJour)
            {
                messageValidation += 
                        AppConfig.MSG_HEURES_MINIMUM_JOUR_BUREAU + ',';
            }
        }
        return messageValidation;
    }

    public double calculerHeuresBureauParSemaine()
    {
        double heuresBureauSemaine = 0.0;

        for (int numeroJour = 0; numeroJour < jours.size(); ++numeroJour)
        {
            List<Projet> projectList = jours.get(numeroJour);
            heuresBureauSemaine += calculerHeuresBureauJour(projectList);
        }
        return heuresBureauSemaine;
    }

    public double calculerHeuresTeleTravailParSemaine()
    {
        double heuresTeleTravailSemaine = 0.0;

        for (int numeroJour = 0; numeroJour < jours.size(); ++numeroJour)
        {
            List<Projet> projectList = jours.get(numeroJour);
            heuresTeleTravailSemaine += calculerHeuresTeleTravailJour(
                                                               projectList);
        }
        return heuresTeleTravailSemaine;
    }

    public double calculerHeuresBureauJour(List<Projet> projetsDuJour)
    {
        double heuresBureauJour = 0.0;
        for (int j = 0; j < projetsDuJour.size(); ++j)
        {
            Projet aProject = projetsDuJour.get(j);
            if (!aProject.IsTeleTravail())
            {
                heuresBureauJour += (projetsDuJour.get(j)).getMinutes();
            }
        }
        return heuresBureauJour;
    }

    public double calculerHeuresTeleTravailJour(List<Projet> projetsDuJour)
    {
        double heuresTeleTravailJour = 0.0;
        for (int j = 0; j < projetsDuJour.size(); ++j)
        {
            Projet aProject = projetsDuJour.get(j);
            if (aProject.IsTeleTravail())
            {
                heuresTeleTravailJour += (projetsDuJour.get(j))
                                                              .getMinutes();
            }
        }
        return heuresTeleTravailJour;
    }
}
