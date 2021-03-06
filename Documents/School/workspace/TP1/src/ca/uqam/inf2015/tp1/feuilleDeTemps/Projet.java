package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;

public class Projet {

    private int noProjet;
    private double minutes;
    
    public static Projet buildProjet(int noProjet, double minutes)
    {
    	return new Projet(noProjet, minutes);			
    }
    
    private Projet(int noProjet, double minutes)
    {
    	setNoProjet(noProjet);
    	setMinutes(minutes);
    }
    
    public int getNoProjet()
    {
        return noProjet;
    }
    
    public double getMinutes()
    {
        return minutes;
    }
    
    public void setNoProjet(int noProjet)
    {
        this.noProjet = noProjet;
    }
    
    public void setMinutes(double minutes)
    {
        this.minutes = minutes;
    }
    
    public boolean IsTeleTravail()
    {
        boolean isTeleTravail = false;
    	if (noProjet > AppConfig.CODE_REF_TELE_TRAVAIL) {
    		isTeleTravail = true;
    	}
        return isTeleTravail;
    }
}
