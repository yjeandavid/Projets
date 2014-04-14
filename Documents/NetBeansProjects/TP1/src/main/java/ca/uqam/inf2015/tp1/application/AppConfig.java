package ca.uqam.inf2015.tp1.application;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class AppConfig {
    public static JSONObject configurations;

    public static void chargerParametres() throws IOException {
        String cheminDuFichier = "configuration/settings.json";
        String jsontxt         = FileUtils.readFileToString(new File(cheminDuFichier), "UTF-8");

        configurations = (JSONObject) JSONSerializer.toJSON(jsontxt);
    }

    public static double getParametreRetournerUnDouble(String parametreDemande) throws IOException {
        if(configurations == null)chargerParametres();
        return (double) configurations.getInt(parametreDemande);
    }

    public static String getParametreRetournerUnString(String parametreDemande) throws IOException {
        if(configurations == null)chargerParametres();
        return configurations.getString(parametreDemande);
    }

    public static char getParametreRetournerUnChar(String parametreDemande) throws IOException {
        if(configurations == null)chargerParametres();
        return configurations.getString(parametreDemande).charAt(0);
    }
}


