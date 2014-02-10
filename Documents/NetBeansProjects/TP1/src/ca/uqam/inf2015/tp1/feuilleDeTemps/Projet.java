package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;

public class Projet {

	private int noProjet;
    private double minutes;
    private boolean isTeleTravail;
    
    public static Projet buildProjet(int noProjet, double minutes)
    {
    	return new Projet(noProjet, minutes);			
    }
    
    private Projet(int noProjet, double minutes)
    {
    	setNoProjet(noProjet);
    	setMinutes(minutes);
    	setIsTeleTravail();
    }
    
    public int getNoProjet()
    {
        return noProjet;
    }
    
    public double getMinutes()
    {
        return minutes;
    }
    
    public boolean getIsTeleTravail()
    {
    	return isTeleTravail;
	}
    
    public void setNoProjet(int noProjet)
    {
        this.noProjet = noProjet;
    }
    
    public void setMinutes(double minutes)
    {
        this.minutes = minutes;
    }
    
    private void setIsTeleTravail()
    {
    	if (noProjet > AppConfig.CODE_REF_TELE_TRAVAIL) {
    		isTeleTravail = true;
    	}
    }
}
