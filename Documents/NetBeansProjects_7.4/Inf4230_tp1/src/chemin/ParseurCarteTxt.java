/* INF4230 - Intelligence artificielle
 * UQAM / Département d'informatique
 * Automne 2014 / TP1 - Algorithme A*
 * http://ericbeaudry.ca/INF4230/tp1/
 */
package chemin;

import java.io.BufferedReader;
import java.util.StringTokenizer;

/**
 * Chargeur de carte à partir d'un fichier en format texte simple.
 * @author Éric Beaudry
 */
public class ParseurCarteTxt {
    
    public static Carte parseCarte(BufferedReader reader) throws Exception{
        Carte map = new Carte();
        String ligne;
        while(!(ligne=reader.readLine()).equals("---")){
            //System.out.println(">>" + ligne);
            int indexspace = ligne.indexOf(' ');
            assert ligne.charAt(0)=='n';
            long id = Long.parseLong(ligne.substring(1, indexspace));
            Coordonnees c = Coordonnees.parseCoordonnees(ligne.substring(indexspace+1));
            map.addNoeud(new Noeud(id, c));
        }
        int wayid = 1;
        int nbnodeslistes=0;
        while((ligne=reader.readLine())!=null && !ligne.equals("---")){
            if(ligne.isEmpty()) continue;
            int li2p = ligne.lastIndexOf(':');
            String nom = ligne.substring(0, li2p-1);
            StringTokenizer st = new StringTokenizer(ligne.substring(li2p+1), " ;");
            Route route = new Route(wayid++);
            route.sensunique = true;
            route.setNom(nom);
            while(st.hasMoreTokens()){
                String nodename = st.nextToken();
                assert nodename.charAt(0)=='n';
                long id = Long.parseLong(nodename.substring(1));
                route.noeuds.add(map.noeuds.get(id));
                nbnodeslistes++;
            }
            map.addRoute(route);
        }
        System.out.println("# Carte chargée: " + map.noeuds.size() + " nodes; " + map.routes.size() + " ways; " + nbnodeslistes + " segments.");
        return map;
    }
    
}
