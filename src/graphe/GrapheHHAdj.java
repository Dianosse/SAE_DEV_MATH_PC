package graphe;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class GrapheHHAdj implements IGraphe{
	private Map<String, HashMap<String, Integer>> hhadj;

	private static final int ERROR = -1;
	private static final int VALU_MIN = 0;
	
	public GrapheHHAdj() {
		hhadj = new HashMap<String, HashMap<String, Integer>>();
	}
	
	public GrapheHHAdj(String s) {
		this();
		this.peupler(s);
	}
	
	
	@Override
	public List<String> getSommets() {
		return new ArrayList<String>(hhadj.keySet());
	}

	@Override
	public List<String> getSucc(String sommet) {
		ArrayList<String> successeurs = new ArrayList<>();
		for(String s : hhadj.get(sommet).keySet()) {
			successeurs.add(s);
		}
		return successeurs;
	}

	@Override
	public int getValuation(String src, String dest) {
		for(String s : hhadj.get(src).keySet()) {
			if(s.equals(dest)) {
				return hhadj.get(src).get(dest);
			}
		}
		return ERROR;
	}

	@Override
	public boolean contientSommet(String sommet) {
		return hhadj.containsKey(sommet);
	}

	@Override
	public boolean contientArc(String src, String dest) {
		if(contientSommet(src)) {
			for(String s : hhadj.get(src).keySet()) {
				if(s.equals(dest)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void ajouterSommet(String noeud) {
		if(!contientSommet(noeud)) {
			hhadj.put(noeud, new HashMap<>());
		}
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		if(!contientSommet(source)) { ajouterSommet(source);}
		
		else if(!contientSommet(destination)) { ajouterSommet(destination);}
		
		
		if(contientArc(source, destination) || valeur < VALU_MIN) {
			throw new IllegalArgumentException();
		}
		else {
			hhadj.get(source).put(destination, valeur);
		}
	}

	@Override
	public void oterSommet(String noeud) {
		if(contientSommet(noeud)) {
			hhadj.remove(noeud);
			for(String s : hhadj.keySet()) {
				HashMap<String,Integer> tmp = hhadj.get(s);
				if(tmp.containsKey(noeud)) {
					tmp.remove(noeud);
				}
			}
		}		
		
	}

	@Override
	public void oterArc(String source, String destination) {
		if(!contientArc(source,destination)) {
			throw new IllegalArgumentException();
		}
		HashMap<String,Integer> tmp = hhadj.get(source);
		if(tmp.containsKey(destination)) {
			tmp.remove(destination);
		}
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean premier = true;
		SortedSet<String> sommets = new TreeSet<>(hhadj.keySet());
		for(String s : sommets) {
			if(hhadj.get(s).isEmpty()) {
				if(!premier) { sb.append(", "); }
    			else { premier = false; }
				sb.append(s + ":");
			}
			SortedSet<String> destination = new TreeSet<>(hhadj.get(s).keySet());
			for(String dest : destination) {
				if(!premier) { sb.append(", "); }
    			else { premier = false; }
				sb.append(s + "-" + dest + "(" + hhadj.get(s).get(dest) + ")");
			}
		}
		return sb.toString();
	}

}
