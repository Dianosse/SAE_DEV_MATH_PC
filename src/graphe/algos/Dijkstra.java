package graphe.algos;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

import graphe.core.IGrapheConst;

public class Dijkstra {
    private static final int NB_POUR_SOURCE = 0;

    public static void dijkstra(IGrapheConst g, String source, Map<String, Integer> dist, Map<String, String> prev) {
        String sommetActuel = source;
        PriorityQueue<String> sommetsNonVisites = new PriorityQueue<String>((s1, s2) -> dist.get(s1) - dist.get(s2));
        HashSet<String> sommetsVisites = new HashSet<>();
        
        
        dist.put(sommetActuel, NB_POUR_SOURCE);
        prev.put(source, "");
        sommetsNonVisites.add(sommetActuel);

        while (!sommetsNonVisites.isEmpty()) {
            sommetActuel = sommetsNonVisites.poll();
        
            for (String s : g.getSucc(sommetActuel)) {
            	dist.putIfAbsent(s, Integer.MAX_VALUE);
                prev.putIfAbsent(s, sommetActuel);
                
                int valuationActuelle = dist.get(sommetActuel) + g.getValuation(sommetActuel, s);
                if (valuationActuelle < dist.get(s) && !sommetsVisites.contains(sommetActuel)) {
                    dist.put(s, valuationActuelle);
                    prev.put(s, sommetActuel);
                    sommetsNonVisites.add(s);
                }
            }
            sommetsVisites.add(sommetActuel);
        }
        prev.remove(source);						//afin de résoudre un bug d'affichage : afficher une virgule 
        											//en trop au début (car dans prev la source est ajouté comme ayant "" et 
        											//donc cela ""bug"" lors de la création du chemin
    }
}
