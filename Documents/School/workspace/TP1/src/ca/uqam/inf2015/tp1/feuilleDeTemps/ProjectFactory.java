package ca.uqam.inf2015.tp1.feuilleDeTemps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ca.uqam.inf2015.tp1.application.AppConfig;

public abstract class ProjectFactory {
	
	private static final short NB_DAYS_TOTAL = 7;
	private static final short NB_DAYS_WEEK = 5;
	
	
	public static List<List<Projet>> buildProjectFromJsonFile(
                                                            JSONObject rootElt)
	{
		List<Projet> projets;
		List<List<Projet>> jours = new ArrayList<>();
		
		for (int i = 0; i < NB_DAYS_TOTAL; i++) {
			if (i < NB_DAYS_WEEK) {
				projets = buildProject(rootElt.getJSONArray(
						AppConfig.CLE_JOUR + 
                                        String.valueOf(i + 1)));
			}
			else {
				projets = buildProject(rootElt.getJSONArray(
						AppConfig.CLE_WEEKEND + 
                                        String.valueOf(i - NB_DAYS_WEEK + 1)));
			}
			
			jours.add(projets);
		}
		
		return jours;
	}
	
	private static List<Projet> buildProject(JSONArray jourElt)
	{
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = jourElt.iterator();
		List<Projet> projets = new ArrayList<>();
		
		while (iterator.hasNext()) {
			JSONObject projectElt = iterator.next();
			
			projets.add(Projet.buildProjet(
                                projectElt.getInt(AppConfig.CLE_PROJET), 
				projectElt.getDouble(AppConfig.CLE_MINUTES)));
		}
		
		return projets;
	}

}
