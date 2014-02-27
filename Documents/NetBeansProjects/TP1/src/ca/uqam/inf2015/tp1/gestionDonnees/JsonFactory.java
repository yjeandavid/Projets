package ca.uqam.inf2015.tp1.gestionDonnees;

import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONArray;


public abstract class JsonFactory {

    public static void buildJsonFile(String filePath, String messages) throws IOException {
        JSONArray messageArray = new JSONArray();
        String theMessages[] = messages.split(",");
        
        if(!(theMessages.length == 1 && theMessages[0].equals("")))
            for (int i = 0; i < theMessages.length; ++i) {
                String aMessage = theMessages[i];
                messageArray.add(aMessage);
            }
        WriterJsonFile(filePath, messageArray);
    }

    private static void WriterJsonFile(String filePath, JSONArray messageArray) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw = (FileWriter) messageArray.write(fw);
        fw.flush();
        fw.close();
    }
}
