package ca.uqam.inf2015.tp1.feuilleDeTemps;


import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.exceptions.MissingDataInJSONFileException;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ProjectFactory {
    private static final short NB_DAYS_TOTAL = 7;
    private static final short NB_DAYS_WEEK  = 5;

    public static List<List<Projet>> construireProjetAPartirDeFichierJson(JSONObject rootElt)
                                throws MissingDataInJSONFileException, IOException {
        List<Projet>       projets;
        List<List<Projet>> jours = new ArrayList<>();

        try {
            for (int i = 0; i < NB_DAYS_TOTAL; i++) {
                if (i < NB_DAYS_WEEK) {
                    projets = construireProjet(rootElt.getJSONArray(AppConfig.getParametreRetournerUnString("CLE_JOUR")
                            + String.valueOf(i + 1)));
                } else {
                    projets =
                        construireProjet(rootElt.getJSONArray(AppConfig.getParametreRetournerUnString("CLE_WEEKEND")
                            + String.valueOf(i - NB_DAYS_WEEK + 1)));
                }

                jours.add(projets);
            }
        } catch (JSONException json) {
            throw new MissingDataInJSONFileException();
        }

        return jours;
    }

    private static List<Projet> construireProjet(JSONArray jourElt) throws IOException {
        @SuppressWarnings("unchecked") Iterator<JSONObject> iterator = jourElt.iterator();
        List<Projet>                                        projets  = new ArrayList<>();

        while (iterator.hasNext()) {
            JSONObject projectElt = iterator.next();
            
            projets.add(
                Projet.construireProjet(
                    projectElt.getInt(AppConfig.getParametreRetournerUnString("CLE_PROJET")),
                    projectElt.getDouble(AppConfig.getParametreRetournerUnString("CLE_MINUTES"))));
        }

        return projets;
    }
}


