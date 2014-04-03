package ca.uqam.inf2015.tp1.test;

//~--- non-JDK imports --------------------------------------------------------

import ca.uqam.inf2015.tp1.application.Inf2015Projet1;

public class Test {
    public static void main(String[] args) {
        System.out.println("Début test!");

        int nombreCas = 54;

        for (int cas = 1; cas <= nombreCas; cas++) {
            System.out.println("Cas " + cas);
            Inf2015Projet1.main(new String[] {
                "configurationTests/Cas" + cas + ".json",
                "resultatsTests/out" + cas + ".json" });
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
