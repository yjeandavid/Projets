package ca.uqam.inf2015.tp1.feuilleDeTemps;

import java.util.List;

public class FeuilleDeTemps {

    private List<List<Projet>> jours;
    
    public FeuilleDeTemps() {}
    
	public List<List<Projet>> getJours() 
	{
		return jours;
	}

	public void setJours(List<List<Projet>> jours) 
	{
		this.jours = jours;
	}
}
