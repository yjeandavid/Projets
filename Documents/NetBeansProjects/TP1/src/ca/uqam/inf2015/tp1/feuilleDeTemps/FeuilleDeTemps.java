package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;
import java.util.List;

public class FeuilleDeTemps {
    
    private List<List<Projet>> jours;
    
    public FeuilleDeTemps(){}
   
    public List<List<Projet>> getJours() {
            return jours;
    }

    public void setJours(List<List<Projet>> jours) {
            this.jours = jours;
    }

    public String validerJoursOuvrables(int minimumHeuresBureauParJour) {
        String messageValidation = "";
        final short NBRE_JOURS_OUVRABLES = 5;

        for (int numeroJour = 0; numeroJour < NBRE_JOURS_OUVRABLES; ++numeroJour) {
            double heureBureauJour;
            List<Projet> projectList = jours.get(numeroJour);
            heureBureauJour = calculerHeuresBureauJour(projectList);
            if (heureBureauJour < minimumHeuresBureauParJour) {
                messageValidation += AppConfig.MSG_HEURES_MINIMUM_JOUR_BUREAU + ',';
            }
        }
        return messageValidation;
    }

    public double calculerHeuresBureauParSemaine() {
        double heuresBureauSemaine = 0.0;

        for (int numeroJour = 0; numeroJour < jours.size(); ++numeroJour) {
            List<Projet> projectList = jours.get(numeroJour);
            heuresBureauSemaine += calculerHeuresBureauJour(projectList);
        }
        return heuresBureauSemaine;
    }

    public double calculerHeuresTeleTravailParSemaine() {
        double heuresTeleTravailSemaine = 0.0;

        for (int numeroJour = 0; numeroJour < jours.size(); ++numeroJour) {
            List<Projet> projectList = jours.get(numeroJour);
            heuresTeleTravailSemaine += calculerHeuresTeleTravailJour(
                                                               projectList);
        }
        return heuresTeleTravailSemaine;
    }

    public double calculerHeuresBureauJour(List<Projet> projetsDuJour) {
        double heuresBureauJour = 0.0;
        
        for (int j = 0; j < projetsDuJour.size(); ++j) {
            Projet aProject = projetsDuJour.get(j);
            if (!aProject.IsTeleTravail()) {
                heuresBureauJour += (projetsDuJour.get(j)).getMinutes();
            }
        }
        return heuresBureauJour;
    }

    public double calculerHeuresTeleTravailJour(List<Projet> projetsDuJour) {
        double heuresTeleTravailJour = 0.0;
        
        for (int j = 0; j < projetsDuJour.size(); ++j) {
            Projet aProject = projetsDuJour.get(j);
            if (aProject.IsTeleTravail()) {
                heuresTeleTravailJour += (projetsDuJour.get(j)).getMinutes();
            }
        }
        return heuresTeleTravailJour;
    }
    
    public String validerCongesMaladie(int heureCongesMaladies) {
        String messageValidation = validerCongesMaladieSemaine(heureCongesMaladies);
        messageValidation+=validerCongesMaladieFinSemaine();
        
        return messageValidation;
    }
    
