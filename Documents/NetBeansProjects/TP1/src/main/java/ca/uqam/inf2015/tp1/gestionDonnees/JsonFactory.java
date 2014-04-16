package ca.uqam.inf2015.tp1.gestionDonnees;

import net.sf.json.JSONArray;
import java.io.IOException;

public abstract class JsonFactory {
    public static void construireFichierJson(String messages, FileWriterWrapper fw) throws IOException {
        JSONArray tableDeMessages = new JSONArray();
        String[]  lesMessages     = messages.split(",");

        if (!(lesMessages.length == 1)) {
            for (int i = 0; i < lesMessages.length; ++i) {
                if (!lesMessages[i].isEmpty()) {
                    tableDeMessages.add(lesMessages[i]);
                }
            }
        } else if (!lesMessages[0].isEmpty()) {
            tableDeMessages.add(lesMessages[0]);
        }

        EcrireFichierJson(tableDeMessages, fw);
    }

    public static void EcrireFichierJson(JSONArray messageArray, FileWriterWrapper fw) throws IOException {
        fw.write(messageArray.toString());
        fw.flush();
        fw.close();
    }
}


