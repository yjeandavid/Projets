/* INF4230 - Intelligence artificielle
 * UQAM / Département d'informatique
 * Automne 2014 / TP1 - Algorithme A*
 * http://ericbeaudry.ca/INF4230/tp1/
 */
package astar;

import java.text.NumberFormat;
import java.util.*;

public class AStar {

    public static List<Action> genererPlan(Monde monde, Etat etatInitial, But but, Heuristique heuristique){
        long starttime = System.currentTimeMillis();
        int nbreEtatGenere, nbreEtatVisite;
        TreeSet<Etat> open, close;
        List<Action> plan = null;
        
        nbreEtatGenere = nbreEtatVisite = 0;
        open = close = new TreeSet<>();
        
        etatInitial.g = 0;
        etatInitial.h = heuristique.estimerCoutRestant(etatInitial, but);
        etatInitial.f = etatInitial.g + etatInitial.h;
        
        open.add(etatInitial);
        ++nbreEtatGenere;
        while (true) {
            if (!open.isEmpty()) {
                Etat n1 = open.first();
                open.remove(n1);
                close.add(n1);
                ++nbreEtatVisite;
                if (but.butSatisfait(n1)) {
                    /*plan = new ArrayList<>();
                    plan.add(n1.actionDepuisParent);*/
                    // À Complèter
                    break;
                }
                genererSuccesseur(n1,heuristique, open, close);
                trier(open);
                
            } else {
                break;
            }
        // À Compléter.
        // Implémentez l'algorithme A* ici.
        
        // Étapes suggérées :
        //  - Numérotez les itérations.
        //  - Pour chaque itération :
        //  --  Affichez le numéro d'itération.
        //  --  Faites une boucles qui itère tous les états e dans open pour trouver celui avec e.f minimal.
        //  --  Affichez l'état e sélectionné (les e.f affichés devraient croître);
        //  --  Vérifiez si l'état e satisfait le but. 
        //  ---   Si oui, sortez du while.
        //  ---   Une autre boucle remonte les pointeurs parents.
        //  --  Générez les successeurs de e.
        //  --  Pour chaque état successeur s de e:
        //  ---   Vérifiez si s.etat est dans closed.
        //  ---   Calculez s.etat.g = e.g + s.cout.
        //  ---   Vérifiez si s.etat existe dans open.
        //  ----    Si s.etat est déjà dans open, vérifiez son .f.
        //  ---   Ajoutez s.etat dans open si nécessaire.
        //  - Exécutez le programme sur un problème très simple.
        //  --  Vérifiez le bon fonctionnement de la génération des états.
        //  --  Vérifiez que e.f soit croissant (>=).
        //  - Une fois que l'algorithme :
        //  -- Ajoutez un TreeSet<Etat> open2 avec un comparateur basé sur f.
        //  -- Évaluez la pertinence d'un PriorityQueue.
        //  - Commentez les lignes propres au déboggage.
        
        // Un plan est une séquence (liste) d'actions.
        }
        

        long lastDuration = System.currentTimeMillis() - starttime;
        // Les lignes écrites débutant par un dièse '#' seront ignorées par le valideur de solution.
        System.out.println("# Nombre d'états générés : " + 0);
        System.out.println("# Nombre d'états visités : " + 0);
        System.out.println("# Durée : " + lastDuration + " ms");
        System.out.println("# Coût : " + nf.format(Double.POSITIVE_INFINITY));
        return plan;
    }
    
    static final NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
    static {
        nf.setMaximumFractionDigits(1);
    }
    
    protected static void genererSuccesseur(Etat n, Heuristique heurisitique, Set<Etat> open, Set<Etat> close) {
        Map<Double, Etat> successeurs = new TreeMap<>();
        
        if (n.getClass() == chemin.Etat.class) {
            chemin.Etat n1 = (chemin.Etat) n;
            chemin.Noeud ntemp = n1.getEmplacement();
            
            for(Map.Entry<chemin.Noeud, Double> entry : ntemp.getTroncons().entrySet()) {
                chemin.Etat n2 = new chemin.Etat(entry.getKey());
                n2.g = n1.g + ntemp.distanceDeg2(entry.getKey());
                n2.h = heurisitique.estimerCoutRestant(n2, null);
                n2.f = n2.g + n2.h;
                
                n2.parent = n1;
                
                if (open.contains(n2)) {
                    chemin.Etat n3 = (chemin.Etat) getEtatIn(open, n2);
                    if (n2.f < n3.f) {
                        open.remove(n3);
                        successeurs.put(n2.f, n2);
                    }
                } else if (close.contains(n2)) {
                    chemin.Etat n3 = (chemin.Etat) getEtatIn(close, n2);
                    if (n2.f < n3.f) {
                        open.remove(n3);
                        successeurs.put(n2.f, n2);
                    }
                } else {
                    successeurs.put(n2.f, n2);
                }
            }
            
            Collection<Etat> it = successeurs.values();
            for(Etat e : it) {
                open.add(e);
            }
        }
    }
    
    protected static Etat getEtatIn(Set<Etat> search, Etat filter) {
        Iterator<Etat> it = search.iterator();
        Etat n = null;
        
        while (it.hasNext()) {
            n = it.next();
            if (n.equals(filter))
                break;
        }
        
        return n;
    }
    
    protected static void trier(TreeSet<Etat> treeToSort) {
        Etat temp[] = (Etat[])treeToSort.toArray();
        ArrayList<Etat> result = new ArrayList<>();
        treeToSort = new TreeSet<>();
        
        
        
        
        for(Etat e : result)
            treeToSort.add(e);
    }
}