    private String validerCongesMaladieSemaine(int heureCongesMaladies) {
         String messageValidation = "";

        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
            double heureCongeMaladie,msgErreur;
            List<Projet> projectList = jours.get(numeroJour);
            heureCongeMaladie = calculerHeuresCongeMaladie(projectList);
            msgErreur = verifierCongeMaladie(projectList);
            if (heureCongeMaladie != heureCongesMaladies && heureCongeMaladie != -1) {
                messageValidation += AppConfig.MSG_HEURES_CONGES_MALADIE + "pour la journee "
                                                                         + (numeroJour+1) + ',';
            } else if(msgErreur == -2) 
                messageValidation += AppConfig.MSG_AUTRE_ACTIVITE_CONGES_MALADIE + 
                                                         "pour la journee "+(numeroJour+1)+ ',';
        }
        return messageValidation;
    }
    
    private String validerCongesMaladieFinSemaine() {
        String messageValidation = "";
        
        for (int numeroJour = 5; numeroJour < 7; ++numeroJour) {
            Boolean isCongesMaladies;
            List<Projet> projectList = jours.get(numeroJour);
            isCongesMaladies = verifierCongeMaladieFinSemaine(projectList);
            if (isCongesMaladies) {
                messageValidation += AppConfig.MSG_CONGES_MALADIE_FIN_DE_SEMAINE +
                                                    "pour la journee "+(numeroJour+1)+ ',';
            }
        }
        return messageValidation;
    }
    
    private Boolean verifierCongeMaladieFinSemaine(List<Projet> projectList) {
        Boolean isCongesMaladies = false;
       
            if(!projectList.isEmpty()) {
                for(int projet = 0; projet < projectList.size();++projet) {
                    Projet aProject = projectList.get(projet);
                    if (aProject.IsCongesMaladie()) {
                        isCongesMaladies = true;
                    }
                }
            }
        
        return isCongesMaladies;
    }
    
    private double calculerHeuresCongeMaladie(List<Projet> projectList) {
            double heuresCongesMaladies = -1;
       
            if(!projectList.isEmpty()) {
                for(int projet = 0; projet < projectList.size();++projet) {
                    Projet aProject = projectList.get(projet);
                    if (aProject.IsCongesMaladie() && projectList.size() == 1) {
                        heuresCongesMaladies = (projectList.get(projet)).getMinutes();
                    }
                }
            }
        
        return heuresCongesMaladies;
    }
      
    private int verifierCongeMaladie(List<Projet> projectList) {
        int messageErreur = 0;

        if(!projectList.isEmpty()) {
            for(int projet = 0; projet < projectList.size();++projet) {
                Projet aProject = projectList.get(projet);
                if (aProject.IsCongesMaladie() && projectList.size() != 1) {
                    messageErreur = -2;
                }
            }
        }
        
        return messageErreur;
    }
    
    public String validerCongesFeries(int heureCongesFeries) {
        String messageValidation = validerCongesFeriesSemaine(heureCongesFeries);
        messageValidation+=validerCongesFeriesFinSemaine();
        
        return messageValidation;
    }
    
    private String validerCongesFeriesSemaine(double heureCongesFeries) {
        String messageValidation = "";

        for (int numeroJour = 0; numeroJour < 5; ++numeroJour) {
          double heureCongeFeries;
          double msgErreur[] = new double [1];
          msgErreur[0] = 1;
          List<Projet> projectList = jours.get(numeroJour);
          heureCongeFeries = calculerHeuresCongeFeries(projectList,msgErreur);
          if (heureCongeFeries != heureCongesFeries && heureCongeFeries != -1) {
              messageValidation += AppConfig.MSG_HEURES_CONGES_FERIE + "pour la journee "
                                                                     + (numeroJour+1) + ',';
          }else if(msgErreur[0] == -2) 
              messageValidation += AppConfig.MSG_AUTRE_ACTIVITE_CONGES_FERIE + 
                                                    "pour la journee " +(numeroJour+1)+ ',';
        }
        return messageValidation;       
    }
       
    private double calculerHeuresCongeFeries(List<Projet>projectList,double messageErreur []) {
       double heureCongesFeries = -1;

        if(!projectList.isEmpty()) {
            for(int projet = 0; projet < projectList.size();++projet) {
                Projet aProject = projectList.get(projet);
                if (aProject.IsCongesFeries()) {
                    heureCongesFeries = (projectList.get(projet)).getMinutes();
                    messageErreur[0] = verifierCongeFeries(projectList);
                }
            }
        }
        
        return heureCongesFeries;
    }
       
    private double verifierCongeFeries (List<Projet>projectList) {
      int messageErreur = 0;

      if(!projectList.isEmpty()) {
        for(int projet = 0; projet < projectList.size();++projet) {
            Projet aProject = projectList.get(projet);
            if (!aProject.IsTeleTravail()) {
                messageErreur = -2;
            }
        }
      }
        
      return messageErreur;  
    }
       
    private String validerCongesFeriesFinSemaine() {
        String messageValidation = "";
        
        for (int numeroJour = 5; numeroJour < 7; ++numeroJour) {
            Boolean isCongeFerie;
            List<Projet> projectList = jours.get(numeroJour);
            isCongeFerie = verifierCongeFerieFinSemaine(projectList);
            if (isCongeFerie) {
                messageValidation += AppConfig.MSG_CONGES_FERIE_FIN_DE_SEMAINE +
                                                "pour la journee "+(numeroJour+1)+ ',';
            }
        }
        return messageValidation;
    }
        
    private Boolean verifierCongeFerieFinSemaine(List<Projet> projectList) {
        Boolean isCongeFerie = false;
       
        if(!projectList.isEmpty()) {
            for(int projet = 0; projet < projectList.size();++projet) {
                Projet aProject = projectList.get(projet);
                if (aProject.IsCongesFeries()) {
                    isCongeFerie = true;
                }
            }
        }
        
        return isCongeFerie;
    }

}
