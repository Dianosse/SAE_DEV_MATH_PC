package Dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphe.IGraphe;

public class Dijkstra {
	private static final int MAX_INT = 2147483647;
	private static final int NB_DEFAULT = -1;
	private static final int NB_POUR_SOURCE = 0;

	
	public static void dijkstra(IGraphe g, String source, Map<String, Integer> dist, Map<String, String> prev) {
		String sommetActuelle = source;
		HashMap<String, Boolean> sommetVisite = new HashMap<>();
		List<String> sommets = g.getSommets();
		for(String s : sommets) {
			dist.put(s, NB_DEFAULT);
			if(s.equals(sommetActuelle)) {
				sommetVisite.put(s, true);
			}
			else {
				sommetVisite.put(s, false);
			}
		}
		dist.remove(sommetActuelle);
		dist.put(sommetActuelle, NB_POUR_SOURCE);
		
		while(!fini(sommetVisite)) {		
			List<String> successeurs = g.getSucc(sommetActuelle);
			for(String s : successeurs) {
				int valuationActuelle = dist.get(sommetActuelle) + g.getValuation(sommetActuelle, s);
				if (valuationActuelle < dist.get(s) || pas_initialise(s,dist)) {
					dist.remove(s);
					dist.put(s, valuationActuelle);
					if(!prev.containsKey(s)) {
						prev.put(s, sommetActuelle);
					}
					else {
						prev.remove(s);
						prev.put(s, sommetActuelle);
					}
				}
			}
			sommetVisite.remove(sommetActuelle);
			sommetVisite.put(sommetActuelle, true);
			sommetActuelle = nouveauSommet(sommetActuelle, dist, sommetVisite);
		}				
	}

	private static boolean pas_initialise(String sommet, Map<String, Integer> dist) {
		if(dist.get(sommet) == NB_DEFAULT) {
			return true;
		}
		return false;
	}

	private static String nouveauSommet(String sommetActuelle, Map<String, Integer> dist, HashMap<String, Boolean> sommetVisite) {
		int min = MAX_INT;
		for(String s : dist.keySet()) {
			if(dist.get(s) < min && !(dist.get(s) == NB_DEFAULT) && !s.equals(sommetActuelle) && !sommetVisite.get(s)) {
				min = dist.get(s);
			}
		}
		for(String s : dist.keySet()) {
			if(dist.get(s) == min && !sommetVisite.get(s)) {
				return s;
			}
		}
		return "";     //TODO Fonctionne pas car si pas de plus petit
	}

	private static boolean fini(HashMap<String, Boolean> sommetVisite) {
		int compteur = 1;
		for(String s : sommetVisite.keySet()) {
			if(sommetVisite.get(s) == true) {
				compteur++;
			}
		}
		if(compteur == sommetVisite.size()) {
			return true;
		}
		return false;
	}
}
