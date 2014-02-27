package ca.uqam.inf2015.tp1.employe;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.exceptions.MissingDataInJSONFileException;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;

public class Employe {
	
	private char typeEmploye;
	private int noEmploye;
	private FeuilleDeTemps timeSheet = null;
	private double heuresDeBureauParSemaine = 0.0;
        private double heuresTeleTravailParSemaine = 0.0;
        
	public Employe(int noEmploye)
	{
		this.noEmploye = noEmploye;
		setTypeEmploye();
	}
	
        public String validerFeuilleDeTemps() throws MissingDataInJSONFileException
        {
            String messages = validerFeuilleDeTempsSelonType();
            String messageValidation = "";
            String theMessages[] = messages.split(",");
            
            for (int i = 0; i < theMessages.length; ++i)
            {
                String aMessage = theMessages[i];
                if(!aMessage.isEmpty())
                {
                    messageValidation += aMessage + ',';
                }
            }
            if (!messageValidation.isEmpty())
            {
                messageValidation = messageValidation.substring(0,
                                                messageValidation.length() - 1);
            }
            return messageValidation;
        }
        
        private String validerFeuilleDeTempsSelonType() throws MissingDataInJSONFileException
        {
            String messageValidation = "";
            
            switch (typeEmploye)
            {
                case AppConfig.EMPLOYE_ADMINISTRATION:
                                messageValidation = validerSemaineTypeAdmin();
                                break;
                case AppConfig.EMPLOYE_EXPLOITATION:
                                messageValidation = validerSemaineTypeExploitation();
                                break;
                case AppConfig.EMPLOYE_PRODUCTION:   
                                messageValidation = validerSemaineTypeProduction();
            }
            return messageValidation;
        }
        
        public String validerSemaineTypeAdmin() throws MissingDataInJSONFileException
        {
            String messageValidation = "";
            
            messageValidation += validerJoursOuvrablesAdmin() + ',';
            messageValidation += validerHeuresTravailBureauParSemaine(
                    AppConfig.MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE,
                    AppConfig.MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE) + ',';
            messageValidation += validerHeuresTeleTravailParSemaine(
                    AppConfig.MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE) + ',';
            messageValidation += validerJoursCongesMaladies();
             messageValidation += validerCongesFeries();
                       
            return messageValidation;
        }
        
        public String validerSemaineTypeExploitation() throws MissingDataInJSONFileException
        {
            String messageValidation = "";
            
            messageValidation += validerJoursOuvrablesNormal() + ',';
            messageValidation += validerHeuresTravailBureauParSemaine(
                    AppConfig.MINIMUM_MINUTES_BUREAU_EXPLOITATION_SEMAINE,
                    AppConfig.MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE) + ',';
           messageValidation += validerJoursCongesMaladies();
           messageValidation += validerCongesFeries();

            return messageValidation;
        }
        
        public String validerSemaineTypeProduction() throws MissingDataInJSONFileException
        {
            String messageValidation = "";
            
            messageValidation += validerJoursOuvrablesNormal() + ',';
            messageValidation += validerHeuresTravailBureauParSemaine(
                    AppConfig.MINIMUM_MINUTES_BUREAU_PRODUCTION_SEMAINE,
                    AppConfig.MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE) + ',';
            messageValidation += validerJoursCongesMaladies();
           messageValidation += validerCongesFeries();

                       
            return messageValidation;
        }
        
        public String validerJoursOuvrablesAdmin() throws MissingDataInJSONFileException
        {   
            return timeSheet.validerJoursOuvrables(
                    AppConfig.MINIMUM_MINUTES_BUREAU_ADMIN_PAR_JOUR);
        }
        
        public String validerJoursOuvrablesNormal() throws MissingDataInJSONFileException
        {
            return timeSheet.validerJoursOuvrables(
                    AppConfig.MINIMUM_MINUTES_BUREAU_PRODUCTION_PAR_JOUR);
        }
        
        public String validerHeuresTravailBureauParSemaine(int minimumHeuresDeBureauParSemaine,
                int maximumHeuresDeBureauParSemaine) throws MissingDataInJSONFileException
        {
            String messageValidation = "";
            
            if (heuresDeBureauParSemaine < minimumHeuresDeBureauParSemaine)
            {
                messageValidation += AppConfig.MSG_HEURES_MINIMUM_SEMAINE_BUREAU
                                        + ',';
            } else if (heuresDeBureauParSemaine >
                    maximumHeuresDeBureauParSemaine)
            {
                messageValidation += AppConfig.MSG_HEURES_MAXIMAL_BUREAU + ',';
            }
            
            return messageValidation;
        }
        
        public String validerHeuresTeleTravailParSemaine(int maximumHeuresTeleTravailParSemaine)
                throws MissingDataInJSONFileException
        {
            String messageValidation = "";
            
            if (heuresTeleTravailParSemaine > 
                                            maximumHeuresTeleTravailParSemaine)
            {
                messageValidation += AppConfig.MSG_HEURES_MAXIMAL_TELE_TRAVAIL
                                        + ',';
            }
            
            return messageValidation;
        }
        
        private String validerJoursCongesMaladies() throws MissingDataInJSONFileException
        {
            return timeSheet.validerCongesMaladie(AppConfig.MINUTES_CONGES_MALADIE);
        }
        private String validerCongesFeries()
        {
             return timeSheet.validerCongesFeries(AppConfig.MINUTES_CONGES_FERIES);
        }
        
	public int getNoEmplye()
	{
		return noEmploye;
	}
	
	public void setNoEmploye(int noEmploye)
	{
		this.noEmploye = noEmploye;
	}
	
	public FeuilleDeTemps getFeuilleDeTemps()
	{
		return timeSheet;
	}
	
	public void setfFeuilleDeTemps(FeuilleDeTemps timeSheet)
	{
		this.timeSheet = timeSheet;
	}
        
        public void setHeuresDeBureauParSemaine()
        {
            heuresDeBureauParSemaine = timeSheet
                                            .calculerHeuresBureauParSemaine();
        }
        
        public void setHeuresDeTeleTravailParSemaine()
        {
            heuresTeleTravailParSemaine = timeSheet
                                         .calculerHeuresTeleTravailParSemaine();
        }
	
	public char getTypeEmploye()
	{
		return typeEmploye;
	}
	
	private void setTypeEmploye()
	{
            if (noEmploye >= AppConfig.CODE_REF_TYPE_EMPLOYE 
             && noEmploye < AppConfig.CODE_REF_TYPE_EMPLOYE_CATEGORIE)
            {
                typeEmploye = AppConfig.EMPLOYE_PRODUCTION;
            }
            else if(noEmploye > AppConfig.CODE_REF_TYPE_EMPLOYE_CATEGORIE)
            {
                typeEmploye = AppConfig.EMPLOYE_EXPLOITATION;
            }
            else 
            {
                typeEmploye = AppConfig.EMPLOYE_ADMINISTRATION;
            }
	}

    
}
