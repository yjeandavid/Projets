package ca.uqam.inf2015.tp1.employe;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;

public class Employe {
	
	private char typeEmploye;
	private int noEmploye;
	private FeuilleDeTemps timeSheet = null;
	
	public static Employe buildEmploye(int noEmploye)
	{
		return new Employe(noEmploye);
	}
	
	private Employe(int noEmploye)
	{
		this.noEmploye = noEmploye;
		setTypeEmploye();
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
	
	public char getTypeEmploye()
	{
		return typeEmploye;
	}
	
	private void setTypeEmploye()
	{
		if (noEmploye >= AppConfig.CODE_REF_TYPE_EMPLOYE) {
            typeEmploye = AppConfig.EMPLOYE_NORMAL;
		}
        else {
            typeEmploye = AppConfig.EMPLOYE_ADMINISTRATION;
        }
	}
}
