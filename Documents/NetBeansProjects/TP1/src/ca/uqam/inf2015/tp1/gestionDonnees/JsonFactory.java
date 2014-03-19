package ca.uqam.inf2015.tp1.gestionDonnees;


import net.sf.json.JSONArray;


import java.io.FileWriter;
import java.io.IOException;

public abstract class JsonFactory {
    public static void construireFichierJson(String cheminDuFichier, String messages) throws IOException {
        JSONArray tableDeMessages = new JSONArray();
        String[]  lesMessages     = messages.split(",");

        if (!((lesMessages.length == 1) && lesMessages[0].equals(""))) {
            for (int i = 0; i < lesMessages.length; ++i) {
                String aMessage = lesMessages[i];

                tableDeMessages.add(aMessage);
            }
        }

        EcrireFichierJson(cheminDuFichier, tableDeMessages);
    }

    public static void EcrireFichierJson(String cheminDuFichier, JSONArray messageArray) throws IOException {
        FileWriter fw = null;

        try {
            fw = new FileWriter(cheminDuFichier);
            fw = (FileWriter) messageArray.write(fw);
        } catch (IOException ex) {
            throw ex;
        } finally {
            fw.flush();
            fw.close();
        }
    }
}


