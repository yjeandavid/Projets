package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.employe.Employe;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;

public abstract class ValidationFeuilleDeTemps {

	public static void valider(Employe employe)
	{
		if (employe.getTypeEmploye() == AppConfig.EMPLOYE_NORMAL) {
			validerRegulier(employe.getFeuilleDeTemps());
		}
		else {
			validerAdmin(employe.getFeuilleDeTemps());
		}
	}
	
	private static void validerRegulier(FeuilleDeTemps timeSheet)
	{
		
	}
	
	private static void validerAdmin(FeuilleDeTemps timeSheet)
	{
		
	}
	
	private static void validerTous(FeuilleDeTemps timeSheet)
	{
		
	}
	
	private static void traiterTeleTravail()
	{
		
	}
	
	private static void traiterTravailBureau()
	{
		
	}
	
	private static boolean isOfficeReachMinimum(char typeEmploye, double nbMinutes)
	{
		boolean isOK = false;
		
		if (typeEmploye == AppConfig.EMPLOYE_NORMAL) {
			
		}
		else {
			
		}
		
		return isOK;
	}
	
}
