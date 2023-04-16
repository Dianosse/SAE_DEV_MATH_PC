package graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class GrapheLAdj implements IGraphe{
	private Map<String, List<Arc>> ladj;
	
	private static final int ERROR = -1;

	
	public GrapheLAdj() {
		ladj = new HashMap<String, List<Arc>>();
	}
	
	public GrapheLAdj(String graphe) {
		this();
		this.peupler(graphe);
	}
	
	
	@Override
	public List<String> getSommets() {
		return new ArrayList<String>(ladj.keySet());
	}

	@Override
	public List<String> getSucc(String sommet) {
		ArrayList<String> successeur = new ArrayList<>();
		for(Arc a : ladj.get(sommet)) {
			successeur.add(a.getDestination());
		}
		return successeur;
	}

	@Override
	public int getValuation(String src, String dest) {
		for(Arc a : ladj.get(src)) {
			if(a.getDestination().equals(dest)) {
				return a.getValuation();
			}
		}
		return ERROR;
	}

	@Override
	public boolean contientSommet(String sommet) {
		return ladj.containsKey(sommet);
	}

	@Override
	public boolean contientArc(String src, String dest) {
		boolean result = false;
		if(contientSommet(src)) {
	        for (Arc a : this.ladj.get(src)) { 
	            if (a.getDestination().equals(dest)){ 
	                result = true; 
	                break; 
	            } 
	        } 
		}
        return result; 
	}

	@Override
	public void ajouterSommet(String noeud) {
		if(!contientSommet(noeud)) {
			ladj.put(noeud, new ArrayList<Arc>());
		}
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		if(!contientSommet(source)) { ajouterSommet(source);}
		
		else if(!contientSommet(destination)) { ajouterSommet(destination);}
		
		
		if(contientArc(source, destination) || valeur < 0) {
			throw new IllegalArgumentException();
		}
		else {
			ladj.get(source).add(new Arc(source,destination,valeur));

		}
			
	}

	@Override
	public void oterSommet(String noeud) {
		if(contientSommet(noeud)) {
			ladj.remove(noeud);
		}
		for(String s : ladj.keySet()) {
			for(int i = 0; i<ladj.get(s).size();++i) {
				if(ladj.get(s).get(i).getDestination().equals(noeud)) {
					ladj.get(s).remove(i);
				}
			}
		}
	}

	@Override
	public void oterArc(String source, String destination) {
		if(!contientArc(source, destination)) {
			throw new IllegalArgumentException();
		}
		for(int i = 0; i<ladj.get(source).size();++i) {
			if(ladj.get(source).get(i).getDestination().equals(destination)) {
				ladj.get(source).remove(i);
				break;
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean premier = true;
		boolean verif = true;
		Comparator<Arc> comparator = Comparator.comparing(Arc::toString);
		SortedSet<String> sommets = new TreeSet<>(ladj.keySet());
        for(String s : sommets) {
            Collections.sort(ladj.get(s), comparator);
        	verif = true;
        	if(ladj.get(s).isEmpty()) {
        		if(!premier) {
    				sb.append(", ");
    			}
    			else {
    				premier = false;
    			}
    			sb.append(s + ":");
    			verif = false;
        	}
        	if(verif == true) {
	        	for(Arc a : ladj.get(s)) {
	        		if(!premier) {
	    				sb.append(", ");
	    			}
	    			else {
	    				premier = false;
	    			}
	        		sb.append(a.toString());
	        	}
        	}
        }
        return sb.toString();
	}

}
